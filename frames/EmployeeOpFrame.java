package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class EmployeeOpFrame extends JFrame implements ActionListener
{
	private JLabel operationLabel;
	private JButton customersBtn,wdBtn, backBtn,accBtn;
	private JPanel panel;
	private User u;
	private Transaction t;

	public EmployeeOpFrame(User u)
	{

		super("Employee Operation Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 20);

		this.operationLabel=new JLabel("Employee Operations", JLabel.CENTER);
		this.operationLabel.setBounds(0,0,1264,70);
		this.operationLabel.setOpaque(true);
		this.operationLabel.setBackground(new Color(0, 102, 204));
		this.operationLabel.setForeground(Color.WHITE);
		this.operationLabel.setFont(titleFont);
		this.panel.add(operationLabel);

		this.customersBtn=new JButton("Customers Operation");
		this.customersBtn.setBounds(452,160,360,50);
		this.customersBtn.addActionListener(this);
		this.customersBtn.setBackground(new Color(0, 102, 204));
		this.customersBtn.setForeground(Color.WHITE);
        this.customersBtn.setFont(font);
        this.customersBtn.setFocusPainted(false);
		this.panel.add(customersBtn);

		this.wdBtn=new JButton("Transit Money");
		this.wdBtn.setBounds(452,235,360,50);
		this.wdBtn.addActionListener(this);
		this.wdBtn.setBackground(new Color(0, 102, 204));
		this.wdBtn.setForeground(Color.WHITE);
        this.wdBtn.setFont(font);
        this.wdBtn.setFocusPainted(false);
		this.panel.add(wdBtn);

		this.accBtn=new JButton("Account Operation");
		this.accBtn.setBounds(452,310,360,50);
		this.accBtn.addActionListener(this);
		this.accBtn.setBackground(new Color(0, 102, 204));
		this.accBtn.setForeground(Color.WHITE);
        this.accBtn.setFont(font);
        this.accBtn.setFocusPainted(false);
		this.panel.add(accBtn);

		this.backBtn=new JButton("Back");
		this.backBtn.setBounds(452,410,360,50);
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

		if(command.equals(customersBtn.getText()))
		{
			CustomersOperationFrame cof=new CustomersOperationFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}

		if(command.equals(wdBtn.getText()))
		{
			TransactionOperationFrame tof=new TransactionOperationFrame(this.t,this.u);
			this.setVisible(false);
			tof.setVisible(true);
		}
		if(command.equals(accBtn.getText()))
		{
			AccountOperationFrame aof=new AccountOperationFrame(this.t,this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}
		if(command.equals(backBtn.getText()))
		{
			EmployeesHomeFrame ehf=new EmployeesHomeFrame(this.u);
			this.setVisible(false);
			ehf.setVisible(true);
		}



	}

}
