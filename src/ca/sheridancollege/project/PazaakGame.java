package ca.sheridancollege.project;

import java.util.ArrayList;

public class PazaakGame extends Game {

	private Player currentPlayer;
	private int wager;
	private String manual;
	private GroupOfCards deck;
	private GroupOfCards sideCards;
	private static final PazaakGame game = new PazaakGame();

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
	 * @param gameName
	 * @param players
	 * @param manual
	 * @param deck
	 */
	private PazaakGame(int gameName, ArrayList<Player> players, String manual, GroupOfCards deck) {
		super("Pazaak");
		throw new UnsupportedOperationException();
	}
        
        private PazaakGame() {
		super("Pazaak");
		throw new UnsupportedOperationException();
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
	public void dealCard(Player player) {
		// TODO - implement PazaakGame.dealCard
		throw new UnsupportedOperationException();
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

	public PazaakGame getGame() {
		return this.game;
	}

}