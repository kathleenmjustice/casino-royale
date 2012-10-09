package croyale;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import croyale.gameutil.Blackjack;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Casinogui {
	private JFrame frame;
	private JLabel welcomeToBlackjack;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
		  public void run() {
			try {
				Casinogui window = new Casinogui();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		});
	}/**
	 * Create the application.
	 */
	public Casinogui() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Set layout for JFrame  
		 frame.setLayout(new FlowLayout());  

		String[] games = {"Blackjack"};
		JComboBox<String> gamesComboBox = new JComboBox<String>(games);
		gamesComboBox.setSelectedItem(null); 
		frame.getContentPane().add(gamesComboBox);
		gamesComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();        
				String gameName = (String)cb.getSelectedItem();
				if (gameName == "Blackjack"){
					blackjackGUI();
				}
		    }
		});

	}
	public void blackjackGUI(){
		welcomeToBlackjack = new JLabel("Welcome to the game of Blackjack!") ;
		frame.getContentPane().add(welcomeToBlackjack);
		Blackjack blackjackGame = new Blackjack();
		blackjackGame.wager();
	}
}