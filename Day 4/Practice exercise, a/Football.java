/**
 * Purpose:     Child class of Ball, representing a football.
 *              Attributes contain info about current state of ball.
 *              Methods change current state of the ball. 
 *
 * Caveats:     Hard-coded input and no input validation. 
 *
 * @author Brienna Herold
 */
public class Football extends Ball {
    private String location; 
    private String team; // current team who has the ball
    private boolean inPlay; 

    /** Constructs Football object */
    public Football() {
        location = "nowhere";
        team = "Buffalo Bills";
        inPlay = false;
    }

    /** Moves the ball to passed location */
    @Override
    public void move(String loc) {
        System.out.println("Running the Football.move method");
        
        if (!loc.equals("nowhere")) {
            location = loc;
        } else {
            System.out.println("Sorry, but your ball needs to be somewhere.");
        }
    }
    
    /** Changes which team currently has the ball */
    public void changeTeam(String name) {
        System.out.println("Running the Football.changeTeam method");
        team = name;
    }

    /** Changes whether ball is in play */
    public void play(boolean _inPlay) {
        System.out.println("Running the Football.play method");
        inPlay = _inPlay;
    }
}