import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * Purpose:     Entry point for vehicle ordering system. Accepts from user
 *              what kind of vehicle they want to purchase, a Car (C/c),
 *              a Truck (T/t), Boat (B/b), or Bicycle (K/k) calls the
 *              constructor for the vehicle requested, and prints out all orders.
 *
 * @author Brienna Herold
 */
public class Orders {

    private static String ORDERS_FILENAME = "VehicleOrders.dat";
    private static ArrayList<Vehicle> orders = new ArrayList<Vehicle>();
    private static Scanner scan = new Scanner(System.in);

    /**
     * Entry point for ordering system
     * @param args not used
     */
    public static void main(String[] args) {

        // Show GUI
        new OrdersScreen();

        // Add any previously saved orders
        readFile();

        // Loop for every new order user wants to enter
        while (true) {

            // Loop until user enters valid order
            boolean validInput = false;
            while (!validInput) {
                // Prompt user to enter order
                System.out.print("Do you want to order a Truck (T/t), Car (C/c)," +
                    " Boat (B/b), or Bicycle (K/k)? ");
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

        saveOrders();
        printOrders();
        System.out.println("\nThank you for using Brienna's Ordering System.\n");
    }

    /** Prints vehicle orders to text file */
    public static void printOrders() {
        try {
            // Open buffered stream (if file exists, it will be overwritten)
            PrintWriter out = new PrintWriter(
    				           new BufferedWriter(
    				           new FileWriter("VehicleOrders.txt")));

            // Print each vehicle order
            for (Vehicle vehicle : orders) {
                out.println();
                out.println(vehicle.toString());

                // Also print to Terminal for now
                System.out.println();
                System.out.println(vehicle.toString());
            }

            // Flush the buffer and close the stream
            out.flush();
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /** Saves orders to DAT file */
    public static void saveOrders() {
        try {
            // Open buffered stream
            File ordersFile = new File(ORDERS_FILENAME);
            FileOutputStream fos = new FileOutputStream(ordersFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            // Save each object
            for (Vehicle order : orders) {
                oos.writeObject(order);
            }

            // Flush the buffer and close the stream
            oos.flush();
            oos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /** Adds any previously saved orders */
    public static void readFile() {
        try {
            // Create File object representing file
            File ordersFile = new File(ORDERS_FILENAME);
            // If actual file exists, open input streams on it
            if (ordersFile.exists()) {  // prevents FileNotFoundException
                System.out.println("Some orders already exist.");
                FileInputStream fis = new FileInputStream(ordersFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);

                // While file contains objects, read object into ArrayList
                while (true) {
                    try {
                        System.out.println("Adding existing order...");
                        Vehicle order = (Vehicle) ois.readObject();
                        orders.add(order);
                    } catch (EOFException eof) {
                        System.out.println("End of file");
                        break;  // loop only breaks at end of file
                    }
                }

                ois.close();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
