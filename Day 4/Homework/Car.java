/**
 * Purpose:     Constructs Car instance, assigning attributes based on user input.
 *
 * Caveats:     None known.
 *
 * @author Brienna Herold
 */
public class Car extends Vehicle {

    private final String[] CAR_TYPES = new String[] {"Sedan", "Coupe", "Wagon"};
    private final String[] TOWING_PACKAGES = new String[] {"Included", "Not included"};
    private int type;  // index
    private int towing;  // index

    /** Constructs a Car instance and sets attributes */
    public Car() {
      super();
      // Prompt user for type and set it
      setType(super.showMenu("What type of car is this?", CAR_TYPES));
      // Prompt user for towing package and set it
      setTowing(super.showMenu("Does this car have a towing package?", TOWING_PACKAGES));
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
        Formats the String representation of the Car instance
        @return the representation
    */
    public String toString() {
        return String.format(this.getClass().getName() + super.toString() + "\n%-8s%-8s%s\n%-8s%-8s%s",
            "", "Type:", getType(),
            "", "Towing:", getTowing());
    }

}
