/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielquintillan
 */
public class ITTest {

    @Test
    public void testSalary() {
        IT Juan = new IT("Juan", 45, "15158684L", 3);
        assertEquals(978, Juan.salary(), 0.1);
    }

    @Test
    public void testITvalid() {
        IT Juan = new IT("Juan", 45, "15158684L", 3);
        assertEquals("Juan", Juan.getName());
        assertEquals(45, Juan.getAge());
        assertEquals("15158684L", Juan.getID());
        assertEquals(3, Juan.getExtraHours());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testITinvalid() {
        IT Juan = new IT("Juan", 45, "15158684L", -3);
    }
        @Test(expected = IllegalArgumentException.class)
    public void testITinvalid2() {
        IT Luis = new IT("Luis", -2, "75132684P", 2);
    }

    @Test
    public void testToString() {
        IT Marta = new IT("Marta", 28, "72164284U", 0);
        assertEquals("Marta(IT): 960.0", Marta.toString());
    }
}
