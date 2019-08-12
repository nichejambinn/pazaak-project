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
        PazaakGame instance = new PazaakGame();
        instance.dealCard();
    }

    /**
     * Test of roundWinner method, of class PazaakGame.
     */
    @Test
    public void testRoundWinner() {
        System.out.println("roundWinner");
        PazaakGame game = new PazaakGame();
        PazaakPlayer p1 = (PazaakPlayer) game.getPlayers().get(0);
        PazaakPlayer p2 = (PazaakPlayer) game.getPlayers().get(1);
        p1.setCardTotal(20);
        p2.setCardTotal(1);
        game.roundWinner();
        assertEquals(1, p1.getWins());
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
    public void testChangeTurn() {
        System.out.println("changeTurn");
        PazaakGame instance = new PazaakGame();
        instance.changeTurn();
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
    
}
