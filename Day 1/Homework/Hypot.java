/**
 * Purpose:     This program accepts two numbers as command line arguments
 *              and computes the hypotenuse of a right triangle using the 
 *              Pythaorean theorem:
 *              (a * a) + (b * b) = (c * c)
 *              where arguments a and b are the two shorter sides of the 
 *              triangle and c is the hypotenuse.
 *
 * Caveats:     Invalid values will throw an error. If more than 2 
 *              arguments are entered, all arguments after the second 
 *              will be ignored. 
 *
 * @author      Brienna Herold
 */

public class Hypot {

    /**
     * Hypotenuse calculation execution starts here.
     *
     * @param args — Will calculate length of side c of the triangle 
     * knowing sides a and b, where a and b are taken from args[0] and args[1]
     */
    public static void main(String [] args) {
        double hypotenuse;
        double d1 = 0;
        double d2 = 0;

        // Verify that two arguments were entered on the command line
        if (args.length != 2) {
            System.out.println("You need to enter two args.");
            System.exit(1);
        }

        // Try to convert the two argument strings to doubles,
        // assuming that they are really numbers
        try {
            d1 = Double.parseDouble(args[0]);
            d2 = Double.parseDouble(args[1]);
        } // Catch the error if non numbers were entered & exit
        catch(NumberFormatException nfe) {
            System.out.println("Arguments need to be numbers.");
            System.exit(2);
        }

        // Exit if a side is nonexistent (measuring 0 in length)
        if (d1 == 0.0 || d2 == 0.0) {
            System.out.println("You entered " + d1 + " and " + d2);
            System.out.println("You can't have a triangle with a side of 0 length.");
            System.exit(1);
        }

        // Calculate the hypotenuse length and print info
        hypotenuse = Math.sqrt(((d1*d1)+(d2*d2)));
        System.out.print("The hypotenuse of a right triangle with sides of ");
        System.out.println(d1 + " and " + d2);
        System.out.println(" is " + hypotenuse);

    }  // end main()

} // end class Hypot