package ca.sheridancollege.project;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Create game with Spider-Manual
		PazaakGame game = new PazaakGame("How do I shot Pazaak?");

		// ca.sheridancollege.project.Display the first four cards of the table deck
		for (int i = 0; i < 4; i++) {
			Card card = game.getDeck().showCards().get(i);
			System.out.println(card);
		}

		// Create p1 Darth Maul and p2 General Kenobi
		PazaakPlayer p1 = (PazaakPlayer)game.getPlayers().get(0);
		PazaakPlayer p2 = (PazaakPlayer)game.getPlayers().get(1);

		// Prompt for custom player ID
		//////////////////////////////////////////////////

		// Assign their side hands
		game.assignSideDeck(p1);
		game.assignSideDeck(p2);

		// ca.sheridancollege.project.Display p2's side hand
		System.out.println("Displaying " + p2.getPlayerID() + "'s hand");
		for (int i = 0; i < p2.getHand().showCards().size(); i++) {
			Card card = p2.getHand().showCards().get(i);
			System.out.println(card);
		}

		// Settle on a wager
		////////////////////////////////////////////

		// Start the round
		////////////////////////////////////////////

		// Deal a table card to either player, can loop over players array instead
		System.out.println("Dealing card to " + p1.getPlayerID());
		game.dealCard(p1);
		System.out.print(p1.getPlayerID() + "'s current total is: ");
		System.out.println(p1.getCardTotal());
		System.out.println();
		System.out.println("Dealing card to " + p2.getPlayerID());
		game.dealCard(p2);
		System.out.print(p2.getPlayerID() + "'s current total is: ");
		System.out.println(p2.getCardTotal());
		System.out.println();
		System.out.println("Displaying cards on " + p1.getPlayerID() + "'s table");
		for (Card card : p1.getTableHand().showCards()) {
			System.out.println(card);
		}

		// Current player's turn, start turn method?
		PazaakPlayer p = (PazaakPlayer)game.getCurrentPlayer();
		while (!p.getTurnOver() && !p.getStanding()) {
			System.out.print("(1) Play card / (2) End turn / (3) Stand: ");
			int choice = input.nextInt();

			switch (choice) {
				case (1):
					System.out.print("Choose which side card to play (1/2/3/4): ");
					int sideIndex = input.nextInt();

					// Adjust card total by side card value
					int currentTotal = p.getCardTotal();
					SideCard card = (SideCard) p.getHand().showCards().get(sideIndex);
					currentTotal += card.getValue().value;

					// Remove side card from hand
					p.getHand().showCards().remove(sideIndex);
					break;
				case (2):
					p.endTurn();
					break;
				case (3):
					p.stand();
					break;
			}
		}

	}

}