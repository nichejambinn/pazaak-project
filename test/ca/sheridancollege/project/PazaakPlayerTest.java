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
public class PazaakPlayerTest {
    
    /**
     * Test of play method, of class PazaakPlayer.
     */
    @Test
    public void testBadPlay() {
        System.out.println("play");
        PazaakGame game = null;
        PazaakPlayer instance = new PazaakPlayer("instance");
        instance.play(game);
        assertEquals(null, instance.getGame());
    }

    @Test
    public void testGoodPlay() {
        System.out.println("play");
        PazaakGame game = new PazaakGame();
        PazaakPlayer instance = new PazaakPlayer("instance");
        instance.play(game);
        assertEquals(game, instance.getGame());
    }

    /**
     * Test of stand method, of class PazaakPlayer.
     */
    @Test
    public void testStand() {
        System.out.println("stand");
        PazaakPlayer instance = new PazaakPlayer("John");
        instance.stand();
        boolean expResult = true;
        boolean result = instance.isStanding();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStanding method, of class PazaakPlayer.
     */
    @Test
    public void testIsStanding() {
        System.out.println("isStanding");
        PazaakPlayer instance = new PazaakPlayer("John");
        boolean expResult = false;
        boolean result = instance.isStanding();
        assertEquals(expResult, result);
    }

    /**
     * Test of endTurn method, of class PazaakPlayer.
     */
    @Test
    public void testEndTurn() {
        System.out.println("endTurn");
        PazaakPlayer instance = new PazaakPlayer("John");
        instance.endTurn();
        assertEquals(instance.isTurnOver(), true);
    }

    /**
     * Test of isTurnOver method, of class PazaakPlayer.
     */
    @Test
    public void testIsTurnOver() {
        System.out.println("isTurnOver");
        PazaakPlayer instance = new PazaakPlayer("John");
        instance.play(new PazaakGame());
        boolean expResult = false;
        boolean result = instance.isTurnOver();
        assertEquals(expResult, result);
    }

    /**
     * Test of forfeit method, of class PazaakPlayer.
     */
    @Test
    public void testForfeitCardTotal() {
        System.out.println("forfeit");
        PazaakPlayer instance = new PazaakPlayer("John");
        instance.forfeit();
        assertEquals(instance.getCardTotal(), -1);
    }
    
    /**
     * Test of forfeit method, of class PazaakPlayer.
     */
    @Test
    public void testForfeitTurnOver() {
        System.out.println("forfeit");
        PazaakPlayer instance = new PazaakPlayer("John");
        instance.forfeit();
        assertEquals(instance.isTurnOver(), true);
    }

    /**
     * Test of playCard method, of class PazaakPlayer.
     */
    @Test
    public void testPlayCard() {
        System.out.println("playCard");
        SideCard card = new SideCard(SideValue.PLUS_TWO);
        PazaakPlayer instance = new PazaakPlayer("John");
        GroupOfCards cards = new GroupOfCards();
        cards.showCards().add(card);
        instance.setHand(cards);
        instance.playCard(card);
        assertEquals(2, instance.getCardTotal());
    }

    /**
     * Test of addTableCard method, of class PazaakPlayer.
     */
    @Test
    public void testAddTableCard() {
        System.out.println("addTableCard");
        TableCard card = new TableCard(TableValue.EIGHT);
        PazaakPlayer instance = new PazaakPlayer("John");
        instance.addTableCard(card);
        assertEquals(8, instance.getCardTotal());
    }
    
}
