package frames;

import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CreateAccountFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel,accNoLabel,userIdLabel,statusLabel,balanceLabel,nameLabel, creditLabel,genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField accNoTF,userIdTF,balanceTF,nameTF, ageTF,nidTF, addressTF, securityAnsTF,creditTF;
	private JRadioButton maleRB, femaleRB,activeRB,deactiveRB;
	private ButtonGroup bg,bg1;
	private JComboBox bloodGroupCMB;
	private JPasswordField passPF;
	private JButton addBtn,backBtn;
	private JPanel panel;
	private Account ac;
	private User u;
	private Customers c;



	public CreateAccountFrame(User u)
	{
		super("Create Account");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);

        this.panel = new JPanel();
        this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);

		this.titleLabel=new JLabel("Create Account", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(182,110,150,32);
		this.userIdLabel.setFont(font);
		this.panel.add(userIdLabel);

		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(332,110,260,32);
		this.userIdTF.setFont(fieldFont);
		this.panel.add(userIdTF);

		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(182,155,150,32);
		this.nameLabel.setFont(font);
		this.panel.add(nameLabel);

		this.nameTF=new JTextField();
		this.nameTF.setBounds(332,155,260,32);
		this.nameTF.setFont(fieldFont);
		this.panel.add(nameTF);

		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(182,200,150,32);
		this.passLabel.setFont(font);
		this.panel.add(passLabel);

		this.passPF=new JPasswordField();
		this.passPF.setBounds(332,200,260,32);
		this.passPF.setFont(fieldFont);
		this.panel.add(passPF);

		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(182,245,150,32);
		this.nidLabel.setFont(font);
		this.panel.add(nidLabel);

		this.nidTF=new JTextField();
		this.nidTF.setBounds(332,245,260,32);
		this.nidTF.setFont(fieldFont);
		this.panel.add(nidTF);

		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(182,290,150,32);
		this.ageLabel.setFont(font);
		this.panel.add(ageLabel);

		this.ageTF=new JTextField();
		this.ageTF.setBounds(332,290,260,32);
		this.ageTF.setFont(fieldFont);
		this.panel.add(ageTF);

		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(182,335,150,32);
		this.genderLabel.setFont(font);
		this.panel.add(genderLabel);

		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(332,335,90,32);
		this.maleRB.setFont(fieldFont);
		this.maleRB.setBackground(Color.WHITE);
		this.panel.add(maleRB);

		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(432,335,100,32);
		this.femaleRB.setFont(fieldFont);
		this.femaleRB.setBackground(Color.WHITE);
		this.panel.add(femaleRB);

		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);

		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(182,380,150,32);
		this.bloodGroupLabel.setFont(font);
		this.panel.add(bloodGroupLabel);

		String[] item={"A+","B+","AB+","O+","A-","B-","AB-","O-"};
		this.bloodGroupCMB=new JComboBox(item);
		this.bloodGroupCMB.setBounds(332,380,260,32);
		this.bloodGroupCMB.setFont(fieldFont);
		this.bloodGroupCMB.setBackground(Color.WHITE);
		this.panel.add(bloodGroupCMB);

		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(662,110,160,32);
		this.addressLabel.setFont(font);
		this.panel.add(addressLabel);

		this.addressTF=new JTextField();
		this.addressTF.setBounds(822,110,260,32);
		this.addressTF.setFont(fieldFont);
		this.panel.add(addressTF);

		this.accNoLabel=new JLabel("Account No:");
		this.accNoLabel.setBounds(662,155,160,32);
		this.accNoLabel.setFont(font);
		this.panel.add(accNoLabel);

		this.accNoTF=new JTextField();
		this.accNoTF.setBounds(822,155,260,32);
		this.accNoTF.setFont(fieldFont);
		this.accNoTF.setText(new AccountRepo().generateAccNo());
		this.accNoTF.setEditable(false);
		this.panel.add(accNoTF);

		this.statusLabel=new JLabel("Status:");
		this.statusLabel.setBounds(662,200,160,32);
		this.statusLabel.setFont(font);
		this.panel.add(statusLabel);

		this.activeRB=new JRadioButton("Active");
		this.activeRB.setBounds(822,200,90,32);
		this.activeRB.setFont(fieldFont);
		this.activeRB.setBackground(Color.WHITE);
		this.panel.add(activeRB);

		this.deactiveRB=new JRadioButton("InActive");
		this.deactiveRB.setBounds(922,200,100,32);
		this.deactiveRB.setFont(fieldFont);
		this.deactiveRB.setBackground(Color.WHITE);
		this.panel.add(deactiveRB);

		this.bg1=new ButtonGroup();
		bg1.add(activeRB);
		bg1.add(deactiveRB);

		this.balanceLabel=new JLabel("Primary Balance:");
		this.balanceLabel.setBounds(662,245,160,32);
		this.balanceLabel.setFont(font);
		this.panel.add(balanceLabel);

		this.balanceTF=new JTextField();
		this.balanceTF.setBounds(822,245,260,32);
		this.balanceTF.setFont(fieldFont);
		this.panel.add(balanceTF);

		this.creditLabel=new JLabel("Primary Credit:");
		this.creditLabel.setBounds(662,290,160,32);
		this.creditLabel.setFont(font);
		this.panel.add(creditLabel);

		this.creditTF=new JTextField();
		this.creditTF.setBounds(822,290,260,32);
		this.creditTF.setFont(fieldFont);
		this.creditTF.setText(String.format("%.2f", 0.00));
        this.creditTF.setEditable(false);
		this.panel.add(creditTF);

		this.securityQuesLabel=new JLabel("Security Question: What is your Date Of Birth?");
		this.securityQuesLabel.setBounds(662,335,420,32);
		this.securityQuesLabel.setFont(font);
		this.panel.add(securityQuesLabel);

		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(662,380,160,32);
		this.securityAnsLabel.setFont(font);
		this.panel.add(securityAnsLabel);

		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(822,380,260,32);
		this.securityAnsTF.setFont(fieldFont);
		this.panel.add(securityAnsTF);

		this.addBtn = new JButton("Create Account");
        this.addBtn.setBounds(464,460,165,40);
		this.addBtn.setBackground(new Color(0, 102, 204));
		this.addBtn.setForeground(Color.WHITE);
		this.addBtn.setFont(font);
		this.addBtn.setFocusPainted(false);
        this.addBtn.addActionListener(this);
        this.panel.add(addBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(649,460,150,40);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);


        this.add(panel);

		this.u=u;
		this.ac=ac;
    }

    public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		AccountRepo arp=new AccountRepo();
		int age;
		double balance;
		double credit=0.00;
		String accNo, userId, status,name,gender,address,securityAns,pass,bloodGroup,nid;

		if(command.equals(addBtn.getText()))
		{


			if((!userIdTF.getText().isEmpty()) && (!accNoTF.getText().isEmpty()) && ((activeRB.isSelected()) || (deactiveRB.isSelected())) && (!balanceTF.getText().isEmpty()) && (!nameTF.getText().isEmpty()) && (!nidTF.getText().isEmpty()) &&((maleRB.isSelected()) || (femaleRB.isSelected())) && (!ageTF.getText().isEmpty()) && (!addressTF.getText().isEmpty())&& (!securityAnsTF.getText().isEmpty()) && (!passPF.getText().isEmpty()) )
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
						nid=nidTF.getText();
						balance = Double.parseDouble(balanceTF.getText());
						age=Integer.parseInt(ageTF.getText());
						if(balance<0 || age<=0)
						{
							JOptionPane.showMessageDialog(this,"Provide Valid Age and Balance");
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
						accNoTF.setText(arp.generateAccNo());

					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Valid Age and Balance");
					}
				}

			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
			}

		}
		else if (command.equals(backBtn.getText()))
		{
            LoginFrame lf = new LoginFrame();
            this.setVisible(false);
            lf.setVisible(true);
        }
    }

}
