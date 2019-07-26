package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your wager");
        try {
            wager = sc.nextInt();
            if (wager < 0) {
                throw new InputMismatchException("Only postive numbers");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a postive non-zero integer");
            sc.next();
        }
        this.wager = wager;
    }

    public String getManual() {
        this.manual = "Pazaak is similar to blackjack, in that players draw and play number-valued cards in an\n"
                + "attempt to get as close to a total of 20 as possible without going over (TrekkieJedi, n.d.). Both\n"
                + "players agree on a wager and then start playing sets. The first player to win 3 sets wins the\n"
                + "match. A player wins a set by filling the table with 9 number cards without busting (going over\n"
                + "20), by standing with a score closer to 20 than the other player, or if the other player busts. Each\n"
                + "player also has a custom-constructed side deck of ten cards from which they randomly draw four\n"
                + "cards at the beginning of the game for use during play. Side cards can be used to affect play in\n"
                + "unique ways. Some cards add or subtract from the player’s total, or swap the value of certain\n"
                + "number cards in play, etc.";
        return this.manual;
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
