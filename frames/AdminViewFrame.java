package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminViewFrame extends JFrame implements ActionListener
{
	private JLabel viewLabel;
	private JButton backBtn,transactionBtn,moneyTransferBtn, accountBtn;
	private JPanel panel;
	private User u;

	public AdminViewFrame(User u)
	{
		super("Admin View Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 20);

		this.viewLabel=new JLabel("View Records", JLabel.CENTER);
		this.viewLabel.setBounds(0,0,1264,70);
		this.viewLabel.setOpaque(true);
		this.viewLabel.setBackground(new Color(0, 102, 204));
		this.viewLabel.setForeground(Color.WHITE);
		this.viewLabel.setFont(titleFont);
		this.panel.add(viewLabel);

		this.transactionBtn=new JButton("View All Transaction");
		this.transactionBtn.setBounds(452,160,360,50);
		this.transactionBtn.addActionListener(this);
		this.transactionBtn.setBackground(new Color(0, 102, 204));
		this.transactionBtn.setForeground(Color.WHITE);
		this.transactionBtn.setFont(font);
		this.transactionBtn.setFocusPainted(false);
		this.panel.add(transactionBtn);

		this.moneyTransferBtn=new JButton("View All MoneyTransfer");
		this.moneyTransferBtn.setBounds(452,235,360,50);
		this.moneyTransferBtn.addActionListener(this);
		this.moneyTransferBtn.setBackground(new Color(0, 102, 204));
		this.moneyTransferBtn.setForeground(Color.WHITE);
		this.moneyTransferBtn.setFont(font);
		this.moneyTransferBtn.setFocusPainted(false);
		this.panel.add(moneyTransferBtn);

		this.accountBtn=new JButton("View All Accounts");
		this.accountBtn.setBounds(452,310,360,50);
		this.accountBtn.addActionListener(this);
		this.accountBtn.setBackground(new Color(0, 102, 204));
		this.accountBtn.setForeground(Color.WHITE);
		this.accountBtn.setFont(font);
		this.accountBtn.setFocusPainted(false);
		this.panel.add(accountBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(452,410,360,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		this.add(panel);
		this.u=u;
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(transactionBtn.getText()))
		{
			AdminAllTransaction aat=new AdminAllTransaction(this.u,"All");
			this.setVisible(false);
			aat.setVisible(true);
		}
		if(command.equals(moneyTransferBtn.getText()))
		{
			AllMoneyTransfer amt=new AllMoneyTransfer(this.u);
			this.setVisible(false);
			amt.setVisible(true);
		}
		if(command.equals(accountBtn.getText()))
		{
			AllAccount ac =new AllAccount(this.u);
			this.setVisible(false);
			ac.setVisible(true);
		}
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
	}
}
