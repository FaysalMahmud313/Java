package frames;

import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SuccessGifDialog extends JDialog implements ActionListener
{
	private ImageIcon updateIcon;
	private JLabel updateLabel;
	private Timer timer;



	public SuccessGifDialog(JFrame frame)
	{
		super(frame, "Successful", true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		
		this.updateIcon=new ImageIcon(Toolkit.getDefaultToolkit().createImage("image/Update.gif"));
		this.updateLabel=new JLabel(updateIcon);
		this.updateLabel.setPreferredSize(new Dimension(300,300));
		this.add(updateLabel);

		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(frame);

		
		this.timer=new Timer(3920,this);
		this.timer.setRepeats(false);
		this.timer.start();
	}

	public void actionPerformed(ActionEvent ae)
	{
		this.dispose();
	}

}
