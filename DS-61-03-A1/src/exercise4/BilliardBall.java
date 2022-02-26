/*Author 1: Daniel Quintillán (daniel.quintillan)*/
/*Author 2: Hilda Romero (h.rvelo)*/
package exercise4;

import static exercise4.BilliardBall.BallType.SOLID;
import static exercise4.BilliardBall.BallType.STRIPED;

//The enum BilliardBall contains all the balls with their respective number, color and type

public enum BilliardBall {
        CUEBALL(0,"WHITE", SOLID),
        BALL1(1,"YELLOW", SOLID),
        BALL2(2,"BLUE", SOLID),
        BALL3(3,"RED", SOLID),
        BALL4(4,"PURPLE", SOLID),
        BALL5(5,"ORANGE", SOLID),
        BALL6(6,"GREEN", SOLID),
        BALL7(7,"MAROON", SOLID),
        BALL8(8,"BLACK", SOLID),
        BALL9(9,"YELLOW", STRIPED),
        BALL10(10,"BLUE", STRIPED),
        BALL11(11,"RED", STRIPED),
        BALL12(12,"PURPLE", STRIPED),
        BALL13(13,"ORANGE", STRIPED),
        BALL14(14,"GREEN", STRIPED),
        BALL15(15,"MAROON", STRIPED);
    
        public enum BallType{STRIPED, SOLID}
        
        
        private final int number;
        private final String BallColor;
        private final BallType BallType;
        
        BilliardBall(int number, String BallColor, BallType Balltype){
            this.number = number;
            this.BallColor = BallColor;
            this.BallType = Balltype;
        }  
        
        public int getNumber(){
            return number;
        }
        
        public String getBallColor(){
            return BallColor;
        }
        
        public BallType getBallType(){
            return BallType;
        }
}
