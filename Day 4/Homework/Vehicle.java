import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Purpose:     Constructs Vehicle instance, assigning attributes based on user input.
 *
 * Caveats:     Assumes user enters valid values for model and color.
 *
 * @author Brienna Herold
 */
public class Vehicle {

    private Scanner scan;
    protected String model;
    protected String color;
    protected double cost;

    /** Constructs a Vehicle instance and sets attributes */
    public Vehicle() {
        scan = new Scanner(System.in);
        askUserForInfo();
    }

    /** Prompts user to set attributes for the order */
    private void askUserForInfo() {
        System.out.println("Entering " + this.getClass().getName() + " order: ");

        // Prompt user for model
        System.out.print("Model: ");
        setModel(scan.nextLine().trim());

        // Prompt user for color
        System.out.print("Color: ");
        setColor(scan.nextLine().trim());

        // Prompt user for valid cost
        while (true) {
            try {
                System.out.print("Cost: ");
                setCost(scan.nextDouble());
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }
    }

    /**
        Prints menu and prompts user for choice
        @param choices the menu to print
        @param prompt the prompt to print
        @return index of choice, if valid
    */
    protected int showMenu(String prompt, String[] choices) {
        // Show prompt and menu
        System.out.println(prompt);
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i + 1) + ". " + choices[i]);
        }

        int choice = 0;  // initialize to a choice out of range
        while (true) {
            // Prompt user to input choice
            System.out.print("Choice: ");

            // Retrieve user's choice
            try {
                choice = scan.nextInt();
                // Return choice if within menu range
                if (choice > 0 && choice <= choices.length) {
                    return choice - 1; // convert to 0-based index
                } else {  // Otherwise notify user & loop again
                    System.out.println("Menu choice is out of range.");
                }
            } catch (InputMismatchException err) {
                // If user inputs anything other than a number, notify user & loop again
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();  // skip line to continue program
            }
        }
    }

    /**
        Tests if index is a valid index for a given String array
        @param index the index to test
        @param list the String array
        @return boolean indicating validity
     */
     protected boolean isValidIndex(int index, String[] list) {
         if (index >= 0 && index < list.length) {
             return true;
         } else {
             return false;
         }
     }

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
        Formats the String representation of the Vehicle instance
        @return the representation
    */
    public String toString() {
        return String.format("\n%-8s%-8s%s\n%-8s%-8s%s\n%-8s%-8s$%.2f",
            "", "Model:", getModel(),
            "", "Color:", getColor(),
            "", "Cost:", getCost());
    }
}
