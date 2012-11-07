package croyale;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import croyale.gameutil.Blackjack;

public class Blackjackgui {
	private JLabel welcomeToBlackjack;
	JFrame blackjackFrame;

	/* Create the application.
	 */
	public Blackjackgui(JFrame blackjackFrame) {
		initialize();
	}
		
	private void initialize() {
		blackjackFrame = new JFrame();
		blackjackFrame.setBounds(100, 100, 600, 600);
		//Set layout for JFrame  
		blackjackFrame.setLayout(new FlowLayout());  

		 welcomeToBlackjack = new JLabel("Welcome to the game of Blackjack!") ;
		 blackjackFrame.getContentPane().add(welcomeToBlackjack);
		 Blackjack blackjackGame = new Blackjack();
		// blackjackGame.wager();
	}
}
