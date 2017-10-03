import java.util.Scanner;
import java.util.ArrayList;

/**
 * Purpose:     Entry point for vehicle ordering system. Accepts from user 
 *              what kind of vehicle they want to purchase, a Car (C/c) or 
 *              a Truck (T/t), and calls the constructor for the class requested. 
 *
 * Caveats:     None known.
 *
 * @author Brienna Herold
 */
public class Order {

    private static ArrayList<Object> orders = new ArrayList<Object>();
    private static Scanner scan = new Scanner(System.in);

    /** Entry point for ordering system */
    public static void main(String[] args) {
        System.out.println("Brienna's Ordering System.");

        // Loop for every order user wants to enter
        while (true) {

            // Loop until user enters valid order
            boolean validInput = false;
            while (!validInput) {
                // Prompt user to enter order
                System.out.print("Do you want to order a Truck (T/t) or Car (C/c)? ");
                String choice = scan.nextLine().trim();

                // Check if entered order is valid (truck or car)
                if (choice.equalsIgnoreCase("T")) {
                    Truck vehicle = new Truck();
                    orders.add(vehicle); 
                    validInput = true;  // valid input, can exit loop
                } else if (choice.equalsIgnoreCase("C")) {
                    Car vehicle = new Car();
                    orders.add(vehicle); 
                    validInput = true;  // valid input, can exit loop
                } else {
                    System.out.println("Invalid vehicle type.");
                }
            }  // end while loop

            // Break loop if user doesn't want to enter another order
            System.out.print("Do you want to order another vehicle? Enter y/n: ");
            if (scan.nextLine().equalsIgnoreCase("n")) {
                break;
            }

        }  // end while loop
        
        printOrders();
        System.out.println();
        System.out.println("Thank you for using Brienna's Ordering System.");
    }

    /** Prints details about each vehicle order */
    private static void printOrders() {
        for (Object vehicle : orders) {
            System.out.println();
            if (vehicle instanceof Car) {
                System.out.println(((Car) vehicle).toString());
            } else if (vehicle instanceof Truck) {
                System.out.println(((Truck) vehicle).toString());
            } else {
                System.out.println("Unknown vehicle type " + vehicle);
            }
        }
    }

}