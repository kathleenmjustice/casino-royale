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
	}
	
	private class PlayListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			Play currentPlay = new Play();
			try {
				currentPlay = BlackjackController.this.m_view.getUserInput();
			}
			catch(Exception e2){
				;
			}
		}
	}
}
