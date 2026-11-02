package frames;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repositories.*;

public class CheckBalanceFrame extends JFrame implements ActionListener
{
    private JLabel titleLabel, summaryLabel, nameLabel, nameValueLabel, userIdLabel, userIdValueLabel, accNoLabel, accNoValueLabel, statusLabel, statusValueLabel, availableLabel, balanceLabel;
    private JPanel panel, cardPanel;
    private JSeparator topLine, bottomLine;
    private JButton checkBtn, backBtn;
    private Account ac;
    private User u;

    public CheckBalanceFrame(Account ac,User u)
    {
        super("Check Balance");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBackground(new Color(245, 247, 250));
        Font titleFont = new Font("Arial", Font.BOLD, 26);
        Font font = new Font("Arial", Font.BOLD, 16);
        Font valueFont = new Font("Arial", Font.PLAIN, 16);

        CustomersRepo crp = new CustomersRepo();
        Customers c = crp.searchCustomersByUserId(u.getUserId());
        String name = "Unknown";
        if (c != null)
        {
            name = c.getName();
        }

        this.titleLabel = new JLabel("Check Balance", JLabel.CENTER);
        this.titleLabel.setBounds(0, 0, 1264, 70);
        this.titleLabel.setOpaque(true);
        this.titleLabel.setBackground(new Color(0, 102, 204));
        this.titleLabel.setForeground(Color.WHITE);
        this.titleLabel.setFont(titleFont);
        this.panel.add(titleLabel);

        this.cardPanel = new JPanel();
        this.cardPanel.setLayout(null);
        this.cardPanel.setBounds(382, 105, 500, 365);
        this.cardPanel.setBackground(Color.WHITE);
        this.cardPanel.setBorder(BorderFactory.createLineBorder(new Color(210, 214, 220)));
        this.panel.add(cardPanel);

        this.summaryLabel = new JLabel("Account Summary");
        this.summaryLabel.setBounds(30, 20, 440, 30);
        this.summaryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        this.summaryLabel.setForeground(new Color(33, 37, 41));
        this.cardPanel.add(summaryLabel);

        this.topLine = new JSeparator();
        this.topLine.setBounds(30, 60, 440, 2);
        this.cardPanel.add(topLine);

        this.nameLabel = new JLabel("Account Holder:");
        this.nameLabel.setBounds(30, 78, 170, 28);
        this.nameLabel.setFont(font);
        this.nameLabel.setForeground(new Color(90, 90, 90));
        this.cardPanel.add(nameLabel);

        this.nameValueLabel = new JLabel(name);
        this.nameValueLabel.setBounds(200, 78, 270, 28);
        this.nameValueLabel.setFont(valueFont);
        this.cardPanel.add(nameValueLabel);

        this.userIdLabel = new JLabel("User ID:");
        this.userIdLabel.setBounds(30, 113, 170, 28);
        this.userIdLabel.setFont(font);
        this.userIdLabel.setForeground(new Color(90, 90, 90));
        this.cardPanel.add(userIdLabel);

        this.userIdValueLabel = new JLabel(u.getUserId());
        this.userIdValueLabel.setBounds(200, 113, 270, 28);
        this.userIdValueLabel.setFont(valueFont);
        this.cardPanel.add(userIdValueLabel);

        this.accNoLabel = new JLabel("Account No:");
        this.accNoLabel.setBounds(30, 148, 170, 28);
        this.accNoLabel.setFont(font);
        this.accNoLabel.setForeground(new Color(90, 90, 90));
        this.cardPanel.add(accNoLabel);

        this.accNoValueLabel = new JLabel(ac.getAccNo());
        this.accNoValueLabel.setBounds(200, 148, 270, 28);
        this.accNoValueLabel.setFont(valueFont);
        this.cardPanel.add(accNoValueLabel);

        this.statusLabel = new JLabel("Account Status:");
        this.statusLabel.setBounds(30, 183, 170, 28);
        this.statusLabel.setFont(font);
        this.statusLabel.setForeground(new Color(90, 90, 90));
        this.cardPanel.add(statusLabel);

        this.statusValueLabel = new JLabel();
        this.statusValueLabel.setBounds(200, 183, 270, 28);
        this.statusValueLabel.setFont(font);
        this.cardPanel.add(statusValueLabel);

        this.bottomLine = new JSeparator();
        this.bottomLine.setBounds(30, 225, 440, 2);
        this.cardPanel.add(bottomLine);

        this.availableLabel = new JLabel("Available Balance", JLabel.CENTER);
        this.availableLabel.setBounds(30, 245, 440, 25);
        this.availableLabel.setFont(valueFont);
        this.availableLabel.setForeground(new Color(90, 90, 90));
        this.cardPanel.add(availableLabel);

        this.balanceLabel = new JLabel("", JLabel.CENTER);
        this.balanceLabel.setBounds(30, 275, 440, 55);
        this.balanceLabel.setFont(new Font("Arial", Font.BOLD, 36));
        this.balanceLabel.setForeground(new Color(0, 102, 204));
        this.cardPanel.add(balanceLabel);

        this.checkBtn = new JButton("Refresh Balance");
        this.checkBtn.setBounds(457, 495, 180, 42);
        this.checkBtn.addActionListener(this);
        this.checkBtn.setBackground(new Color(0, 102, 204));
        this.checkBtn.setForeground(Color.WHITE);
        this.checkBtn.setFont(font);
        this.checkBtn.setFocusPainted(false);
        this.panel.add(checkBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(657, 495, 150, 42);
        this.backBtn.addActionListener(this);
        this.backBtn.setBackground(new Color(108, 117, 125));
        this.backBtn.setForeground(Color.WHITE);
        this.backBtn.setFont(font);
        this.backBtn.setFocusPainted(false);
        this.panel.add(backBtn);

        this.add(panel);

        this.u = u;
        this.ac = ac;
        this.showBalance();
    }

    private void showBalance()
    {
        AccountRepo arp = new AccountRepo();
        Account account = arp.searchAccountByUserId(u.getUserId());
        if (account != null)
        {
            this.ac = account;
        }

        balanceLabel.setText("Tk " + String.format("%,.2f", arp.checkBalance(u.getUserId())));
        statusValueLabel.setText(ac.getStatus());
        if (ac.getStatus().equals("Active"))
        {
            statusValueLabel.setForeground(new Color(0, 128, 0));
        }
        else
        {
            statusValueLabel.setForeground(new Color(204, 0, 0));
        }
    }

    public void actionPerformed(ActionEvent ae)
    {
        String command = ae.getActionCommand();
        if (command.equals(checkBtn.getText()))
        {
            this.showBalance();
        }
        else if (command.equals(backBtn.getText()))
        {
            CustomersHomeFrame chf = new CustomersHomeFrame(this.u);
            this.setVisible(false);
            chf.setVisible(true);
        }
    }
}
