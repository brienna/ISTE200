import java.util.Scanner;

/**
 * Purpose:     Calculates amount of tip to leave when purchasing
 *              a dinner in a restaurant.
 *              Usage: java TipCalculator bill percentage
 *              where bill is a double and percentage is an integer
 *
 * @author Brienna Herold
 */
public class TipCalculator {

    Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Verify there is enough data in the arguments
        if (args.length < 2) {
            System.out.println("Please input more data.");
            System.exit(0);
        }

        // Convert the arguments to numerics
        Double doubleObj;
        double bill = 0.00;
        Integer intObj;
        int percentage = 0;
        try {
            doubleObj = new Double(args[0]);
            bill = doubleObj.doubleValue(); // convert Double to double (unbox)
            intObj = new Integer(args[1]);
            percentage = intObj.intValue(); // convert Int to int (unbox)
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid value entered.");
            System.exit(0);
        }

        // Calculate and print the tip
        double tip = bill * (percentage / 100.0);
        System.out.println(String.format("The tip is $%.2f", tip));
    }

    // Note: In Java 5 or later, boxing is done automatically (autoboxing),
    // so you just need to check if Integer is null

}
