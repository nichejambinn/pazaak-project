/*
 * Test cases:

 */
package ca.sheridancollege.project;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jammoo
 */
public class SideCardTest {

    @Test
    public void testToStringPositive() {
        SideCard a = new SideCard(SideValue.PLUS_ONE);
        String expResult = " ____ \n|+1  |\n|    |\n|____|\n";
        String result = a.toString();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    };
    
    @Test
    public void testToStringNegative() {
        SideCard a = new SideCard(SideValue.MINUS_FIVE);
        String expResult = " ____ \n|-5  |\n|    |\n|____|\n";
        String result = a.toString();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    };
}
