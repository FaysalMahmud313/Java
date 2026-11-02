package frames;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class TransactionHistoryFrame extends JFrame implements ActionListener
{

	private JLabel titleLabel,accountInfoLabel;
	private JButton backBtn;
	private JTable historyTable;
	private JScrollPane historyTableSP;
	private JPanel panel;
	private User u;
	private Account ac;



	public TransactionHistoryFrame(User u)
	{
		super("Transaction History");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AccountRepo arp=new AccountRepo();
		this.ac=arp.searchAccountByUserId(u.getUserId());

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);

		this.titleLabel=new JLabel("Transaction History", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.accountInfoLabel=new JLabel("Account No: " + ac.getAccNo() + "        Account Holder: " + this.getAccountHolderName(ac.getAccNo()) + "        Current Balance: Tk " + String.format("%,.2f", ac.getBalance()));
		this.accountInfoLabel.setBounds(60,90,1144,32);
		this.accountInfoLabel.setFont(new Font("Arial", Font.BOLD, 17));
		this.accountInfoLabel.setForeground(new Color(0, 102, 204));
		this.panel.add(accountInfoLabel);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(60,600,160,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		TransactionRepo trp=new TransactionRepo();
		Transaction[] transactionList=trp.searchByAccNo(ac.getAccNo());
		MoneyTransferRepo mtrp=new MoneyTransferRepo();
		MoneyTransfer[] moneyTransferList=mtrp.searchByAccNo(ac.getAccNo());

		int count=0;
		for(int i=0;i<transactionList.length;i++)
		{
			if(transactionList[i]!=null)
			{
				count++;
			}
		}
		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				count++;
			}
		}

		String ownName=this.getAccountHolderName(ac.getAccNo());
		String historyData1[][]=new String[count][8];
		int row=0;

		for(int i=0;i<transactionList.length;i++)
		{
			if(transactionList[i]!=null)
			{
				historyData1[row][0]=transactionList[i].getTransactionId();
				historyData1[row][1]=transactionList[i].getTransactionType();
				historyData1[row][2]=transactionList[i].getDate();
				historyData1[row][3]=String.valueOf(transactionList[i].getAmount());
				if(transactionList[i].getTransactionType().equals("Withdraw"))
				{
					historyData1[row][4]=ownName;
					historyData1[row][5]=ac.getAccNo();
					historyData1[row][6]="-";
					historyData1[row][7]="-";
				}
				else
				{
					historyData1[row][4]="-";
					historyData1[row][5]="-";
					historyData1[row][6]=ownName;
					historyData1[row][7]=ac.getAccNo();
				}
				row++;
			}
		}

		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				historyData1[row][0]=moneyTransferList[i].getMoneyTransferId();
				if(moneyTransferList[i].getSenderAccNo().equals(ac.getAccNo()))
				{
					historyData1[row][1]="Transfer Sent";
				}
				else
				{
					historyData1[row][1]="Transfer Received";
				}
				historyData1[row][2]=moneyTransferList[i].getDate();
				historyData1[row][3]=String.valueOf(moneyTransferList[i].getAmount());
				historyData1[row][4]=this.getAccountHolderName(moneyTransferList[i].getSenderAccNo());
				historyData1[row][5]=moneyTransferList[i].getSenderAccNo();
				historyData1[row][6]=this.getAccountHolderName(moneyTransferList[i].getReceiverAccNo());
				historyData1[row][7]=moneyTransferList[i].getReceiverAccNo();
				row++;
			}
		}

		String head1[]={"Transaction Id","Type","Date","Amount","Sender Name","Sender Acc No","Receiver Name","Receiver Acc No"};
		this.historyTable=new JTable(historyData1,head1);
		this.historyTable.setFont(fieldFont);
		this.historyTable.setRowHeight(28);
		this.historyTable.getTableHeader().setFont(font);
		this.historyTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.historyTable.getTableHeader().setForeground(Color.WHITE);
		this.historyTableSP=new JScrollPane(historyTable);
		this.historyTableSP.setBounds(60,135,1144,445);
		this.historyTableSP.getViewport().setBackground(Color.WHITE);
		this.historyTable.setEnabled(false);
		this.panel.add(historyTableSP);

		this.add(panel);

		this.u=u;

	}

	private String getAccountHolderName(String accNo)
	{
		AccountRepo arp=new AccountRepo();
		Account account=arp.searchAccountByAccNo(accNo);
		if(account!=null)
		{
			CustomersRepo crp=new CustomersRepo();
			Customers c=crp.searchCustomersByUserId(account.getUserId());
			if(c!=null)
			{
				return c.getName();
			}
		}
		return "Unknown";
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(backBtn.getText()))
		{
			CustomersHomeFrame chf=new CustomersHomeFrame(this.u);
			this.setVisible(false);
			chf.setVisible(true);
		}
	}

}
