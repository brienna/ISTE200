import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Purpose:     Constructs Car instance, assigning attributes based on user input.
 *
 * Caveats:     Assumes user enters valid values for model and color.
 *          
 * @author Brienna Herold    
 */
public class Car {
    private final String[] CAR_TYPES = new String[] {"Sedan", "Coupe", "Wagon"};
    private final String[] TOWING_PACKAGES = new String[] {"Included", "Not included"};

    private Scanner scan;
    private String model;
    private String color;
    private double cost;
    private String type;
    private String towing;

    /** Constructs a Car instance, setting attributes via askUserForInfo */
    public Car() {
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

        // Prompt user for car type
        while (true) {
            System.out.println("What type of car is this?");
            for (int i = 0; i < CAR_TYPES.length; i++) {
                System.out.println((i + 1) + ". " + CAR_TYPES[i]);
            }
            System.out.print("Choice: ");
            int choice = -1;
            try {
                choice = scan.nextInt();
                // Break loop if choice is within range
                if (choice > 0 && choice <= CAR_TYPES.length) {
                    setType(CAR_TYPES[choice - 1]);
                    break;
                } else {
                    System.out.println("Menu choice is out of range.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }  // end while

        // Prompt user for car towing info
        while (true) {
            System.out.println("Does this car have a towing package?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Choice: ");

            int choice = -1; 
            try {
                choice = scan.nextInt();
                // Break loop if choice is within range
                if (choice > 0 && choice <= TOWING_PACKAGES.length) {
                    setTowing(TOWING_PACKAGES[choice - 1]);
                    break;
                } else {
                    System.out.println("Menu choice is out of range.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }  // end while loop
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
        Sets type
        @return boolean indicating success
    */
    public boolean setType(String _type) {
        for (int i = 0; i < CAR_TYPES.length; i++) {
            if (CAR_TYPES[i].equalsIgnoreCase(_type)) {
                type = _type;
                return true;
            }
        }
        return false;
    }

    /** 
        Gets type
        @return type
    */
    public String getType() {
        return type;
    }

    /** 
        Sets towing info
        @return boolean indicating success
    */
    public boolean setTowing(String _towing) {
        for (int i = 0; i < TOWING_PACKAGES.length; i++) {
            if (TOWING_PACKAGES[i].equalsIgnoreCase(_towing)) {
                towing = _towing;
                return true;
            }
        }
        return false;
    }

    /** 
        Gets towing info
        @return towing
    */
    public String getTowing() {
        return towing;
    }

    /** 
        Returns the formatted String representation of the Car instance
        @return the representation
    */
    public String toString() {
        return String.format("Car:\n\tModel: " + getModel() + "\n\tColor: " + getColor() +
            "\n\tCost: $%.2f" + "\n\tType: " + getType() + 
            "\n\tTowing: " + getTowing(), getCost());
    }

}