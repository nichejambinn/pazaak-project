/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
        PazaakGame instance = new PazaakGame();
        instance.declareWinner();
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
    public void testRoundWinner() {
        System.out.println("roundWinner");
        PazaakGame instance = new PazaakGame();
        instance.roundWinner();
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
