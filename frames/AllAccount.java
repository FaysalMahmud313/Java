package frames;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AllAccount extends JFrame implements ActionListener
{

	private JLabel titleLabel;
	private JButton backBtn;
	private JTable accountTable;
	private JScrollPane accountTableSP;
	private JPanel panel;
	private User u;



	public AllAccount(User u)
	{
		super(" All Account");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 16);

		this.titleLabel=new JLabel("All Accounts", JLabel.CENTER);
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

		AccountRepo arp=new AccountRepo();
		Account[] accountList=arp.getAllAccount();
		int count=0;
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i]!=null)
			{
				count++;
			}
		}
		String accountData1[][]=new String[count][4];
		int row=0;
		for(int i=0;i<accountList.length;i++)
		{

			if(accountList[i]!=null)
			{
				accountData1[row][0]=accountList[i].getAccNo();
				accountData1[row][1]=accountList[i].getUserId();
				accountData1[row][2]=accountList[i].getStatus();
				accountData1[row][3]=String.valueOf(accountList[i].getBalance());
				row++;
			}

		}

		String head1[]={"Account No","User Id","Status","Balance"};
		this.accountTable=new JTable(accountData1,head1);
		this.accountTable.setFont(new Font("Arial", Font.PLAIN, 15));
		this.accountTable.setRowHeight(28);
		this.accountTable.getTableHeader().setFont(font);
		this.accountTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.accountTable.getTableHeader().setForeground(Color.WHITE);
		this.accountTableSP=new JScrollPane(accountTable);
		this.accountTableSP.setBounds(60,100,1144,470);
		this.accountTableSP.getViewport().setBackground(Color.WHITE);
		this.accountTable.setEnabled(false);
		this.panel.add(accountTableSP);

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
