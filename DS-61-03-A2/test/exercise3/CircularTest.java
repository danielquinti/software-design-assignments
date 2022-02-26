package exercise3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CircularTest {
   
    @Test
    public void testHasNext() {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
                a.add(i);
        }
        Iterator<Integer> cIt = new Circular(a);
        boolean expResult = true;
        boolean result = cIt.hasNext();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testHasNextFalse() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        Iterator<Integer> cIt = new Circular(a);
        boolean expResult = false;
        boolean result = cIt.hasNext();
        assertEquals(expResult, result);
    }
}
