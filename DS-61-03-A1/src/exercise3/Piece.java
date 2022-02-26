/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise3;

import static java.lang.Character.toLowerCase;

/**The class Piece stores the type and color of the pieces, 
and links every piece with a character depending on said atributes*/

public class Piece {

    private final PieceType PieceType;
    private final PieceColor PieceColor;

    Piece(PieceType Piecetype, PieceColor Piececolor) {
        this.PieceType = Piecetype;
        this.PieceColor = Piececolor;
    }

    public PieceType getType() {
        return PieceType;
    }

    public PieceColor getColor() {
        return PieceColor;
    }

    public char toChar() {
        char a = 0;
        switch (this.PieceType) {
            case BISHOP:
                a = 'B';
                break;
            case KING:
                a = 'K';
                break;
            case QUEEN:
                a = 'Q';
                break;
            case KNIGHT:
                a = 'N';
                break;
            case ROOK:
                a = 'R';
                break;
            case PAWN:
                a = 'P';
                break;
            default:
                break;
        }
        if (this.PieceColor == PieceColor.BLACK) {
            return toLowerCase(a);
        } else {
            return a;
        }
    }
}
