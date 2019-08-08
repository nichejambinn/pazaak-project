package ca.sheridancollege.project;

public class PazaakPlayer extends Player {

	private int credits;
	private GroupOfCards hand;
	private int wins;
	private int cardTotal;
	private GroupOfCards tableHand;
	private boolean standing;
	private boolean turnOver;

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

		// Create side hand
		this.hand = new GroupOfCards();

		this.standing = false;
		this.turnOver = false;
	}

	public void stand() {
		setStanding(true);
	}

	public void setStanding(boolean standing) {
		this.standing = standing;
	}

	public boolean isStanding() {
		return this.standing;
	}

	public void endTurn() {
		setTurnOver(true);
	}

	public void setTurnOver(boolean turnOver) {
		this.turnOver = turnOver;
	}

	public boolean isTurnOver() {
		return this.turnOver;
	}

	public void forfeit() {
		// TODO - implement PazaakPlayer.forfeit
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param card
	 */
	public void playCard(SideCard card) {
        int currentTotal = this.getCardTotal() + card.getValue().value;
        if (currentTotal < 0) currentTotal = 0;
        this.setCardTotal(currentTotal);
        this.getHand().showCards().remove(card);
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