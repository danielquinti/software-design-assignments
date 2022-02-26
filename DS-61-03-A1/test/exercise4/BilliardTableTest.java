/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class BilliardTableTest {
    
    @Test
    public void testStartGame() {
        BilliardTable table = new BilliardTable();
        table.startGame();

        assertTrue(table.isGameUnderway());

        ArrayList testBalls = new ArrayList();
        assertEquals(testBalls, table.sunkBalls());

        testBalls.addAll(Arrays.asList(BilliardBall.values()));
        assertEquals(testBalls, table.ballsOnTable());
    }

    @Test
    public void testPocketBall() {
        BilliardTable table = new BilliardTable();
        table.startGame();

        List expectedBallsOnTable = new ArrayList();
        List expectedSunkBalls = new ArrayList();
        expectedBallsOnTable.addAll(Arrays.asList(BilliardBall.values()));
       
        table.pocketBall(BilliardBall.BALL1);
       
        expectedBallsOnTable.remove(BilliardBall.BALL1);
        expectedSunkBalls.add(BilliardBall.BALL1);
        
        assertEquals(expectedBallsOnTable, table.ballsOnTable());
        assertEquals(expectedSunkBalls, table.sunkBalls());
    }

//Testing case of pocketing the ball 8
    @Test
    public void testTableEight(){
    BilliardTable table = new BilliardTable();
    table.startGame();
    assertFalse (table.pocketBall(BilliardBall.BALL8));
    }
    
//Testing case of pocketing the cueball   
    @Test
    public void testTableCueball(){
    BilliardTable table = new BilliardTable();
    table.startGame();
    assertTrue(table.pocketBall(BilliardBall.CUEBALL));
    }
    
    

    @Test
    public void testPocketAllBalls() {
        BilliardBall b = null;
        BilliardTable table = new BilliardTable();
        table.startGame();

        List expectedBallsOnTable = new ArrayList();
        List expectedSunkBalls = new ArrayList();

        for (BilliardBall bolaBillar : BilliardBall.values()) {
            if (!(bolaBillar.equals(BilliardBall.CUEBALL)) && !(bolaBillar.equals(BilliardBall.BALL8))) {
                table.pocketBall(bolaBillar);
            }
        }
        expectedBallsOnTable.add(BilliardBall.CUEBALL);
        expectedBallsOnTable.add(BilliardBall.BALL8);
                
        expectedSunkBalls.addAll(Arrays.asList(BilliardBall.values()));
        expectedSunkBalls.remove(BilliardBall.CUEBALL);
        expectedSunkBalls.remove(BilliardBall.BALL8);        
        
        assertEquals(expectedBallsOnTable, table.ballsOnTable());
        assertEquals(expectedSunkBalls, table.sunkBalls());
    }

    @Test
    public void testNoIsGameUnderway() {
        BilliardTable table = new BilliardTable();
        assertFalse(table.isGameUnderway());
    }
    
    @Test
    public void testIsGameUnderway() {
        BilliardTable table = new BilliardTable();
        table.startGame();
        assertTrue(table.isGameUnderway());
    }    

    @Test
    public void testGetWinnerSolid() {
        BilliardTable table = new BilliardTable();
        
        table.startGame();
        table.pocketBall(BilliardBall.BALL1);
        assertEquals(BilliardBall.BallType.SOLID, table.getWinner());
    }
    
    @Test
    public void testGetWinnerStriped() {
        BilliardTable table = new BilliardTable();
        
        table.startGame();
        table.pocketBall(BilliardBall.BALL10);
        assertEquals(BilliardBall.BallType.STRIPED, table.getWinner());
    }    
    
    @Test
    public void testGetWinnerTied() {
        BilliardTable table = new BilliardTable();
        
        table.startGame();      
        table.pocketBall(BilliardBall.BALL10);      
        table.pocketBall(BilliardBall.BALL1);                
        assertEquals(null, table.getWinner());
    }            
}
