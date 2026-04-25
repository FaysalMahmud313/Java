package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	private ImageIcon backgroundIcon,operationIcon,viewIcon,updateIcon,backIcon;
	private JLabel backgroundLabel,operationLabel,viewLabel, updateLabel;
	private JButton adminBtn,backBtn, employeesBtn, transactionBtn,moneyTransferBtn, accountBtn, profileBtn, passBtn,operationBtn,viewBtn,updateBtn;
	private JPanel panel;
	private User u;
	
	public AdminHomeFrame(User u)
	{
		
		super("Admin Home Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		Font font = new Font("Arial Rounded MT Bold", Font.BOLD, 24);
		//this.panel.setBackground(Color.CYAN);
		
		
		
		backgroundIcon = new ImageIcon("image/Admin Panel.jpg");
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 1280, 720);
        panel.add(backgroundLabel);
		
		this.operationBtn=new JButton("Operations");
		this.operationBtn.setBounds(100,220,300,50);
		this.operationBtn.addActionListener(this);
		this.operationBtn.setBackground(new Color(51, 204, 255));
		this.operationBtn.setForeground(Color.WHITE);
        this.operationBtn.setFont(font);
        this.operationBtn.setFocusPainted(false);
		this.panel.add(operationBtn);
		this.operationBtn.setVisible(true);
		
		/*operationIcon = new ImageIcon("image/Operations.png");
		this.operationBtn=new JButton(operationIcon);
		this.operationBtn.setBounds(180,200,148,64);
		operationBtn.setBorderPainted(false);
		this.operationBtn.addActionListener(this);
		this.panel.add(operationBtn);*/
		
		this.viewBtn=new JButton("View");
		this.viewBtn.setBounds(100,320,300,50);
		this.viewBtn.addActionListener(this);
		this.viewBtn.setBackground(new Color(51, 204, 255));
		this.viewBtn.setForeground(Color.WHITE);
        this.viewBtn.setFont(font);
        this.viewBtn.setFocusPainted(false);
		this.panel.add(viewBtn);
		this.viewBtn.setVisible(true);
		
		/*viewIcon = new ImageIcon("image/View.png");
		this.viewBtn=new JButton(viewIcon);
		this.viewBtn.setBounds(180,304,144,63);
		viewBtn.setBorderPainted(false);
		this.viewBtn.addActionListener(this);
		this.panel.add(viewBtn);*/
		
		this.updateBtn=new JButton("Updates");
		this.updateBtn.setBounds(100,420,300,50);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(new Color(51, 204, 255));
		this.updateBtn.setForeground(Color.WHITE);
        this.updateBtn.setFont(font);
        this.updateBtn.setFocusPainted(false);
		this.panel.add(updateBtn);
		this.updateBtn.setVisible(true);
		
		/*updateIcon = new ImageIcon("image/Update.png");
		this.updateBtn=new JButton(updateIcon);
		this.updateBtn.setBounds(180,407,145,65);
		updateBtn.setBorderPainted(false);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);*/
		
		backIcon = new ImageIcon("image/Back.png");
		this.backBtn=new JButton(backIcon);
		this.backBtn.setBounds(500,520,82,51);
		backBtn.setBorderPainted(false);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		panel.setComponentZOrder(operationBtn, 1); // Button on top
        panel.setComponentZOrder(viewBtn, 0); // Button on top
        panel.setComponentZOrder(updateBtn, 2); // Button on top
		panel.setComponentZOrder(backBtn, 3);
        panel.setComponentZOrder(backgroundLabel, 4);
		
		this.add(panel);
		this.u=u;
		
	}
	
	public void actionPerformed(ActionEvent ae)
{
    Object source = ae.getSource();

    if (source == operationBtn)
    {
        AdminOpFrame aof = new AdminOpFrame(this.u);
        this.setVisible(false);
        aof.setVisible(true);
    }
    else if (source == viewBtn)
    {
        AdminViewFrame avf = new AdminViewFrame(this.u);
        this.setVisible(false);
        avf.setVisible(true);
    }
    else if (source == updateBtn)
    {
        AdminUpdateFrame auf = new AdminUpdateFrame(this.u);
        this.setVisible(false);
        auf.setVisible(true);
    }
    else if (source == backBtn)
    {
        LoginFrame lf = new LoginFrame();
        this.setVisible(false);
        lf.setVisible(true);
    }
}

}