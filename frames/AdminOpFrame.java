package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminOpFrame extends JFrame implements ActionListener
{
	private JLabel operationLabel;
	private JButton adminBtn,backBtn, employeesBtn, customersBtn;
	private JPanel panel;
	private User u;


	public AdminOpFrame(User u)
	{

		super("Operation Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 20);

		this.operationLabel = new JLabel("Operations", JLabel.CENTER);
		this.operationLabel.setBounds(0,0,1264,70);
		this.operationLabel.setOpaque(true);
		this.operationLabel.setBackground(new Color(0, 102, 204));
		this.operationLabel.setForeground(Color.WHITE);
		this.operationLabel.setFont(titleFont);
		this.panel.add(operationLabel);

		this.adminBtn=new JButton("Admin Operation");
		this.adminBtn.setBounds(452,160,360,50);
		this.adminBtn.addActionListener(this);
		this.adminBtn.setBackground(new Color(0, 102, 204));
		this.adminBtn.setForeground(Color.WHITE);
        this.adminBtn.setFont(font);
        this.adminBtn.setFocusPainted(false);
		this.panel.add(adminBtn);

		this.employeesBtn=new JButton("Employee Operation");
		this.employeesBtn.setBounds(452,235,360,50);
		this.employeesBtn.addActionListener(this);
		this.employeesBtn.setBackground(new Color(0, 102, 204));
		this.employeesBtn.setForeground(Color.WHITE);
        this.employeesBtn.setFont(font);
        this.employeesBtn.setFocusPainted(false);
		this.panel.add(employeesBtn);

		this.customersBtn=new JButton("Customer Operation");
		this.customersBtn.setBounds(452,310,360,50);
		this.customersBtn.addActionListener(this);
		this.customersBtn.setBackground(new Color(0, 102, 204));
		this.customersBtn.setForeground(Color.WHITE);
        this.customersBtn.setFont(font);
        this.customersBtn.setFocusPainted(false);
		this.panel.add(customersBtn);

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

		if(command.equals(adminBtn.getText()))
		{
			AdminOperationFrame aof=new AdminOperationFrame(this.u);
			this.setVisible(false);
			aof.setVisible(true);
		}

		if(command.equals(employeesBtn.getText()))
		{
			EmployeesOperationFrame eof=new EmployeesOperationFrame(this.u);
			this.setVisible(false);
			eof.setVisible(true);
		}

		if(command.equals(customersBtn.getText()))
		{
			CustomersOperationFrame cof=new CustomersOperationFrame(this.u);
			this.setVisible(false);
			cof.setVisible(true);
		}

		if(command.equals(backBtn.getText()))
		{
			AdminHomeFrame ahf=new AdminHomeFrame(this.u);
			this.setVisible(false);
			ahf.setVisible(true);
		}



	}

}
