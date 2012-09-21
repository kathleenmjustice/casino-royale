package croyale.gameutil;

public class Deck {

	private Card[] mydeck;
	private int topcard;
	private int[] order;
	
	public Deck(){
		mydeck = new Card[52];
		int k = 0;
		for (int i=1;i<14;i++){
			for (int j=1;j<5;j++){
				mydeck[k] = new Card(i,j);
				k++;
			}
		}
		shuffle();
		topcard = 0;
	}
	
	public void shuffle(){
		//to be implemented
	}
	
	public Card drawCard(){
		return mydeck[topcard++];
	}
	
}
