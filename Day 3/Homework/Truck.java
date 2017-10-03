import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Purpose:     Constructs Truck instance, assigning attributes based on user input.
 *
 * Caveats:     Assumes user enters valid values for model and color.
 *          
 * @author Brienna Herold    
 */
public class Truck {
    private final String[] LOADS = new String[] {"Half-ton", "Full ton"};
    private final String[] ENGINES = new String[] {"4 cylinders or smaller", "5 cylinders or larger"};

    private Scanner scan;
    private String model;
    private String color;
    private double cost;
    private String load;
    private String engine;

    /** Constructs a Truck instance, setting attributes via askUserForInfo */
    public Truck() {
        scan = new Scanner(System.in);
        askUserForInfo();
    }

    /** Prompts user to set attributes for the order */
    private void askUserForInfo() {
        // Prompt user for model
        System.out.print("Model: ");
        setModel(scan.nextLine().trim());

        // Prompt user for color
        System.out.print("Color: ");
        setColor(scan.nextLine().trim());

        // Prompt user for cost
        while (true) {
            try {
                System.out.print("Cost: ");
                setCost(scan.nextDouble());
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }  // end while loop

        // Prompt user for truck load info
        while (true) {
            System.out.println("What size truck is this?");
            for (int i = 0; i < LOADS.length; i++) {
                System.out.println((i + 1) + ". " + LOADS[i]);
            }
            System.out.print("Choice: ");
            int choice = -1;
            try {
                choice = scan.nextInt();
                // Break loop if choice is within range
                if (choice > 0 && choice <= LOADS.length) {
                    setLoad(LOADS[choice - 1]);
                    break;
                } else {
                    System.out.println("Menu choice is out of range.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }  // end while

        // Prompt user for engine
        while (true) {
            System.out.println("What is the engine size of the truck?");
            for (int i = 0; i < ENGINES.length; i++) {
                System.out.println((i + 1) + ". " + ENGINES[i]);
            }
            System.out.print("Choice: ");
            int choice = -1;
            try {
                choice = scan.nextInt();
                // Break loop if choice is within range
                if (choice > 0 && choice <= ENGINES.length) {
                    setEngine(ENGINES[choice - 1]);
                    break;
                } else {
                    System.out.println("Menu choice is out of range.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }  // end while

    }  // end method askUserForInfo

    /** 
        Sets model
        @return boolean indicating success 
    */
    public boolean setModel(String model) {
        this.model = model;
        return true;
    }

    /** 
        Gets model
        @return model
    */
    public String getModel() {
        return model;
    }

    /** 
        Sets color
        @return boolean indicating success
    */
    public boolean setColor(String color) {
        this.color = color;
        return true;
    }

    /** 
        Gets color
        @return color
    */
    public String getColor() {
        return color;
    }

    /** 
        Sets cost
        @return boolean indicating success
    */    
    public boolean setCost(double cost) {
        this.cost = cost;
        return true;
    }

    /** 
        Gets cost
        @return cost
    */
    public double getCost() {
        return cost;
    }

    /** 
        Sets load
        @return boolean indicating success
    */    
    public boolean setLoad(String _load) {
        for (int i = 0; i < LOADS.length; i++) {
            if (LOADS[i].equalsIgnoreCase(_load)) {
                load = _load;
                return true;
            }
        }
        return false;
    }

    /** 
        Gets load
        @return load
    */
    public String getLoad() {
        return load;
    }

    /** 
        Sets engine size
        @return boolean indicating success
    */    
    public boolean setEngine(String _engine) {
        for (int i = 0; i < ENGINES.length; i++) {
            if (ENGINES[i].equalsIgnoreCase(_engine)) {
                engine = _engine;
                return true;
            }
        }
        return false;
    }

    /** 
        Gets engine size
        @return engine
    */
    public String getEngine() {
        return engine;
    }

    /** 
        Returns the formatted String representation of the Truck instance
        @return the representation
    */
    public String toString() {
        return String.format("Truck:\n\tModel: " + getModel() + "\n\tColor: " + getColor() +
            "\n\tCost: $%.2f" + "\n\tLoad: " + getLoad() + 
            "\n\tEngine: " + getEngine(), getCost());
    }
}