package frames;

import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CreateAccountFrame extends JFrame implements ActionListener 
{
	private ImageIcon crtIcon;
	private JLabel crtLabel,accNoLabel,userIdLabel,statusLabel,balanceLabel,nameLabel, creditLabel,genderLabel, bloodGroupLabel,ageLabel, nidLabel, addressLabel, securityQuesLabel, securityAnsLabel, passLabel;
	private JTextField accNoTF,userIdTF,statusTF,balanceTF,nameTF, ageTF,nidTF, addressTF, securityAnsTF,creditTF;
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
	private Customers c;
	
	
	
	public CreateAccountFrame(User u)
	{
		super("Create Account");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 20);

        this.panel = new JPanel();
        this.panel.setLayout(null);
		this.panel.setBackground(new Color(255, 255, 255));
		
		this.crtIcon = new ImageIcon("image/Create Account.jpg");
        this.crtLabel = new JLabel();
        this.crtLabel.setIcon(crtIcon);
        this.crtLabel.setBounds(560, 0, 720, 720);
        this.panel.add(crtLabel);
		
		this.accNoLabel=new JLabel("AccNo:");
		this.accNoLabel.setBounds(50,150,60,30);
		this.panel.add(accNoLabel);
		
		this.accNoTF=new JTextField();
		this.accNoTF.setBounds(120,150,100,30);
		this.panel.add(accNoTF);
		
		this.userIdLabel=new JLabel("UserId:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userIdTF=new JTextField();
		this.userIdTF.setBounds(120,50,100,30);
		//this.userIdTF.setText(u.getUserId());
		//this.userIdTF.setEditable(false);
		this.panel.add(userIdTF);
		
		this.statusLabel=new JLabel("Status:");
		this.statusLabel.setBounds(50,350,60,30);
		this.panel.add(statusLabel);
		
		this.activeRB=new JRadioButton("Active");
		this.activeRB.setBounds(120,350,60,30);
		this.panel.add(activeRB);
		
		this.deactiveRB=new JRadioButton("InActive");
		this.deactiveRB.setBounds(190,350,80,30);
		this.panel.add(deactiveRB);
		
		this.bg1=new ButtonGroup();
		bg1.add(activeRB);
		bg1.add(deactiveRB);
		
		this.balanceLabel=new JLabel("Primary Balance:");
		this.balanceLabel.setBounds(280,300,220,30);
		this.panel.add(balanceLabel);
		
		this.balanceTF=new JTextField();
		this.balanceTF.setBounds(390,300,100,30);
		this.panel.add(balanceTF);
		
		this.creditLabel=new JLabel("Primary Credit:");
		this.creditLabel.setBounds(280,350,220,30);
		this.panel.add(creditLabel);
		
		this.creditTF=new JTextField();
		this.creditTF.setBounds(390,350,100,30);
		this.creditTF.setText(String.format("%.2f", 0.00));
        this.creditTF.setEditable(false);
		this.panel.add(creditTF);
		
		this.nameLabel=new JLabel("Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.panel.add(nameTF);
		
		this.nidLabel=new JLabel("NID:");
		this.nidLabel.setBounds(50,200,60,30);
		this.panel.add(nidLabel);
		
		this.nidTF=new JTextField();
		this.nidTF.setBounds(120,200,100,30);
		this.panel.add(nidTF);
		
		this.genderLabel=new JLabel("Gender:");
		this.genderLabel.setBounds(50,250,60,30);
		this.panel.add(genderLabel);
		
		this.maleRB=new JRadioButton("Male");
		this.maleRB.setBounds(120,250,60,30);
		this.panel.add(maleRB);
		
		this.femaleRB=new JRadioButton("Female");
		this.femaleRB.setBounds(190,250,80,30);
		this.panel.add(femaleRB);
		
		this.bg=new ButtonGroup();
		bg.add(maleRB);
		bg.add(femaleRB);
		
		this.ageLabel=new JLabel("Age:");
		this.ageLabel.setBounds(50,300,60,30);
		this.panel.add(ageLabel);
		
		this.ageTF=new JTextField();
		this.ageTF.setBounds(120,300,100,30);
		this.panel.add(ageTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(280,50,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(390,50,100,30);
		this.panel.add(addressTF);
		
		this.securityQuesLabel=new JLabel("Security Ques: What is your Date Of Birth?:");
		this.securityQuesLabel.setBounds(280,100,300,30);
		this.panel.add(securityQuesLabel);
		
		this.securityAnsLabel=new JLabel("Security Ans:");
		this.securityAnsLabel.setBounds(280,150,100,30);
		this.panel.add(securityAnsLabel);
		
		this.securityAnsTF=new JTextField();
		this.securityAnsTF.setBounds(390,150,100,30);
		this.panel.add(securityAnsTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(280,200,100,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		this.bloodGroupLabel=new JLabel("Blood Group:");
		this.bloodGroupLabel.setBounds(280,250,100,30);
		this.panel.add(bloodGroupLabel);
		
		String[] item={"A+","B+","AB+","O+","A-","B-","AB-","O-"};
		this.bloodGroupCMB=new JComboBox(item);
		this.bloodGroupCMB.setBounds(390,250,160,30);
		this.panel.add(bloodGroupCMB);
		
		this.addBtn = new JButton("Create Account");
        this.addBtn.setBounds(50,420, 250, 50);
		this.addBtn.setBackground(new Color(51, 204, 255));
		this.addBtn.setFont(font);
        this.addBtn.addActionListener(this);
        this.panel.add(addBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(340, 420, 100, 50);
		this.backBtn.setBackground(new Color(204, 0, 0));
		this.backBtn.setFont(font);
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
				userId=userIdTF.getText();
				
				Account ac=arp.searchAccountByUserId(userId);
				if(ac==null)
				{
					try
					{
						name=nameTF.getText();
						//credit=creditTF.getText();
						nid=nidTF.getText();
						accNo=accNoTF.getText();
						balance = Double.parseDouble(balanceTF.getText());
						
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
						age=Integer.parseInt(ageTF.getText());
						address=addressTF.getText();
						int role=3;
						securityAns=securityAnsTF.getText();
						pass=passPF.getText();
						bloodGroup=bloodGroupCMB.getSelectedItem().toString();
						
						UserRepo urp=new UserRepo();
						User ur =new User(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass);
						urp.addUser(ur);
						CustomersRepo crp=new CustomersRepo();
						Customers c=new Customers(userId,name,gender,bloodGroup,age,nid,address,role,securityAns,pass,credit);
						crp.addCustomers(c);
						
						Account ac1=new Account(accNo,userId,status,balance);
						arp.createAccount(ac1);
						
						
						
						UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 24));
						JOptionPane.showMessageDialog(this, "Account Created Successfully");
                        
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Provide Balance");
					}
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"User Id Already Exists.");
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