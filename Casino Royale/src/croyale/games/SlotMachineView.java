package croyale.games;

import javax.swing.*;
import java.awt.*;


public class SlotMachineView extends JPanel
{
	JButton button1;
	
	public SlotMachineView(JPanel panel)
	{
		System.out.println("Create a button");
		
		panel.clearall();
		button1 = new JButton("Hello Casino");
		panel.add(button1);
		panel.setVisible(true);
				
		System.out.println("Panel should be updated");
	
	}
}
