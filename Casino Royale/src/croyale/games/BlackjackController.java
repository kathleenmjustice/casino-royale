package croyale.games;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import croyale.gameutil.Play;


public class BlackjackController {
	private BlackjackModel m_model;
	private BlackjackView m_view;
	
	public BlackjackController(BlackjackModel model, BlackjackView view){ 
		this.m_model = model;
		this.m_view = view;
		System.out.println("money: " + this.m_model.getMoney());
		this.m_view.setMoney(this.m_model.getMoney());
		
		view.addPlayListener(new PlayListener());
		view.addBetListener(new BetListener());
	}
	
	private class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try {
				Play currentPlay = BlackjackController.this.m_view.getCurrentPlay();
				
				BlackjackController.this.m_view.setMoney(BlackjackController.this.m_model.getMoney());
			}
			catch(Exception e2){
				;
			}
		}
	}
	private class BetListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int bet;
			try {
				bet = BlackjackController.this.m_view.getBet();
			}
			catch(Exception e2){
				;
			}
		}
	}
}
