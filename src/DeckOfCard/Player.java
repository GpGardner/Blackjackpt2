package DeckOfCard;

import java.util.ArrayList;

/**
 * Player
 */
public class Player {

	private String name;
	private ArrayList<Card> hand;
	private int currentTotal;
	private boolean broke;
	private boolean hasBlackJack;

	public Player(String name) {
		this.name = name;
		this.hand = new ArrayList<Card>();
		this.currentTotal = 0;
	}

	public void showCards() {
		for (Card card : this.hand) {
			System.out.println(card.toString());
		}
	}

	public void giveCard(Card card) {
		this.hand.add(card);
		this.currentTotal += card.getValue();
		if (this.currentTotal > 21) {
			this.broke = true;
		}
		if (this.currentTotal == 21) {
			this.hasBlackJack = true;
		}
	}

	public void removeAllCards() {
		this.hand.clear();
		this.currentTotal = 0;
	}

	public int getCurrentTotal() {
		return this.currentTotal;
	}

	public boolean getBroke() {
		return this.broke;
	}

	public boolean getHasBlackJack() {
		return this.hasBlackJack;
	}

	public String getName() {
		return this.name;
	}

	public int getHandSize(){
		return this.hand.size();
	}

}