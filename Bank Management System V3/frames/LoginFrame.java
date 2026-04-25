package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import entities.*;
import repositories.*;


public class LoginFrame extends JFrame implements ActionListener
{
	private ImageIcon background,loginIcon,userIcon,passIcon;
	private JLabel userIdLabel, passLabel,backgroundLabel,userLabel;
	private JTextField userIdTF;
	private JPasswordField passPF;
	private JButton loginBtn, exitBtn, createAccountBtn, forgetPassBtn;
	private JPanel panel;
	private Account ac;
	private User u;
	
	public LoginFrame()
	{
		super("Welcome To KAM Bank PLC.");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBounds(0, 0, 1280, 720);
		this.panel.setBackground(new Color(255, 255, 255));
		
		this.background = new ImageIcon("image/UI3.gif");
        this.backgroundLabel = new JLabel();
        this.backgroundLabel.setIcon(background);
        this.backgroundLabel.setBounds(560, 0, 720, 720);
        this.panel.add(backgroundLabel);
		
		/*this.welcomeLabel = new JLabel("Welcome to KAM Bank PLC");
		Font welcomeFont = new Font("Arial", Font.BOLD, 30); 
		this.welcomeLabel.setFont(welcomeFont);
		this.welcomeLabel.setBounds(275, 100, 500, 60); 
		this.panel.add(welcomeLabel);*/
		
		this.userIcon = new ImageIcon("image/User.png");
        this.userLabel = new JLabel();
        this.userLabel.setIcon(userIcon);
        this.userLabel.setBounds(100, 250, 50, 50);
        this.panel.add(userLabel);
		
		/*this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(49, 311, 42, 25);
		this.userIdLabel.setOpaque(true);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);*/
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(190, 248, 270, 50);
		this.userIdTF.setFont(font);
		Border border = BorderFactory.createLineBorder(new Color(123, 123, 123), 2);
        this.userIdTF.setBorder(border);
		this.panel.add(userIdTF);
		
		this.passIcon = new ImageIcon("image/Pass.png");
        this.passLabel = new JLabel();
        this.passLabel.setIcon(passIcon);
        this.passLabel.setBounds(100, 329, 50, 50);
        this.panel.add(passLabel);
		
		/*this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(49, 382, 161, 27);
		this.passLabel.setOpaque(true);
		this.passLabel.setFont(font);
		this.panel.add(passLabel);*/
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(190, 321, 270, 50);
		this.passPF.setFont(font);
        Border passwordBorder = BorderFactory.createLineBorder(new Color(123, 123, 123), 2);
        this.passPF.setBorder(passwordBorder);
		this.panel.add(passPF);
		
		this.loginBtn=new JButton("Login");
		this.loginBtn.setBounds(100, 408, 360, 50);
		this.loginBtn.addActionListener(this);
		this.loginBtn.setBackground(new Color(51, 204, 255));
		this.loginBtn.setForeground(Color.WHITE);
        this.loginBtn.setFont(font);
        this.loginBtn.setFocusPainted(false);
		this.panel.add(loginBtn);
		this.loginBtn.setVisible(true);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(210,580,150,50);
		this.exitBtn.addActionListener(this);
		this.exitBtn.setBackground(new Color(204, 0, 0));
		this.exitBtn.setFont(font);
		this.panel.add(exitBtn);
		
		this.createAccountBtn=new JButton("Create Account");
		this.createAccountBtn.setBounds(20, 512, 250, 50);
		this.createAccountBtn.addActionListener(this);
		this.createAccountBtn.setBackground(new Color(102, 255, 102));
		this.createAccountBtn.setFont(font);
		this.panel.add(createAccountBtn);
		
		this.forgetPassBtn=new JButton("Forget Password");
		this.forgetPassBtn.setBounds(300,512,250,50);
		this.forgetPassBtn.addActionListener(this);
		this.forgetPassBtn.setBackground(new Color(255, 102, 102));
		this.forgetPassBtn.setFont(font);
		this.panel.add(forgetPassBtn);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(loginBtn.getText()))
		{
			String uId=userIdTF.getText();
			String pass=passPF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUserByUserId(uId);
			if(user!=null)
			{
				if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==1)
				{
					AdminHomeFrame ahf=new AdminHomeFrame(user);
					this.setVisible(false);
					ahf.setVisible(true);
				}
				
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==2)
				{
					EmployeesHomeFrame ehf=new EmployeesHomeFrame(user);
					this.setVisible(false);
					ehf.setVisible(true);
				}
				
				else if(user.getUserId().equals(uId)&&user.getPassword().equals(pass)&&user.getRole()==3)
				{
					CustomersHomeFrame chf=new CustomersHomeFrame(user);
					this.setVisible(false);
					chf.setVisible(true);
				}
				
				
				
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong user Id or Password!", "WARNING!!!", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(this, "Wrong user Id or Password!", "WARNING!!!", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(command.equals(createAccountBtn.getText()))
		{
			CreateAccountFrame caf=new CreateAccountFrame(this.u);
			this.setVisible(false);
			caf.setVisible(true);
		}
		
		if(command.equals(forgetPassBtn.getText()))
		{
			ForgetPassFrame fpf=new ForgetPassFrame();
			this.setVisible(false);
			fpf.setVisible(true);
		}
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
