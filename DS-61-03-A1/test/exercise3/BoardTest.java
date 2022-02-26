/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise3;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testCreateBoard() {
        Board board = new Board();
        assertEquals("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board.toString());
    }

    @Test
    public void testStartGame() {
        Board board = new Board();
        board.move(new Position('e', '2'), new Position('e', '4'));
        board.startGame();
        assertEquals("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board.toString());
    }

    /**
     * This test assumes that the search proceeds in rows starting with position
     * a8
     */
    @Test
    public void testFindPieces() {
        Board board = new Board();
        List expResult = new ArrayList(16);
        List result = board.findPieces(PieceType.PAWN);

        expResult.add(new Position('a', '7'));
        expResult.add(new Position('b', '7'));
        expResult.add(new Position('c', '7'));
        expResult.add(new Position('d', '7'));
        expResult.add(new Position('e', '7'));
        expResult.add(new Position('f', '7'));
        expResult.add(new Position('g', '7'));
        expResult.add(new Position('h', '7'));
        expResult.add(new Position('a', '2'));
        expResult.add(new Position('b', '2'));
        expResult.add(new Position('c', '2'));
        expResult.add(new Position('d', '2'));
        expResult.add(new Position('e', '2'));
        expResult.add(new Position('f', '2'));
        expResult.add(new Position('g', '2'));
        expResult.add(new Position('h', '2'));

        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        Position origin = new Position('a', '2');
        Position destination = new Position('b', '3');
        Board board = new Board();
        board.move(origin, destination);
        assertEquals("rnbqkbnr/pppppppp/8/8/8/1P6/1PPPPPPP/RNBQKBNR", board.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveWithoutPiece() {
        Board board = new Board();
        board.move(new Position('a', '3'), new Position('b', '4'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveErroneousOrigin() {
        Board board = new Board();
        board.move(new Position('3', 'a'), new Position('b', '4'));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMoveErroneousDestination() {
        Board board = new Board();
        board.move(new Position('a', '3'), new Position('b', '0'));
    }
    
}