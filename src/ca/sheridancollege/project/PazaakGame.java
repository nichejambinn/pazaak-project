package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class PazaakGame extends Game {

    private PazaakPlayer currentPlayer;
    private int wager;
    private String manual;
    private GroupOfCards deck;
    private GroupOfCards sideCards;
    private boolean roundWon;
    String playFirst;
    private Scanner input = new Scanner(System.in);

    public PazaakPlayer getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     *
     * @param currentPlayer
     */
    public void setCurrentPlayer(PazaakPlayer currentPlayer) {
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
     * Default constructor
     */
    public PazaakGame() {
        super("Pazaak");

        // Build table deck, four of each value
        this.deck = new GroupOfCards();

        this.manual = "How do I shot Pazaak?";

        // Get side cards, one of each value
        this.sideCards = new GroupOfCards();

        for (SideValue val : SideValue.values()) {
            sideCards.showCards().add(new SideCard(val));
        }

        // Set players with default names
        this.getPlayers().add(new PazaakPlayer("Darth Maul"));
        this.getPlayers().add(new PazaakPlayer("General Kenobi"));

        // Set the first player to current player
        this.currentPlayer = (PazaakPlayer) this.getPlayers().get(0);

        this.roundWon = false;
    }

    @Override
    public void play() {
        System.out.println("Starting a new round");
        buildDeck();

        PazaakPlayer player1 = (PazaakPlayer)this.getPlayers().get(0);
        PazaakPlayer player2 = (PazaakPlayer)this.getPlayers().get(1);

        // Clearing table cards
        player1.getTableHand().showCards().clear();
        player2.getTableHand().showCards().clear();

        // Clearing scores
        player1.setCardTotal(0);
        player2.setCardTotal(0);

        player1.setStanding(false);
        player2.setStanding(false);
    }

    public void setRoundWon(boolean roundWon) {
        this.roundWon = roundWon;
    }

    /**
     * Declares the match winner between player1 and player2 based on who has 3
     * wins.
     *
     */
    @Override
    public void declareWinner() {
        PazaakPlayer winner;
        PazaakPlayer loser;

        PazaakPlayer player1 = (PazaakPlayer) this.getPlayers().get(0);
        PazaakPlayer player2 = (PazaakPlayer) this.getPlayers().get(1);

        if (player1.getWins() == 3) {
            winner = player1;
            loser = player2;
        } else {
            winner = player2;
            loser = player1;
        }

        System.out.println(winner.getPlayerID() + " wins the match!");
        winner.setCredits(winner.getCredits() + wager);
        loser.setCredits(loser.getCredits() - wager);
        System.out.println(wager + " credits have been removed from " + loser.getPlayerID()
                + "'s account and added to " + winner.getPlayerID() + "'s");
    }

    /**
     *
     * @param winner
     * @return true if the players decide and are able to play again, false otherwise
     */
    public boolean rematch(PazaakPlayer winner) {
        this.currentPlayer = winner;
        boolean playAgain = true;

        int pIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);

        if (nextPlayer.getCredits() == 0) {
            playAgain = false;
        } else {
            currentPlayer.setWins(0);
            nextPlayer.setWins(0);
        }

        System.out.print("Do you want to play first? (Y/N)");
        playFirst = input.next();
        if ("Y".equalsIgnoreCase(playFirst)) {
            this.currentPlayer = winner;
        } else if ("N".equalsIgnoreCase(playFirst)) {
            this.currentPlayer = nextPlayer;
        }

        return playAgain;
    }

    /**
     *
     */
    public void dealCard() {
        // If a player isn't standing, deal them a card
        if (!this.currentPlayer.isStanding()) {
            // Get player's table hand
            GroupOfCards tableHand = this.currentPlayer.getTableHand();

            if (tableHand.showCards().size() < 9) {
                // Get the top card of the game's table deck
                TableCard tableCard = (TableCard) deck.showCards().get(0);

                // Add the card to the player's hand
                tableHand.showCards().add(tableCard);

                // Increase the player's total by its value
                this.currentPlayer.setCardTotal(this.currentPlayer.getCardTotal() + tableCard.getValue().value);

                // Remove the card from the game's table deck
                deck.showCards().remove(0);
            }
        }
    }

    public void roundWinner() {
        PazaakPlayer winner = null;
        int pIndex = (this.currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);
        // check all conditions for round winner only once
        boolean alreadyWon = false;

        //if current player has forfeited then nextPLayer wins
        if (this.currentPlayer.getCardTotal() <= -1) {
            winner = nextPlayer;
            alreadyWon = true;
        }
        // if nextPlayer forfeits current player wins
        if (nextPlayer.getCardTotal() <= -1 && !alreadyWon) {
            winner = this.currentPlayer;
            alreadyWon = true;
        }
        // if currentPlayer has 9 deck cards then current player wins
        if (this.currentPlayer.getTableHand().showCards().size() >= 9 && !alreadyWon) {
            winner = this.currentPlayer;
            alreadyWon = true;
        }
        // if next Player has 9 deck cards then next player wins
        if (nextPlayer.getTableHand().showCards().size() >= 9 && !alreadyWon) {
            winner = nextPlayer;
            alreadyWon = true;
        }
        // if current player's card total is over 20 then next player wins
        if (currentPlayer.getCardTotal() > 20 && nextPlayer.getCardTotal() < 20 && !alreadyWon) {
            alreadyWon = true;
            winner = nextPlayer;
        }
        // if next player's card total is over 20 then current player wins
        if (nextPlayer.getCardTotal() > 20 && currentPlayer.getCardTotal() < 20 && !alreadyWon) {
            alreadyWon = true;
            winner = currentPlayer;
        }

        if (this.currentPlayer.isStanding() && nextPlayer.isStanding()) {
            // if current player has the same card total as next player the game is a draw
            if (this.currentPlayer.getCardTotal() == nextPlayer.getCardTotal() && !alreadyWon) {
                alreadyWon = true;
            }
            // if both players' card total is over 20 then the game is a draw
            if (currentPlayer.getCardTotal() > 20 && nextPlayer.getCardTotal() > 20 && !alreadyWon) {
                alreadyWon = true;
            }
            //if current player is over 20 then nextPLayer wins
            if (this.currentPlayer.getCardTotal() == -1 && !alreadyWon) {
                winner = nextPlayer;
                alreadyWon = true;
            }
            // if nextPlayer is over 20 then current player wins
            if (nextPlayer.getCardTotal() == -1 && !alreadyWon) {
                winner = this.currentPlayer;
                alreadyWon = true;
            }
            // if current player has 20 or is closer to 20 than the next player
            if (this.currentPlayer.getCardTotal() == 20 || currentPlayer.getCardTotal() > nextPlayer.getCardTotal() && !alreadyWon) {
                winner = this.currentPlayer;
                alreadyWon = true;
            }
            // if next player has 20 or is closer to 20 than the current player
            if (nextPlayer.getCardTotal() == 20 || nextPlayer.getCardTotal() > currentPlayer.getCardTotal() && !alreadyWon) {
                winner = this.currentPlayer;
                alreadyWon = true;
            }
        }

        if (alreadyWon) {
            // set roundWon accordingly
            this.roundWon = true;
            // increment the winner's wins
            winner.setWins(winner.getWins() + 1);
            this.currentPlayer = winner;
        }
    }

    public void buildDeck() {

        for (TableValue val : TableValue.values()) {
            for (int i = 0; i < 4; i++) {
                deck.showCards().add(new TableCard(val));
            }
        }

        deck.shuffle();
    }

    public boolean isRoundWon() {
        return this.roundWon;
    }

    /**
     *
     * @param player
     */
    public void assignSideDeck(PazaakPlayer player) {
        GroupOfCards sideHand = player.getHand();
        sideHand.showCards().clear();

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
        System.out.println("changeTurn called");
        PazaakPlayer currentPlayer = this.currentPlayer;

        // Find next player
        int pIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);
        System.out.println("Next player is " + nextPlayer.getPlayerID());

        if (!nextPlayer.isStanding()) {
            // If next player is not standing, switch to current player
            this.currentPlayer = nextPlayer;
        }
    }

    public void startTurn() {
        PazaakPlayer p = this.getCurrentPlayer();
        p.setTurnOver(false);
        boolean cardPlayed = false;
        while (!p.isTurnOver() && !p.isStanding()) {
            this.showBoard();
            System.out.println(p.getPlayerID() + "'s turn");
            System.out.print("Play card (1)/ End turn (2)/ Stand (3)/ Forfeit (4): ");
            int choice = input.nextInt();

            switch (choice) {
                case (1):
                    if (!cardPlayed) {
                        System.out.print("Choose which side card to play (1/2/3/4): ");
                        int sideIndex = input.nextInt() - 1;
                        p.playCard((SideCard) p.getHand().showCards().get(sideIndex));
                        cardPlayed = true;
                        break;
                    } else {
                        System.out.println("You have already played a side card this round");
                    }
                    break;
                case (2):
                    p.endTurn();
                    break;
                case (3):
                    if (p.getCardTotal() <= 20) {
                        p.stand();
                    } else {
                        System.out.println("You cannot stand with a total greater than 20");
                    }
                    break;
                case (4):
                    p.forfeit();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    /**
     *
     */
    public void checkTotal() {
    }

    /**
     * Displays the game board
     */
    public void showBoard() {
        PazaakPlayer p1 = (PazaakPlayer) this.getPlayers().get(0);
        PazaakPlayer p2 = (PazaakPlayer) this.getPlayers().get(1);
        PazaakPlayer[] pArr = {p1, p2};

        for (int i = 0; i < pArr.length; i++) {
            System.out.println(pArr[i].getPlayerID() + ", Wins: " + pArr[i].getWins() + ", Total: " + pArr[i].getCardTotal());
            System.out.print("Side Cards: ");
            for (int j = 0; j < pArr[i].getHand().showCards().size(); j++) {
                SideCard sCard = (SideCard) pArr[i].getHand().showCards().get(j);
                String plus = (sCard.getValue().value > 0) ? "+" : "";
                System.out.print(plus + sCard.getValue().value + " ");
            }
            System.out.print("  Table: ");
            for (int j = 0; j < pArr[i].getTableHand().showCards().size(); j++) {
                TableCard tCard = (TableCard) pArr[i].getTableHand().showCards().get(j);
                System.out.print(tCard.getValue().value + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

}
