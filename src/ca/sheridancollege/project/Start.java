package ca.sheridancollege.project;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Create game with Spider-Manual
		PazaakGame game = new PazaakGame();

		// Display the first four cards of the table deck
		for (int i = 0; i < 4; i++) {
			Card card = game.getDeck().showCards().get(i);
			System.out.println(card);
		}

		// Create p1 Darth Maul and p2 General Kenobi
		PazaakPlayer p1 = (PazaakPlayer)game.getPlayers().get(0);
		p1.play(game);
		PazaakPlayer p2 = (PazaakPlayer)game.getPlayers().get(1);
		p2.play(game);

		// Prompt for custom player ID
		//////////////////////////////////////////////////

		// Settle on a wager
		////////////////////////////////////////////

		// Start the match / rematch

		// Assign their side hands
		game.assignSideDeck(p1);
		game.assignSideDeck(p2);

		// Start the round
		while (p1.getWins() < 3 && p2.getWins() < 3) {
			// while there is no round winner, do this:
			while (!game.isRoundWon()) {
				for (int i = 0; i < game.getPlayers().size(); i++) {
					// Deal a table card to the player if they aren't standing
					game.dealCard();

					// Start current player's turn (set by constructor initially)
					game.startTurn();

					// Has anyone won?
					game.roundWinner();

					// Change current player
					game.changeTurn();
				}
			}
		}

		game.declareWinner();

		PazaakPlayer winner = null;
		if (p1.getWins() == 3) {
			winner = p1;
		} else {
			winner = p2;
		}
		game.rematch(winner);
	}
}