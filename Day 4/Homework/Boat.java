/**
 * Purpose:     Constructs Boat instance, assigning attributes based on user input.
 *
 * Caveats:     None known.
 *
 * @author Brienna Herold
 */
public class Boat extends Vehicle {

    private final String[] BOAT_TYPES = new String[] {"Pontoon", "PWC", "Sailboat"};
    private final String[] CONSTRUCTIONS = new String[] {"Wood", "Fiberglass", "Steel"};
    private int type;  // index
    private int construction;  // index

    /** Constructs a Boat instance and sets attributes */
    public Boat() {
        super();
        // Prompt user for boat type and set it
        setBoatType(super.showMenu("What type of boat is this?", BOAT_TYPES));
        // Prompt user for construction and set it
        setConstruction(super.showMenu("What is the boat's construction?", CONSTRUCTIONS));
    }

    /**
        Sets index of boat type if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setBoatType(int index) {
        if (isValidIndex(index, BOAT_TYPES)) {
            type = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets boat type
        @return boat type
    */
    public String getBoatType() {
        return BOAT_TYPES[type];
    }

    /**
        Sets index of construction if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setConstruction(int index) {
        if (isValidIndex(index, CONSTRUCTIONS)) {
            construction = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets construction
        @return construction
    */
    public String getConstruction() {
        return CONSTRUCTIONS[construction];
    }

    /**
        Formats String representation of the Boat instance
        @return the representation
    */
    public String toString() {
        return String.format(this.getClass().getName() + super.toString() + "\n%-8s%-8s%s\n%-8s%-8s%s",
        "", "Type:", getBoatType(),
        "", "Made of:", getConstruction());
    }

}
