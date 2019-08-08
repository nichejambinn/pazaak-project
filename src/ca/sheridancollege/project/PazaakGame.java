package ca.sheridancollege.project;

public class PazaakGame extends Game {

	private Player currentPlayer;
	private int wager;
	private String manual;
	private GroupOfCards deck;
	private GroupOfCards sideCards;

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	/**
	 *
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public int getWager() {
		return this.wager;
	}

	/**
	 *
	 * @param wager
	 */
	public void setWager(int wager) {
		this.wager = wager;
	}

	public String getManual() {
		return this.manual;
	}

	/**
	 *
	 * @param manual
	 */
	public void setManual(String manual) {
		this.manual = manual;
	}

	public GroupOfCards getDeck() {
		return this.deck;
	}

	/**
	 *
	 * @param deck
	 */
	public void setDeck(GroupOfCards deck) {
		this.deck = deck;
	}

	/**
	 *
	 * @param manual
	 */
	public PazaakGame(String manual) {
		super("Pazaak");

		// Build table deck, four of each value
		this.deck = new GroupOfCards();

		for (TableValue val : TableValue.values()) {
			for (int i = 0; i < 4; i++) {
				deck.showCards().add(new TableCard(val));
			}
		}
		deck.shuffle();

		// Get side cards, one of each value
		this.sideCards = new GroupOfCards();

		for (SideValue val : SideValue.values()) {
			sideCards.showCards().add(new SideCard(val));
		}

		// Set players with default names
		this.getPlayers().add(new PazaakPlayer("Darth Maul"));
		this.getPlayers().add(new PazaakPlayer("General Kenobi"));

		// Set the first player to current player
		this.currentPlayer = this.getPlayers().get(0);
	}

	public void play() {
		// TODO - implement PazaakGame.play
		throw new UnsupportedOperationException();
	}

	public void declareWinner() {
		// TODO - implement PazaakGame.declareWinner
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param rematch
	 */
	public void rematch(boolean rematch) {
		// TODO - implement PazaakGame.rematch
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param player
	 */
	public void dealCard(PazaakPlayer player) {
		// Get player's table hand
		GroupOfCards tableHand = player.getTableHand();

		if (tableHand.showCards().size() < 9) {
			// Get the top card of the game's table deck
			TableCard tableCard = (TableCard)deck.showCards().get(0);

			// Add the card to the player's hand
			tableHand.showCards().add(tableCard);

			// Increase the player's total by its value
            player.setCardTotal(player.getCardTotal()+tableCard.getValue().value);

			// Remove the card from the game's table deck
			deck.showCards().remove(0);
		}
	}

	public void roundWinner() {
		// TODO - implement PazaakGame.roundWinner
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param player
	 */
	public void assignSideDeck(PazaakPlayer player) {
		GroupOfCards sideHand = player.getHand();

		// Assign random side cards, making better cards more rare
		for (int i = 0; i < 4; i++) {
			double p = Math.random();
			Card card;
			if (0 <= p && p < 0.3) {
				card = sideCards.showCards().get(0);
			} else if (0.3 <= p && p < 0.6) {
				card = sideCards.showCards().get(1);
			} else if (0.6 <= p && p < 0.7) {
				card = sideCards.showCards().get(2);
			} else if (0.7 <= p && p < 0.8) {
				card = sideCards.showCards().get(3);
			} else if (0.8 <= p && p < 0.85) {
				card = sideCards.showCards().get(4);
			} else if (0.85 <= p && p < 0.9) {
				card = sideCards.showCards().get(5);
			} else if (0.9 <= p && p < 0.95) {
				card = sideCards.showCards().get(6);
			} else {
				card = sideCards.showCards().get(7);
			}

			sideHand.showCards().add(card);
		}
	}

	public GroupOfCards getSideCards() {
		return this.sideCards;
	}

	/**
	 *
	 * @param sideCards
	 */
	public void setSideCards(GroupOfCards sideCards) {
		this.sideCards = sideCards;
	}

	/**
	 *
	 * @param wager
	 */
	public void takeWager(int wager) {
		// TODO - implement PazaakGame.takeWager
		throw new UnsupportedOperationException();
	}

	public void changeTurn() {
		// TODO - implement PazaakGame.changeTurn
		throw new UnsupportedOperationException();
	}

	public void startTurn() {
		// TODO - implement PazaakGame.startTurn
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param player
	 */
	public void checkTotal(PazaakPlayer player) {
		player.getCardTotal();
	}

}