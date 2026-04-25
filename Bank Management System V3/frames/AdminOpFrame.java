package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;


public class AdminOpFrame extends JFrame implements ActionListener
{
	ImageIcon backgroundIcon, adminIcon, employeeIcon;
	private JLabel backgroundLabel,operationLabel;
	private JButton adminBtn,backBtn, employeesBtn;
	private JPanel panel;
	private User u;
	
	
	public AdminOpFrame(User u)
	{
		
		super("Operation Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		
		backgroundIcon = new ImageIcon("image/Operation.jpg");
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		this.operationLabel = new JLabel("Operations");
		Font operationFont = new Font("Arial", Font.BOLD, 30); 
		this.operationLabel.setFont(operationFont);
		this.operationLabel.setBounds(380, 30, 500, 60); 
		this.panel.add(operationLabel);
		
		this.adminBtn=new JButton("Admin Operation");
		this.adminBtn.setBounds(100,220,300,50);
		this.adminBtn.addActionListener(this);
		this.adminBtn.setBackground(new Color(51, 204, 255));
		this.adminBtn.setForeground(Color.WHITE);
        this.adminBtn.setFont(font);
        this.adminBtn.setFocusPainted(false);
		this.panel.add(adminBtn);
		this.adminBtn.setVisible(true);
		
		/*this.adminBtn=new JButton("Admin Operation");
		this.adminBtn.setBounds(150,200,200,30);
		this.adminBtn.addActionListener(this);
		this.adminBtn.setBackground(Color.ORANGE);
		this.panel.add(adminBtn);*/
		
		this.employeesBtn=new JButton("Employee Operation");
		this.employeesBtn.setBounds(100,320,300,50);
		this.employeesBtn.addActionListener(this);
		this.employeesBtn.setBackground(new Color(51, 204, 255));
		this.employeesBtn.setForeground(Color.WHITE);
        this.employeesBtn.setFont(font);
        this.employeesBtn.setFocusPainted(false);
		this.panel.add(employeesBtn);
		this.employeesBtn.setVisible(true);
		
		/*this.employeesBtn=new JButton("Employees Operation");
		this.employeesBtn.setBounds(150,240,200,30);
		this.employeesBtn.addActionListener(this);
		this.employeesBtn.setBackground(Color.WHITE);
		this.panel.add(employeesBtn);*/
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(210,580,150,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(204, 0, 0));
		this.backBtn.setFont(font);
		this.panel.add(backBtn);
		
		/*this.backBtn=new JButton("Back");
		this.backBtn.setBounds(800,450,100,30);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(255,102,102));
		this.panel.add(backBtn);*/
		
		panel.setComponentZOrder(adminBtn, 1); // Button on top
        panel.setComponentZOrder(employeesBtn, 0); // Button on top
        panel.setComponentZOrder(backBtn, 2); // Button on top
		panel.setComponentZOrder(backgroundLabel, 3);
		
		this.add(panel);
		this.u=u;
	}		
		
public void actionPerformed(ActionEvent ae)
		
		
	{
		String command=ae.getActionCommand();
		
		if(command.equals(adminBtn.getText()))
		{
			AdminOperationFrame aof=new AdminOperationFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		
		if(command.equals(employeesBtn.getText()))
		{
			EmployeesOperationFrame eof=new EmployeesOperationFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
		
		
		
	}
	
}


		