import java.util.ArrayList;

public class Deck {


	private int numberOfCards;

	private boolean shuffled;

	ArrayList<Card> cards;

	ArrayList<Card> discardPile;

	public Deck(){
		this.cards = new ArrayList<Card>();
		this.discardPile = new ArrayList<Card>()


		this.numberOfCards = 52;
		this.shuffled = false;


		 for (int value = 1; value <= 13; value++) {
			for (int suit = 0; suit < 4; suit++) {
				Card card = new Card(Suit.values()[suit], value);
				cards.add(card);
			}
		}
	}

	public Card dealCard(){
		//TODO: finish dealCard
		return card;
	}

	public Card discardCard(){
		//TODO: add logic for discarding
	}

	public boolean getShuffled(){
		return this.shuffled;
	}

	public ArrayList<Card> getCards(){
		return this.cards;
	}
	
}
