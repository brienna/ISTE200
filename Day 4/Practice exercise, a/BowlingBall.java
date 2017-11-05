import java.util.ArrayList;

/**
 * Purpose:     Child class of Ball, representing a bowling ball.
 *              Attributes contain info about current state of ball.
 *              Methods change current state of the ball. 
 *
 * Caveats:     Hard-coded input and no input validation. 
 *
 * @author Brienna Herold
 */
public class BowlingBall extends Ball {
    private String location;  
    private String owner;
    private String alley;

    /** Constructs BowlingBall object */
    public BowlingBall() {
        location = "nowhere";
        owner = "no one";
        alley = "nonexistent";
    }

    /** Moves the ball to passed location */
    @Override
    public void move(String loc) {
        System.out.println("Running the BowlingBall.move method");

        // Assemble list of valid locations
        ArrayList<String> locations = new ArrayList<String>();
        locations.add("gutter");
        locations.add("rack");
        locations.add("return");
        locations.add("lane");
        locations.add("pit");

        // Accept passed location if valid
        if (locations.contains(loc)) {
            location = loc;
        } else {
            System.out.println("Sorry, that location is invalid.");
        }
    }

    /** Changes ball owner */
    public void changeOwner(String name) {
        System.out.println("Running the BowlingBall.changeOwner method");
        owner = name;
    }

    /** Changes alley that ball belongs to */
    public void changeAlley(String _alley) {
        System.out.println("Running the BowlingBall.changeAlley method");
        alley = _alley;
    }


}