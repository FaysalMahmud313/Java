package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminUpdateFrame extends JFrame implements ActionListener
{
	private JLabel updateLabel;
	private JButton backBtn,passBtn,profileBtn;
	private JPanel panel;
	private User u;

	public AdminUpdateFrame(User u)
	{
		super("Admin Update Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 20);

		this.updateLabel=new JLabel("Updates", JLabel.CENTER);
		this.updateLabel.setBounds(0,0,1264,70);
		this.updateLabel.setOpaque(true);
		this.updateLabel.setBackground(new Color(0, 102, 204));
		this.updateLabel.setForeground(Color.WHITE);
		this.updateLabel.setFont(titleFont);
		this.panel.add(updateLabel);

		this.profileBtn=new JButton("Update Profile");
		this.profileBtn.setBounds(452,160,360,50);
		this.profileBtn.addActionListener(this);
		this.profileBtn.setBackground(new Color(0, 102, 204));
		this.profileBtn.setForeground(Color.WHITE);
		this.profileBtn.setFont(font);
		this.profileBtn.setFocusPainted(false);
		this.panel.add(profileBtn);

		this.passBtn=new JButton("Update Password");
		this.passBtn.setBounds(452,235,360,50);
		this.passBtn.addActionListener(this);
		this.passBtn.setBackground(new Color(0, 102, 204));
		this.passBtn.setForeground(Color.WHITE);
		this.passBtn.setFont(font);
		this.passBtn.setFocusPainted(false);
		this.panel.add(passBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(452,335,360,50);
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

		if(command.equals(profileBtn.getText()))
		{
			AdminRepo arp=new AdminRepo();
			if(arp.searchAdminByUserId(this.u.getUserId())!=null)
			{
				AdminUpdateProfileFrame aof=new AdminUpdateProfileFrame(this.u);
				this.setVisible(false);
				aof.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Admin profile not found.");
			}
		}

		if(command.equals(passBtn.getText()))
		{
			AdminUpdatePasswordFrame aof=new AdminUpdatePasswordFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}
	}
}
