package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class CustomersHomeFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel;
	private JButton backBtn,transactionBtn,moneyTransferBtn, profileBtn, passBtn,checkBalanceBtn,historyBtn;
	private JPanel panel;
	private User u;
	private Transaction t;
	private MoneyTransfer mt;
	private Account ac;

	public CustomersHomeFrame(User u)
	{

		super("Customers Home Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 20);

		this.titleLabel=new JLabel("Customer Panel", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.transactionBtn=new JButton("Withdraw / Deposit");
		this.transactionBtn.setBounds(452,120,360,50);
		this.transactionBtn.addActionListener(this);
		this.transactionBtn.setBackground(new Color(0, 102, 204));
		this.transactionBtn.setForeground(Color.WHITE);
        this.transactionBtn.setFont(font);
        this.transactionBtn.setFocusPainted(false);
		this.panel.add(transactionBtn);

		this.moneyTransferBtn=new JButton("Transfer Money");
		this.moneyTransferBtn.setBounds(452,190,360,50);
		this.moneyTransferBtn.addActionListener(this);
		this.moneyTransferBtn.setBackground(new Color(0, 102, 204));
		this.moneyTransferBtn.setForeground(Color.WHITE);
        this.moneyTransferBtn.setFont(font);
        this.moneyTransferBtn.setFocusPainted(false);
		this.panel.add(moneyTransferBtn);

		this.checkBalanceBtn=new JButton("Check Balance");
		this.checkBalanceBtn.setBounds(452,260,360,50);
		this.checkBalanceBtn.addActionListener(this);
		this.checkBalanceBtn.setBackground(new Color(0, 102, 204));
		this.checkBalanceBtn.setForeground(Color.WHITE);
        this.checkBalanceBtn.setFont(font);
        this.checkBalanceBtn.setFocusPainted(false);
		this.panel.add(checkBalanceBtn);

		this.historyBtn=new JButton("Transaction History");
		this.historyBtn.setBounds(452,330,360,50);
		this.historyBtn.addActionListener(this);
		this.historyBtn.setBackground(new Color(0, 102, 204));
		this.historyBtn.setForeground(Color.WHITE);
        this.historyBtn.setFont(font);
        this.historyBtn.setFocusPainted(false);
		this.panel.add(historyBtn);

		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(452,400,360,50);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(new Color(0, 102, 204));
		this.profileBtn.setForeground(Color.WHITE);
        this.profileBtn.setFont(font);
        this.profileBtn.setFocusPainted(false);
		this.panel.add(profileBtn);

		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(452,470,360,50);
		this.passBtn.addActionListener(this);
		this.passBtn.setBackground(new Color(0, 102, 204));
		this.passBtn.setForeground(Color.WHITE);
        this.passBtn.setFont(font);
        this.passBtn.setFocusPainted(false);
		this.panel.add(passBtn);

		this.backBtn=new JButton("Logout");
		this.backBtn.setBounds(452,560,360,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		AccountRepo arp=new AccountRepo();
		this.ac=arp.searchAccountByUserId(u.getUserId());

		this.add(panel);
		this.u=u;
		this.t=t;
		this.mt=mt;
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();


		if(command.equals(transactionBtn.getText()))
		{
			if(this.ac!=null)
			{
				TransactionOperationFrame tof=new TransactionOperationFrame(this.t,this.u);
				this.setVisible(false);
				tof.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No bank account found for this user.");
			}
		}
		if(command.equals(historyBtn.getText()))
		{
			if(this.ac!=null)
			{
				TransactionHistoryFrame thf=new TransactionHistoryFrame(this.u);
				this.setVisible(false);
				thf.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No bank account found for this user.");
			}
		}
		if(command.equals(moneyTransferBtn.getText()))
		{
			if(this.ac!=null)
			{
				MoneyTransferOperation mto=new MoneyTransferOperation(this.mt,this.u);
				this.setVisible(false);
				mto.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No bank account found for this user.");
			}
		}

		if(command.equals(checkBalanceBtn.getText()))
		{
			if(this.ac!=null)
			{
				CheckBalanceFrame cbf=new CheckBalanceFrame(this.ac,this.u);
				this.setVisible(false);
				cbf.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No bank account found for this user.");
			}
		}

		if(command.equals(profileBtn.getText()))
		{
			CustomersRepo crp=new CustomersRepo();
			if(crp.searchCustomersByUserId(this.u.getUserId())!=null)
			{
				CustomersUpdateProfileFrame cupf=new CustomersUpdateProfileFrame(this.u);
				this.setVisible(false);
				cupf.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Customer profile not found.");
			}
		}

		if(command.equals(passBtn.getText()))
		{
			CustomersUpdatePasswordFrame cupf=new CustomersUpdatePasswordFrame(this.u);
			this.setVisible(false);
			cupf.setVisible(true);
		}

		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}


	}

}
