package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class EmployeesUpdateProfileFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,userIdLabel,nameLabel, genderLabel, bloodGroupLabel, ageLabel, nidLabel, addressLabel, employeesPostLabel;
	private JTextField userTF, nameTF, genderTF, ageTF, nidTF, addressTF, employeesPostTF;
	private JComboBox bloodGroupCMB;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	private Employees employees;



	public EmployeesUpdateProfileFrame(User u)
	{
		super("Employees Update Profile Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 16);
		Font fieldFont = new Font("Arial", Font.PLAIN, 16);

		EmployeesRepo erp=new EmployeesRepo();
		this.employees=erp.searchEmployeesByUserId(u.getUserId());

		this.titleLabel=new JLabel("Update Profile", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(380,100,200,34);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);

		this.userTF=new JTextField();
		this.userTF.setBounds(590,100,300,34);
		this.userTF.setFont(fieldFont);
		this.userTF.setText(employees.getUserId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);

		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(380,145,200,34);
		this.nameLabel.setFont(font);
		this.panel.add(nameLabel);

		this.nameTF=new JTextField();
		this.nameTF.setBounds(590,145,300,34);
		this.nameTF.setFont(fieldFont);
		this.nameTF.setText(employees.getName());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);

		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(380,190,200,34);
		this.genderLabel.setFont(font);
		this.panel.add(genderLabel);

		this.genderTF=new JTextField();
		this.genderTF.setBounds(590,190,300,34);
		this.genderTF.setFont(fieldFont);
		this.genderTF.setText(employees.getGender());
		this.genderTF.setEditable(false);
		this.panel.add(genderTF);

		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(380,235,200,34);
		this.bloodGroupLabel.setFont(font);
		this.panel.add(bloodGroupLabel);

		String[] item={"A+","B+","AB+","O+","A-","B-","AB-","O-"};
		this.bloodGroupCMB=new JComboBox(item);
		this.bloodGroupCMB.setBounds(590,235,300,34);
		this.bloodGroupCMB.setFont(fieldFont);
		this.bloodGroupCMB.setBackground(Color.WHITE);
		this.bloodGroupCMB.setSelectedItem(employees.getBloodGroup());
		this.panel.add(bloodGroupCMB);

		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(380,280,200,34);
		this.ageLabel.setFont(font);
		this.panel.add(ageLabel);

		this.ageTF=new JTextField();
		this.ageTF.setBounds(590,280,300,34);
		this.ageTF.setFont(fieldFont);
		this.ageTF.setText(String.valueOf(employees.getAge()));
		this.ageTF.setEditable(false);
		this.panel.add(ageTF);

		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(380,325,200,34);
		this.nidLabel.setFont(font);
		this.panel.add(nidLabel);

		this.nidTF=new JTextField();
		this.nidTF.setBounds(590,325,300,34);
		this.nidTF.setFont(fieldFont);
		this.nidTF.setText(employees.getNid());
		this.nidTF.setEditable(false);
		this.panel.add(nidTF);

		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(380,370,200,34);
		this.addressLabel.setFont(font);
		this.panel.add(addressLabel);

		this.addressTF=new JTextField();
		this.addressTF.setBounds(590,370,300,34);
		this.addressTF.setFont(fieldFont);
		this.addressTF.setText(employees.getAddress());
		this.panel.add(addressTF);

		this.employeesPostLabel=new JLabel("Employees Post:");
		this.employeesPostLabel.setBounds(380,415,200,34);
		this.employeesPostLabel.setFont(font);
		this.panel.add(employeesPostLabel);

		this.employeesPostTF=new JTextField();
		this.employeesPostTF.setBounds(590,415,300,34);
		this.employeesPostTF.setFont(fieldFont);
		this.employeesPostTF.setText(employees.getEmployeesPost());
		this.employeesPostTF.setEditable(false);
		this.panel.add(employeesPostTF);

		this.updateBtn=new JButton("Update");
		this.updateBtn.setBounds(470,485,150,40);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(new Color(0, 102, 204));
		this.updateBtn.setForeground(Color.WHITE);
		this.updateBtn.setFont(font);
		this.updateBtn.setFocusPainted(false);
		this.panel.add(updateBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(640,485,150,40);
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


		if(command.equals(updateBtn.getText()))
		{
			if((!nidTF.getText().isEmpty()) && (!addressTF.getText().trim().isEmpty()))
			{
				if(!addressTF.getText().contains(","))
				{
					employees.setBloodGroup(bloodGroupCMB.getSelectedItem().toString());
					employees.setNid(nidTF.getText());
					employees.setAddress(addressTF.getText().trim());

					EmployeesRepo erp=new EmployeesRepo();
					erp.updateEmployees(employees);

					JOptionPane.showMessageDialog(this,"Profile Updated Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in Address");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All the Field Properly");
			}
		}


		if(command.equals(backBtn.getText()))
		{
			EmployeeUpdateFrame evf=new EmployeeUpdateFrame(this.u);
			this.setVisible(false);
			evf.setVisible(true);
		}
	}

}
