import java.util.Scanner;

/**
 * Purpose:     This program accepts two numbers via Scanner input
 *              and computes the hypotenuse of a right triangle using the 
 *              Pythaorean theorem:
 *              (a * a) + (b * b) = (c * c)
 *              where Scanner inputs a and b are the two shorter sides of the 
 *              triangle and c is the hypotenuse.
 *
 * Caveats:     Invalid values will throw an error. 
 *              All arguments will be ignored.
 *
 * @author      Brienna Herold
 */

public class Hypot1 {

    /**
     * Hypotenuse calculation execution starts here.
     */
    public static void main(String [] args) {
        double hypotenuse;
        double d1 = 0;
        double d2 = 0;

        // Prompt user to input lengths of sides a and b 
        System.out.println("Input lengths of the two shorter sides " +
            "of the triangle: ");

        // Get user input
        Scanner sc = new Scanner(System.in);
        d1 = sc.nextDouble();
        d2 = sc.nextDouble();

        // Exit if a side is nonexistent (measuring 0 in length)
        if (d1 == 0 || d2 == 0) {
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