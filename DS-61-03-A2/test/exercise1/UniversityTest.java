/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danielquintillan
 */
public class UniversityTest {

    @Test
    public void testPrintPayslips() {
        System.out.println("printPayslips");
        List<Employee> myarray = new ArrayList<>();
        myarray.add(new Administrator("Luis", 32, "75132684P", 2));
        myarray.add(new Administrator("Manuel", 26, "75137584P", 0));
        myarray.add(new Professor("Javier", 47, "78541374N", 2));
        myarray.add(new Professor("Laura", 43, "24541372V", 0));
        myarray.add(new IT("Marta", 28, "72164284U", 0));
        myarray.add(new IT("Carlos", 42, "77469432R", 2));
        myarray.add(new Researcher("María", 30, "15158684L"));
        University myUniversity = new University(myarray);
        String result = myUniversity.printPayslips();
        String expResult = "Luis(Administrator with 2 extra hours): 1122.0\n"
                + "Manuel(Administrator): 1110.0\n"
                + "Javier(Professor with 2 six-year terms): 1384.0\n"
                + "Laura(Professor): 1184.0\n"
                + "Marta(IT): 960.0\n"
                + "Carlos(IT with 2 extra hours): 972.0\n"
                + "María(Researcher): 980.0\n"
                + "The monthly personnel costs of the UDC is 7712 euros\n";
        assertEquals(expResult, result);
    }
}
