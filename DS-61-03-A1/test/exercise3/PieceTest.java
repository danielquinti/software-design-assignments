/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise3;

import org.junit.Test;
import static org.junit.Assert.*;

public class PieceTest {
    
    /**
     * Test of getType method, of class Piece.
     */
    @Test
    public void testGetType() {
        Piece piece1 = new Piece (PieceType.KING, PieceColor.BLACK);      
        Piece piece2 = new Piece (PieceType.PAWN, PieceColor.WHITE);      
        assertEquals(PieceType.KING, piece1.getType());
        assertEquals(PieceType.PAWN, piece2.getType());

    }

    /**
     * Test of getColor method, of class Piece.
     */
    @Test
    public void testGetColor() {
        Piece piece1 = new Piece (PieceType.KING, PieceColor.BLACK);      
        Piece piece2 = new Piece (PieceType.PAWN, PieceColor.WHITE);
        assertEquals(PieceColor.BLACK, piece1.getColor());
        assertEquals(PieceColor.WHITE, piece2.getColor());
    }
    
}
