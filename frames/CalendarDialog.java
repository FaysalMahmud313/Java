package frames;

import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;

public class CalendarDialog extends JDialog implements ActionListener
{
	private JLabel monthLabel;
	private JLabel[] dayNameLabel;
	private JButton prevBtn, nextBtn;
	private JButton[] dayBtn;
	private JPanel panel;
	private JTextField dateTF;
	private LocalDate shownMonth;



	public CalendarDialog(JFrame frame, JTextField dateTF)
	{
		super(frame, "Select Date", true);
		this.setSize(390,370);
		this.setLocationRelativeTo(frame);
		this.setResizable(false);

		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.panel.setBackground(Color.WHITE);
		Font font = new Font("Arial", Font.BOLD, 15);

		this.prevBtn=new JButton("<");
		this.prevBtn.setBounds(20,15,50,32);
		this.prevBtn.addActionListener(this);
		this.prevBtn.setBackground(new Color(108, 117, 125));
		this.prevBtn.setForeground(Color.WHITE);
		this.prevBtn.setFont(font);
		this.prevBtn.setFocusPainted(false);
		this.panel.add(prevBtn);

		this.monthLabel=new JLabel("", JLabel.CENTER);
		this.monthLabel.setBounds(75,15,224,32);
		this.monthLabel.setFont(new Font("Arial", Font.BOLD, 17));
		this.monthLabel.setForeground(new Color(0, 102, 204));
		this.panel.add(monthLabel);

		this.nextBtn=new JButton(">");
		this.nextBtn.setBounds(304,15,50,32);
		this.nextBtn.addActionListener(this);
		this.nextBtn.setBackground(new Color(108, 117, 125));
		this.nextBtn.setForeground(Color.WHITE);
		this.nextBtn.setFont(font);
		this.nextBtn.setFocusPainted(false);
		this.panel.add(nextBtn);

		String[] dayNames={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		this.dayNameLabel=new JLabel[7];
		for(int i=0;i<7;i++)
		{
			this.dayNameLabel[i]=new JLabel(dayNames[i], JLabel.CENTER);
			this.dayNameLabel[i].setBounds(20+i*48,55,46,25);
			this.dayNameLabel[i].setFont(new Font("Arial", Font.BOLD, 13));
			this.dayNameLabel[i].setForeground(new Color(90, 90, 90));
			this.panel.add(dayNameLabel[i]);
		}

		this.dayBtn=new JButton[42];
		for(int i=0;i<42;i++)
		{
			this.dayBtn[i]=new JButton();
			this.dayBtn[i].setBounds(20+(i%7)*48,85+(i/7)*38,46,34);
			this.dayBtn[i].setFont(new Font("Arial", Font.PLAIN, 14));
			this.dayBtn[i].setMargin(new Insets(0,0,0,0));
			this.dayBtn[i].setFocusPainted(false);
			this.dayBtn[i].addActionListener(this);
			this.panel.add(dayBtn[i]);
		}

		this.add(panel);

		this.dateTF=dateTF;
		this.shownMonth=LocalDate.now().withDayOfMonth(1);
		this.showMonth();
	}

	public static String getToday()
	{
		return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	private void showMonth()
	{
		monthLabel.setText(shownMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH) + " " + shownMonth.getYear());

		LocalDate today=LocalDate.now();
		int start=shownMonth.getDayOfWeek().getValue()%7;
		int days=shownMonth.lengthOfMonth();

		for(int i=0;i<42;i++)
		{
			int day=i-start+1;
			if(day>=1 && day<=days)
			{
				LocalDate date=shownMonth.withDayOfMonth(day);
				dayBtn[i].setText(String.valueOf(day));
				dayBtn[i].setVisible(true);

				dayBtn[i].setEnabled(!date.isAfter(today));

				if(date.equals(today))
				{
					dayBtn[i].setBackground(new Color(0, 102, 204));
					dayBtn[i].setForeground(Color.WHITE);
				}
				else
				{
					dayBtn[i].setBackground(Color.WHITE);
					dayBtn[i].setForeground(new Color(33, 37, 41));
				}
			}
			else
			{
				dayBtn[i].setVisible(false);
			}
		}

		nextBtn.setEnabled(shownMonth.isBefore(today.withDayOfMonth(1)));
	}

	public void actionPerformed(ActionEvent ae)
	{
		Object source=ae.getSource();

		if(source==prevBtn)
		{
			shownMonth=shownMonth.minusMonths(1);
			showMonth();
		}
		else if(source==nextBtn)
		{
			shownMonth=shownMonth.plusMonths(1);
			showMonth();
		}
		else
		{
			for(int i=0;i<42;i++)
			{
				if(source==dayBtn[i])
				{
					LocalDate date=shownMonth.withDayOfMonth(Integer.parseInt(dayBtn[i].getText()));
					dateTF.setText(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
					this.dispose();
				}
			}
		}
	}

}
