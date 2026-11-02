package frames;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;


public class AdminHomeFrame extends JFrame implements ActionListener
{
	private JLabel titleLabel;
	private JButton backBtn,operationBtn,viewBtn,updateBtn;
	private JPanel panel;
	private User u;

	public AdminHomeFrame(User u)
	{

		super("Admin Home Frame");
		this.setSize(1280,720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font titleFont = new Font("Arial", Font.BOLD, 26);
		Font font = new Font("Arial", Font.BOLD, 20);

		this.titleLabel=new JLabel("Admin Panel", JLabel.CENTER);
		this.titleLabel.setBounds(0,0,1264,70);
		this.titleLabel.setOpaque(true);
		this.titleLabel.setBackground(new Color(0, 102, 204));
		this.titleLabel.setForeground(Color.WHITE);
		this.titleLabel.setFont(titleFont);
		this.panel.add(titleLabel);

		this.operationBtn=new JButton("Operations");
		this.operationBtn.setBounds(452,160,360,50);
		this.operationBtn.addActionListener(this);
		this.operationBtn.setBackground(new Color(0, 102, 204));
		this.operationBtn.setForeground(Color.WHITE);
        this.operationBtn.setFont(font);
        this.operationBtn.setFocusPainted(false);
		this.panel.add(operationBtn);

		this.viewBtn=new JButton("View");
		this.viewBtn.setBounds(452,235,360,50);
		this.viewBtn.addActionListener(this);
		this.viewBtn.setBackground(new Color(0, 102, 204));
		this.viewBtn.setForeground(Color.WHITE);
        this.viewBtn.setFont(font);
        this.viewBtn.setFocusPainted(false);
		this.panel.add(viewBtn);

		this.updateBtn=new JButton("Updates");
		this.updateBtn.setBounds(452,310,360,50);
		this.updateBtn.addActionListener(this);
		this.updateBtn.setBackground(new Color(0, 102, 204));
		this.updateBtn.setForeground(Color.WHITE);
        this.updateBtn.setFont(font);
        this.updateBtn.setFocusPainted(false);
		this.panel.add(updateBtn);

		this.backBtn=new JButton("Logout");
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
