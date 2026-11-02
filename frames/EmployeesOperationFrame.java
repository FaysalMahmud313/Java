package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class EmployeesOperationFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,userIdLabel,nameLabel, genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, employeesPostLabel,salaryLabel;
	private JTextField userIdTF, nameTF, ageTF,nidTF, addressTF, securityAnsTF, employeesPostTF,salaryTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox bloodGroupCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable employeesTable;
	private JScrollPane employeesTableSP;
	private JPanel panel;
	private User u;



	public EmployeesOperationFrame(User u)
	{
		super("Employees Operation");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);

		this.titleLabel=new JLabel("Employee Operation", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(60,95,150,32);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);

		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(210,95,260,32);
		this.userIdTF.setFont(fieldFont);
		this.panel.add(userIdTF);

		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(60,140,150,32);
		this.nameLabel.setFont(font);
		this.panel.add(nameLabel);

		this.nameTF=new JTextField();
		this.nameTF.setBounds(210,140,260,32);
		this.nameTF.setFont(fieldFont);
		this.panel.add(nameTF);

		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(60,185,150,32);
		this.passLabel.setFont(font);
		this.panel.add(passLabel);

		this.passPF=new JPasswordField();
		this.passPF.setBounds(210,185,260,32);
		this.passPF.setFont(fieldFont);
		this.panel.add(passPF);

		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(60,230,150,32);
		this.nidLabel.setFont(font);
		this.panel.add(nidLabel);

		this.nidTF=new JTextField();
		this.nidTF.setBounds(210,230,260,32);
		this.nidTF.setFont(fieldFont);
		this.panel.add(nidTF);

		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(60,275,150,32);
		this.ageLabel.setFont(font);
		this.panel.add(ageLabel);

		this.ageTF=new JTextField();
		this.ageTF.setBounds(210,275,260,32);
		this.ageTF.setFont(fieldFont);
		this.panel.add(ageTF);

		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(60,320,150,32);
		this.genderLabel.setFont(font);
		this.panel.add(genderLabel);

		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(210,320,90,32);
		this.maleRB.setFont(fieldFont);
		this.maleRB.setBackground(Color.WHITE);
		this.panel.add(maleRB);

		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(310,320,100,32);
		this.femaleRB.setFont(fieldFont);
		this.femaleRB.setBackground(Color.WHITE);
		this.panel.add(femaleRB);

		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);

		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(540,95,160,32);
		this.addressLabel.setFont(font);
		this.panel.add(addressLabel);

		this.addressTF=new JTextField();
		this.addressTF.setBounds(700,95,260,32);
		this.addressTF.setFont(fieldFont);
		this.panel.add(addressTF);

		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(540,140,160,32);
		this.bloodGroupLabel.setFont(font);
		this.panel.add(bloodGroupLabel);

		String[] item={"A+","B+","AB+","O+","A-","B-","AB-","O-"};
		this.bloodGroupCMB=new JComboBox(item);
		this.bloodGroupCMB.setBounds(700,140,260,32);
		this.bloodGroupCMB.setFont(fieldFont);
		this.bloodGroupCMB.setBackground(Color.WHITE);
		this.panel.add(bloodGroupCMB);

		this.employeesPostLabel=new JLabel("Employees Post:");
		this.employeesPostLabel.setBounds(540,185,160,32);
		this.employeesPostLabel.setFont(font);
		this.panel.add(employeesPostLabel);

		this.employeesPostTF=new JTextField();
		this.employeesPostTF.setBounds(700,185,260,32);
		this.employeesPostTF.setFont(fieldFont);
		this.panel.add(employeesPostTF);

		this.salaryLabel=new JLabel("Salary:");
		this.salaryLabel.setBounds(540,230,160,32);
		this.salaryLabel.setFont(font);
		this.panel.add(salaryLabel);

		this.salaryTF=new JTextField();
		this.salaryTF.setBounds(700,230,260,32);
		this.salaryTF.setFont(fieldFont);
		this.panel.add(salaryTF);

		this.securityQuesLabel=new JLabel("Security Question: What is your Date Of Birth?");
		this.securityQuesLabel.setBounds(540,275,420,32);
		this.securityQuesLabel.setFont(font);
		this.panel.add(securityQuesLabel);

		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(540,320,160,32);
		this.securityAnsLabel.setFont(font);
		this.panel.add(securityAnsLabel);

		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(700,320,260,32);
		this.securityAnsTF.setFont(fieldFont);
		this.panel.add(securityAnsTF);

		this.addBtn=new JButton("Add Employees");
		this.addBtn.setBounds(60,375,190,40);
		this.addBtn.addActionListener(this);
		this.addBtn.setBackground(new Color(0, 102, 204));
		this.addBtn.setForeground(Color.WHITE);
		this.addBtn.setFont(font);
		this.addBtn.setFocusPainted(false);
		this.panel.add(addBtn);

		this.updateBtn=new JButton("Update Employees");
		this.updateBtn.setBounds(265,375,190,40);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(new Color(0, 102, 204));
		this.updateBtn.setForeground(Color.WHITE);
		this.updateBtn.setFont(font);
		this.updateBtn.setFocusPainted(false);
		this.panel.add(updateBtn);

		this.removeBtn=new JButton("Remove Employees");
		this.removeBtn.setBounds(470,375,190,40);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(new Color(204, 0, 0));
		this.removeBtn.setForeground(Color.WHITE);
		this.removeBtn.setFont(font);
		this.removeBtn.setFocusPainted(false);
		this.panel.add(removeBtn);

		this.searchBtn=new JButton("Search Employees");
		this.searchBtn.setBounds(675,375,190,40);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(new Color(0, 102, 204));
		this.searchBtn.setForeground(Color.WHITE);
		this.searchBtn.setFont(font);
		this.searchBtn.setFocusPainted(false);
		this.panel.add(searchBtn);

		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(880,375,150,40);
		this.resetBtn.addActionListener(this);
		this.resetBtn.setBackground(new Color(108, 117, 125));
		this.resetBtn.setForeground(Color.WHITE);
		this.resetBtn.setFont(font);
		this.resetBtn.setFocusPainted(false);
		this.panel.add(resetBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(1045,375,150,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		EmployeesRepo erp=new EmployeesRepo();
		Employees[] employeesList=erp.getAllEmployees();
		int count=0;
		for(int i=0;i<employeesList.length;i++)
		{
			if(employeesList[i]!=null)
			{
				count++;
			}
		}
		String employeesData1[][]=new String[count][9];
		int row=0;
		for(int i=0;i<employeesList.length;i++)
		{

			if(employeesList[i]!=null)
			{
				employeesData1[row][0]=employeesList[i].getUserId();
				employeesData1[row][1]=employeesList[i].getName();
				employeesData1[row][2]=employeesList[i].getGender();
				employeesData1[row][3]=employeesList[i].getBloodGroup();
				employeesData1[row][4]=String.valueOf(employeesList[i].getAge());
				employeesData1[row][5]=employeesList[i].getNid();
				employeesData1[row][6]=employeesList[i].getAddress();
				employeesData1[row][7]=employeesList[i].getEmployeesPost();
				employeesData1[row][8]=String.valueOf(employeesList[i].getSalary());
				row++;
			}

		}
		String head1[]={"Id","Name","Gender","Blood Group","Age","NID","Address","Employee Post","Salary"};
		this.employeesTable=new JTable(employeesData1,head1);
		this.employeesTable.setFont(fieldFont);
		this.employeesTable.setRowHeight(26);
		this.employeesTable.getTableHeader().setFont(font);
		this.employeesTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.employeesTable.getTableHeader().setForeground(Color.WHITE);
		this.employeesTableSP=new JScrollPane(employeesTable);
		this.employeesTableSP.setBounds(60,435,1144,215);
		this.employeesTableSP.getViewport().setBackground(Color.WHITE);
		this.employeesTable.setEnabled(false);
		this.panel.add(employeesTableSP);

		this.add(panel);

		this.u=u;

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(addBtn.getText()))
		{
			String userId,name,employeesPost,gender,address,securityAns,pass,bloodGroup,nid;
			int age;
			double salary;
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!employeesPostTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty())&& (!salaryTF.getText().isEmpty()) )
			{
				userId=userIdTF.getText().trim();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if((userId+nameTF.getText()+employeesPostTF.getText()+nidTF.getText()+addressTF.getText()+securityAnsTF.getText()+passPF.getText()).contains(","))
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in any field");
				}
				else if(user==null)
				{
					try
					{
						name=nameTF.getText();
						employeesPost=employeesPostTF.getText();
						nid=nidTF.getText();

						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}

						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}

						else
						{
							gender=maleRB.getText();
						}
						age=Integer.parseInt(ageTF.getText());
						salary=Double.parseDouble(salaryTF.getText());
						if(age<=0 || salary<0)
						{
							JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
							return;
						}
						address=addressTF.getText();
						int role=2;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
						Employees e=new Employees(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass,employeesPost,salary);
						urp.addUser(e);
						EmployeesRepo erp=new EmployeesRepo();
						erp.addEmployees(e);
						JOptionPane.showMessageDialog(this,"Employees added Successfully");

						EmployeesOperationFrame eof=new EmployeesOperationFrame(this.u);
						this.setVisible(false);
						eof.setVisible(true);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
					}
				}

				else
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}

		}

		if(command.equals(updateBtn.getText()))
		{

			String userId,name,gender,bloodGroup,nid,address,employeesPost;

			int age;
			double salary;
			if((!userIdTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!employeesPostTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!salaryTF.getText().isEmpty()))
			{
				userId=userIdTF.getText().trim();
				EmployeesRepo erp=new EmployeesRepo();
				Employees e=erp.searchEmployeesByUserId(userId);
				if((nameTF.getText()+employeesPostTF.getText()+nidTF.getText()+addressTF.getText()).contains(","))
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in any field");
				}
				else if(e!=null)
				{

					try
					{
						name=nameTF.getText();
						employeesPost=employeesPostTF.getText();
						nid=nidTF.getText();
						if(maleRB.isSelected())
						{
							gender=maleRB.getText();
						}

						else if(femaleRB.isSelected())
						{
							gender=femaleRB.getText();
						}

						else
						{
							gender=maleRB.getText();
						}
						age=Integer.parseInt(ageTF.getText());
						salary=Double.parseDouble(salaryTF.getText());
						if(age<=0 || salary<0)
						{
							JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
							return;
						}
						address=addressTF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();

						e.setName(name);
						e.setEmployeesPost(employeesPost);
						e.setSalary(salary);
						e.setBloodGroup(bloodGroup);
						e.setGender(gender);
						e.setAge(age);
						e.setAddress(address);
						e.setNid(nid);
						erp.updateEmployees(e);
						JOptionPane.showMessageDialog(this,"Employees Updated Successfully");

						EmployeesOperationFrame eof=new EmployeesOperationFrame(this.u);
						this.setVisible(false);
						eof.setVisible(true);
					}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age or Salary");
						return;
					}
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid User ID");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}
		}

		if(command.equals(removeBtn.getText()))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText().trim();
				EmployeesRepo erp=new EmployeesRepo();
				Employees e=erp.searchEmployeesByUserId(userId);
				if(e!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					erp.removeEmployees(userId);
					JOptionPane.showMessageDialog(this,"Employees Removed Successfully");

					EmployeesOperationFrame eof=new EmployeesOperationFrame(this.u);
					this.setVisible(false);
					eof.setVisible(true);
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Provide Valid User ID");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Provide a Valid UserId");
			}
		}

		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText().trim();
				EmployeesRepo erp=new EmployeesRepo();
				Employees e=erp.searchEmployeesByUserId(userId);
				if(e!=null)
				{
					userIdTF.setEditable(false);
					nameTF.setText(e.getName());
					employeesPostTF.setText(e.getEmployeesPost());
					nidTF.setText(e.getNid());
					if(e.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}

					else
					{
						femaleRB.setSelected(true);
					}
					if(e.getBloodGroup().equals("A+"))
					{
						bloodGroupCMB.setSelectedItem("A+");
					}
					else if(e.getBloodGroup().equals("B+"))
					{
						bloodGroupCMB.setSelectedItem("B+");
					}
					else if(e.getBloodGroup().equals("AB+"))
					{
						bloodGroupCMB.setSelectedItem("AB+");
					}
					else if(e.getBloodGroup().equals("O+"))
					{
						bloodGroupCMB.setSelectedItem("O+");
					}
					else if(e.getBloodGroup().equals("A-"))
					{
						bloodGroupCMB.setSelectedItem("A-");
					}
					else if(e.getBloodGroup().equals("B-"))
					{
						bloodGroupCMB.setSelectedItem("B-");
					}
					else if(e.getBloodGroup().equals("AB-"))
					{
						bloodGroupCMB.setSelectedItem("AB-");
					}
					else
					{
						bloodGroupCMB.setSelectedItem("O-");
					}
					ageTF.setText(String.valueOf(e.getAge()));
					salaryTF.setText(String.valueOf(e.getSalary()));
					addressTF.setText(e.getAddress());
					JOptionPane.showMessageDialog(this,"Employees Found.");
				}

				else
				{
					JOptionPane.showMessageDialog(this,"Emplopyees Not Found!!");
				}
			}

			else
			{
				JOptionPane.showMessageDialog(this,"Please Provide UserId To Search Employees.");
			}

		}

		if(command.equals(resetBtn.getText()))
		{
			userIdTF.setEditable(true);
			userIdTF.setText("");
			nameTF.setText("");
			nidTF.setText("");
			ageTF.setText("");
			employeesPostTF.setText("");
			salaryTF.setText("");
			addressTF.setText("");
			securityAnsTF.setText("");
			passPF.setText("");
			bg.clearSelection();
			bloodGroupCMB.setSelectedIndex(0);
			JOptionPane.showMessageDialog(this,"Reset Successfully");
		}

			if(command.equals(backBtn.getText()))
			{

				AdminOpFrame adf=new AdminOpFrame(this.u);
				this.setVisible(false);
				adf.setVisible(true);

			}
	}

}
