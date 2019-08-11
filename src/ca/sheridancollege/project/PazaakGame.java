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
        System.out.println("\nWelcome to " + this.getGameName() + "!\n");

        // Build table deck, four of each value
        this.deck = new GroupOfCards();

        this.manual = "\nPazaak is a game, similar to blackjack, where the goal of each round is to get a score" +
                "\nof as close to 20 as possible without going over.\n\nPlayers take turns being dealt" +
                "a single card with a number value (1-10) onto their table.\nDuring their turn," +
                " a player may choose to play one of four side cards they were dealt\nat the beginning" +
                "of the round, stand with their current total and wait for their\nopponent to finish" +
                " playing that round, or end their turn and receive another table\ncard at the start of" +
                " their subsequent turn.\n\nThe player with a score closer to 20 than their opponent" +
                " without going over wins" +
                " that round.\n\nThe first player to win 3 rounds takes the match and gets the amount" +
                " of the agreed upon\nwager added to their credit account.\n" ;

        this.wager = 0;

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
        System.out.println("\nStarting a new round\n");
        buildDeck();

        PazaakPlayer player1 = (PazaakPlayer) this.getPlayers().get(0);
        PazaakPlayer player2 = (PazaakPlayer) this.getPlayers().get(1);

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
     * @return true if the players decide and are able to play again, false
     * otherwise
     */
    public boolean rematch(PazaakPlayer winner) {
        int winnerRematch = 0;
        int loserRematch = 0;

        boolean playAgain = false;

        int pIndex = (winner == (PazaakPlayer)this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer loser = (PazaakPlayer) this.getPlayers().get(pIndex);

        while (loserRematch == 0 && loser.getCredits() > 0) {
            System.out.print(loser.getPlayerID() + ", would you care for a rematch (Y/N)? ");
            String choice = input.next();
            if (choice.equalsIgnoreCase("Y")) {
                loserRematch = 1;
            } else if (!choice.equalsIgnoreCase("N")) {
                System.out.println("Invalid input");
            } else {
                loserRematch = -1;
            }
        }

        if (loserRematch == 1) {
            while (winnerRematch == 0 && winner.getCredits() > 0) {
                System.out.print(winner.getPlayerID() + ", would you care for a rematch (Y/N)? ");
                String choice = input.next();
                if (choice.equalsIgnoreCase("Y")) {
                    winnerRematch = 1;
                } else if (!choice.equalsIgnoreCase("N")) {
                    System.out.println("Invalid input");
                } else {
                    winnerRematch = -1;
                }
            }
        }

        if (winnerRematch + loserRematch == 2) {
            playAgain = true;
            winner.setWins(0);
            loser.setWins(0);

            int deciding = 0;

            while (deciding == 0) {
                System.out.print(winner.getPlayerID() + ", will you play first? (Y/N) ");
                String playFirst = input.next();
                if (playFirst.equalsIgnoreCase("Y")) {
                    this.currentPlayer = winner;
                    deciding = 1;
                } else if (!playFirst.equalsIgnoreCase("N")) {
                    System.out.println("Invalid input");
                } else {
                    this.currentPlayer = loser;
                    deciding = -1;
                }
            }
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
            System.out.println(this.currentPlayer.getPlayerID() + " has forfeited");
            winner = nextPlayer;
            alreadyWon = true;
        }
        // if nextPlayer forfeits current player wins
        if (nextPlayer.getCardTotal() <= -1 && !alreadyWon) {
            System.out.println(nextPlayer.getPlayerID() + " has forfeited");
            winner = this.currentPlayer;
            alreadyWon = true;
        }
        // if currentPlayer has 9 deck cards then current player wins
        if (this.currentPlayer.getTableHand().showCards().size() >= 9 && !alreadyWon) {
            System.out.println(this.currentPlayer.getPlayerID() + " filled the table");
            winner = this.currentPlayer;
            alreadyWon = true;
        }
        // if next Player has 9 deck cards then next player wins
        if (nextPlayer.getTableHand().showCards().size() >= 9 && !alreadyWon) {
            System.out.println(nextPlayer.getPlayerID() + " filled the table");
            winner = nextPlayer;
            alreadyWon = true;
        }
        // if current player's card total is over 20 then next player wins
        if (currentPlayer.getCardTotal() > 20 && nextPlayer.getCardTotal() <= 20 && !alreadyWon) {
            System.out.println(this.currentPlayer.getPlayerID() + " went over 20");
            alreadyWon = true;
            winner = nextPlayer;
        }
        // if next player's card total is over 20 then current player wins
        if (nextPlayer.getCardTotal() > 20 && currentPlayer.getCardTotal() <= 20 && !alreadyWon) {
            System.out.println(nextPlayer.getPlayerID() + " went over 20");
            alreadyWon = true;
            winner = currentPlayer;
        }

        if (this.currentPlayer.isStanding() && nextPlayer.isStanding()) {
            // if current player has the same card total as next player the game is a draw
            if (this.currentPlayer.getCardTotal() == nextPlayer.getCardTotal() && !alreadyWon) {
                System.out.println("Both players have the same card total");
                alreadyWon = true;
            }
            // if both players' card total is over 20 then the game is a draw
            if (currentPlayer.getCardTotal() > 20 && nextPlayer.getCardTotal() > 20 && !alreadyWon) {
                System.out.println("Both players went over 20");
                alreadyWon = true;
            }

            // if current player has 20 or is closer to 20 than the next player
//            if (this.currentPlayer.getCardTotal() == 20 || this.currentPlayer.getCardTotal() > nextPlayer.getCardTotal() && !alreadyWon) {
            if (this.currentPlayer.getCardTotal() > nextPlayer.getCardTotal() && !alreadyWon) {
                System.out.println(this.currentPlayer.getPlayerID() + " stood with the higher total");
                winner = this.currentPlayer;
                alreadyWon = true;
            }
            // if next player has 20 or is closer to 20 than the current player
//            if (nextPlayer.getCardTotal() == 20 || nextPlayer.getCardTotal() > currentPlayer.getCardTotal() && !alreadyWon) {
            if (nextPlayer.getCardTotal() > this.currentPlayer.getCardTotal() && !alreadyWon) {
                System.out.println(nextPlayer.getPlayerID() + " stood with the higher total");
                winner = nextPlayer;
                alreadyWon = true;
            }
        }

        if (alreadyWon) {
            // set roundWon accordingly
            this.roundWon = true;
            if (winner != null) {
                // increment the winner's wins
                winner.setWins(winner.getWins() + 1);
                System.out.println("\n" + winner.getPlayerID() + " won the round\n");
                this.currentPlayer = winner;
            } else {
                System.out.println("\nRound is a draw\n");
            }
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
     */
    public void takeWager() {
        int p1wager = 0;
        int p2wager = 0;
        String answer;
        char c;
        boolean takeWagerOnce = true;
        boolean takeWager = true;
        boolean checkBalance = true;

        // Used to get both players credits
        int pIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);
        
        System.out.println("\n" + this.currentPlayer.getPlayerID() + " credit: " + this.currentPlayer.getCredits());
        System.out.println(nextPlayer.getPlayerID() + " credit: " + nextPlayer.getCredits());
        System.out.println();

        // do while loop for asking wager
        do {

            // Loops only once
            while (takeWagerOnce) {
                System.out.print(this.currentPlayer.getPlayerID() + " enter wager amount: ");
                p1wager = input.nextInt();
                System.out.print("Do you accept " + this.currentPlayer.getPlayerID() + " wager " + p1wager + "? (Y/N): ");
                answer = input.next();
                c = answer.charAt(0);
                if ("Y".equals(answer)) {
                    p2wager = p1wager;
                    takeWagerOnce = false;
                    if (this.currentPlayer.getCredits() >= p2wager && nextPlayer.getCredits() >= p2wager) {
                        takeWager = false;
                        checkBalance = false;
                    } else {
                        System.out.println("Wager should be less than the credit");
                    }
                } else if ("N".equals(answer)) {
                    p1wager = 0;
                    System.out.print(nextPlayer.getPlayerID() + " enter wager amount: ");
                    p2wager = input.nextInt();
                    takeWagerOnce = false;
                }
            }

            // If player2 did not agree for player1 wager
            if (p1wager != p2wager) {
                System.out.print("Do you accept " + nextPlayer.getPlayerID() + " wager " + p2wager + "? (Y/N): ");
                answer = input.next();
                if ("Y".equals(answer)) {
                    p1wager = p2wager;
                    if (this.currentPlayer.getCredits() >= p2wager && nextPlayer.getCredits() >= p2wager) {
                        takeWager = false;
                        checkBalance = false;
                    } else {
                        System.out.println("Wager should be less than the credit");
                    }
                } else if ("N".equals(answer)) {
                    p2wager = 0;
                    System.out.print(this.currentPlayer.getPlayerID() + " enter wager amount: ");
                    p1wager = input.nextInt();
                }
            }
            if (p1wager != p2wager) {
                System.out.print("Do you accept " + this.currentPlayer.getPlayerID() + " wager " + p1wager + "? (Y/N): ");
                answer = input.next();
                c = answer.charAt(0);
                if ("Y".equals(c)) {
                    p2wager = p1wager;
                    if (this.currentPlayer.getCredits() >= p2wager && nextPlayer.getCredits() >= p2wager) {
                        takeWager = false;
                        checkBalance = false;
                    } else {
                        System.out.println("Wager should be less than the credit");
                    }
                } else {
                    p1wager = 0;
                    System.out.print(nextPlayer.getPlayerID() + " enter wager amount: ");
                    p2wager = input.nextInt();
                }
            }
        } while (takeWager && checkBalance);
        this.wager = p1wager;
    }

    public void changeTurn() {
        PazaakPlayer currentPlayer = this.currentPlayer;

        // Find next player
        int pIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);
        System.out.println("\nNext player is " + nextPlayer.getPlayerID());

        if (!nextPlayer.isStanding()) {
            // If next player is not standing, switch to current player
            this.currentPlayer = nextPlayer;
        }
    }

    public void startTurn() {
        PazaakPlayer p = this.currentPlayer;
        p.setTurnOver(false);
        boolean cardPlayed = false;
        while (!p.isTurnOver() && !p.isStanding()) {
            System.out.println();
            this.showBoard();
            System.out.println(p.getPlayerID() + "'s turn");
            System.out.print("Play card (1)/ End turn (2)/ Stand (3)/ Forfeit (4): ");
            int choice = input.nextInt();
//            System.out.println();

            switch (choice) {
                case (1):
                    if (!cardPlayed) {
                        System.out.print("Choose which side card to play (1/2/3/4): ");
                        int sideIndex = input.nextInt() - 1;
                        System.out.println();
                        if (sideIndex < p.getHand().showCards().size()) {
                            p.playCard((SideCard) p.getHand().showCards().get(sideIndex));
                            cardPlayed = true;
                        } else {
                            System.out.println("Please select a card in your hand");
                        }
                        System.out.println();
                        break;
                    } else {
                        System.out.println("You have already played a side card this round");
                        System.out.println();
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
