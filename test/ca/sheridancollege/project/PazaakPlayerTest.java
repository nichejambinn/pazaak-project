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
public class PazaakPlayerTest {
    
    public PazaakPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of play method, of class PazaakPlayer.
     */
    @Test
    public void testPlay() {
        System.out.println("play");
        PazaakGame game = null;
        PazaakPlayer instance = null;
        instance.play(game);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCredits method, of class PazaakPlayer.
     */
    @Test
    public void testGetCredits() {
        System.out.println("getCredits");
        PazaakPlayer instance = null;
        int expResult = 0;
        int result = instance.getCredits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCredits method, of class PazaakPlayer.
     */
    @Test
    public void testSetCredits() {
        System.out.println("setCredits");
        int credits = 0;
        PazaakPlayer instance = null;
        instance.setCredits(credits);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stand method, of class PazaakPlayer.
     */
    @Test
    public void testStand() {
        System.out.println("stand");
        PazaakPlayer instance = null;
        instance.stand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStanding method, of class PazaakPlayer.
     */
    @Test
    public void testSetStanding() {
        System.out.println("setStanding");
        boolean standing = false;
        PazaakPlayer instance = null;
        instance.setStanding(standing);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStanding method, of class PazaakPlayer.
     */
    @Test
    public void testIsStanding() {
        System.out.println("isStanding");
        PazaakPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.isStanding();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endTurn method, of class PazaakPlayer.
     */
    @Test
    public void testEndTurn() {
        System.out.println("endTurn");
        PazaakPlayer instance = null;
        instance.endTurn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurnOver method, of class PazaakPlayer.
     */
    @Test
    public void testSetTurnOver() {
        System.out.println("setTurnOver");
        boolean turnOver = false;
        PazaakPlayer instance = null;
        instance.setTurnOver(turnOver);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isTurnOver method, of class PazaakPlayer.
     */
    @Test
    public void testIsTurnOver() {
        System.out.println("isTurnOver");
        PazaakPlayer instance = null;
        boolean expResult = false;
        boolean result = instance.isTurnOver();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forfeit method, of class PazaakPlayer.
     */
    @Test
    public void testForfeit() {
        System.out.println("forfeit");
        PazaakPlayer instance = null;
        instance.forfeit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playCard method, of class PazaakPlayer.
     */
    @Test
    public void testPlayCard() {
        System.out.println("playCard");
        SideCard card = null;
        PazaakPlayer instance = null;
        instance.playCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHand method, of class PazaakPlayer.
     */
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        PazaakPlayer instance = null;
        GroupOfCards expResult = null;
        GroupOfCards result = instance.getHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHand method, of class PazaakPlayer.
     */
    @Test
    public void testSetHand() {
        System.out.println("setHand");
        GroupOfCards hand = null;
        PazaakPlayer instance = null;
        instance.setHand(hand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWins method, of class PazaakPlayer.
     */
    @Test
    public void testGetWins() {
        System.out.println("getWins");
        PazaakPlayer instance = null;
        int expResult = 0;
        int result = instance.getWins();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWins method, of class PazaakPlayer.
     */
    @Test
    public void testSetWins() {
        System.out.println("setWins");
        int wins = 0;
        PazaakPlayer instance = null;
        instance.setWins(wins);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardTotal method, of class PazaakPlayer.
     */
    @Test
    public void testGetCardTotal() {
        System.out.println("getCardTotal");
        PazaakPlayer instance = null;
        int expResult = 0;
        int result = instance.getCardTotal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCardTotal method, of class PazaakPlayer.
     */
    @Test
    public void testSetCardTotal() {
        System.out.println("setCardTotal");
        int cardTotal = 0;
        PazaakPlayer instance = null;
        instance.setCardTotal(cardTotal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTableHand method, of class PazaakPlayer.
     */
    @Test
    public void testGetTableHand() {
        System.out.println("getTableHand");
        PazaakPlayer instance = null;
        GroupOfCards expResult = null;
        GroupOfCards result = instance.getTableHand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTableHand method, of class PazaakPlayer.
     */
    @Test
    public void testSetTableHand() {
        System.out.println("setTableHand");
        GroupOfCards tableHand = null;
        PazaakPlayer instance = null;
        instance.setTableHand(tableHand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTableCard method, of class PazaakPlayer.
     */
    @Test
    public void testAddTableCard() {
        System.out.println("addTableCard");
        TableCard card = null;
        PazaakPlayer instance = null;
        instance.addTableCard(card);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
