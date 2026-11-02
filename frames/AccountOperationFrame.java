package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import entities.*;
import repositories.*;

public class AccountOperationFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,accNoLabel,userIdLabel,statusLabel,balanceLabel,nameLabel, creditLabel,genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField accNoTF,userIdTF,balanceTF,nameTF, ageTF,nidTF, addressTF, securityAnsTF,creditTF;
	private JTable accountTable;
	private JScrollPane accountTableSP;
	private JRadioButton maleRB, femaleRB,activeRB,deactiveRB;
	private ButtonGroup bg,bg1;
	private JComboBox bloodGroupCMB;
	private JPasswordField passPF;
	private JButton addBtn,removeBtn,backBtn,searchBtn,checkBalanceBtn;
	private JPanel panel;
	private Account ac;
	private User u;



	public AccountOperationFrame(Account ac,User u)
	{
		super("Account Operation");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);

		this.titleLabel=new JLabel("Account Operation", JLabel.CENTER);
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

		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(60,365,150,32);
		this.bloodGroupLabel.setFont(font);
		this.panel.add(bloodGroupLabel);

		String[] item={"A+","B+","AB+","O+","A-","B-","AB-","O-"};
		this.bloodGroupCMB=new JComboBox(item);
		this.bloodGroupCMB.setBounds(210,365,260,32);
		this.bloodGroupCMB.setFont(fieldFont);
		this.bloodGroupCMB.setBackground(Color.WHITE);
		this.panel.add(bloodGroupCMB);

		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(540,95,160,32);
		this.addressLabel.setFont(font);
		this.panel.add(addressLabel);

		this.addressTF=new JTextField();
		this.addressTF.setBounds(700,95,260,32);
		this.addressTF.setFont(fieldFont);
		this.panel.add(addressTF);

		this.accNoLabel=new JLabel("Account No:");
		this.accNoLabel.setBounds(540,140,160,32);
		this.accNoLabel.setFont(font);
		this.panel.add(accNoLabel);

		this.accNoTF=new JTextField();
		this.accNoTF.setBounds(700,140,260,32);
		this.accNoTF.setFont(fieldFont);
		this.accNoTF.setText(new AccountRepo().generateAccNo());
		this.accNoTF.setEditable(false);
		this.panel.add(accNoTF);

		this.statusLabel=new JLabel("Status:");
		this.statusLabel.setBounds(540,185,160,32);
		this.statusLabel.setFont(font);
		this.panel.add(statusLabel);

		this.activeRB=new JRadioButton("Active");
		this.activeRB.setBounds(700,185,90,32);
		this.activeRB.setFont(fieldFont);
		this.activeRB.setBackground(Color.WHITE);
		this.panel.add(activeRB);

		this.deactiveRB=new JRadioButton("InActive");
		this.deactiveRB.setBounds(800,185,100,32);
		this.deactiveRB.setFont(fieldFont);
		this.deactiveRB.setBackground(Color.WHITE);
		this.panel.add(deactiveRB);

		this.bg1=new ButtonGroup();
		bg1.add(activeRB);
		bg1.add(deactiveRB);

		this.balanceLabel=new JLabel("Primary Balance:");
		this.balanceLabel.setBounds(540,230,160,32);
		this.balanceLabel.setFont(font);
		this.panel.add(balanceLabel);

		this.balanceTF=new JTextField();
		this.balanceTF.setBounds(700,230,260,32);
		this.balanceTF.setFont(fieldFont);
		this.panel.add(balanceTF);

		this.creditLabel=new JLabel("Primary Credit:");
		this.creditLabel.setBounds(540,275,160,32);
		this.creditLabel.setFont(font);
		this.panel.add(creditLabel);

		this.creditTF=new JTextField();
		this.creditTF.setBounds(700,275,260,32);
		this.creditTF.setFont(fieldFont);
		this.panel.add(creditTF);

		this.securityQuesLabel=new JLabel("Security Question: What is your Date Of Birth?");
		this.securityQuesLabel.setBounds(540,320,420,32);
		this.securityQuesLabel.setFont(font);
		this.panel.add(securityQuesLabel);

		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(540,365,160,32);
		this.securityAnsLabel.setFont(font);
		this.panel.add(securityAnsLabel);

		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(700,365,260,32);
		this.securityAnsTF.setFont(fieldFont);
		this.panel.add(securityAnsTF);

		this.addBtn=new JButton("Create Account");
		this.addBtn.setBounds(60,415,170,40);
		this.addBtn.addActionListener(this);
		this.addBtn.setBackground(new Color(0, 102, 204));
		this.addBtn.setForeground(Color.WHITE);
		this.addBtn.setFont(font);
		this.addBtn.setFocusPainted(false);
		this.panel.add(addBtn);

		this.removeBtn=new JButton("Delete Account");
		this.removeBtn.setBounds(245,415,170,40);
		this.removeBtn.addActionListener(this);
		this.removeBtn.setBackground(new Color(204, 0, 0));
		this.removeBtn.setForeground(Color.WHITE);
		this.removeBtn.setFont(font);
		this.removeBtn.setFocusPainted(false);
		this.panel.add(removeBtn);

		this.searchBtn=new JButton("Search By User Id");
		this.searchBtn.setBounds(430,415,190,40);
		this.searchBtn.addActionListener(this);
		this.searchBtn.setBackground(new Color(0, 102, 204));
		this.searchBtn.setForeground(Color.WHITE);
		this.searchBtn.setFont(font);
		this.searchBtn.setFocusPainted(false);
		this.panel.add(searchBtn);

		this.checkBalanceBtn=new JButton("Balance Check");
		this.checkBalanceBtn.setBounds(635,415,170,40);
		this.checkBalanceBtn.addActionListener(this);
		this.checkBalanceBtn.setBackground(new Color(0, 102, 204));
		this.checkBalanceBtn.setForeground(Color.WHITE);
		this.checkBalanceBtn.setFont(font);
		this.checkBalanceBtn.setFocusPainted(false);
		this.panel.add(checkBalanceBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(820,415,150,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		AccountRepo arp=new AccountRepo();
		Account[] accountList=arp.getAllAccount();
		int count=0;
		for(int i=0;i<accountList.length;i++)
		{
			if(accountList[i]!=null)
			{
				count++;
			}
		}
		String accountData1[][]=new String[count][4];
		int row=0;
		for(int i=0;i<accountList.length;i++)
		{

			if(accountList[i]!=null)
			{
				accountData1[row][0]=accountList[i].getAccNo();
				accountData1[row][1]=accountList[i].getUserId();
				accountData1[row][2]=accountList[i].getStatus();
				accountData1[row][3]=String.valueOf(accountList[i].getBalance());
				row++;
			}
		}

		String head1[]={"Account No","User Id","Status","Balance"};
		this.accountTable=new JTable(accountData1,head1);
		this.accountTable.setFont(fieldFont);
		this.accountTable.setRowHeight(26);
		this.accountTable.getTableHeader().setFont(font);
		this.accountTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.accountTable.getTableHeader().setForeground(Color.WHITE);
		this.accountTableSP=new JScrollPane(accountTable);
		this.accountTableSP.setBounds(60,475,1144,175);
		this.accountTableSP.getViewport().setBackground(Color.WHITE);
		this.accountTable.setEnabled(false);
		this.panel.add(accountTableSP);

		this.add(panel);

		this.u=u;
		this.ac=ac;

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		AccountRepo arp=new AccountRepo();
		int age;
		double balance,credit;
		String accNo, userId, status,name,gender,address,securityAns,pass,bloodGroup,nid;

		if(command.equals(addBtn.getText()))
		{


			if((!userIdTF.getText().isEmpty()) && (!accNoTF.getText().isEmpty()) && ((activeRB.isSelected()) || (deactiveRB.isSelected())) && (!balanceTF.getText().isEmpty()) && (!creditTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()) )
			{
				userId=userIdTF.getText().trim();
				accNo=arp.generateAccNo();
				accNoTF.setText(accNo);

				UserRepo urp=new UserRepo();
				Account ac=arp.searchAccountByUserId(userId);
				if((userId+accNo+nameTF.getText()+nidTF.getText()+addressTF.getText()+securityAnsTF.getText()+passPF.getText()).contains(","))
				{
					JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in any field");
				}
				else if(ac!=null || urp.searchUserByUserId(userId)!=null)
				{
					JOptionPane.showMessageDialog(this,"User Id Already Exists.");
				}
				else
				{
					try
					{
						name=nameTF.getText();
						credit= Double.parseDouble(creditTF.getText());
						nid=nidTF.getText();
						balance = Double.parseDouble(balanceTF.getText());
						age=Integer.parseInt(ageTF.getText());
						if(balance<0 || credit<0 || age<=0)
						{
							JOptionPane.showMessageDialog(this,"Provide Valid Age, Balance and Credit");
							return;
						}

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
						if(activeRB.isSelected())
						{
							status=activeRB.getText();
						}

						else if(deactiveRB.isSelected())
						{
							status=deactiveRB.getText();
						}

						else
						{
							status=activeRB.getText();
						}
						address=addressTF.getText();
						int role=3;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();

						User ur =new User(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass);
						urp.addUser(ur);
						CustomersRepo crp=new CustomersRepo();
						Customers c=new Customers(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass,credit);
						crp.addCustomers(c);

						Account ac1=new Account(accNo,userId,status,balance);
						arp.createAccount(ac1);

						JOptionPane.showMessageDialog(this, "Account Created Successfully\nAccount No: " + accNo);

						AccountOperationFrame aof=new AccountOperationFrame(this.ac,this.u);
						this.setVisible(false);
						aof.setVisible(true);
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age, Balance and Credit");
					}
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}

		}

		if(command.equals(removeBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText().trim();
				CustomersRepo crp=new CustomersRepo();
				Account ac=arp.searchAccountByUserId(userId);
				if(ac!=null)
				{
					UserRepo urp=new UserRepo();
					urp.removeUser(userId);
					arp.removeAccount(userId);
					crp.removeCustomers(userId);
					JOptionPane.showMessageDialog(this, "Account Removed Successfully");

					AccountOperationFrame aof=new AccountOperationFrame(this.ac,this.u);
					this.setVisible(false);
					aof.setVisible(true);
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

			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText().trim();
				CustomersRepo crp=new CustomersRepo();
				Account ac=arp.searchAccountByUserId(userId);
				Customers c=crp.searchCustomersByUserId(userId);
				if(ac!=null && c!=null)
				{
					userIdTF.setEditable(false);
					accNoTF.setText(ac.getAccNo());
					nameTF.setText(c.getName());
					nidTF.setText(c.getNid());
					balanceTF.setText(String.valueOf(ac.getBalance()));
					if(c.getGender().equals("Male"))
					{
						maleRB.setSelected(true);
					}

					else
					{
						femaleRB.setSelected(true);
					}
					if(ac.getStatus().equals("Active"))
					{
						activeRB.setSelected(true);
					}

					else
					{
						deactiveRB.setSelected(true);
					}
					if(c.getBloodGroup().equals("A+"))
					{
						bloodGroupCMB.setSelectedItem("A+");
					}
					else if(c.getBloodGroup().equals("B+"))
					{
						bloodGroupCMB.setSelectedItem("B+");
					}
					else if(c.getBloodGroup().equals("AB+"))
					{
						bloodGroupCMB.setSelectedItem("AB+");
					}
					else if(c.getBloodGroup().equals("O+"))
					{
						bloodGroupCMB.setSelectedItem("O+");
					}
					else if(c.getBloodGroup().equals("A-"))
					{
						bloodGroupCMB.setSelectedItem("A-");
					}
					else if(c.getBloodGroup().equals("B-"))
					{
						bloodGroupCMB.setSelectedItem("B-");
					}
					else if(c.getBloodGroup().equals("AB-"))
					{
						bloodGroupCMB.setSelectedItem("AB-");
					}
					else
					{
						bloodGroupCMB.setSelectedItem("O-");
					}
					ageTF.setText(String.valueOf(c.getAge()));
					addressTF.setText(c.getAddress());
					creditTF.setText(String.valueOf(c.getCreditScore()));
					JOptionPane.showMessageDialog(this, "Account Found");

				}

				else
				{
					JOptionPane.showMessageDialog(this,"Account not found");
				}
			}

			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to Search Account.");
			}

		}
		if(command.equals(checkBalanceBtn.getText()))
		{
			if(!userIdTF.getText().isEmpty())
			{
				userId=userIdTF.getText().trim();
				if(arp.searchAccountByUserId(userId)!=null)
				{
					balance = arp.checkBalance(userId);
					JOptionPane.showMessageDialog(this,"Balance for userId " + userId + ": " + balance);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Account not found");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please provide userId to Check Balance.");
			}
		}

		if(command.equals(backBtn.getText()))
		{

			EmployeeOpFrame eof=new EmployeeOpFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}
	}


}
