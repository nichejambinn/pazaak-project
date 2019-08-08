package ca.sheridancollege.project;

public class PazaakPlayer extends Player {

	private int credits;
	private GroupOfCards hand;
	private int wins;
	private int cardTotal;
	private GroupOfCards tableHand;

	public void play() {
		// TODO - implement PazaakPlayer.play
		throw new UnsupportedOperationException();
	}

	public int getCredits() {
		return this.credits;
	}

	/**
	 *
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 *
	 * @param name
	 */
	public PazaakPlayer(String name) {
		super(name);
		this.credits = 1000;
		this.wins = 0;
		this.cardTotal = 0;

		// Create table hand
		this.tableHand = new GroupOfCards();
	}

	public String getPlayerID() {
		// TODO - implement PazaakPlayer.getPlayerID
		throw new UnsupportedOperationException();
	}

	public void stand() {
		// TODO - implement PazaakPlayer.stand
		throw new UnsupportedOperationException();
	}

	public void endTurn() {
		// TODO - implement PazaakPlayer.endTurn
		throw new UnsupportedOperationException();
	}

	public void forfeit() {
		// TODO - implement PazaakPlayer.forfeit
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param card
	 */
	public void playCard(Card card) {
		// TODO - implement PazaakPlayer.playCard
		throw new UnsupportedOperationException();
	}

	public GroupOfCards getHand() {
		return this.hand;
	}

	/**
	 *
	 * @param hand
	 */
	public void setHand(GroupOfCards hand) {
		this.hand = hand;
	}

	public int getWins() {
		return this.wins;
	}

	/**
	 *
	 * @param wins
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getCardTotal() {
		return this.cardTotal;
	}

	/**
	 *
	 * @param cardTotal
	 */
	public void setCardTotal(int cardTotal) {
		this.cardTotal = cardTotal;
	}

	public GroupOfCards getTableHand() {
		return this.tableHand;
	}

	/**
	 *
	 * @param tableHand
	 */
	public void setTableHand(GroupOfCards tableHand) {
		this.tableHand = tableHand;
	}

}