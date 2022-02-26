/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise3;

import org.junit.Test;
import static org.junit.Assert.*;

public class PositionTest {
      
    @Test
    public void testGetRow() {
        Position position = new Position('a', '1');        
        assertEquals('1', position.getRow());
    }

    @Test
    public void testGetColumn() {
        Position position = new Position('a', '1');        
        assertEquals('a', position.getColumn());
    }
    
    //Position cannot be performed with invalid arguments
    @Test(expected = IllegalArgumentException.class)
    public void testPosition1(){
        Position position = new Position('Z', '1');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPosition2(){
        Position position = new Position('z', '1');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPosition3(){
        Position position = new Position('a', 'Z');
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPosition4(){
        Position position = new Position('a', 'z');
    }
    
    //Testing equality against null position
    @Test
    public void testEqualsNull(){
        Position position = new Position('a', '1'); 
        Position position2 = null; 
        assertNotEquals(position, position2);
    }
    
    //Testing equality between different classes
    @Test
    public void testDifClass(){
        Position position = new Position('a', '1'); 
        String position2 = "Different classes"; 
        assertNotEquals(position, position2);
    }
    
    //Testing correct equality
    @Test
    public void testEquals(){
        Position position = new Position('a', '1'); 
        Position position2 = new Position('a', '1');
        assertEquals(position, position2);
    }
  
    //Testing column inequality
    @Test
    public void testNotEqualsColumns(){
        Position position = new Position('a', '1'); 
        Position position2 = new Position('b', '1');
        assertNotEquals(position, position2);
    }
    
    //Testing row inequality
    @Test
    public void testNotEqualsRows(){
        Position position = new Position('a', '1'); 
        Position position2 = new Position('a', '2');
        assertNotEquals(position, position2);
    }
    
    
    
}
