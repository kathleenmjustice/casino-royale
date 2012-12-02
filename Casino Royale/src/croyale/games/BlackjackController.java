package croyale.games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import croyale.gameutil.Card;

//import croyale.gameutil.Play;


public class BlackjackController {
	private BlackjackModel model;
	private BlackjackView view;
	
	public BlackjackController(BlackjackModel m, BlackjackView v){ 
		model = m;
		view = v;
		view.setMoney(model.getMoney());
		
		view.addPlayListener(new PlayListener());
		view.addBetListener(new BetListener());
		
		view.displayCards(model.deal());
	}
	
	private class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try {
				String source = ((JButton)e.getSource()).getText();
				if(model.getDealerHand().getBlackjackValue() == 21)
					view.drawLose();
				else if (model.getUserHand().getBlackjackValue() == 21)
					view.drawWin();
				if (source == "Hit!"){
					model.hit();
					view.drawLose();
				}
				else if (source == "Stand!"){
					
					while (model.getDealerHand().getBlackjackValue() <= 16) {
						 model.dealOneCard(model.getDealerHand());
				         if (model.getDealerHand().getBlackjackValue() > 21) {
				            System.out.println();
				           // Dealer busted by going over 21.  You win.
				           model.setUserWins(true);
				         }
				      }
				    if (model.getUserWins() == true)
				    	view.drawWin();
				    else
				    	view.drawLose();
				}
				else if (source == "New Game?"){
					view.reset();
					view.displayCards(model.deal());
				}
				//Play currentPlay = BlackjackController.this.m_view.getCurrentPlay();
				
				//BlackjackController.this.m_view.setMoney(BlackjackController.this.m_model.getMoney());
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}
	private class BetListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int bet;
			try {
				bet = BlackjackController.this.view.getBet();
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}
}
