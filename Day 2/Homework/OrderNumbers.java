import java.util.Scanner;

/**
 * Purpose:     This program accepts three numbers from the user and 
 *              sorts and prints the numbers in ascending numerical order. 
 *
 * Caveats:     No restrictions or errors known.
 *
 * @author:     Brienna Herold
 */
public class OrderNumbers {

    /** OrderNumbers execution starts and ends here. */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Ordering 3 whole numbers, by Brienna");

        // Declare and initialize all variables
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int temp = 0;  // for sorting numbers
        int pointer = 1;  // for keeping track of user input

        // Prompt user to input numbers while checking validity
        while (true) {
            // If user has entered 3 valid numbers, break loop
            if (pointer > 3) {
                break;
            }

            // Prompt user to input a number
            System.out.print("Enter number: ");

            // If input is invalid, notify user
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input.");
            } else {
                // Otherwise assign input to appropriate variable
                if (pointer == 1) {
                    num1 = scan.nextInt();
                } else if (pointer == 2) {
                    num2 = scan.nextInt();
                } else if (pointer == 3) {
                    num3 = scan.nextInt();
                } 
                pointer++;
            }
            scan.nextLine();  // eats line
        }
        
        // Sort numbers in ascending order
        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        } 
        if (num2 > num3) {
            temp = num2; 
            num2 = num3;
            num3 = temp;
        }
        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        // Print the ordered numbers
        System.out.println("Ordered numbers are: " + num1 + ", " + 
            num2 + ", " + num3);

    }

 }