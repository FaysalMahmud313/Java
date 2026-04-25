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
		this.setSize(1010,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 20);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(new Color(255, 255, 204));
		
		this.forgotIcon = new ImageIcon("image/Forgot Password.gif");
        this.forgotLabel = new JLabel();
        this.forgotLabel.setIcon(forgotIcon);
        this.forgotLabel.setBounds(510, 0, 500, 500);
        this.panel.add(forgotLabel);
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,150,50);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(280,40,150,50);
		this.userTF.setFont(font);
		this.panel.add(userTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your DOB:");
		this.securityQuesLabel.setBounds(50,110,450,50);
		this.securityQuesLabel.setFont(font);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(50,180,200,50);
		this.securityAnsLabel.setFont(font);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(280,170,150,50);
		this.securityAnsTF.setFont(font);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("New Password:");
		this.passLabel.setBounds(50,240,200,50);
		this.passLabel.setFont(font);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(280,230,150,50);
		this.passPF.setFont(font);
		this.panel.add(passPF);
		
		this.submitBtn=new JButton("Submit");
		this.submitBtn.setBounds(50,320,150,50);
		this.submitBtn.setFont(font);
		this.submitBtn.setBackground(new Color(51, 204, 255));
		this.submitBtn.addActionListener(this);
		this.panel.add(submitBtn);
		
		this.exitBtn=new JButton("Exit");
		this.exitBtn.setBounds(130,390,220,50);
		this.exitBtn.setFont(font);
		this.exitBtn.setBackground(new Color(204, 0, 0));
		this.exitBtn.addActionListener(this);
		this.panel.add(exitBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(230,320,150,50);
		this.backBtn.setFont(font);
		this.backBtn.setBackground(new Color(255, 102, 102));
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
				if(user!=null)
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
