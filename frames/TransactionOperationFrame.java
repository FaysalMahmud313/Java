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
	private JLabel titleLabel,transactionIdLabel,accNoLabel,transactionTypeLabel,dateLabel,amountLabel,statusLabel,passLabel,userIdLabel,balanceLabel;
    private JTextField transactionIdTF,accNoTF,dateTF, amountTF,userIdTF,balanceTF;
	private JPasswordField passPF;
	private JRadioButton activeRB, inactiveRB;
	private ButtonGroup bg;
	private JComboBox transactionTypeCMB;
    private JButton depositBtn, searchByAccNoBtn, searchByTransactionIdBtn,backBtn,dateBtn;
	private JTable transactionTable;
	private JScrollPane transactionTableSP;
	private JPanel panel;
	private Transaction t;
	private User u;
	private Account ac;


	public TransactionOperationFrame(Transaction t,User u)
	{

        super ("Transaction Operations");
        this.setSize(1280,720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		AccountRepo arp=new AccountRepo();
		this.ac=arp.searchAccountByUserId(u.getUserId());

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 15);
		Font fieldFont = new Font("Arial", Font.PLAIN, 15);

		this.titleLabel=new JLabel("Withdraw / Deposit", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.transactionIdLabel=new JLabel("Transaction ID:");
		this.transactionIdLabel.setBounds(60,95,150,32);
		this.transactionIdLabel.setFont(font);
		this.panel.add(transactionIdLabel);

		this.transactionIdTF=new JTextField();
		this.transactionIdTF.setBounds(210,95,260,32);
		this.transactionIdTF.setFont(fieldFont);
		this.transactionIdTF.setEditable(false);
		this.panel.add(transactionIdTF);

		this.accNoLabel=new JLabel("Account No:");
		this.accNoLabel.setBounds(60,140,150,32);
		this.accNoLabel.setFont(font);
		this.panel.add(accNoLabel);

		this.accNoTF=new JTextField();
		this.accNoTF.setBounds(210,140,260,32);
		this.accNoTF.setFont(fieldFont);
		this.panel.add(accNoTF);

		this.dateLabel=new JLabel("Date:");
		this.dateLabel.setBounds(60,185,150,32);
		this.dateLabel.setFont(font);
		this.panel.add(dateLabel);

		this.dateTF=new JTextField();
		this.dateTF.setBounds(210,185,180,32);
		this.dateTF.setFont(fieldFont);
		this.dateTF.setText(CalendarDialog.getToday());
		this.dateTF.setEditable(false);
		this.panel.add(dateTF);

		this.dateBtn=new JButton("Select");
		this.dateBtn.setBounds(395,185,75,32);
		this.dateBtn.addActionListener(this);
		this.dateBtn.setBackground(new Color(0, 102, 204));
		this.dateBtn.setForeground(Color.WHITE);
		this.dateBtn.setFont(font);
		this.dateBtn.setMargin(new Insets(0,0,0,0));
		this.dateBtn.setFocusPainted(false);
		this.panel.add(dateBtn);

		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(60,230,150,32);
		this.amountLabel.setFont(font);
		this.panel.add(amountLabel);

		this.amountTF=new JTextField();
		this.amountTF.setBounds(210,230,260,32);
		this.amountTF.setFont(fieldFont);
		this.panel.add(amountTF);

		this.transactionTypeLabel=new JLabel("Transaction Type:");
		this.transactionTypeLabel.setBounds(60,275,150,32);
		this.transactionTypeLabel.setFont(font);
		this.panel.add(transactionTypeLabel);

		String[] item={"Withdraw","Deposit"};
		this.transactionTypeCMB=new JComboBox(item);
		this.transactionTypeCMB.setBounds(210,275,260,32);
		this.transactionTypeCMB.setFont(fieldFont);
		this.transactionTypeCMB.setBackground(Color.WHITE);
		this.transactionTypeCMB.addActionListener(this);
		this.panel.add(transactionTypeCMB);

		
		TransactionRepo idRepo=new TransactionRepo();
		this.transactionIdTF.setText(idRepo.generateTransactionId(transactionTypeCMB.getSelectedItem().toString()));

		this.statusLabel=new JLabel("Status:");
		this.statusLabel.setBounds(60,320,150,32);
		this.statusLabel.setFont(font);
		this.panel.add(statusLabel);

		this.activeRB=new JRadioButton("Active");
		this.activeRB.setBounds(210,320,90,32);
		this.activeRB.setFont(fieldFont);
		this.activeRB.setBackground(Color.WHITE);
		this.panel.add(activeRB);

		this.inactiveRB=new JRadioButton("Inactive");
		this.inactiveRB.setBounds(310,320,100,32);
		this.inactiveRB.setFont(fieldFont);
		this.inactiveRB.setBackground(Color.WHITE);
		this.panel.add(inactiveRB);

		this.bg=new ButtonGroup();
		bg.add(activeRB);
		bg.add(inactiveRB);

		this.userIdLabel = new JLabel("User ID:");
        this.userIdLabel.setBounds(540, 95, 160, 32);
        this.userIdLabel.setFont(font);
        this.panel.add(userIdLabel);

		this.userIdTF = new JTextField();
        this.userIdTF.setBounds(700, 95, 260, 32);
        this.userIdTF.setFont(fieldFont);
		this.userIdTF.setText(u.getUserId());
        this.userIdTF.setEditable(false);
        this.panel.add(userIdTF);

		this.balanceLabel = new JLabel("Balance:");
        this.balanceLabel.setBounds(540, 140, 160, 32);
        this.balanceLabel.setFont(font);
        this.panel.add(balanceLabel);

		this.balanceTF = new JTextField();
        this.balanceTF.setBounds(700, 140, 260, 32);
        this.balanceTF.setFont(fieldFont);
        this.balanceTF.setEditable(false);
        this.panel.add(balanceTF);

		this.passLabel=new JLabel("Password:");
		this.passLabel.setBounds(540,185,160,32);
		this.passLabel.setFont(font);
		this.panel.add(passLabel);

		this.passPF=new JPasswordField();
		this.passPF.setBounds(700,185,260,32);
		this.passPF.setFont(fieldFont);
		this.panel.add(passPF);

		if(u.getRole()==3 && this.ac!=null)
		{
			this.accNoTF.setText(ac.getAccNo());
			this.accNoTF.setEditable(false);
			this.balanceTF.setText(String.valueOf(ac.getBalance()));
		}

		this.depositBtn=new JButton("Transit");
		this.depositBtn.setBounds(60,375,150,40);
		this.depositBtn.addActionListener(this);
		this.depositBtn.setBackground(new Color(0, 102, 204));
		this.depositBtn.setForeground(Color.WHITE);
		this.depositBtn.setFont(font);
		this.depositBtn.setFocusPainted(false);
		this.panel.add(depositBtn);

		this.searchByTransactionIdBtn=new JButton("ID Search");
		this.searchByTransactionIdBtn.setBounds(225,375,150,40);
		this.searchByTransactionIdBtn.addActionListener(this);
		this.searchByTransactionIdBtn.setBackground(new Color(0, 102, 204));
		this.searchByTransactionIdBtn.setForeground(Color.WHITE);
		this.searchByTransactionIdBtn.setFont(font);
		this.searchByTransactionIdBtn.setFocusPainted(false);
		this.panel.add(searchByTransactionIdBtn);

		this.searchByAccNoBtn=new JButton("AccNo Search");
		this.searchByAccNoBtn.setBounds(390,375,150,40);
		this.searchByAccNoBtn.addActionListener(this);
		this.searchByAccNoBtn.setBackground(new Color(0, 102, 204));
		this.searchByAccNoBtn.setForeground(Color.WHITE);
		this.searchByAccNoBtn.setFont(font);
		this.searchByAccNoBtn.setFocusPainted(false);
		this.panel.add(searchByAccNoBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(555,375,150,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		TransactionRepo trp=new TransactionRepo();
		Transaction [] transactionList;
		if(u.getRole()==3 && this.ac!=null)
		{
			transactionList=trp.searchByAccNo(ac.getAccNo());
		}
		else
		{
			transactionList=trp.getAllTransaction();
		}

		int count=0;
		for(int i=0;i<transactionList.length;i++)
		{
			if(transactionList[i]!=null)
			{
				count++;
			}
		}
		String transactionData1[][]=new String[count][8];
		int row=0;
		for(int i=0;i<transactionList.length;i++)
		{

			if(transactionList[i]!=null)
			{
				transactionData1[row][0]=transactionList[i].getTransactionId();
				transactionData1[row][1]=transactionList[i].getAccNo();
				transactionData1[row][2]=transactionList[i].getUserId();
				transactionData1[row][3]=transactionList[i].getTransactionType();
				transactionData1[row][4]=transactionList[i].getDate();
				transactionData1[row][5]=String.valueOf(transactionList[i].getAmount());
				transactionData1[row][6]=transactionList[i].getStatus();
				transactionData1[row][7]=String.valueOf(transactionList[i].getBalance());
				row++;
			}

		}

		String head1[]={"Transaction Id","Account No","User Id","Type","Date","Amount","Status","Balance"};
		this.transactionTable=new JTable(transactionData1,head1);
		this.transactionTable.setFont(fieldFont);
		this.transactionTable.setRowHeight(26);
		this.transactionTable.getTableHeader().setFont(font);
		this.transactionTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.transactionTable.getTableHeader().setForeground(Color.WHITE);
		this.transactionTableSP=new JScrollPane(transactionTable);
		this.transactionTableSP.setBounds(60,435,1144,215);
		this.transactionTableSP.getViewport().setBackground(Color.WHITE);
		this.transactionTable.setEnabled(false);
		this.panel.add(transactionTableSP);

		this.add(panel);
		this.u=u;
		this.t=t;
	}



	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();
		TransactionRepo trp = new TransactionRepo();

		if (ae.getSource() == transactionTypeCMB)
		{
			transactionIdTF.setText(trp.generateTransactionId(transactionTypeCMB.getSelectedItem().toString()));
		}

		if (command.equals(dateBtn.getText()))
		{
			CalendarDialog cd = new CalendarDialog(this, dateTF);
			cd.setVisible(true);
		}

		if (command.equals(depositBtn.getText()))
		{
			if((!transactionIdTF.getText().isEmpty()) && (!accNoTF.getText().isEmpty()) && (!amountTF.getText().isEmpty()) &&((activeRB.isSelected()) || (inactiveRB.isSelected())) && (!dateTF.getText().isEmpty()) && (!passPF.getText().isEmpty()))
			{
				String transactionId = transactionIdTF.getText().trim();
				String accNo = accNoTF.getText().trim();
				String date = dateTF.getText().trim();
				String pass=passPF.getText();
				double amount;
				try
				{
					amount = Double.parseDouble(amountTF.getText());
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this, "Invalid Amount","Massage",JOptionPane.WARNING_MESSAGE);
					return;
				}
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

				if((transactionType.equals("Withdraw") && !transactionId.startsWith("TXWD")) || (transactionType.equals("Deposit") && !transactionId.startsWith("TXDP")) || trp.searchByTransactionId(transactionId)!=null)
				{
					transactionId = trp.generateTransactionId(transactionType);
				}

				AccountRepo arp=new AccountRepo();
				Account account=arp.searchAccountByAccNo(accNo);

				if(date.contains(","))
				{
					JOptionPane.showMessageDialog(this, "Comma (,) is not allowed in any field","Massage",JOptionPane.WARNING_MESSAGE);
				}
				else if(amount<=0)
				{
					JOptionPane.showMessageDialog(this, "Amount must be greater than zero.","Massage",JOptionPane.WARNING_MESSAGE);
				}
				else if(!u.getPassword().equals(pass) || account==null)
				{
					JOptionPane.showMessageDialog(this, "Enter correct password Or ACCNO!!","Massage",JOptionPane.ERROR_MESSAGE);
				}
				else if(!account.getStatus().equals("Active"))
				{
					JOptionPane.showMessageDialog(this, "This Account is not Active.","Massage",JOptionPane.ERROR_MESSAGE);
				}
				else if(transactionType.equals("Withdraw") && account.getBalance()<amount)
				{
					JOptionPane.showMessageDialog(this, "Insufficient Balance.","Massage",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Transaction tr = new Transaction(transactionId, accNo, account.getUserId(), transactionType, date, amount, status, account.getBalance());

					if (transactionType.equals("Withdraw"))
					{
						trp.withdraw(tr);
						SuccessGifDialog sgd = new SuccessGifDialog(this);
						sgd.setVisible(true);
						JOptionPane.showMessageDialog(this, "Withdrawal Successful\nTransaction ID: " + transactionId + "\nNew Balance: " + tr.getBalance());
					}
					else
					{
						trp.deposit(tr);
						SuccessGifDialog sgd = new SuccessGifDialog(this);
						sgd.setVisible(true);
						JOptionPane.showMessageDialog(this, "Deposit Successful\nTransaction ID: " + transactionId + "\nNew Balance: " + tr.getBalance());
					}

					TransactionOperationFrame tof=new TransactionOperationFrame(this.t,this.u);
					this.setVisible(false);
					tof.setVisible(true);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please Fill UP all fields.","Message",JOptionPane.QUESTION_MESSAGE);
			}
		}

		if(command.equals(searchByAccNoBtn.getText()))
		{
			String accNo;
			accNo=accNoTF.getText().trim();

			if(!accNo.isEmpty())
			{
				AccountRepo arp=new AccountRepo();
				Account account=arp.searchAccountByAccNo(accNo);
				if(account!=null)
				{
					balanceTF.setText(String.valueOf(account.getBalance()));
				}

				Transaction[] t = trp.searchByAccNo(accNo);
				StringBuilder result = new StringBuilder("Transactions for Account No " + accNo + ":\n");
				boolean found=false;
				for (Transaction tr : t)
				{
					if (tr!=null)
					{
						result.append("Id: " + tr.getTransactionId() + ",  " + tr.getTransactionType() + ",  Date: " + tr.getDate() + ",  Amount: " + tr.getAmount() + ",  Balance: " + tr.getBalance() + "\n");
						found=true;
					}
				}

				if(found)
				{
					JOptionPane.showMessageDialog(this,result.toString());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Transaction not found.","Massage",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Enter Account No To Search.");
			}
		}

		if(command.equals(searchByTransactionIdBtn.getText()))
		{
			String transactionId;
			transactionId=JOptionPane.showInputDialog(this,"Enter Transaction ID:");

			if(transactionId!=null && !transactionId.trim().isEmpty())
			{
				Transaction t = trp.searchByTransactionId(transactionId.trim());
				if (t != null && (u.getRole()!=3 || (ac!=null && t.getAccNo().equals(ac.getAccNo()))))
				{
					JOptionPane.showMessageDialog(this,"Transaction found\nId: " + t.getTransactionId() + "\nAccount No: " + t.getAccNo() + "\nType: " + t.getTransactionType() + "\nDate: " + t.getDate() + "\nAmount: " + t.getAmount() + "\nBalance: " + t.getBalance());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Transaction not found.","Massage",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Enter Transaction ID To Search.");
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
