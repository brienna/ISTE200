import java.util.Scanner;

/**
 * Purpose:    Accepts one integer number and displays 
 *             information about the number. 
 *             
 * Caveats:    Throws error if a non-integer number is entered.
 *             Does not recognize numbers equal to 0, 10, 20, 30, or 40. 
 *             Does not use good programming practice 
 *             with only a main routine. 
 *
 * @author:    Brienna Herold
 */
public class Range {

   /** Range execution starts and ends here */
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

      // Display information about the number
      if (num < 0) {
         System.out.println("The number is less than zero");
      } else if (num > 0 && num < 10) {
         System.out.println("The number is greater than 0 and less than 10");
      } else if (num > 10 && num < 20) {
         System.out.println("The number is greater than 10 and less than 20");
      } else if (num > 20 && num < 30) {
         System.out.println("The number is greater than 20 and less than 30");
      } else if (num > 30 && num < 40) {
         System.out.println("The number is greater than 30 and less than 40");
      } else if (num > 40) {
         System.out.println("The number is greater than 40");
      }

   }  // end main()

}  // end class Range