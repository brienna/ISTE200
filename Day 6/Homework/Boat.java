/**
 * Purpose:     Constructs Boat instance, assigning attributes based on user input.
 *
 * Caveats:     None known.
 *
 * @author Brienna Herold
 */
public class Boat extends Vehicle {

    private final static String VEHICLE_IS = "Boat";
    private final static String[] BOAT_TYPES = new String[] {"Pontoon", "PWC", "Sailboat"};
    private final static String[] CONSTRUCTIONS = new String[] {"Wood", "Fiberglass", "Steel"};
    private int type;  // stores index
    private int construction;  // stores index

    /** Constructs a Boat instance and sets attributes */
    public Boat() {
        super(VEHICLE_IS);
        // Prompt user for boat type and set it
        setBoatType(super.showMenu("What type of boat is this?", BOAT_TYPES));
        // Prompt user for construction and set it
        setConstruction(super.showMenu("What is the boat's construction?", CONSTRUCTIONS));
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
