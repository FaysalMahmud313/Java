package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;


public class EmployeesHomeFrame extends JFrame implements ActionListener
{
	private ImageIcon backgroundIcon,operationIcon,viewIcon,updateIcon,backIcon;
	private JLabel backgroundLabel,employeeHomeLabel, operationLabel, viewLabel, updateLabel;
	private JButton operationBtn, viewBtn,updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Transaction t;
	
	public EmployeesHomeFrame(User u)
	{
		
		super("Employees Home Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		
		
		backgroundIcon = new ImageIcon("image/Employee Panel.jpg");
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		this.operationBtn=new JButton("Operations");
		this.operationBtn.setBounds(100,220,300,50);
		this.operationBtn.addActionListener(this);
		this.operationBtn.setBackground(new Color(51, 204, 255));
		this.operationBtn.setForeground(Color.WHITE);
        this.operationBtn.setFont(font);
        this.operationBtn.setFocusPainted(false);
		this.panel.add(operationBtn);
		this.operationBtn.setVisible(true);
		
		/*operationIcon = new ImageIcon("image/Operations.png");
		this.operationBtn=new JButton(operationIcon);
		this.operationBtn.setBounds(180,200,148,64);
		operationBtn.setBorderPainted(false);
		this.operationBtn.addActionListener(this);
		this.panel.add(operationBtn);*/
		
		this.viewBtn=new JButton("View");
		this.viewBtn.setBounds(100,320,300,50);
		this.viewBtn.addActionListener(this);
		this.viewBtn.setBackground(new Color(51, 204, 255));
		this.viewBtn.setForeground(Color.WHITE);
        this.viewBtn.setFont(font);
        this.viewBtn.setFocusPainted(false);
		this.panel.add(viewBtn);
		this.viewBtn.setVisible(true);
		
		/*viewIcon = new ImageIcon("image/View.png");
		this.viewBtn=new JButton(viewIcon);
		this.viewBtn.setBounds(180,304,144,63);
		viewBtn.setBorderPainted(false);
		this.viewBtn.addActionListener(this);
		this.panel.add(viewBtn);*/
		
		this.updateBtn=new JButton("Updates");
		this.updateBtn.setBounds(100,420,300,50);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(new Color(51, 204, 255));
		this.updateBtn.setForeground(Color.WHITE);
        this.updateBtn.setFont(font);
        this.updateBtn.setFocusPainted(false);
		this.panel.add(updateBtn);
		this.updateBtn.setVisible(true);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(900,600,150,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(191, 191, 191));
		this.backBtn.setForeground(new Color(0, 0, 0));
		this.backBtn.setFont(font);
		this.panel.add(backBtn);
		
		panel.setComponentZOrder(operationBtn, 1); 
        panel.setComponentZOrder(viewBtn, 0); 
        panel.setComponentZOrder(updateBtn, 2);
		panel.setComponentZOrder(backBtn, 3);
        panel.setComponentZOrder(backgroundLabel, 4);
		
		
		this.add(panel);
		this.u=u;
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
		if(command.equals(operationBtn.getText()))
		{
			EmployeeOpFrame eof=new EmployeeOpFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
		
		if(command.equals(viewBtn.getText()))
		{
			EmployeeViewFrame evf=new EmployeeViewFrame(this.u);
			this.setVisible(false);
			evf.setVisible(true);
		}
		if(command.equals(updateBtn.getText()))
		{
			EmployeeUpdateFrame euf=new EmployeeUpdateFrame(this.u);
			this.setVisible(false);
			euf.setVisible(true);
		}
		/*if(command.equals(accountBtn.getText()))
		{
			AllAccount ac =new AllAccount(this.u);
			this.setVisible(false);
			ac.setVisible(true);
		}
		
		if(command.equals(profileBtn.getText()))
		{
			EmployeesUpdateProfileFrame eupf=new EmployeesUpdateProfileFrame(this.u);
			this.setVisible(false);
			eupf.setVisible(true);
		}
		
		if(command.equals(passBtn.getText()))
		{
			EmployeesUpdatePasswordFrame eupf=new EmployeesUpdatePasswordFrame(this.u);
			this.setVisible(false);
			eupf.setVisible(true);
		}
		if(command.equals(wdBtn.getText()))
		{
			TransactionOperationFrame tof=new TransactionOperationFrame(this.t,this.u);
			this.setVisible(false);
			tof.setVisible(true);
		}*/
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
		
	}
	
}
