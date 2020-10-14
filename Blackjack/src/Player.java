import java.util.ArrayList;

/**
 * Player
 */
public class Player {

	private String name;
	private ArrayList<Card> hand;
	private int currentTotal;
	private boolean broke;

	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<Card>();
		this.currentTotal = 0;
	}

	public void showCards() {

		for (Card card : hand) {
			System.out.println(card.toString());
		}

	}

	public void giveCard(Card card){
		this.hand.add(card);	
		this.currentTotal += card.getValue();
		if(this.currentTotal > 21){
			this.broke = true;
		}
	}

	
	public int getCurrentTotal(){
		return this.currentTotal;
	}

	public boolean getBroke(){
		return this.broke;
	}

}