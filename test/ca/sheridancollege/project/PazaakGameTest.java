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
     * Test of play method, of class PazaakGame.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        PazaakGame instance = new PazaakGame();
        instance.play();
    }

    /**
     * Test of setRoundWon method, of class PazaakGame.
     */
    @Test
    public void testSetRoundWon() {
        System.out.println("setRoundWon");
        boolean roundWon = false;
        PazaakGame instance = new PazaakGame();
        instance.setRoundWon(roundWon);
    }

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
     * Test of getSideCards method, of class PazaakGame.
     */
    @Test
    public void testGetSideCards() {
        System.out.println("getSideCards");
        PazaakGame instance = new PazaakGame();
        GroupOfCards expResult = null;
        GroupOfCards result = instance.getSideCards();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSideCards method, of class PazaakGame.
     */
    @Test
    public void testSetSideCards() {
        System.out.println("setSideCards");
        GroupOfCards sideCards = null;
        PazaakGame instance = new PazaakGame();
        instance.setSideCards(sideCards);
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
