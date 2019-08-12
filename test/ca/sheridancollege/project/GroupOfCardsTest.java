/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arsalan Ali
 */
public class GroupOfCardsTest {

    /**
     * Test of showCards method, of class GroupOfCards.
     */
    @Test
    public void testShowCards() {
        System.out.println("showCards");
        GroupOfCards instance = new GroupOfCards();
        GroupOfCards test = new GroupOfCards();
        ArrayList<Card> expResult = test.showCards();
        expResult.add((new SideCard(SideValue.PLUS_ONE)));
        ArrayList<Card> result = instance.showCards();
        result.add((new SideCard(SideValue.PLUS_ONE)));
        assertEquals(expResult.get(0).toString(),result.get(0).toString());
    }
    
}
