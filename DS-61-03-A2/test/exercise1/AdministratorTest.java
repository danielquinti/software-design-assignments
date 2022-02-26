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
public class AdministratorTest {

    @Test
    public void testSalary() {
        Administrator Luis = new Administrator("Luis", 32, "75132684P", 2);
        assertEquals(1122, Luis.salary(), 0.1);
    }

    @Test
    public void testAdministratorValid() {
        Administrator Luis = new Administrator("Luis", 32, "75132684P", 2);
        assertEquals("Luis", Luis.getName());
        assertEquals(32, Luis.getAge());
        assertEquals("75132684P", Luis.getID());
        assertEquals(2, Luis.getExtraHours());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdministratorInvalid1() {
        Administrator Luis = new Administrator("Luis", 32, "75132684P", -2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAdministratorInvalid2() {
        Administrator Luis = new Administrator("Luis", -2, "75132684P", 2);
    }
    
    @Test
    public void testToString() {
        Administrator Luis = new Administrator("Luis", 32, "75132684P", 2);
        assertEquals("Luis(Administrator with 2 extra hours): 1122.0", Luis.toString());
    }
}
