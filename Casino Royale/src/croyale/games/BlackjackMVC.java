package croyale.games;

import javax.swing.JFrame;

public class BlackjackMVC {
	private JFrame blackjackFrame;
	public BlackjackMVC(){
		BlackjackModel model = new BlackjackModel();
		BlackjackView view = new BlackjackView(blackjackFrame);
		BlackjackController controller = new BlackjackController(model,view);
		
	}
}
