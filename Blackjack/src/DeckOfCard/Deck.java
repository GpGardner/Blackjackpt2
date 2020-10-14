package DeckOfCard;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> discardPile;
	private int numberOfCards;


	public Deck() {
		discardPile = new ArrayList<Card>();
		this.numberOfCards = 52;
		generateCards();
	}

	public Card dealCard(){
		Card toDeal = cards.get(0);
		cards.remove(0);
		return toDeal;
	}

	public void shuffleCards() {
		Random rng = new Random();

		Card temp;
		int j;
		for (int i = 0; i < this.numberOfCards; i++) {
			j = rng.nextInt(this.numberOfCards);

			temp = this.cards.get(i);
			this.cards.set(i, this.cards.get(j));
			this.cards.set(j, temp);

		}
	}

	public void addToDiscardPile(Card card){
			this.discardPile.add(card);
	}

	private void generateCards() {
		this.cards = new ArrayList<Card>();
		for (int value = 1; value < 14; value++) {
			for (int suit = 0; suit < 4; suit++) {
				this.cards.add(new Card(Suit.values()[suit], value));
			}
		}
	}

	public void showDiscardPile(){
		System.out.println(discardPile);
	}

	@Override
	public String toString() {
		String result = "";
		for (Card card : this.cards) {
			result += (card + "\n");
		}
		return result;
	}

}
