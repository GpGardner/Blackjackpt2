import java.util.ArrayList;

public class Deck {


	private int numberOfCards;

	private boolean shuffled;

	ArrayList<Card> cards;

	ArrayList<Card> discardPile;

	public Deck(){
		this.cards = new ArrayList<Card>();
		this.discardPile = new ArrayList<Card>();


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
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}

	public void discardCard(Card card){
		discardPile.add(card);
	}

	public boolean getShuffled(){
		return this.shuffled;
	}

	public ArrayList<Card> getCards(){
		return this.cards;
	}

	@Override
	public String toString(){

		String result = "";
		for (Card card : this.cards) {
			result += (card + "\n");
		}
		return result;
	}
	
}
