package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class EmployeesUpdatePasswordFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,userIdLabel,currentPassLabel, newPassLabel;
	private JTextField userTF;
	private JPasswordField currentPassPF,newPassPF;
	private JButton confirmBtn, backBtn;
	private JPanel panel;
	private User u;



	public EmployeesUpdatePasswordFrame(User u)
	{
		super("Employees Update Password ");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);

		this.titleLabel=new JLabel("Update Password", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(380,130,200,34);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);

		this.userTF=new JTextField();
		this.userTF.setBounds(590,130,300,34);
		this.userTF.setFont(fieldFont);
		this.userTF.setText(u.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);

		this.currentPassLabel=new JLabel("Current Password:");
		this.currentPassLabel.setBounds(380,180,200,34);
		this.currentPassLabel.setFont(font);
		this.panel.add(currentPassLabel);

		this.currentPassPF=new JPasswordField();
		this.currentPassPF.setBounds(590,180,300,34);
		this.currentPassPF.setFont(fieldFont);
		this.panel.add(currentPassPF);

		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(380,230,200,34);
		this.newPassLabel.setFont(font);
		this.panel.add(newPassLabel);

		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(590,230,300,34);
		this.newPassPF.setFont(fieldFont);
		this.panel.add(newPassPF);

		this.confirmBtn=new JButton("Confirm");
		this.confirmBtn.setBounds(470,300,150,40);
		this.confirmBtn.addActionListener(this);
		this.confirmBtn.setBackground(new Color(0, 102, 204));
		this.confirmBtn.setForeground(Color.WHITE);
		this.confirmBtn.setFont(font);
		this.confirmBtn.setFocusPainted(false);
		this.panel.add(confirmBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(640,300,150,40);
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



		if(command.equals(confirmBtn.getText()))
		{
			if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{

				if(currentPassPF.getText().equals(u.getPassword()))
				{
					if(!newPassPF.getText().contains(","))
					{
						u.setPassword(newPassPF.getText());
						UserRepo urp=new UserRepo();
						urp.updateUser(u);

						currentPassPF.setText("");
						newPassPF.setText("");
						JOptionPane.showMessageDialog(this,"Password Updated Successfully");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in Password");
					}
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Password Dosen't Match!!!");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}
		}


		if(command.equals(backBtn.getText()))
		{
			EmployeeUpdateFrame euf=new EmployeeUpdateFrame(this.u);
			this.setVisible(false);
			euf.setVisible(true);
		}
	}

}
