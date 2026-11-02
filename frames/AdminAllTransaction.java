package frames;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminAllTransaction extends JFrame implements ActionListener
{

	private JLabel titleLabel;
	private JButton backBtn;
	private JTable transactionTable;
	private JScrollPane transactionTableSP;
	private JPanel panel;
	private User u;



	public AdminAllTransaction(User u,String type)
	{
		super(" All Transaction History!!");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 16);

		String title="All Transactions";
		if(type.equals("Deposit"))
		{
			title="All Deposits";
		}
		else if(type.equals("Withdraw"))
		{
			title="All Withdrawals";
		}

		this.titleLabel=new JLabel(title, JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(60,600,160,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		TransactionRepo trp=new TransactionRepo();
		Transaction[] transactionList=trp.getAllTransaction();

		if(!type.equals("All"))
		{
			for(int i=0;i<transactionList.length;i++)
			{
				if(transactionList[i]!=null && !transactionList[i].getTransactionType().equals(type))
				{
					transactionList[i]=null;
				}
			}
		}

		int count=0;
		for(int i=0;i<transactionList.length;i++)
		{
			if(transactionList[i]!=null)
			{
				count++;
			}
		}
		String transactionData1[][]=new String[count][8];
		int row=0;
		for(int i=0;i<transactionList.length;i++)
		{

			if(transactionList[i]!=null)
			{
				transactionData1[row][0]=transactionList[i].getTransactionId();
				transactionData1[row][1]=transactionList[i].getAccNo();
				transactionData1[row][2]=transactionList[i].getUserId();
				transactionData1[row][3]=transactionList[i].getTransactionType();
				transactionData1[row][4]=transactionList[i].getDate();
				transactionData1[row][5]=String.valueOf(transactionList[i].getAmount());
				transactionData1[row][6]=transactionList[i].getStatus();
				transactionData1[row][7]=String.valueOf(transactionList[i].getBalance());
				row++;
			}

		}
		String head1[]={"Transaction Id","Account No","User Id","Type","Date","Amount","Status","Balance"};
		this.transactionTable=new JTable(transactionData1,head1);
		this.transactionTable.setFont(new Font("Arial", Font.PLAIN, 15));
		this.transactionTable.setRowHeight(28);
		this.transactionTable.getTableHeader().setFont(font);
		this.transactionTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.transactionTable.getTableHeader().setForeground(Color.WHITE);
		this.transactionTableSP=new JScrollPane(transactionTable);
		this.transactionTableSP.setBounds(60,100,1144,470);
		this.transactionTableSP.getViewport().setBackground(Color.WHITE);
		this.transactionTable.setEnabled(false);
		this.panel.add(transactionTableSP);

		this.add(panel);

		this.u=u;

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(backBtn.getText()))
		{
			if(u.getRole()==2)

			{
				EmployeeViewFrame evf=new EmployeeViewFrame(this.u);
				this.setVisible(false);
				evf.setVisible(true);
			}
			else
			{
				AdminViewFrame avf=new AdminViewFrame(this.u);
				this.setVisible(false);
				avf.setVisible(true);
			}
		}
	}

}
