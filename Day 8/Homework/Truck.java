/**
 * Purpose:     Constructs Truck instance, assigning attributes based on user input.
 *
 * @author Brienna Herold
 */
public class Truck extends Vehicle {

    public final static String VEHICLE_IS = "Truck";
    public final static String[] LOADS = new String[] {"Half-ton", "Full ton"};
    public final static String[] ENGINES = new String[] {"4 cylinders or smaller", "5 cylinders or larger"};
    public final static String[] PROMPTS = new String[] {"What size truck is this?", "What is the engine size of the truck?"};
    private int load;  // stores index
    private int engine;  // stores index

    /** Constructs a Truck instance and sets attributes */
    public Truck(int index1, int index2) {
        super(VEHICLE_IS);
        setLoad(index1);
        setEngine(index2);
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
        Gets choices for all the prompts
        @return choices in 2D array, with each element being an array of choices
        corresponding to each question in PROMPTS
    */
    public static String[][] getPromptChoices() {
        String[][] choices = new String[][] {LOADS, ENGINES};
        return choices;
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
