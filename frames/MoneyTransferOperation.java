package frames;


import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class MoneyTransferOperation extends JFrame implements ActionListener
{
	private JLabel titleLabel,moneyTransferIdLabel,senderAccNoLabel, receiverAccNoLabel,amountLabel,dateLabel,balanceLabel;
	private JTextField senderAccNoTF, receiverAccNoTF,amountTF,dateTF,moneyTransferIdTF,balanceTF;
	private JButton transferBtn, backBtn,searchByAccNoBtn,searchByMoneyTransferIdBtn,dateBtn;
	private JTable moneyTransferTable;
	private JScrollPane moneyTransferTableSP;
	private MoneyTransfer mt;
	private JPanel panel;
	private User u;
	private Account ac;



	public MoneyTransferOperation(MoneyTransfer mt,User u)
	{
		super("Money Transfer Operation");
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

		this.titleLabel=new JLabel("Money Transfer", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.moneyTransferIdLabel=new JLabel("Money Transfer Id:");
		this.moneyTransferIdLabel.setBounds(60,95,200,32);
		this.moneyTransferIdLabel.setFont(font);
		this.panel.add(moneyTransferIdLabel);

		this.moneyTransferIdTF=new JTextField();
		this.moneyTransferIdTF.setBounds(270,95,260,32);
		this.moneyTransferIdTF.setFont(fieldFont);
		this.moneyTransferIdTF.setEditable(false);
		MoneyTransferRepo idRepo=new MoneyTransferRepo();
		this.moneyTransferIdTF.setText(idRepo.generateMoneyTransferId());
		this.panel.add(moneyTransferIdTF);

		this.senderAccNoLabel=new JLabel("Sender Account No:");
		this.senderAccNoLabel.setBounds(60,140,200,32);
		this.senderAccNoLabel.setFont(font);
		this.panel.add(senderAccNoLabel);

		this.senderAccNoTF=new JTextField();
		this.senderAccNoTF.setBounds(270,140,260,32);
		this.senderAccNoTF.setFont(fieldFont);
		this.senderAccNoTF.setText(ac.getAccNo());
		this.senderAccNoTF.setEditable(false);
		this.panel.add(senderAccNoTF);

		this.receiverAccNoLabel=new JLabel("Receiver Account No:");
		this.receiverAccNoLabel.setBounds(60,185,200,32);
		this.receiverAccNoLabel.setFont(font);
		this.panel.add(receiverAccNoLabel);

		this.receiverAccNoTF=new JTextField();
		this.receiverAccNoTF.setBounds(270,185,260,32);
		this.receiverAccNoTF.setFont(fieldFont);
		this.panel.add(receiverAccNoTF);

		this.amountLabel=new JLabel("Amount:");
		this.amountLabel.setBounds(60,230,200,32);
		this.amountLabel.setFont(font);
		this.panel.add(amountLabel);

		this.amountTF=new JTextField();
		this.amountTF.setBounds(270,230,260,32);
		this.amountTF.setFont(fieldFont);
		this.panel.add(amountTF);

		this.dateLabel=new JLabel("Date:");
		this.dateLabel.setBounds(60,275,200,32);
		this.dateLabel.setFont(font);
		this.panel.add(dateLabel);

		this.dateTF=new JTextField();
		this.dateTF.setBounds(270,275,180,32);
		this.dateTF.setFont(fieldFont);
		this.dateTF.setText(CalendarDialog.getToday());
		this.dateTF.setEditable(false);
		this.panel.add(dateTF);

		this.dateBtn=new JButton("Select");
		this.dateBtn.setBounds(455,275,75,32);
		this.dateBtn.addActionListener(this);
		this.dateBtn.setBackground(new Color(0, 102, 204));
		this.dateBtn.setForeground(Color.WHITE);
		this.dateBtn.setFont(font);
		this.dateBtn.setMargin(new Insets(0,0,0,0));
		this.dateBtn.setFocusPainted(false);
		this.panel.add(dateBtn);

		this.balanceLabel=new JLabel("Current Balance:");
		this.balanceLabel.setBounds(60,320,200,32);
		this.balanceLabel.setFont(font);
		this.panel.add(balanceLabel);

		this.balanceTF=new JTextField();
		this.balanceTF.setBounds(270,320,260,32);
		this.balanceTF.setFont(fieldFont);
		this.balanceTF.setText(String.valueOf(ac.getBalance()));
		this.balanceTF.setEditable(false);
		this.panel.add(balanceTF);

		this.transferBtn=new JButton("Transfer");
		this.transferBtn.setBounds(60,375,150,40);
		this.transferBtn.addActionListener(this);
		this.transferBtn.setBackground(new Color(0, 102, 204));
		this.transferBtn.setForeground(Color.WHITE);
		this.transferBtn.setFont(font);
		this.transferBtn.setFocusPainted(false);
		this.panel.add(transferBtn);

		this.searchByAccNoBtn=new JButton("Search By AccNo");
		this.searchByAccNoBtn.setBounds(225,375,200,40);
		this.searchByAccNoBtn.addActionListener(this);
		this.searchByAccNoBtn.setBackground(new Color(0, 102, 204));
		this.searchByAccNoBtn.setForeground(Color.WHITE);
		this.searchByAccNoBtn.setFont(font);
		this.searchByAccNoBtn.setFocusPainted(false);
		this.panel.add(searchByAccNoBtn);

		this.searchByMoneyTransferIdBtn=new JButton("Search By Transfer Id");
		this.searchByMoneyTransferIdBtn.setBounds(440,375,220,40);
		this.searchByMoneyTransferIdBtn.addActionListener(this);
		this.searchByMoneyTransferIdBtn.setBackground(new Color(0, 102, 204));
		this.searchByMoneyTransferIdBtn.setForeground(Color.WHITE);
		this.searchByMoneyTransferIdBtn.setFont(font);
		this.searchByMoneyTransferIdBtn.setFocusPainted(false);
		this.panel.add(searchByMoneyTransferIdBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(675,375,150,40);
		this.backBtn.addActionListener(this);
		this.backBtn.setBackground(new Color(108, 117, 125));
		this.backBtn.setForeground(Color.WHITE);
		this.backBtn.setFont(font);
		this.backBtn.setFocusPainted(false);
		this.panel.add(backBtn);

		MoneyTransferRepo mtrp=new MoneyTransferRepo();
		MoneyTransfer[] moneyTransferList=mtrp.searchByAccNo(ac.getAccNo());
		int count=0;
		for(int i=0;i<moneyTransferList.length;i++)
		{
			if(moneyTransferList[i]!=null)
			{
				count++;
			}
		}
		String moneyTransferData1[][]=new String[count][5];
		int row=0;
		for(int i=0;i<moneyTransferList.length;i++)
		{

			if(moneyTransferList[i]!=null)
			{
				moneyTransferData1[row][0]=moneyTransferList[i].getMoneyTransferId();
				moneyTransferData1[row][1]=moneyTransferList[i].getSenderAccNo();
				moneyTransferData1[row][2]=moneyTransferList[i].getReceiverAccNo();
				moneyTransferData1[row][3]=String.valueOf(moneyTransferList[i].getAmount());
				moneyTransferData1[row][4]=moneyTransferList[i].getDate();
				row++;
			}
		}

		String head1[]={"Transfer Id","Sender Account No","Receiver Account No","Amount","Date"};
		this.moneyTransferTable=new JTable(moneyTransferData1,head1);
		this.moneyTransferTable.setFont(fieldFont);
		this.moneyTransferTable.setRowHeight(28);
		this.moneyTransferTable.getTableHeader().setFont(font);
		this.moneyTransferTable.getTableHeader().setBackground(new Color(0, 102, 204));
		this.moneyTransferTable.getTableHeader().setForeground(Color.WHITE);
		this.moneyTransferTableSP=new JScrollPane(moneyTransferTable);
		this.moneyTransferTableSP.setBounds(60,435,1144,215);
		this.moneyTransferTableSP.getViewport().setBackground(Color.WHITE);
		this.moneyTransferTable.setEnabled(false);
		this.panel.add(moneyTransferTableSP);

		this.add(panel);

		this.mt=mt;
		this.u=u;

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(dateBtn.getText()))
		{
			CalendarDialog cd=new CalendarDialog(this,dateTF);
			cd.setVisible(true);
		}

		if(command.equals(transferBtn.getText()))
		{
	        MoneyTransferRepo mtrp=new MoneyTransferRepo();
			AccountRepo arp=new AccountRepo();
			String senderAccNo,receiverAccNo,moneyTransferId,date;
			moneyTransferId=moneyTransferIdTF.getText().trim();
			senderAccNo = senderAccNoTF.getText();
            receiverAccNo = receiverAccNoTF.getText().trim();
			date = dateTF.getText().trim();

			if(receiverAccNo.isEmpty() || amountTF.getText().isEmpty() || date.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Please Fill Up All The Field Properly");
				return;
			}

			if(!moneyTransferId.startsWith("TXTR") || mtrp.searchByMoneyTransferId(moneyTransferId)!=null)
			{
				moneyTransferId=mtrp.generateMoneyTransferId();
			}

            double amount = 0;
            try
			{
                amount = Double.parseDouble(amountTF.getText());
            } catch (Exception e)
			{
                JOptionPane.showMessageDialog(this,"Invalid Amount","Massage",JOptionPane.WARNING_MESSAGE);
                return;
			}

			Account senderAc=arp.searchAccountByAccNo(senderAccNo);
			Account receiverAc=arp.searchAccountByAccNo(receiverAccNo);

			if((receiverAccNo+date).contains(","))
			{
				JOptionPane.showMessageDialog(this,"Comma (,) is not allowed in any field","Massage",JOptionPane.WARNING_MESSAGE);
			}
			else if(amount<=0)
			{
				JOptionPane.showMessageDialog(this,"Amount must be greater than zero.","Massage",JOptionPane.WARNING_MESSAGE);
			}
			else if(receiverAccNo.equals(senderAccNo))
			{
				JOptionPane.showMessageDialog(this,"Sender and Receiver Account can not be same.","Massage",JOptionPane.WARNING_MESSAGE);
			}
			else if(receiverAc==null)
			{
				JOptionPane.showMessageDialog(this,"Receiver Account Not Found.","Massage",JOptionPane.ERROR_MESSAGE);
			}
			else if(!senderAc.getStatus().equals("Active"))
			{
				JOptionPane.showMessageDialog(this,"Your Account is not Active.","Massage",JOptionPane.ERROR_MESSAGE);
			}
			else if(senderAc.getBalance()<amount)
			{
				JOptionPane.showMessageDialog(this,"Insufficient Balance.","Massage",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				MoneyTransfer mt = new MoneyTransfer(moneyTransferId,senderAccNo, receiverAccNo, amount, date);
				mtrp.transfer(mt);
				SuccessGifDialog sgd=new SuccessGifDialog(this);
				sgd.setVisible(true);
				JOptionPane.showMessageDialog(this,"Money Transfer Successful.\nTransaction ID: " + moneyTransferId);

				MoneyTransferOperation mto=new MoneyTransferOperation(this.mt,this.u);
				this.setVisible(false);
				mto.setVisible(true);
			}
		}

		if(command.equals(searchByAccNoBtn.getText()))
		{
			String receiverAccNo;
			receiverAccNo=receiverAccNoTF.getText().trim();

			if(!receiverAccNo.isEmpty())
			{
				MoneyTransferRepo mtrp=new MoneyTransferRepo();
				MoneyTransfer[] mt = mtrp.searchByAccNo(ac.getAccNo());
				StringBuilder result = new StringBuilder("Money Transfers with Account No " + receiverAccNo + ":\n");
				boolean found=false;
				for (MoneyTransfer mtr : mt)
				{
					if (mtr!=null && (mtr.getSenderAccNo().equals(receiverAccNo) || mtr.getReceiverAccNo().equals(receiverAccNo)))
					{
						result.append("Id: " + mtr.getMoneyTransferId() + ",  From: " + mtr.getSenderAccNo() + ",  To: " + mtr.getReceiverAccNo() + ",  Amount: " + mtr.getAmount() + ",  Date: " + mtr.getDate() + "\n");
						found=true;
					}
				}
				if(found)
				{
					JOptionPane.showMessageDialog(this,result.toString());
				}
				else
				{
					JOptionPane.showMessageDialog(this,"MoneyTransfer Not Found","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Enter Receiver Account No To Search.");
			}
		}
		if(command.equals(searchByMoneyTransferIdBtn.getText()))
		{
			String moneyTransferId;
			moneyTransferId=JOptionPane.showInputDialog(this,"Enter Money Transfer Id:");

			if(moneyTransferId!=null && !moneyTransferId.trim().isEmpty())
			{
				MoneyTransferRepo mtrp=new MoneyTransferRepo();
				MoneyTransfer mt = mtrp.searchByMoneyTransferId(moneyTransferId.trim());
				if (mt != null && (mt.getSenderAccNo().equals(ac.getAccNo()) || mt.getReceiverAccNo().equals(ac.getAccNo())))
				{
					JOptionPane.showMessageDialog(this,"MoneyTransfer Found\nId: " + mt.getMoneyTransferId() + "\nFrom: " + mt.getSenderAccNo() + "\nTo: " + mt.getReceiverAccNo() + "\nAmount: " + mt.getAmount() + "\nDate: " + mt.getDate());
				} else
				{
					JOptionPane.showMessageDialog(this,"MoneyTransferId not found.","Message",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Enter Money Transfer Id To Search.");
			}
		}


		if(command.equals(backBtn.getText()))
		{
			CustomersHomeFrame chf=new CustomersHomeFrame(this.u);
			this.setVisible(false);
			chf.setVisible(true);
		}


	}


}
