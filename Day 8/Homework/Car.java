/**
 * Purpose:     Constructs Car instance, assigning attributes based on user input.
 *
 * @author Brienna Herold
 */
public class Car extends Vehicle {

    public final static String VEHICLE_IS = "Car";
    public final static String[] CAR_TYPES = new String[] {"Sedan", "Coupe", "Wagon"};
    public final static String[] TOWING_PACKAGES = new String[] {"Included", "Not included"};
    public final static String[] PROMPTS = new String[] {"What type of car is this?", "Does this car have a towing package?"};
    private int type;  // stores index
    private int towing;  // stores index

    /** Constructs a Car instance and sets attributes */
    public Car(int index1, int index2) {
      super(VEHICLE_IS);
      setType(index1);
      setTowing(index2);
    }

    /**
        Gets gas usage based on car type
        @return miles per gallon
    */
    @Override
    public double gasMileage() {
        double mpg;

        String typeStr = getType();
        switch (typeStr) {
            case "Sedan":
                mpg = CAR_SEDAN_MPG;
                break;
            case "Coupe":
                mpg = CAR_COUPE_MPG;
                break;
            case "Wagon":
                mpg = CAR_WAGON_MPG;
                break;
            default:
                mpg = 0.00;
                break;
        }

        // If towing is included, subtract 3 mpg
        if (getTowing().matches("Included")) {
            mpg -= 3;
        }

        return mpg;
    }

    /**
        Sets type index if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setType(int index) {
        if (isValidIndex(index, CAR_TYPES)) {
            type = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets type
        @return type
    */
    public String getType() {
        return CAR_TYPES[type];
    }

    /**
        Sets towing index if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setTowing(int index) {
        if (isValidIndex(index, TOWING_PACKAGES)) {
            towing = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets towing info
        @return towing
    */
    public String getTowing() {
        return TOWING_PACKAGES[towing];
    }

    /**
        Gets choices for all the prompts
        @return choices in 2D array, with each element being an array of choices
        corresponding to each question in PROMPTS
    */
    public static String[][] getPromptChoices() {
        String[][] choices = new String[][] {CAR_TYPES, TOWING_PACKAGES};
        return choices;
    }

    /**
        Formats the String representation of the Car instance
        @return the representation
    */
    @Override
    public String toString() {
        return String.format(super.toString() + "\n%-8s%-10s%s\n%-8s%-10s%s",
            "", "Type:", getType(),
            "", "Towing:", getTowing());
    }

}
