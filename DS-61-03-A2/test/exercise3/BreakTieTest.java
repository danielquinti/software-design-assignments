package exercise3;

import org.junit.Test;
import static org.junit.Assert.*;


public class BreakTieTest {

    @Test
    public void testWinner() {
        Integer expected=1;
        Integer result = BreakTie.winner(5, 3, MyIterators.REBOUND);
        assertEquals(expected, result);
    }
    
    @Test
    public void testWinner2() {
        Integer expected=4;
        Integer result = BreakTie.winner(5, 3, MyIterators.CIRCULAR);
        assertEquals(expected, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument(){
        BreakTie.winner(5, (-1), MyIterators.CIRCULAR);
    }
    
    
    
    
}
