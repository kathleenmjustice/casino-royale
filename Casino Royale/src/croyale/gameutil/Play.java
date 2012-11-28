package croyale.gameutil;

import java.lang.reflect.InvocationTargetException;

import util.ParseString;

public interface Play {
	public void myPlay(Deck deck, BlackjackHand userHand, BlackjackHand dealerHand);
}