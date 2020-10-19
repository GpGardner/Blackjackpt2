
import java.util.ArrayList;
import java.util.Scanner;

import DeckOfCard.*;

/**
 * Blackjack "runner" this is the instance of the game itself, it will continue
 * running until conditions are met
 * 
 * winValue = total to play to
 * 
 * dealer = to be instance of dealer
 * 
 * players = to be list of all players in a specific game
 * 
 * deck = to be instance of deck of cards
 */

public class Blackjack {

	private int winValue;

	private Dealer dealer;

	private ArrayList<Player> players;

	private Deck deck;

	/**
	 * default constructor used to make a basic blackjack game sets value to 21,
	 * addes a dealer, adds two players, adds a deck
	 */
	public Blackjack() {
		players = new ArrayList<Player>();
		this.winValue = 21;
		dealer = new Dealer();
		players.add(new Player("George", true));
		players.add(new Player("Steve", false));
		deck = new Deck();
	}

	/**
	 * run method houses our game logic
	 * 
	 * TODO - add more concise methods to house parts of logic
	 * 
	 * EXAMPLE: a method to house logic where players are asked to hit or stay
	 * 
	 * SOLVES: easy adaptation for different responses besides hit or stay
	 */

	public void run() {
		Scanner userInput = new Scanner(System.in);
		String play = "Y";
		System.out.println("\nWELCOME TO GEORGE'S BLACKJACK\n");
		deck.shuffleCards();

		// Game Loop
		while (play.equalsIgnoreCase("Y")) {
			System.out.printf("Lets start a new round: \n");
			if (deck.getNumberOfCards() < 15) {
				deck = new Deck();
				deck.shuffleCards();
			}
			dealCards(players.size());
			
			System.out.println("Okay everyone has their cards\n");

			/**
			 * This is where we loop over the list of players. Each players turn is preceded
			 * with listing their cards As long as their total is less than 21, they get
			 * asked to hit or stay hit gives them another card, anything else chooses to
			 * stay and it moves on to the next person
			 */
			for (Player player : players) {
				boolean choice = true;
				while (choice) {
					System.out.printf("\n%s's turn\n\n", player.getName());
					System.out.println("Current Cards:");
					player.showCards();
					int currentTotal = player.getCurrentTotal();
					printTotal(currentTotal, player);

					while (currentTotal <= this.getWinValue()) {
						if (currentTotal == this.getWinValue() && player.getHandSize() == 2) {
							System.out.println("\nWoohoo blackjack");
							break;
						}

						System.out.printf("\n%s, would you like to (H)it or (S)tay?\n\n", player.getName());
						String answer = userInput.nextLine();

						if (answer.equalsIgnoreCase("H")) {
							Card newPlayerCard = deck.dealCard();
							System.out.println(newPlayerCard.toString());
							player.giveCard(newPlayerCard);
							printTotal(currentTotal, player);

						} else {
							break;
						}

						currentTotal = player.getCurrentTotal();
					}
					

					if (currentTotal > this.getWinValue()) {
						System.out.println("\nDamn, you broke");
					}

					choice = false;
				}
			}

			// end of game - reset hands
			for (Player player : players) {
				player.removeAllCards();
				System.out.println("Cards cleared!");
			}
			System.out.println("Cards left: " + deck.getNumberOfCards());
			System.out.println("Would you like to play again (Y)es or (N)o?");
			play = userInput.nextLine();
		}

		userInput.close();
	}

	private void printTotal(int currentTotal, Player player ) {
		System.out.printf("Current Total: %s", player.getCurrentTotal());

	}

	private void dealCards(int size) {
		for (int i = 1; i <= 2; i++) {
			for (int j = 0; j < size; j++) {
				Player curPlayer = players.get(j);
				Card curCard = deck.dealCard();
				System.out.printf("%s gets dealt a %s\n", curPlayer.getName(), curCard);
				curPlayer.giveCard(curCard);
			}
		}
	}

	public int getWinValue() {
		return this.winValue;
	}

}
