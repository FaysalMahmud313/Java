package frames;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AllMoneyTransfer extends JFrame implements ActionListener
{

	private JLabel titleLabel;
	private JButton backBtn;
	private JTable moneyTransferTable;
	private JScrollPane moneyTransferTableSP;
	private JPanel panel;
	private User u;




	public AllMoneyTransfer(User u)
	{
		super(" All Money Transfer");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 16);

		this.titleLabel=new JLabel("All Money Transfers", JLabel.CENTER);
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

		MoneyTransferRepo mtrp=new MoneyTransferRepo();
		MoneyTransfer[] moneyTransferList=mtrp.getAllMoneyTransfer();
		int count=0;
		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				count++;
			}
		}
		String moneyTransferData1[][]=new String[count][5];
		int row=0;
		for(int i=0;i<moneyTransferList.length;i++)
		{

			if(moneyTransferList[i]!=null)
			{
				moneyTransferData1[row][0]=moneyTransferList[i].getMoneyTransferId();
				moneyTransferData1[row][1]=moneyTransferList[i].getSenderAccNo();
				moneyTransferData1[row][2]=moneyTransferList[i].getReceiverAccNo();
				moneyTransferData1[row][3]=String.valueOf(moneyTransferList[i].getAmount());
				moneyTransferData1[row][4]=moneyTransferList[i].getDate();
				row++;
			}

		}

		String head1[]={"Transfer Id","Sender Account No","Receiver Account No","Amount","Date"};
		this.moneyTransferTable=new JTable(moneyTransferData1,head1);
		this.moneyTransferTable.setFont(new Font("Arial", Font.PLAIN, 15));
		this.moneyTransferTable.setRowHeight(28);
		this.moneyTransferTable.getTableHeader().setFont(font);
		this.moneyTransferTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.moneyTransferTable.getTableHeader().setForeground(Color.WHITE);
		this.moneyTransferTableSP=new JScrollPane(moneyTransferTable);
		this.moneyTransferTableSP.setBounds(60,100,1144,470);
		this.moneyTransferTableSP.getViewport().setBackground(Color.WHITE);
		this.moneyTransferTable.setEnabled(false);
		this.panel.add(moneyTransferTableSP);

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
