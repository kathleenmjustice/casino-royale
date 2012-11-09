package croyale;

import javax.swing.*;

public class Casino {

	public static void main(String[] args) {
		
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
				MainGUI.createAndShowGUI();
			}
		});

	}

}
