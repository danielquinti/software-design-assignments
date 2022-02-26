/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise3;

/**
 * Immutable class representing a position in a chessboard .
 */
public final class Position {

    private final char columnChar;
    private final char rowChar;

    /**
     * Creates a position from two coordinates of a chessboard .
     *
     * @param columnChar Column with values between a and h.
     * @param rowChar Row with values between 1 and 8.
     */
    public Position(char columnChar, char rowChar) {
        if (columnChar < 'a' || columnChar > 'h' || rowChar < '1' || rowChar > '8') {
            throw new IllegalArgumentException("Illegal argument: column or row out of bounds");
        } else {
            this.columnChar = columnChar;
            this.rowChar = rowChar;
        }
    }

    /**
     * Returns the value of the row .
     *
     * @return The row .
     */
    public char getRow() {
        return rowChar;
    }

    /**
     * Returns the value of the column .
     *
     * @return The column .
     */
    public char getColumn() {
        return columnChar;
    }
    
 
//The equals method needs to compare the rows and colums of the position
    
    @Override
    public boolean equals (Object position2) 
    {
        if (position2==null) return false;
        if (this.getClass()!=position2.getClass()) return false;
         final Position other= (Position) position2;
         return (this.rowChar == other.rowChar && this.columnChar == other.columnChar);
    }

//hashCode must be recalculated
    @Override
    public int hashCode() {
        return this.columnChar * 79 +this.rowChar;
    }

}