/**
 * Purpose:     Constructs Bicycle instance, assigning attributes based on user input.
 *
 * @author Brienna Herold
 */
public class Bicycle extends Vehicle {

    public final static String VEHICLE_IS = "Bicycle";
    public final static String[] FUNCTIONS = new String[] {"mountain", "road", "hybrid", "cruise", "other"};
    public final static String[] MATERIALS = new String[] {"carbon fiber", "aluminum", "steel", "other"};
    public final static String[] PROMPTS = new String[] {"What is the bicycle's function?", "What is the bicycle made of?"};
    private int function;  // stores index
    private int material;  // stores index

    /** Constructs a Bicycle instance and sets attributes */
    public Bicycle() {
        super(VEHICLE_IS);
        // Prompt user for function and set it
        showMenu(PROMPTS[0], FUNCTIONS);
        // Prompt user for material and set it
        showMenu(PROMPTS[1], MATERIALS);
    }

    /**
        Gets gas usage
        @return bicycle mpg
    */
    @Override
    public double gasMileage() {
        return BICYCLE_MPG;
    }

    /**
        Gets bicycle function
        @return bicycle function
    */
    public String getFunction() {
        return FUNCTIONS[function];
    }

    /**
        Sets index of bicycle function if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setFunction(int index) {
        if (isValidIndex(index, FUNCTIONS)) {
            function = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets bicycle material
        @return bicycle material
    */
    public String getMaterial() {
        return MATERIALS[material];
    }

    /**
        Sets index of bicycle material if valid
        @param index the index
        @return boolean indicating success
    */
    public boolean setMaterial(int index) {
        if (isValidIndex(index, MATERIALS)) {
            material = index;
            return true;
        } else {
            return false;
        }
    }

    /**
        Gets choices for all the prompts
        @return choices in 2D array, with each element being an array of choices
        corresponding to each question in PROMPTS
    */
    public static String[][] getPromptChoices() {
        String[][] choices = new String[][] {FUNCTIONS, MATERIALS};
        return choices;
    }

    /**
        Formats the String representation of the Bicycle instance
        @return the representation
    */
    @Override
    public String toString() {
        return String.format(super.toString() + "\n%-8s%-10s%s\n%-8s%-10s%s",
            "", "Function:", getFunction(),
            "", "Material:", getMaterial());
    }

}
