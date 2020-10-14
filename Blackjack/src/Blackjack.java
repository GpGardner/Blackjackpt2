
import java.util.ArrayList;
import java.util.Scanner;

import DeckOfCard.*;


public class Blackjack {

	private int winValue = 21;

	private Dealer dealer;

	private ArrayList<Player> players;

	private Deck deck;

	public Blackjack() {
		players = new ArrayList<Player>();
		this.winValue = 21;
		dealer = new Dealer();
		players.add(new Player("George"));
		players.add(new Player("Steve"));
		deck = new Deck();
	}

	public void run() {
		Scanner userInput = new Scanner(System.in);
		String play = "Y";
		System.out.println("\nWELCOME TO GEORGE'S BLACKJACK\n");
		System.out.println("Ill shuffle the deck\n");
		deck.shuffleCards();
		while (play.equalsIgnoreCase("Y")) {
			System.out.printf("Lets start a new round: \n");
			for (int i = 1; i <= 2; i++) {
				for (int j = 0; j < players.size(); j++) {
					Player curPlayer = players.get(j);
					Card curCard = deck.dealCard();
					System.out.printf("%s gets dealt a %s\n", curPlayer.getName(), curCard);
					curPlayer.giveCard(curCard);
				}
			}

			System.out.println("Okay everyone has their cards\n");

			/**
			 * This is where we loop over the list of players.
			 * Each players turn is preceded with listing their cards
			 * As long as their total is less than 21, they get asked to hit or stay
			 * hit gives them another card, anything else chooses to stay and it moves on to the next person
			 */
			for (Player player : players) {
				boolean choice = true;
				while (choice) {
					System.out.printf("\n%s's turn\n\n", player.getName());
					System.out.println("Current Cards:");
					player.showCards();
					int currentTotal = player.getCurrentTotal();
					System.out.printf("Current Total: %s", player.getCurrentTotal());

					while(currentTotal < 21){
						
						System.out.printf("\n%s, would you like to (H)it or (S)tay?\n\n", player.getName());
						String answer = userInput.nextLine();

						if(answer.equalsIgnoreCase("H")){
							player.giveCard(deck.dealCard());
							System.out.printf("Current Total: %s", player.getCurrentTotal());
						} else{
							break;
						}

						currentTotal = player.getCurrentTotal();
					}

					if(currentTotal == 21){
						System.out.println("Woohoo blackjack");
					}

					

					choice = false;
				}
			}

			play = "N";
		}

		userInput.close();
	}

}
