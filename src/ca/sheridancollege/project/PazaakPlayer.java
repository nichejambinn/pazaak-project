package ca.sheridancollege.project;

public class PazaakPlayer extends Player {

	private int credits;
	private GroupOfCards hand;
	private int wins = 0;
	private int cardTotal = 0;
	private GroupOfCards tableHand;
        private boolean canPlay = true;
        private PazaakGame game = null;


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
	 * @param credits
	 */
	public PazaakPlayer(String name, int credits) {
            super(name);
            this.credits = credits;
            hand = new GroupOfCards(4);
            tableHand = new GroupOfCards(9);
	}

        @Override
        public String getPlayerID() {
            return super.getPlayerID();
	}

	public void stand() {
            canPlay = false;
            game.changeTurn();
	}
        
        public boolean getCanPlay() {
            return canPlay;
        }

	public void endTurn() {
            game.changeTurn();
	}

	public void forfeit() {
            wins = -1;
            game.declareWinner(); /////////////// in declareWinner(), assume that a negative number of wins means a forfeit
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

	public void getAttribute() {
		// TODO - implement PazaakPlayer.getAttribute
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param attribute
	 */
	public void setAttribute(int attribute) {
		// TODO - implement PazaakPlayer.setAttribute
		throw new UnsupportedOperationException();
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

    @Override
    public void play(PazaakGame game) {
        this.game = game;
    }


}