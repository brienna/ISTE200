import java.util.Scanner;
import java.util.ArrayList;

/**
 * Purpose:     Entry point for vehicle ordering system. Accepts from user
 *              what kind of vehicle they want to purchase, a Car (C/c),
 *              a Truck (T/t), Boat (B/b), or Bicycle (K/k) calls the
 *              constructor for the vehicle requested, and prints out all orders.
 *
 * Caveats:     None known.
 *
 * @author Brienna Herold
 */
public class Order {

    private static ArrayList<Vehicle> orders = new ArrayList<Vehicle>();
    private static Scanner scan = new Scanner(System.in);

    /** Entry point for ordering system */
    public static void main(String[] args) {
        System.out.println("\nBrienna Herold");
        System.out.println("Java for Programmers ISTE-200 2017-Fall");
        System.out.println("Homework 5\n");

        // Loop for every order user wants to enter
        while (true) {

            // Loop until user enters valid order
            boolean validInput = false;
            while (!validInput) {
                // Prompt user to enter order
                System.out.print("Do you want to order a Truck (T/t), Car (C/c)," +
                    " Boat (B/b), Bicycle (K/k), Motorcycle (M/m), or" +
                    " Hot Air Balloon (H/h)? ");
                String choice = scan.nextLine().trim().toUpperCase();

                // Check if entered order is valid (truck or car)
                switch (choice) {
                    case "T":
                        Truck truck = new Truck();
                        orders.add(truck);
                        validInput = true;  // valid input, can exit loop
                        break;
                    case "C":
                        Car car = new Car();
                        orders.add(car);
                        validInput = true;
                        break;
                    case "B":
                        Boat boat = new Boat();
                        orders.add(boat);
                        validInput = true;
                        break;
                    case "K":
                        Bicycle bicycle = new Bicycle();
                        orders.add(bicycle);
                        validInput = true;
                        break;
                    /* other students' classes, both don't work,
                       please see writeup.txt
                    case "H":
                        HotAirBalloon hotAirBalloon = new HotAirBalloon();
                        orders.add(hotAirBalloon);
                        validInput = true;
                        break;
                    case "M":
                        Motorcycle motorcycle = new Motorcycle();
                        orders.add(motorcycle);
                        validInput = true;
                        break;
                    */
                    default:
                        System.out.println("Invalid vehicle type.");
                }
            }  // end inner while loop

            // Break loop if user doesn't want to enter another order
            System.out.print("\nDo you want to order another vehicle? Enter y/n: ");
            if (scan.nextLine().equalsIgnoreCase("n")) {
                break;
            }

        }  // end outer while loop

        printOrders();
        System.out.println("\nThank you for using Brienna's Ordering System.\n");
    }

    /** Prints details about each vehicle order */
    private static void printOrders() {
        for (Vehicle vehicle : orders) {
            System.out.println();
            System.out.println(vehicle.toString());
        }
    }

}
