/**
 * Purpose:     Constructs Truck instance, assigning attributes based on user input.
 *
 * Caveats:     None known.
 *
 * @author Brienna Herold
 */
public class Truck extends Vehicle {

    private final static String VEHICLE_IS = "Truck";
    private final static String[] LOADS = new String[] {"Half-ton", "Full ton"};
    private final static String[] ENGINES = new String[] {"4 cylinders or smaller", "5 cylinders or larger"};
    private int load;  // stores index
    private int engine;  // stores index

    /** Constructs a Truck instance and sets attributes */
    public Truck() {
        super(VEHICLE_IS);
        // Prompt user for load and set it
        setLoad(super.showMenu("What size truck is this?", LOADS));
        // Prompt user for engine and set it
        setEngine(super.showMenu("What is the engine size of the truck?", ENGINES));
    }

    /**
        Gets gas usage based on car type
        @return miles per gallon
    */
    @Override
    public double gasMileage() {
        return 50 - (Math.sqrt(getCost()) / 10.0 );
    }

    /**
        Sets index of load if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setLoad(int index) {
        if (isValidIndex(index, LOADS)) {
            load = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets load
        @return load
    */
    public String getLoad() {
        return LOADS[load];
    }

    /**
        Sets index of engine size if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setEngine(int index) {
        if (isValidIndex(index, ENGINES)) {
            engine = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets engine size
        @return engine
    */
    public String getEngine() {
        return ENGINES[engine];
    }

    /**
        Formats the String representation of the Truck instance
        @return the representation
    */
    @Override
    public String toString() {
        return String.format(super.toString() + "\n%-8s%-10s%s\n%-8s%-10s%s",
            "", "Load:", getLoad(),
            "", "Engine:", getEngine());
    }

}
