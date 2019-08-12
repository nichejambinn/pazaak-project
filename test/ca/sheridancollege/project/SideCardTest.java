/*
 * Test cases:

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
 * @author Jammoo
 */
public class SideCardTest {
    
    public SideCardTest() {
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

    @Test
    public void testToString() {
        SideCard a = new SideCard(SideValue.PLUS_ONE);
        String expResult = " ____ \n|+1  |\n|    |\n|____|\n";
        String result = a.toString();
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    };
}
