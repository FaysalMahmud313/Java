package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class AdminOperationFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,userIdLabel,nameLabel, genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel, cspLabel;
	private JTextField userTF, nameTF, ageTF,nidTF, addressTF, securityAnsTF, cspTF;
	private JPasswordField passPF;
	private JRadioButton maleRB, femaleRB;
	private ButtonGroup bg;
	private JComboBox bloodGroupCMB;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JTable adminTable;
	private JScrollPane adminTableSP;
	private JPanel panel;
	private User u;



	public AdminOperationFrame(User u)
	{
		super("Admin Operation Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);

		this.titleLabel=new JLabel("Admin Operation", JLabel.CENTER);
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

		this.userTF=new JTextField();
		this.userTF.setBounds(210,95,260,32);
		this.userTF.setFont(fieldFont);
		this.panel.add(userTF);

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

		this.cspLabel=new JLabel("Company Share:");
		this.cspLabel.setBounds(540,185,160,32);
		this.cspLabel.setFont(font);
		this.panel.add(cspLabel);

		this.cspTF=new JTextField();
		this.cspTF.setBounds(700,185,260,32);
		this.cspTF.setFont(fieldFont);
		this.panel.add(cspTF);

		this.securityQuesLabel=new JLabel("Security Question: What is your Date Of Birth?");
		this.securityQuesLabel.setBounds(540,230,420,32);
		this.securityQuesLabel.setFont(font);
		this.panel.add(securityQuesLabel);

		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(540,275,160,32);
		this.securityAnsLabel.setFont(font);
		this.panel.add(securityAnsLabel);

		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(700,275,260,32);
		this.securityAnsTF.setFont(fieldFont);
		this.panel.add(securityAnsTF);

		this.addBtn=new JButton("Add Admin");
		this.addBtn.setBounds(60,375,150,40);
		this.addBtn.addActionListener(this);
		this.addBtn.setBackground(new Color(0, 102, 204));
		this.addBtn.setForeground(Color.WHITE);
		this.addBtn.setFont(font);
		this.addBtn.setFocusPainted(false);
		this.panel.add(addBtn);

		this.updateBtn=new JButton("Update Admin");
		this.updateBtn.setBounds(225,375,150,40);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(new Color(0, 102, 204));
		this.updateBtn.setForeground(Color.WHITE);
		this.updateBtn.setFont(font);
		this.updateBtn.setFocusPainted(false);
		this.panel.add(updateBtn);

		this.removeBtn=new JButton("Remove Admin");
		this.removeBtn.setBounds(390,375,150,40);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(new Color(204, 0, 0));
		this.removeBtn.setForeground(Color.WHITE);
		this.removeBtn.setFont(font);
		this.removeBtn.setFocusPainted(false);
		this.panel.add(removeBtn);

		this.searchBtn=new JButton("Search Admin");
		this.searchBtn.setBounds(555,375,150,40);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(new Color(0, 102, 204));
		this.searchBtn.setForeground(Color.WHITE);
		this.searchBtn.setFont(font);
		this.searchBtn.setFocusPainted(false);
		this.panel.add(searchBtn);

		this.resetBtn=new JButton("Reset");
		this.resetBtn.setBounds(720,375,150,40);
		this.resetBtn.addActionListener(this);
		this.resetBtn.setBackground(new Color(108, 117, 125));
		this.resetBtn.setForeground(Color.WHITE);
		this.resetBtn.setFont(font);
		this.resetBtn.setFocusPainted(false);
		this.panel.add(resetBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(885,375,150,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		AdminRepo arp=new AdminRepo();
		Admin[] adminList=arp.getAllAdmin();
		int count=0;
		for(int i=0;i<adminList.length;i++)
		{
			if(adminList[i]!=null)
			{
				count++;
			}
		}
		String adminData1[][]=new String[count][8];
		int row=0;
		for(int i=0;i<adminList.length;i++)
		{

			if(adminList[i]!=null)
			{
				adminData1[row][0]=adminList[i].getUserId();
				adminData1[row][1]=adminList[i].getName();
				adminData1[row][2]=adminList[i].getGender();
				adminData1[row][3]=adminList[i].getBloodGroup();
				adminData1[row][4]=String.valueOf(adminList[i].getAge());
				adminData1[row][5]=adminList[i].getNid();
				adminData1[row][6]=adminList[i].getAddress();
				adminData1[row][7]=adminList[i].getCompanyShareParcentage();
				row++;
			}

		}
		String head1[]={"Id","Name","Gender","Blood Group","Age","NID","Address","Company Share"};
		this.adminTable=new JTable(adminData1,head1);
		this.adminTable.setFont(fieldFont);
		this.adminTable.setRowHeight(26);
		this.adminTable.getTableHeader().setFont(font);
		this.adminTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.adminTable.getTableHeader().setForeground(Color.WHITE);
		this.adminTableSP=new JScrollPane(adminTable);
		this.adminTableSP.setBounds(60,435,1144,215);
		this.adminTableSP.getViewport().setBackground(Color.WHITE);
		this.adminTable.setEnabled(false);
		this.panel.add(adminTableSP);

		this.add(panel);

		this.u=u;

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(addBtn.getText()))
		{
			String userId,name,csp,gender,address,securityAns,pass,bloodGroup,nid;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!cspTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				userId=userTF.getText().trim();
				UserRepo urp=new UserRepo();
				User user=urp.searchUserByUserId(userId);
				if((userId+nameTF.getText()+cspTF.getText()+nidTF.getText()+addressTF.getText()+securityAnsTF.getText()+passPF.getText()).contains(","))
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in any field");
				}
				else if(user==null)
				{

					try
					{
						name=nameTF.getText();
						csp=cspTF.getText();
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
						if(age<=0)
						{
							JOptionPane.showMessageDialog(this,"provide valid age");
							return;
						}
						address=addressTF.getText();
						int role=1;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
						Admin a=new Admin(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass,csp);
						User ur =new User(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass);
						urp.addUser(ur);
						AdminRepo arp=new AdminRepo();
						arp.addAdmin(a);
						JOptionPane.showMessageDialog(this,"Admin added Successfully");

						AdminOperationFrame aof=new AdminOperationFrame(this.u);
						this.setVisible(false);
						aof.setVisible(true);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}

				else
				{
					JOptionPane.showMessageDialog(this,"User Id already exists.");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}

		}

		if(command.equals(updateBtn.getText()))
		{

			String userId,name,gender,bloodGroup,nid,address,csp;
			int age;
			if((!userTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!cspTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				userId=userTF.getText().trim();
				AdminRepo arp=new AdminRepo();
				Admin a=arp.searchAdminByUserId(userId);
				if((nameTF.getText()+cspTF.getText()+nidTF.getText()+addressTF.getText()).contains(","))
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in any field");
				}
				else if(a!=null)
				{

					try
					{
						name=nameTF.getText();
						csp=cspTF.getText();
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
						if(age<=0)
						{
							JOptionPane.showMessageDialog(this,"provide valid age");
							return;
						}
						address=addressTF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();

						a.setName(name);
						a.setCompanyShareParcentage(csp);
						a.setBloodGroup(bloodGroup);
						a.setGender(gender);
						a.setAge(age);
						a.setAddress(address);
						a.setNid(nid);
						arp.updateAdmin(a);
						JOptionPane.showMessageDialog(this,"admin updated Successfully");

						AdminOperationFrame aof=new AdminOperationFrame(this.u);
						this.setVisible(false);
						aof.setVisible(true);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"provide valid age");
					}
				}

				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}

		if(command.equals(removeBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText().trim();
				AdminRepo arp=new AdminRepo();
				Admin a=arp.searchAdminByUserId(userId);
				if(userId.equals(this.u.getUserId()))
				{
					JOptionPane.showMessageDialog(this,"You can not remove your own account.");
				}
				else if(a!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					arp.removeAdmin(userId);
					JOptionPane.showMessageDialog(this,"Admin removed Successfully");

					AdminOperationFrame aof=new AdminOperationFrame(this.u);
					this.setVisible(false);
					aof.setVisible(true);
				}

				else
				{
					JOptionPane.showMessageDialog(this,"provide Valid user ID");
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"please Provide a valid userId");
			}
		}

		if(command.equals(searchBtn.getText()))
		{
			String userId;
			if(!userTF.getText().isEmpty())
			{
				userId=userTF.getText().trim();
				AdminRepo urp=new AdminRepo();
				Admin a=urp.searchAdminByUserId(userId);
				if(a!=null)
				{
					userTF.setEditable(false);
					nameTF.setText(a.getName());
					cspTF.setText(a.getCompanyShareParcentage());
					nidTF.setText(a.getNid());
					if(a.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}

					else
					{
						femaleRB.setSelected(true);
					}
					if(a.getBloodGroup().equals("A+"))
					{
						bloodGroupCMB.setSelectedItem("A+");
					}
					else if(a.getBloodGroup().equals("B+"))
					{
						bloodGroupCMB.setSelectedItem("B+");
					}
					else if(a.getBloodGroup().equals("AB+"))
					{
						bloodGroupCMB.setSelectedItem("AB+");
					}
					else if(a.getBloodGroup().equals("O+"))
					{
						bloodGroupCMB.setSelectedItem("O+");
					}
					else if(a.getBloodGroup().equals("A-"))
					{
						bloodGroupCMB.setSelectedItem("A-");
					}
					else if(a.getBloodGroup().equals("B-"))
					{
						bloodGroupCMB.setSelectedItem("B-");
					}
					else if(a.getBloodGroup().equals("AB-"))
					{
						bloodGroupCMB.setSelectedItem("AB-");
					}
					else
					{
						bloodGroupCMB.setSelectedItem("O-");
					}
					ageTF.setText(String.valueOf(a.getAge()));
					addressTF.setText(a.getAddress());
					JOptionPane.showMessageDialog(this,"admin found");
				}

				else
				{
					JOptionPane.showMessageDialog(this,"admin not found");
				}
			}

			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to search admin.");
			}

		}

		if(command.equals(resetBtn.getText()))
		{
			userTF.setEditable(true);
			userTF.setText("");
			nameTF.setText("");
			nidTF.setText("");
			ageTF.setText("");
			addressTF.setText("");
			cspTF.setText("");
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
