package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;


public class ForgetPassFrame extends JFrame implements ActionListener
{
	private ImageIcon forgotIcon;
	private JLabel userIdLabel, securityQuesLabel, securityAnsLabel, passLabel,forgotLabel;
	private JTextField userTF, securityAnsTF;
	private JPasswordField passPF;
	private JButton submitBtn, exitBtn, backBtn;
	private JPanel panel;
	
	public ForgetPassFrame()
	{
		super("Forgot Password Frame");
		this.setSize(1026,539);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 20);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		
		this.forgotIcon = new ImageIcon("image/Forgot Password.gif");
        this.forgotLabel = new JLabel();
        this.forgotLabel.setIcon(forgotIcon);
        this.forgotLabel.setBounds(510, 0, 500, 500);
        this.panel.add(forgotLabel);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,200,45);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(260,50,220,45);
		this.userTF.setFont(font);
		this.panel.add(userTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your DOB:");
		this.securityQuesLabel.setBounds(50,115,450,45);
		this.securityQuesLabel.setFont(font);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(50,180,200,45);
		this.securityAnsLabel.setFont(font);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(260,180,220,45);
		this.securityAnsTF.setFont(font);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("New Password:");
		this.passLabel.setBounds(50,245,200,45);
		this.passLabel.setFont(font);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(260,245,220,45);
		this.passPF.setFont(font);
		this.panel.add(passPF);
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(50,320,430,50);
		this.submitBtn.setFont(font);
		this.submitBtn.setBackground(new Color(0, 102, 204));
		this.submitBtn.setForeground(Color.WHITE);
		this.submitBtn.setFocusPainted(false);
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(270,385,210,45);
		this.exitBtn.setFont(font);
		this.exitBtn.setBackground(new Color(204, 0, 0));
		this.exitBtn.setForeground(Color.WHITE);
		this.exitBtn.setFocusPainted(false);
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(50,385,210,45);
		this.backBtn.setFont(font);
		this.backBtn.setBackground(Color.WHITE);
		this.backBtn.setForeground(new Color(0, 102, 204));
		this.backBtn.setBorder(BorderFactory.createLineBorder(new Color(0, 102, 204), 2));
		this.backBtn.setFocusPainted(false);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command= ae.getActionCommand();
		
		if(command.equals(submitBtn.getText()))
		{
			if((!userTF.getText().isEmpty())&&(!securityAnsTF.getText().isEmpty())&&(!passPF.getText().isEmpty()))
			{
				String userId, securityAns, newPass;
				userId=userTF.getText();
				securityAns=securityAnsTF.getText();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if(passPF.getText().contains(","))
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in Password");
				}

				else if(user!=null)
				{
					if((user.getUserId().equals(userId))&&(user.getSecurityAns().equals(securityAns)))
					{
						user.setPassword(passPF.getText());
						urp.updateUser(user);
						JOptionPane.showMessageDialog(this,"Password changed successfully");
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong security Ans");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User not Found");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Fillup all the field");
			}
		}
		
		if(command.equals(backBtn.getText()))
		{
			LoginFrame lf=new LoginFrame();
			this.setVisible(false);
			lf.setVisible(true);
		}
		
		
		if(command.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
	}
	
}
