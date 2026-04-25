package frames;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import entities.*;
import interfaces.*;
import repositories.*;

public class TransactionOperationFrame extends JFrame implements ActionListener 
{
	private JLabel transactionIdLabel,accNoLabel,transactionTypeLabel,dateLabel,amountLabel,statusLabel,passLabel,userIdLabel,balanceLabel;
    private JTextField transactionIdTF,accNoTF,dateTF, amountTF,userIdTF,balanceTF;
	private JPasswordField passPF;
	private JRadioButton activeRB, inactiveRB;
	private ButtonGroup bg;
	private JComboBox transactionTypeCMB;
    private JButton withdrawBtn, depositBtn, searchByAccNoBtn, searchByTransactionIdBtn,backBtn;
	private JTable transactionTable;
	private JScrollPane transactionTableSP;
	private JPanel panel;
	private Transaction t;
	private User u;
	private Account ac;
	

	public TransactionOperationFrame(Transaction t,User u)  
	{

        super ("Transaction Operations");
        this.setSize(1000,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		AccountRepo arp=new AccountRepo();
		this.ac=arp.searchAccountByUserId(u.getUserId());
		
		//TransactionRepo trp1= new TransactionRepo();
		//Transaction[] transactions =trp1.searchByAccNo(t.getAccNo());
        
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.GRAY);
		
		this.transactionIdLabel=new JLabel("Transaction ID:");
		this.transactionIdLabel.setBounds(50,50,100,30);
		this.panel.add(transactionIdLabel);
		
		this.transactionIdTF=new JTextField();
		this.transactionIdTF.setBounds(160,50,100,30);
		this.panel.add(transactionIdTF);
		

		this.accNoLabel=new JLabel("Account No:");
		this.accNoLabel.setBounds(50,100,90,30);
		this.panel.add(accNoLabel);
		
		this.accNoTF=new JTextField();
		this.accNoTF.setBounds(160,100,100,30);
		this.panel.add(accNoTF);
		
		this.dateLabel=new JLabel("Date");
		this.dateLabel.setBounds(50,150,60,30);
		this.panel.add(dateLabel);
		
		this.dateTF=new JTextField();
		this.dateTF.setBounds(160,150,100,30);
		this.panel.add(dateTF);
		
		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(50,200,60,30);
		this.panel.add(amountLabel);
		
		this.amountTF=new JTextField();
		this.amountTF.setBounds(160,200,100,30);
		this.panel.add(amountTF);
		
		this.statusLabel=new JLabel("Status:");
		this.statusLabel.setBounds(50,250,60,30);
		this.panel.add(statusLabel);
		
		this.activeRB=new JRadioButton("Active");
		this.activeRB.setBounds(120,250,90,30);
		this.panel.add(activeRB);
		
		this.inactiveRB=new JRadioButton("Inactive");
		this.inactiveRB.setBounds(220,250,80,30);
		this.panel.add(inactiveRB);
		
		this.bg=new ButtonGroup();
		bg.add(activeRB);
		bg.add(inactiveRB);
		
		this.transactionTypeLabel=new JLabel("Transaction Type:");
		this.transactionTypeLabel.setBounds(310,250,130,30);
		this.panel.add(transactionTypeLabel);
		
		String[] item={"Withdraw","Deposit"};
		this.transactionTypeCMB=new JComboBox(item);
		this.transactionTypeCMB.setBounds(450,250,200,30);
		this.panel.add(transactionTypeCMB);
		
		this.userIdLabel = new JLabel("User ID:");
        this.userIdLabel.setBounds(310, 50, 60, 30);
        this.panel.add(userIdLabel);
		
		this.userIdTF = new JTextField();
        this.userIdTF.setBounds(390, 50, 100, 30);
		this.userIdTF.setText(u.getUserId());
        this.userIdTF.setEditable(false);
        this.panel.add(userIdTF);
		
		this.balanceLabel = new JLabel("Balance:");
        this.balanceLabel.setBounds(310, 120, 60, 30);
        this.panel.add(balanceLabel);
		
		this.balanceTF = new JTextField();
        this.balanceTF.setBounds(390, 120, 100, 30);
		this.balanceTF.setText(String.valueOf(ac.getBalance()));
        this.balanceTF.setEditable(false);
        this.panel.add(balanceTF);
		
		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(310,200,70,30);
		this.panel.add(passLabel);
		
		this.passPF=new JPasswordField();
		this.passPF.setBounds(390,200,100,30);
		this.panel.add(passPF);
		
		/*this.withdrawBtn=new JButton("Withdraw");
		this.withdrawBtn.setBounds(50,350,100,30);
		this.withdrawBtn.addActionListener(this);
		this.panel.add(withdrawBtn);*/
		
		this.depositBtn=new JButton("Transit");
		this.depositBtn.setBounds(160,350,120,30);
		this.depositBtn.addActionListener(this);
		this.panel.add(depositBtn);
		
		this.searchByTransactionIdBtn=new JButton("ID Search");
		this.searchByTransactionIdBtn.setBounds(290,350,120,30);
		this.searchByTransactionIdBtn.addActionListener(this);
		this.panel.add(searchByTransactionIdBtn);
		
		this.searchByAccNoBtn=new JButton("AccNo Search");
		this.searchByAccNoBtn.setBounds(420,350,120,30);
		this.searchByAccNoBtn.addActionListener(this);
		this.panel.add(searchByAccNoBtn);
		
		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(660,350,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		TransactionRepo trp=new TransactionRepo();
		Transaction [] transactionList=trp.getAllTransaction();
		
		String transactionData1[][]=new String[transactionList.length][8];
		for(int i=0;i<transactionList.length;i++)
		{
		
			if(transactionList[i]!=null)
			{
				System.out.println(transactionList[i].toStringTransaction());
				transactionData1[i][0]=transactionList[i].getTransactionId();
				transactionData1[i][1]=transactionList[i].getAccNo();
				transactionData1[i][2]=transactionList[i].getUserId();
				transactionData1[i][3]=transactionList[i].getTransactionType();
				transactionData1[i][4]=transactionList[i].getDate();
				transactionData1[i][5]=String.valueOf(transactionList[i].getAmount());
				transactionData1[i][6]=transactionList[i].getStatus();
				transactionData1[i][7]=String.valueOf(transactionList[i].getBalance());
				
			}
			
			String head1[]={"TransactionId","AccountNO","UserID","TransactionType","Date","Amount","Status","Balance"};
			this.transactionTable=new JTable(transactionData1,head1);
			this.transactionTableSP=new JScrollPane(transactionTable);
			this.transactionTableSP.setBounds(50,380,700,200);
			this.transactionTable.setEnabled(false);
			this.panel.add(transactionTableSP);
		
			this.panel.revalidate();
			this.panel.repaint();
		
			this.add(panel);
			this.u=u;
			//this.t=t;
			this.ac=ac;
			
		}
	}
	
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		TransactionRepo trp = new TransactionRepo();
		if (command.equals(depositBtn.getText())) 
		{
			String userId = userIdTF.getText();
			UserRepo urp=new UserRepo();
			User user=urp.searchUserByUserId(userId);
			if(user!=null)
			{
				if((!transactionIdTF.getText().isEmpty()) && (!accNoTF.getText().isEmpty()) && (!amountTF.getText().isEmpty()) &&((activeRB.isSelected()) || (inactiveRB.isSelected())) && (!dateTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
				{
					String transactionId = transactionIdTF.getText();
					String accNo = accNoTF.getText();
					String date = dateTF.getText();
					double balance=Double.parseDouble(balanceTF.getText());
					double amount = Double.parseDouble(amountTF.getText());
					String pass=passPF.getText();
					String status;
					if(activeRB.isSelected())
									{
										status=activeRB.getText();
									}
					
									else if(inactiveRB.isSelected())
									{
										status=inactiveRB.getText();
									}
					
									else
									{
										status=activeRB.getText();
									}
					String transactionType = transactionTypeCMB.getSelectedItem().toString();
					Transaction tr = new Transaction(transactionId, accNo,userId, transactionType, date, amount, status,balance);

					if (transactionType.equals("Withdraw")) 
					{
						if(u.getPassword().equals(pass)&&t.getAccNo().equals(accNo))
						{
							
							trp.withdraw(tr);
							JOptionPane.showMessageDialog(this, "Withdrawal Successful");
						}
						else
						{
							JOptionPane.showMessageDialog(this, "Enter correct password Or ACCNO!!","Massage",JOptionPane.ERROR_MESSAGE);
						}
							
					}
						else if (transactionType.equals("Deposit")) 
						{
							if(u.getPassword().equals(pass)&&t.getAccNo().equals(accNo))
							{
								trp.deposit(tr);
								JOptionPane.showMessageDialog(this, "Deposit Successful");
							}
							else
							{
								JOptionPane.showMessageDialog(this, "Enter correct password Or ACCNO!!","Massage",JOptionPane.ERROR_MESSAGE);
							}
						}
					 
					else 
					{
						JOptionPane.showMessageDialog(this, "Please Fill UP all fields.","Message",JOptionPane.QUESTION_MESSAGE);
					}
				} 
				
				
			}
		}

        /*if (command.equals(depositBtn.getText())) 
		{
            if((!transactionIdTF.getText().isEmpty()) && (!accNoTF.getText().isEmpty()) && (!amountTF.getText().isEmpty()) &&((activeRB.isSelected()) || (inactiveRB.isSelected())) && (!dateTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
			
                String transactionId = transactionIdTF.getText();
                String accNo = accNoTF.getText();
                String date = dateTF.getText();
				String pass=passPF.getText();
                double amount = Double.parseDouble(amountTF.getText());
                String status;
				if(activeRB.isSelected())
								{
									status=activeRB.getText();
								}
				
								else if(inactiveRB.isSelected())
								{
									status=inactiveRB.getText();
								}
				
								else
								{
									status=activeRB.getText();
								}
                String transactionType = transactionTypeCMB.getSelectedItem().toString();

                if (transactionType.equals("Deposit")) 
				{
					if(u.getPassword().equals(pass)&&t.getAccNo().equals(accNo))
					{
						Transaction t = new Transaction(transactionId, accNo, transactionType, date, amount, status);
						trp.deposit(t);
						JOptionPane.showMessageDialog(this, "Deposit Successful");
					}
					else
					{
						JOptionPane.showMessageDialog(this, "Enter correct password Or ACCNO!!","Massage",JOptionPane.ERROR_MESSAGE);
					}
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Fill UP all fields.","Message",JOptionPane.QUESTION_MESSAGE);
            }
        }*/

			if(command.equals(searchByAccNoBtn.getText()))
			{
				String accNo;
			
				accNo=accNoTF.getText();
				Transaction[] t = trp.searchByAccNo(accNo);
				StringBuilder result = new StringBuilder("Transactions for user ID " + accNo + ":\n");
				for (Transaction tr : t) 
				{
					if (tr!=null) 
					{
						JOptionPane.showMessageDialog(this,"Transaction found: ");
						break;
					}
					else 
						{
							JOptionPane.showMessageDialog(this,"Transaction not found.","Massage",JOptionPane.ERROR_MESSAGE);
							break;
						}
					
				}
				
				JOptionPane.showMessageDialog(this,result.toString());
			}
				if(command.equals(searchByTransactionIdBtn.getText()))
				{
					String transactionId;
					transactionId=transactionIdTF.getText();
					Transaction[] transactionList = trp.getAllTransaction();
					for (Transaction t : transactionList) 
					{
						if (t != null && t.getTransactionId().equals(transactionId)) 
						{
							JOptionPane.showMessageDialog(this,"Transaction found: ");
							break;
						} 
						else 
						{
							JOptionPane.showMessageDialog(this,"Transaction not found.","Massage",JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
				
					
				}
			
			if(command.equals(backBtn.getText()))
			{
				if(u.getRole()==3)
				{	
				CustomersHomeFrame chf=new CustomersHomeFrame(this.u);
				this.setVisible(false);
				chf.setVisible(true);
				}
				else
				{
					EmployeeOpFrame eof=new EmployeeOpFrame(this.u);
					this.setVisible(false);
					eof.setVisible(true);
				}
				
			}
						
						
						
	}
}