/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DILJOT
 */
public class PazaakGameTest {
    
    
    /**
     * Test of declareWinner method, of class PazaakGame.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        PazaakGame game = new PazaakGame();
        PazaakPlayer p1 = (PazaakPlayer) game.getPlayers().get(0);
        PazaakPlayer p2 = (PazaakPlayer) game.getPlayers().get(1);
        game.setWager(1000);
        p1.play(game);
	p2.play(game);
        p1.setWins(3);
        game.declareWinner();
        assertEquals(2000, p1.getCredits());
    }

    /**
     * Test of dealCard method, of class PazaakGame.
     */
    @Test
    public void testDealCard() {
        System.out.println("dealCard");
        PazaakGame game = new PazaakGame();
        PazaakPlayer p1 = (PazaakPlayer) game.getPlayers().get(0);
        game.setCurrentPlayer(p1);
        game.buildDeck();
        p1.setTableHand(new GroupOfCards());
        game.dealCard();
        boolean result = p1.getCardTotal() > 0;
        assertEquals(true, result);
    }

    /**
     * Test of roundWinner method, of class PazaakGame.
     */
    @Test
    public void testBoundaryRoundWinner() {
        System.out.println("roundWinner");
        PazaakGame game = new PazaakGame();
        PazaakPlayer p1 = game.getCurrentPlayer();
        PazaakPlayer p2 = game.getNextPlayer();
        p1.setCardTotal(20);
        p2.setCardTotal(1);
        p1.setStanding(true);
        p2.setStanding(true);
        game.roundWinner();
        assertEquals(1, p1.getWins());
    }

    @Test
    public void testGoodRoundWinner() {
        System.out.println("roundWinner");
        PazaakGame game = new PazaakGame();
        PazaakPlayer p1 = game.getCurrentPlayer();
        PazaakPlayer p2 = game.getNextPlayer();
        p1.setCardTotal(19);
        p2.setCardTotal(1);
        p1.setStanding(true);
        p2.setStanding(true);
        game.roundWinner();
        assertEquals(1, p1.getWins());
    }

    @Test
    public void testBadRoundWinner() {
        System.out.println("roundWinner");
        PazaakGame game = new PazaakGame();
        PazaakPlayer p1 = game.getCurrentPlayer();
        PazaakPlayer p2 = game.getNextPlayer();
        p1.setCardTotal(25);
        p2.setCardTotal(1);
        game.roundWinner();
        assertEquals(0, p1.getWins());
    }

    /**
     * Test of isRoundWon method, of class PazaakGame.
     */
    @Test
    public void testIsRoundWon() {
        System.out.println("isRoundWon");
        PazaakGame instance = new PazaakGame();
        boolean expResult = false;
        boolean result = instance.isRoundWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkCredit method, of class PazaakGame.
     */
    @Test
    public void testGoodCheckCredit() {
        System.out.println("checkCredit");
        int player1 = 1000;
        int player2 = 1000;
        int wager = 150;
        PazaakGame instance = new PazaakGame();
        boolean expResult = false;
        boolean result = instance.checkCredit(player1, player2, wager);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkCredit method, of class PazaakGame.
     */
    @Test
    public void testBadCheckCredit() {
        System.out.println("checkCredit");
        int player1 = 1000;
        int player2 = 1000;
        int wager = 3000;
        PazaakGame instance = new PazaakGame();
        boolean expResult = true;
        boolean result = instance.checkCredit(player1, player2, wager);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkCredit method, of class PazaakGame.
     */
    @Test
    public void testBoundaryCheckCredit() {
        System.out.println("checkCredit");
        int player1 = 1000;
        int player2 = 1000;
        int wager = 1000;
        PazaakGame instance = new PazaakGame();
        boolean expResult = false;
        boolean result = instance.checkCredit(player1, player2, wager);
        assertEquals(expResult, result);
    }

    /**
     * Test of changeTurn method, of class PazaakGame.
     */
    @Test
    public void testGoodChangeTurn() {
        System.out.println("changeTurn, nextPlayer is not standing");
        PazaakGame game = new PazaakGame();
        PazaakPlayer currentPlayer = game.getCurrentPlayer();
        PazaakPlayer nextPlayer = game.getNextPlayer();

        game.changeTurn();

        assertEquals(game.getCurrentPlayer(), nextPlayer);
    }

    @Test
    public void testBadChangeTurn() {
        System.out.println("changeTurn, nextPlayer is standing");
        PazaakGame game = new PazaakGame();
        PazaakPlayer currentPlayer = game.getCurrentPlayer();
        PazaakPlayer nextPlayer = game.getNextPlayer();
        nextPlayer.setStanding(true);

        game.changeTurn();

        assertEquals(game.getCurrentPlayer(), currentPlayer);
    }
    
}
