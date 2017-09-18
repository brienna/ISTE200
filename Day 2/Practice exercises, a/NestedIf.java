import java.util.Scanner;

/**
 * Purpose:    Accepts an integer number and then 
 *             displays information about the number.
 * 
 * Caveats:    Throws error if a non-integer number is entered. 
 *             Does not use good programming practice 
 *             with only a main routine. 
 *
 * @author:    Brienna Herold
 */
public class NestedIf {

   /** NestedIf execution starts and ends here. */
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);

      int num;
      while (true) {
         // Prompt user to enter number
         System.out.print("Enter an integer: ");
         // If user enters invalid number, throw error
         if (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            sc.nextLine();
         } else {  // Otherwise get user input
            num = sc.nextInt();
            break;
         }
      }
      
      // Display info about the number
      if (num >= 0) {
         System.out.println("Your number is positive");
         if (num % 4 == 0) {
            System.out.println("Your number is evenly divisible by 4");
         } else {
            System.out.println("Your number is not evenly divisible by 4");
         }
      } else {
         System.out.println("Your number is negative");
         if (num % 2 == 0) {
            System.out.println("Your number is even");
         } else {
            System.out.println("Your number is odd");
         }
      }

   }  // end main()

}  // end class NestedIf