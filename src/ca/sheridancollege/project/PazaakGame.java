package ca.sheridancollege.project;

import javax.swing.*;
import java.util.ArrayList;

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
		this.deck = new GroupOfCards();

		for (TableValue val : TableValue.values()) {
			for (int i = 0; i < 4; i++) {
				deck.showCards().add(new TableCard(val));
			}
		}
//		deck.shuffle();
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
			Card tableCard = deck.showCards().get(0);

			// Add the card to the player's hand
			tableHand.showCards().add(tableCard);


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
	public void assignSideDeck(Player player) {
		// TODO - implement PazaakGame.assignSideDeck
		throw new UnsupportedOperationException();
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
	public void checkTotal(Player player) {
		// TODO - implement PazaakGame.checkTotal
		throw new UnsupportedOperationException();
	}

}