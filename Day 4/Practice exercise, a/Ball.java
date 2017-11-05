/**
 * Purpose:     Parent class, representing a generic ball.
 *              Attributes contain info about current state of ball.
 *              Methods change current state of the ball. 
 *
 * Caveats:     Hard-coded input and no input validation. 
 *
 * @author Brienna Herold
 */
public class Ball {
    private int size;  // diameter, in inches
    private String location;  
    private String color;
    private double weight;  // in pounds

    /** Constructs a Ball object */
    public Ball() {
        size = 20;
        location = "somewhere";
        color = "black";
        weight = 10;
    }

    /** Moves the ball to passed location */
    public void move(String loc) {
        System.out.println("Running the Ball.move method");
        location = loc;
    }

    /** Changes the ball color */
    public void paint(String _color) {
        System.out.println("Running the Ball.paint method");
        color = _color;
    }

    /** Changes the diameter of the ball */
    public void resize(int inches) {
        System.out.println("Running the Ball.resize method");
        size = inches;
    }

    /** Changes the weight of the ball */
    public void changeWeight(double pounds) {
        System.out.println("Running the Ball.changeWeight method");
        weight = pounds;
    }
    
}