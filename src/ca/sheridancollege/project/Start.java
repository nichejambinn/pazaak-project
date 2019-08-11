package ca.sheridancollege.project;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// Create game with Spider-Manual
		PazaakGame game = new PazaakGame();

		// Create p1 Darth Maul and p2 General Kenobi
		PazaakPlayer p1 = (PazaakPlayer) game.getPlayers().get(0);
		PazaakPlayer p2 = (PazaakPlayer) game.getPlayers().get(1);

		// Prompt for custom player ID
		/*System.out.print("Player 1, enter your name: ");
		p1.setPlayerID(input.next());
		System.out.print("\nPlayer 2, enter your name: ");
		p2.setPlayerID(input.next());*/

		p1.play(game);
		p2.play(game);

		boolean playing = true;

		// Start the match / rematch
		System.out.println("\nStarting a new match\n");
		while (playing) {
			// Settle on a wager
			game.takeWager();

			// Assign their side hands
			game.assignSideDeck(p1);
			game.assignSideDeck(p2);

			// Start the round
			while (p1.getWins() < 3 && p2.getWins() < 3) {

				game.play();
				// while there is no round winner, do this:
				while (!game.isRoundWon()) {
					// Deal a table card to the player if they aren't standing
					game.dealCard();

					// Start current player's turn (set by constructor initially)
					game.startTurn();

					// Change current player
					game.changeTurn();

					// Has anyone won?
					game.roundWinner();
				}
				game.setRoundWon(false);
			}

			game.declareWinner();

			// declareWinner from Game class returns void, so find a winner
			PazaakPlayer winner = null;
			if (p1.getWins() == 3) {
				winner = p1;
			} else {
				winner = p2;
			}

			playing = game.rematch(winner);
		}
		System.out.println("\n\nThanks for playing " + p1.getPlayerID() + " and " + p2.getPlayerID() + "!");
	}
}