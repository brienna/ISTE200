import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.Serializable;

/**
 * Purpose:     Constructs Vehicle instance, assigning attributes based on user input.
 *
 * Caveats:     Assumes user enters valid values for model and color.
 *
 * @author Brienna Herold
 */
public abstract class Vehicle implements Vinfo, Serializable {

    transient Scanner scan;  // marked as transient to make object serializable
    private String model;
    private String color;
    private String type;
    private double cost;

    /** Constructs a Vehicle instance and sets attributes */
    public Vehicle(String type) {
        setVehIs(type);
        scan = new Scanner(System.in);
        askUserForInfo();
    }

    /** Prompts user to set attributes for the vehicle ordered */
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
                System.out.println("Invalid dollar amount, do not use $ in the entered cost." +
                    " Try again.");
                scan.nextLine();  // skip line to continue program
            }
        }
    }

    /**
        Prints menu and prompts user for choice
        @param choices the menu to print
        @param prompt the prompt to print
        @param errorMsg the message to print if an exception is thrown
        @return index of choice, if valid
    */
    protected int showMenu(String prompt, String[] choices) {
        int choice = 0;  // initialize to a choice out of range
        while (true) {
            // Show prompt and menu
            System.out.println(prompt);
            for (int i = 0; i < choices.length; i++) {
                System.out.println((i + 1) + ". " + choices[i]);
            }

            // Prompt user to input choice
            System.out.print("Choice: ");

            // Retrieve user's choice
            try {
                choice = scan.nextInt();
                // Return choice if within menu range
                if (choice > 0 && choice <= choices.length) {
                    return choice - 1;  // convert to 0-based index
                } else {
                    System.out.println("Please enter a number 1 through " + choices.length);
                }
            } catch (InputMismatchException ime) {
                System.out.println("Please enter a number.");
                scan.nextLine();
            } catch (Exception ex) {
                System.out.println("Unknown error: " + ex);
                scan.nextLine();
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

     /** Gets gas usage based on vehicle type */
     public abstract double gasMileage();

     /**
          Gets type of vehicle
          @return type
      */
     public String getVehIs() {
         return type;
     }

     /**
          Sets type of vehicle
          @return boolean indicating success
      */
      public boolean setVehIs(String type) {
          this.type = type;
          return true;
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
    @Override
    public String toString() {
        return String.format(getVehIs() + "\n%-8s%-10s%s\n%-8s%-10s%s\n%-8s%-10s$%.2f\n%-8s%-10s%.1f",
            "", "Model:", getModel(),
            "", "Color:", getColor(),
            "", "Cost:", getCost(),
            "", "MPG/GPH:", gasMileage());
    }

}
