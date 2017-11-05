/**
 * Purpose:     Demonstrate polymorphism by creating a variable for
 *              a parent class, assigning a child object to it, and
 *              calling the child object's methods. 
 *
 *              Overriden methods will be called. The methods that 
 *              aren't overriden will not be found by the compiler.
 *
 * @author Brienna Herold
 */
public class BallTest {

    /** BallTest execution starts here */
    public static void main(String[] args) {
        // Create a ball reference variable
        Ball ball;

        // Assign a Football object to the Ball reference variable
        ball = new Football();
        // Call the Football class methods
        ball.move("somewhere");
        // ball.changeTeam("Packers");  // won't work
        // ball.play(true);  // won't work

        // Assign a BowlingBall object to the Ball reference variable
        ball = new BowlingBall();
        // Call the BowlingBall class methods
        ball.move("anywhere");
        // ball.changeOwner("John Smith");  // won't work
        // ball.changeAlley("Comet Bowling");  // won't work

        ball = new Ball();
        ball.move("nowhere");
        ball.paint("red");
        ball.resize(49);
        ball.changeWeight(38.43);
    }

}