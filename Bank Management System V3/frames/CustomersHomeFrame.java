package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class CustomersHomeFrame extends JFrame implements ActionListener
{
	private ImageIcon backgroundIcon;
	private JLabel backgroundLabel;
	private JButton backBtn,transactionBtn,moneyTransferBtn, profileBtn, passBtn,checkBalanceBtn;
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
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		
		
		backgroundIcon = new ImageIcon("image/Customer.jpg");
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		this.transactionBtn=new JButton("Withdraw/Deposite");
		this.transactionBtn.setBounds(80,250,300,50);
		this.transactionBtn.addActionListener(this);
		this.transactionBtn.setBackground(new Color(51, 204, 255));
		this.transactionBtn.setForeground(Color.WHITE);
        this.transactionBtn.setFont(font);
        this.transactionBtn.setFocusPainted(false);
		this.panel.add(transactionBtn);
		this.transactionBtn.setVisible(true);
		
		this.moneyTransferBtn=new JButton("Transfer Money");
		this.moneyTransferBtn.setBounds(80,350,300,50);
		this.moneyTransferBtn.addActionListener(this);
		this.moneyTransferBtn.setBackground(new Color(51, 204, 255));
		this.moneyTransferBtn.setForeground(Color.WHITE);
        this.moneyTransferBtn.setFont(font);
        this.moneyTransferBtn.setFocusPainted(false);
		this.panel.add(moneyTransferBtn);
		this.moneyTransferBtn.setVisible(true);
		
		this.checkBalanceBtn=new JButton("Check Balance");
		this.checkBalanceBtn.setBounds(480,300,300,50);
		this.checkBalanceBtn.addActionListener(this);
		this.checkBalanceBtn.setBackground(new Color(51, 204, 255));
		this.checkBalanceBtn.setForeground(Color.WHITE);
        this.checkBalanceBtn.setFont(font);
        this.checkBalanceBtn.setFocusPainted(false);
		this.panel.add(checkBalanceBtn);
		this.checkBalanceBtn.setVisible(true);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(880,350,300,50);
		this.passBtn.addActionListener(this);
		this.passBtn.setBackground(new Color(51, 204, 255));
		this.passBtn.setForeground(Color.WHITE);
        this.passBtn.setFont(font);
        this.passBtn.setFocusPainted(false);
		this.panel.add(passBtn);
		this.passBtn.setVisible(true);
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(880,250,300,50);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(new Color(51, 204, 255));
		this.profileBtn.setForeground(Color.WHITE);
        this.profileBtn.setFont(font);
        this.profileBtn.setFocusPainted(false);
		this.panel.add(profileBtn);
		this.profileBtn.setVisible(true);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(980,600,150,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(191, 191, 191));
		this.backBtn.setForeground(new Color(0, 0, 0));
		this.backBtn.setFont(font);
		this.panel.add(backBtn);
		
		AccountRepo arp=new AccountRepo();
		Account[] accountList=arp.getAllAccount();
		
		panel.setComponentZOrder(transactionBtn, 1); 
        panel.setComponentZOrder(moneyTransferBtn, 0); 
        panel.setComponentZOrder(checkBalanceBtn, 2);
		panel.setComponentZOrder(passBtn, 3);
		panel.setComponentZOrder(profileBtn, 4);
		panel.setComponentZOrder(backBtn, 5);
        panel.setComponentZOrder(backgroundLabel, 6);
		
		this.add(panel);
		this.u=u;
		this.t=t;
		this.mt=mt;
		this.ac=ac;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		
		if(command.equals(transactionBtn.getText()))
		{
			TransactionOperationFrame tof=new TransactionOperationFrame(this.t,this.u);
			this.setVisible(false);
			tof.setVisible(true);
		}
		if(command.equals(moneyTransferBtn.getText()))
		{
			MoneyTransferOperation mto=new MoneyTransferOperation(this.mt);
			this.setVisible(false);
			mto.setVisible(true);
		}
		
		if(command.equals(checkBalanceBtn.getText()))
		{
			CheckBalanceFrame cbf=new CheckBalanceFrame(this.ac,this.u);
			this.setVisible(false);
			cbf.setVisible(true);
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
