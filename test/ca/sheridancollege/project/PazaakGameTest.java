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
     * Test of rematch method, of class PazaakGame.
     */
    @Test
    public void testRematch() {
        System.out.println("rematch");
        PazaakPlayer winner = null;
        PazaakGame instance = new PazaakGame();
        boolean expResult = false;
        boolean result = instance.rematch(winner);
        assertEquals(expResult, result);
    }

    /**
     * Test of dealCard method, of class PazaakGame.
     */
    @Test
    public void testDealCard() {
        System.out.println("dealCard");
        PazaakGame instance = new PazaakGame();
        instance.dealCard();
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
     * Test of buildDeck method, of class PazaakGame.
     */
    @Test
    public void testBuildDeck() {
        System.out.println("buildDeck");
        PazaakGame instance = new PazaakGame();
        instance.buildDeck();
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
     * Test of assignSideDeck method, of class PazaakGame.
     */
    @Test
    public void testAssignSideDeck() {
        System.out.println("assignSideDeck");
        PazaakPlayer player = null;
        PazaakGame instance = new PazaakGame();
        instance.assignSideDeck(player);
    }


    /**
     * Test of takeWager method, of class PazaakGame.
     */
    @Test
    public void testTakeWager() {
        System.out.println("takeWager");
        PazaakGame instance = new PazaakGame();
        instance.takeWager();
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
    public void testChangeTurn() {
        System.out.println("changeTurn");
        PazaakGame instance = new PazaakGame();
        instance.changeTurn();
    }

    /**
     * Test of startTurn method, of class PazaakGame.
     */
    @Test
    public void testStartTurn() {
        System.out.println("startTurn");
        PazaakGame instance = new PazaakGame();
        instance.startTurn();
    }

    /**
     * Test of checkTotal method, of class PazaakGame.
     */
    @Test
    public void testCheckTotal() {
        System.out.println("checkTotal");
        PazaakGame instance = new PazaakGame();
        instance.checkTotal();
    }

    /**
     * Test of showBoard method, of class PazaakGame.
     */
    @Test
    public void testShowBoard() {
        System.out.println("showBoard");
        PazaakGame instance = new PazaakGame();
        instance.showBoard();
    }
    
}
