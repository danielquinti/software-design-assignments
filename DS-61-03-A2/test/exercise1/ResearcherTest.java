/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResearcherTest {

    @Test
    public void testSalary() {
        Researcher María = new Researcher("María", 30, "15158684L");
        assertEquals(980.0, María.salary(), 0.1);
    }

    @Test
    public void testResearcherValid() {
        Researcher María = new Researcher("María", 30, "15158684L");
        assertEquals("María", María.getName());
        assertEquals(30, María.getAge());
        assertEquals("15158684L", María.getID());
    }

        @Test(expected = IllegalArgumentException.class)
    public void testResearcherInvalid() {
        Researcher Luis = new Researcher("Luis", -2, "75132684P");
    }
    
    @Test
    public void testToString() {
        Researcher María = new Researcher("María", 30, "15158684L");
        assertEquals("María(Researcher): 980.0", María.toString());
    }
}
