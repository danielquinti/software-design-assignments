/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void testSalary() {
        Professor Javier = new Professor("Javier", 47, "78541374N", 2);
        assertEquals(1384.0, Javier.salary(), 0.1);
    }

    @Test
    public void testProfessorValid() {
        Professor Javier = new Professor("Javier", 47, "78541374N", 2);
        assertEquals("Javier", Javier.getName());
        assertEquals(47, Javier.getAge());
        assertEquals("78541374N", Javier.getID());
        assertEquals(2, Javier.getNumberOfSYT());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProfessorInvalid1() {
        Professor Javier = new Professor("Javier", 47, "78541374N", -3);
    }

    public void testProfessorInvalid2() {
        Professor Javier = new Professor("Javier", 47, "78541374N", 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProfessorInvalid3() {
        Professor Luis = new Professor("Luis", -2, "75132684P", 2);
    }
    
    @Test
    public void testToString() {
        Professor Javier = new Professor("Javier", 47, "78541374N", 2);
        assertEquals("Javier(Professor with 2 six-year terms): 1384.0", Javier.toString());
    }
}
