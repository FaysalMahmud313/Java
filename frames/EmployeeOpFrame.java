package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class EmployeeOpFrame extends JFrame implements ActionListener
{
	private ImageIcon backgroundIcon,operationIcon,viewIcon,updateIcon,backIcon;
	private JLabel backgroundLabel,employeeHomeLabel, operationLabel, viewLabel, updateLabel;
	private JButton customersBtn,wdBtn, backBtn,accBtn;
	private JPanel panel;
	private User u;
	private Transaction t;
	
	public EmployeeOpFrame(User u)
	{
		
		super("Employee Operation Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		
		backgroundIcon = new ImageIcon("image/Operations.jpg");
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		
		this.customersBtn=new JButton("Customers Operation");
		this.customersBtn.setBounds(60,550,300,50);
		this.customersBtn.addActionListener(this);
		this.customersBtn.setBackground(new Color(23, 64, 109));
		this.customersBtn.setForeground(Color.WHITE);
        this.customersBtn.setFont(font);
        this.customersBtn.setFocusPainted(false);
		this.panel.add(customersBtn);
		this.customersBtn.setVisible(true);
		
		/*this.customersBtn=new JButton("Customers Operation");
		this.customersBtn.setBounds(150,200,200,30);
		this.customersBtn.addActionListener(this);
		this.customersBtn.setBackground(Color.ORANGE);
		this.panel.add(customersBtn);*/
		
		this.wdBtn=new JButton("Transit Money");
		this.wdBtn.setBounds(480,550,300,50);
		this.wdBtn.addActionListener(this);
		this.wdBtn.setBackground(new Color(23, 64, 109));
		this.wdBtn.setForeground(Color.WHITE);
        this.wdBtn.setFont(font);
        this.wdBtn.setFocusPainted(false);
		this.panel.add(wdBtn);
		this.wdBtn.setVisible(true);
		
		/*this.wdBtn=new JButton("Transit Money");
		this.wdBtn.setBounds(150,240,200,30);
		this.wdBtn.addActionListener(this);
		this.wdBtn.setBackground(Color.WHITE);
		this.panel.add(wdBtn);*/
		
		this.accBtn=new JButton("Account Operation");
		this.accBtn.setBounds(880,550,300,50);
		this.accBtn.addActionListener(this);
		this.accBtn.setBackground(new Color(23, 64, 109));
		this.accBtn.setForeground(Color.WHITE);
        this.accBtn.setFont(font);
        this.accBtn.setFocusPainted(false);
		this.panel.add(accBtn);
		this.accBtn.setVisible(true);
		
		/*this.accBtn=new JButton("Account Operation");
		this.accBtn.setBounds(150,300,200,30);
		this.accBtn.addActionListener(this);
		this.accBtn.setBackground(Color.WHITE);
		this.panel.add(accBtn);*/
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(1080,630,120,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(242, 216, 196));
		this.backBtn.setFont(font);
		this.panel.add(backBtn);
		
		panel.setComponentZOrder(customersBtn, 1); // Button on top
        panel.setComponentZOrder(wdBtn, 0); // Button on top
        panel.setComponentZOrder(accBtn, 2); // Button on top
		panel.setComponentZOrder(backBtn, 3);
		panel.setComponentZOrder(backgroundLabel, 4);
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(customersBtn.getText()))
		{
			CustomersOperationFrame cof=new CustomersOperationFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}
		
		if(command.equals(wdBtn.getText()))
		{
			TransactionOperationFrame tof=new TransactionOperationFrame(this.t,this.u);
			this.setVisible(false);
			tof.setVisible(true);
		}
		if(command.equals(accBtn.getText()))
		{
			AccountOperationFrame aof=new AccountOperationFrame(this.t,this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		if(command.equals(backBtn.getText()))
		{
			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
		
		
		
	}
	
}