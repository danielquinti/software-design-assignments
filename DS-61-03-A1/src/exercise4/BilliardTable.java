/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise4;

import java.util.ArrayList;
import java.util.Arrays;

public class BilliardTable {
    private final ArrayList<BilliardBall> pocketed = new ArrayList<>(16);
    private final ArrayList<BilliardBall> table = new ArrayList<>(16);

    /**
    * Creates a billiard table with all the balls pocketed .
    */
    public BilliardTable ()
    {
        this.pocketed.addAll(Arrays.asList(BilliardBall.values()));
    }
    
    /**
    * Resets the billiard table with all the balls on the table .
    */
    //Placing all the balls in the table and removing them from the pocket
    public void startGame ()
    {
        this.table.addAll(this.pocketed);
        this.pocketed.removeAll(pocketed);
    }

    /**
    * If it is a regular ball (1 to 7 or 9 to 15) , the ball is removed from the
    * table and placed on the triangle rack with all the previously pocketed
    * balls , in the order they have been pocketed .
    *
    * If it is the cue ball , the ball is returned to the table ( unless the game is
    * over ).
    *
    * If it is the 8 ball , then the game is over .
    *
    * @param b Billiard ball that is pocketed .
    * @return The state of the game after the ball has been pocketed .
    * True if the game is still underway or False if it is not.
    * Only changes when the pocketed ball is the 8 ball , which
    * automatically means that the game is over .
    */
    public boolean pocketBall (BilliardBall b)
    {
       if ((b.getNumber() == 8))
         {
            this.pocketed.addAll(this.table);
            this.table.clear();
            return false;
         }
       if ((b.getNumber() == 0))
                return true;
       else
        {
            this.pocketed.add(b);
            this.table.remove(b);
            return true;
        }
    }

    /**
    * Returns an ArrayList with the balls that are still on the table .
    * @return An ArrayList with BilliardBall objects .
    */
    public ArrayList ballsOnTable ()
    {
        return this.table;
    }
    
    /**
    * Returns an ArrayList with the balls that have been pocketed in the table .
    * @return An ArrayList with BilliardBall objects .
    */
    public ArrayList sunkBalls ()
    {
        return this.pocketed;
    }

    /**
    * Checks if the game is still underway .
    * @return True if the game is still underway . False otherwise .
    */
    public boolean isGameUnderway ()
    {
     return !this.pocketed.contains(BilliardBall.BALL8);
    }
    
    /**
    * Indicates which player ( solids or stripes ) is winning .
    * Essentially , you are winning (or have won when the game is over ) if
    * fewer balls of your type remain on the table compared to the other player .
    * @return The enumerated value BallType . SOLID if the solids are winning ;
    * the enumerated value BallType . STRIPED if the stripes are winning ;
    * or the null value in the case of a tie .
    */
    public BilliardBall.BallType getWinner ()
    {      int i = 0;
           int j = 0;
           for (BilliardBall Ball : pocketed)
           {
            if (Ball.getBallType() == BilliardBall.BallType.SOLID)
            {i = i + 1;}
            else {j = j + 1;}
           }

           if (i > j) {return BilliardBall.BallType.SOLID;}
           else if (i == j){return null;}
           else {return BilliardBall.BallType.STRIPED;}

    }
}
