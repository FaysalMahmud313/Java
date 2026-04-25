package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;


public class AdminViewFrame extends JFrame implements ActionListener
{
	private ImageIcon backgroundIcon;
	private JLabel viewLabel,backgroundLabel;
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
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		//this.panel.setBackground(Color.CYAN);
		
		this.backgroundIcon = new ImageIcon("image/Admin View.jpg");
        this.backgroundLabel = new JLabel();
        this.backgroundLabel.setIcon(backgroundIcon);
        this.backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		
		this.transactionBtn=new JButton("View All Transaction");
		this.transactionBtn.setBounds(90,210,350,60);
		this.transactionBtn.addActionListener(this);
		this.transactionBtn.setBackground(new Color(205,143,174));
		this.transactionBtn.setForeground(new Color(123, 0, 64));
		this.transactionBtn.setFont(font);
		this.panel.add(transactionBtn);
		
		this.moneyTransferBtn=new JButton("View All MoneyTransfer");
		this.moneyTransferBtn.setBounds(90,310,350,60);
		this.moneyTransferBtn.addActionListener(this);
		this.moneyTransferBtn.setBackground(new Color(205,143,174));
		this.moneyTransferBtn.setForeground(new Color(123, 0, 64));
		this.moneyTransferBtn.setFont(font);
		this.panel.add(moneyTransferBtn);
		
		this.accountBtn=new JButton("View All Accounts");
		this.accountBtn.setBounds(90,410,350,60);
		this.accountBtn.addActionListener(this);
		this.accountBtn.setBackground(new Color(205,143,174));
		this.accountBtn.setForeground(new Color(123, 0, 64));
		this.accountBtn.setFont(font);
		this.panel.add(accountBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(950,600,200,60);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(113, 51, 83));
		this.backBtn.setForeground(new Color(237, 215, 226));
		this.backBtn.setFont(font);
		this.panel.add(backBtn);
		
		panel.setComponentZOrder(transactionBtn, 1); // Button on top
        panel.setComponentZOrder(moneyTransferBtn, 0);// Button on top
		panel.setComponentZOrder(accountBtn, 2);// Button on top
        panel.setComponentZOrder(backBtn, 3); // Button on top
		panel.setComponentZOrder(backgroundLabel, 4);
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(transactionBtn.getText()))
		{
			AdminAllTransaction aat=new AdminAllTransaction(this.u);
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