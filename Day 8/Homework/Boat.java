/**
 * Purpose:     Constructs Boat instance, assigning attributes based on user input.
 *
 * @author Brienna Herold
 */
public class Boat extends Vehicle {

    public final static String VEHICLE_IS = "Boat";
    public final static String[] BOAT_TYPES = new String[] {"Pontoon", "PWC", "Sailboat"};
    public final static String[] CONSTRUCTIONS = new String[] {"Wood", "Fiberglass", "Steel"};
    public final static String[] PROMPTS = new String[] {"What type of boat is this?", "What is the boat's construction?"};
    private int type;  // stores index
    private int construction;  // stores index

    /** Constructs a Boat instance and sets attributes */
    public Boat(int index1, int index2) {
        super(VEHICLE_IS);
        setBoatType(index1);
        // Prompt user for construction and set it
        setConstruction(index2);
    }

    /**
        Gets gas usage based on boat type
        @return gallons per hour
    */
    @Override
    public double gasMileage() {
        String typeStr = getBoatType();
        switch (typeStr) {
            case "Pontoon":
                return BOAT_PONTOON_MPG;
            case "PWC":
                return BOAT_PWC_MPG;
            case "Sailboat":
                return BOAT_SAILBOAT_MPG;
            default:
                return 0.00;
        }
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
        Gets choices for all the prompts
        @return choices in 2D array, with each element being an array of choices
        corresponding to each question in PROMPTS
    */
    public static String[][] getPromptChoices() {
        String[][] choices = new String[][] {BOAT_TYPES, CONSTRUCTIONS};
        return choices;
    }

    /**
        Formats String representation of the Boat instance
        @return the representation
    */
    @Override
    public String toString() {
        return String.format(super.toString() + "\n%-8s%-10s%s\n%-8s%-10s%s",
            "", "Type:", getBoatType(),
            "", "Made of:", getConstruction());
    }

}
