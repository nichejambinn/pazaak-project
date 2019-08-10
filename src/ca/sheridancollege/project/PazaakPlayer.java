package ca.sheridancollege.project;

public class PazaakPlayer extends Player {

	private int credits;
	private GroupOfCards hand;
	private int wins;
	private int cardTotal;
	private GroupOfCards tableHand;
	private boolean standing;
	private boolean turnOver;
    private PazaakGame game;

    /**
     * The player is considered playing a game when they store a reference
     * to a game object. The play method does this.
     *
     * @param game the pazaak game object
     */
	public void play(PazaakGame game) {
            this.game = game;
            System.out.println(this.playerID + " has joined the game");
	}

    /**
     * get the credits this player has
     *
     * @return
     */
	public int getCredits() {
		return this.credits;
	}

	/**
	 *Set this Player's credits to the given value
     *
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
        System.out.println(this.playerID + " has " + this.credits + " credits");
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

    /**
     * This method puts the player in a standing state by changing the
     * setStanding boolean variable to true
     */
	public void stand() {
		setStanding(true);
        System.out.println(this.playerID + " has chosen to stand");
	}

    /**
     * Set standing boolean variable to the given boolean value
     * @param standing
     */
	public void setStanding(boolean standing) {
		this.standing = standing;
	}

    /**
     * Return true iff this player is standing
     * @return
     */
	public boolean isStanding() {
		return this.standing;
	}

    /**
     * set the state of this player to be so that their turn has ended by
     * changing the turnOver boolean variable to true
     */
	public void endTurn() {
		setTurnOver(true);
        System.out.println(this.playerID + " has chosen to end their turn");
	}

    /**
     * set the variable turnOver to the given value for this player
     *
     * @param turnOver
     */
	public void setTurnOver(boolean turnOver) {
		this.turnOver = turnOver;
	}

    /**
     * Return value of the turnOver property for this player
     *
     * @return
     */
	public boolean isTurnOver() {
		return this.turnOver;
	}

    /**
     * This method forces this player to lose by setting their card total
     * to a negative number and then standing
     */
	public void forfeit() {
            this.cardTotal = -1;
            this.turnOver = true;
            System.out.println(this.playerID + " has chosen to forfeit");
	}

	/**
	 *Play the given side card iff the card is in the hand
     *
	 * @param card
	 */
	public void playCard(SideCard card) {
	    if (this.hand.showCards().indexOf(card) != -1) {
            int currentTotal = this.cardTotal + card.getValue().value;
            if (currentTotal < 0) currentTotal = 0;
            this.cardTotal = currentTotal;
            this.hand.showCards().remove(card);
            System.out.println(this.playerID + " has played the " + card.getValue().name() + " card");
        }
	}

    /**
     * Return this player's hand
     *
     * @return
     */
	public GroupOfCards getHand() {
		return this.hand;
	}

	/**
	 * Set the hand of this player to the given groupOfCards object
     *
	 * @param hand
	 */
	public void setHand(GroupOfCards hand) {
		this.hand = hand;
	}

    /**
     * Return the number of wins for this player
     *
     * @return
     */
	public int getWins() {
		return this.wins;
	}

	/**
	 * Set the number of wins for this player to the given value
     *
	 * @param wins
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

    /**
     * Return the card total for this player
     * @return
     */
	public int getCardTotal() {
		return this.cardTotal;
	}

	/**
	 * Set the card total for this player to the given value
     *
	 * @param cardTotal
	 */
	public void setCardTotal(int cardTotal) {
		this.cardTotal = cardTotal;
	}

    /**
     * Return the table cards this player has
     *
     * @return tableHand
     */
	public GroupOfCards getTableHand() {
		return this.tableHand;
	}

	/**
	 * Set the table card this player has to the given value
     *
	 * @param tableHand
	 */
	public void setTableHand(GroupOfCards tableHand) {
		this.tableHand = tableHand;
	}
        
    /**
     * This method add the given card to this player's table cards
     *
     * @param card
     */
    public void addTableCard(TableCard card) {
        this.tableHand.showCards().add(card);
        this.cardTotal += card.getValue().value;
        System.out.println(this.playerID + " has been dealt a plus " + card.getValue().name() + " card");
    }
}