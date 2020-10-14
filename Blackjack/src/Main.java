import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffleCards();
		Player george = new Player("George");
		Player neil = new Player("Neil");
		Scanner userInput = new Scanner(System.in);

		boolean keepPlaying = true;

		while (keepPlaying) {

			System.out.println("Welcome to my blackjack game\n");

			System.out.println("Here comes your cards: \n");

			for (int i = 0; i < 4; i++) {
				if (i == 0 || i == 2) {
					george.giveCard(deck.dealCard());
				} else {
					neil.giveCard(deck.dealCard());
				}
			}
			System.out.println("Georges Hand: \n");
			george.showCards();
			System.out.println("\nNeils Hand: \n");
			neil.showCards();

			while (george.getCurrentTotal() <= 21) {
				System.out.println("\nGeorge, do you want to hit or stay?");
				System.out.printf("Current Total: %s\n", george.getCurrentTotal());
				String answer = userInput.nextLine();

				if (answer.equals("hit")) {

					george.giveCard(deck.dealCard());
					george.showCards();

				} else {
					break;
				}
			}

			System.out.println("Current total: \n" + george.getCurrentTotal());

			while (neil.getCurrentTotal() <= 21) {
				System.out.println("Neil, do you want to hit or stay?");
				System.out.printf("Current Total: %s\n", neil.getCurrentTotal());
				String answer = userInput.nextLine();

				if (answer.equals("hit")) {

					neil.giveCard(deck.dealCard());
					neil.showCards();
				} else {
					break;
				}
			}

			System.out.println("Current total: \n" + neil.getCurrentTotal());


			if ( george.getBroke() || neil.getCurrentTotal() > george.getCurrentTotal() && !neil.getBroke()) {
				System.out.println("Neil wins!\n");
			} else if (neil.getBroke() || george.getCurrentTotal() > neil.getCurrentTotal() && !george.getBroke()) {
				System.out.println("George wins!\n");
			} else {
				System.out.println("Looks like a tie!\n");
			}

			keepPlaying = false;
		}

	}
}
