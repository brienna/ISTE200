import java.util.Scanner;

/**
 * Purpose:    Accepts a number from 0 to 40, inclusive, 
 *             and calculates and displays its factorial.  
 *             
 * Caveats:    Only accepts numbers from 0 to 40, inclusive.
 *             Only accepts y/n as affirmative/negative responses.
 *             Does not use good programming practice 
 *             with only a main routine. 
 *
 * @author:    Brienna Herold
 */
public class Factorial {

   /** Factorial execution starts and ends here. */
   public static void main(String[] args) {

      while (true) {
         Scanner sc = new Scanner(System.in);
      
         int num;
         while (true) {
            // Prompt user for input
            System.out.print("Enter a number from 0 to 40, inclusive: ");
            // If user enters invalid number, throw error
            if (!sc.hasNextInt()) {
               System.out.println("Invalid input");
               sc.nextLine();
            } else {  // Otherwise get number
               num = sc.nextInt();
               // If number is within bounds, use it
               if (num >= 0 && num <= 40) {
                  break; 
               } else {
                  System.out.println("Out of bounds.");
               }
            }
         }  
         
         // Calculate the factorial 
         int factorial = 1;
         for (int i = 1; i <= num; i++) {
            factorial *= i;
         }

         // Display factorial
         System.out.println("The factorial for " + num + " is " + factorial);
         sc.nextLine(); // eats line

         // Loop entire program if user wants to enter another number
         System.out.print("Do you want to enter another number? Enter y/n: ");
         if (!sc.nextLine().equals("y")) {
            break;  
         }
      }  // end while loop

   }  // end main()

}  // end class Factorial
