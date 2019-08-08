package ca.sheridancollege.project;

public class Start {

	public static void main(String[] args) {
		PazaakGame game = new PazaakGame("How do I shot Pazaak?");
		// Display the first four cards of the table deck
		for (int i = 0; i < 4; i++) {
			Card card = game.getDeck().showCards().get(i);
			System.out.println(card);
		}

		System.out.println();
		PazaakPlayer player1 = new PazaakPlayer("Darth Maul");
		game.getPlayers().add(player1);

		// Shuffle the deck and deal a card
		game.getDeck().shuffle();
		game.dealCard(player1);

		GroupOfCards p1Table = player1.getTableHand();
		for (Card card : p1Table.showCards()) {
			System.out.println(card);
		}
	}

}