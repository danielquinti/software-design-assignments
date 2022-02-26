/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise3;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chessboard
 */
public class Board {

    private Piece[][] Board = new Piece[8][8];

    /**
     * Constructor for creating a board with the initial configuration .
     */
    public Board() {
        this.Board[0][0] = new Piece(PieceType.ROOK, PieceColor.BLACK);
        this.Board[0][1] = new Piece(PieceType.KNIGHT, PieceColor.BLACK);
        this.Board[0][2] = new Piece(PieceType.BISHOP, PieceColor.BLACK);
        this.Board[0][3] = new Piece(PieceType.QUEEN, PieceColor.BLACK);
        this.Board[0][4] = new Piece(PieceType.KING, PieceColor.BLACK);
        this.Board[0][5] = new Piece(PieceType.BISHOP, PieceColor.BLACK);
        this.Board[0][6] = new Piece(PieceType.KNIGHT, PieceColor.BLACK);
        this.Board[0][7] = new Piece(PieceType.ROOK, PieceColor.BLACK);

        for (int i = 0; i < 8; i++) {
            this.Board[1][i] = new Piece(PieceType.PAWN, PieceColor.BLACK);
            this.Board[6][i] = new Piece(PieceType.PAWN, PieceColor.WHITE);
        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.Board[i][j] = null;
            }
        }

        this.Board[7][0] = new Piece(PieceType.ROOK, PieceColor.WHITE);
        this.Board[7][1] = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        this.Board[7][2] = new Piece(PieceType.BISHOP, PieceColor.WHITE);
        this.Board[7][3] = new Piece(PieceType.QUEEN, PieceColor.WHITE);
        this.Board[7][4] = new Piece(PieceType.KING, PieceColor.WHITE);
        this.Board[7][5] = new Piece(PieceType.BISHOP, PieceColor.WHITE);
        this.Board[7][6] = new Piece(PieceType.KNIGHT, PieceColor.WHITE);
        this.Board[7][7] = new Piece(PieceType.ROOK, PieceColor.WHITE);
    }

    /**
     * Restores a preexisting board to the initial configuration .
     */
    public void startGame() {
        Board temp = new Board();
        this.Board = temp.Board;

    }

    /**
     * Returns a String with the FEN representation of the board .
     *
     * @return String using the FEN notation .
     */
    
    
    @Override
    public String toString() {
        String temp = "";
        int count = 0;
        for (int i = 0; i < 64; i++) {
            if (this.Board[i / 8][i % 8] == null) {
                count++;
                if ((this.Board[(i + 1) / 8][(i + 1) % 8] != null) || (i % 8 == 7)) {
                    temp = temp + count;
                }
            } else {
                count = 0;
                temp = temp + this.Board[i / 8][i % 8].toChar();
            }
            if (i % 8 == 7 && i != 63) {
                temp = temp + "/";
                count = 0;
            }
        }
        return temp;
    }

    /**
     * Takes a type of piece as an argument and returns a list of the Position
     * objects that contain pieces of that type ( black and white ).
     *
     * @param piece Chess piece
     * @return List of Position objects with the positions for the piece that
     * was passed as an argument .
     */
    public List findPieces(PieceType piece) {

        List<Position> findp = new ArrayList<>(16);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((this.Board[i][j]) == null) {
                    break;
                } else if (this.Board[i][j].getType() == piece) {
                    Position pos = new Position((char) (j + 97), (char) (56 - i));
                    findp.add(pos);
                }

            }
        }
        return findp;

    }

    /**
     * Moves pieces in the Board . Receives an origin Position and a destination
     * Position . If the destination Position contains a Piece , it will be
     * captured , placing in its square the piece that is being moved . For
     * simplicity , the correctness of the move ( according to the rules of the
     * game ) will not be checked . Nevertheless , the method will throw
     * exceptions if the origin position does not contain any pieces or if any
     * of the positions is not valid .
     *
     * @param origin Origin position of the piece that is being moved .
     * @param destination Destination position of the piece that is being moved
     * .
     */
    
    /*The components of the position are translated into coordinates of the array 
    to make the move() method more readable*/ 
    private int rowtoInt(Position p) {
        return (56 - (int) p.getRow());
    }

    private int columntoInt(Position p) {
        return ((int) p.getColumn() - 97);
    }
    public void move(Position origin, Position destination) {
        
        if ((Board[rowtoInt(origin)][columntoInt(origin)]) == null) {
            throw new IllegalArgumentException("There is no piece here.");
        } else {
                Board[rowtoInt(destination)][columntoInt(destination)]
                        = Board[rowtoInt(origin)][columntoInt(origin)];
                Board[rowtoInt(origin)][columntoInt(origin)] = null;
        }
    }

}
