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
     *
     * @param manual
     */
    public PazaakGame(String manual) {
        super("Pazaak");

        // Build table deck, four of each value
        this.deck = new GroupOfCards();

        buildDeck();
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
        this.currentPlayer = (PazaakPlayer) this.getPlayers().get(0);

        this.roundWon = false;
    }

    public void play() {
        for (int i = 0; i < this.getPlayers().size(); i++) {
            PazaakPlayer player = (PazaakPlayer) this.getPlayers().get(i);

            // If a player isn't standing, deal them a card
            if (!player.isStanding()) {
                this.dealCard(player);
            }
        }
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
            TableCard tableCard = (TableCard) deck.showCards().get(0);

            // Add the card to the player's hand
            tableHand.showCards().add(tableCard);

            // Increase the player's total by its value
            player.setCardTotal(player.getCardTotal() + tableCard.getValue().value);

            // Remove the card from the game's table deck
            deck.showCards().remove(0);
        }
    }

    public void roundWinner() {
        PazaakPlayer winner;
        int pIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);
        // check all conditions for round winner
        //if current player has forfeited then nextPLayer wins
        if (this.currentPlayer.getCardTotal() == -1) {
            winner = nextPlayer;
        }
        // if nextPlayer forfeits current player wins
        if (nextPlayer.getCardTotal() == -1) {
            winner = currentPlayer;
        }
        
        /*
        win conditions:
        1- 
        2- if someone has gone over 20
        3- someone has 9 cards and is under 20
        4- both players standing, one has higher or equal
        */

        // set roundWon accordingly
        this.roundWon = true;
        
        currentPlayer.setWins(currentPlayer.getWins()+1);
        buildDeck();
        
        System.out.print("Do you want to play first? (Y/N)");
        playFirst = input.next();
        if ("Y".equalsIgnoreCase(playFirst)){
            
        } else if ("N".equalsIgnoreCase(playFirst)){
            int psIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
            PazaakPlayer nextPlayer1 = (PazaakPlayer) this.getPlayers().get(psIndex);
            PazaakPlayer temp;
            currentPlayer = nextPlayer;
        } 
        
        // the winner gets their wins incremented
        // start a new round by resetting player values
        // ask winner if they want to play first
        
    }
    
    public void buildDeck(){
        
        for (TableValue val : TableValue.values()) {
            for (int i = 0; i < 4; i++) {
                deck.showCards().add(new TableCard(val));
            }
        }
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
        PazaakPlayer currentPlayer = this.getCurrentPlayer();

        // Find next player
        int pIndex = (currentPlayer == (PazaakPlayer) this.getPlayers().get(0)) ? 1 : 0;
        PazaakPlayer nextPlayer = (PazaakPlayer) this.getPlayers().get(pIndex);
        System.out.println("Next player is " + nextPlayer.getPlayerID());

        if (!nextPlayer.isStanding()) {
            // If next player is not standing, switch to current player
            this.setCurrentPlayer(nextPlayer);
        }
    }

    public void startTurn() {
        PazaakPlayer p = this.getCurrentPlayer();
        p.setTurnOver(false);
        while (!p.isTurnOver() && !p.isStanding()) {
            this.showBoard();
            System.out.println(p.getPlayerID() + "'s turn");
            System.out.print("Play card (1)/ End turn (2)/ Stand (3)/ Forfeit (4): ");
            int choice = input.nextInt();
            boolean cardPlayed = false;

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
                case (2):
                    p.endTurn();
                    break;
                case (3):
                    p.stand();
                    break;
                case (4):
                    p.forfeit();
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
            System.out.println(pArr[i].getPlayerID() + ", Total: " + pArr[i].getCardTotal());
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
