package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;


public class EmployeeUpdateFrame extends JFrame implements ActionListener
{
	private ImageIcon backgroundIcon;
	private JLabel backgroundLabel,employeeHomeLabel, operationLabel, viewLabel, updateLabel;
	private JButton operationBtn, profileBtn, passBtn,backBtn;
	private JPanel panel;
	private User u;
	
	public EmployeeUpdateFrame(User u)
	{
		
		super("Employee Update Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		
		this.backgroundIcon = new ImageIcon("image/Update BG.jpg");
        this.backgroundLabel = new JLabel();
        this.backgroundLabel.setIcon(backgroundIcon);
        this.backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		
		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(60,260,300,60);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(new Color(195,205,239));
		this.profileBtn.setForeground(new Color(0, 0, 0));
		this.profileBtn.setFont(font);
		this.panel.add(profileBtn);
		
		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(60,380,300,60);
		this.passBtn.addActionListener(this);
		this.passBtn.setBackground(new Color(195,205,239));
		this.passBtn.setForeground(new Color(0, 0, 0));
		this.passBtn.setFont(font);
		this.panel.add(passBtn);
		
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(900,600,150,50);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(191, 191, 191));
		this.backBtn.setForeground(new Color(0, 0, 0));
		this.backBtn.setFont(font);
		this.panel.add(backBtn);
		
		panel.setComponentZOrder(profileBtn, 1); // Button on top
        panel.setComponentZOrder(passBtn, 0);// Button on top
        panel.setComponentZOrder(backBtn, 2); // Button on top
		panel.setComponentZOrder(backgroundLabel, 3);
		
		
		this.add(panel);
		this.u=u;
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		
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
		if(command.equals(backBtn.getText()))
		{
			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}
		
		
		
	}
	
}