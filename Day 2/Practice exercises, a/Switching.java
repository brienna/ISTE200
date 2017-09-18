import java.util.Scanner;

/**
 * Purpose:    Accepts one integer number
 *             and displays what it was. 
 *             
 * Caveats:    Throws error if a non-integer number is entered.
 *             Does not use good programming practice with only 
 *             a main routine. 
 *
 * @author:    Brienna Herold
 */
public class Switching {

   /** Switching execution starts and ends here. */
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
      
      // Display what the number was
      switch (num) {
         case 0:
            System.out.println("Number is zero");
            break;
         case 1:
            System.out.println("Number is one");
            break;
         case 2: 
            System.out.println("Number is two");
            break;
         case 3:
            System.out.println("Number is three");
            break;
         default: 
            System.out.println("Number is negative or greater than three");
            break;
      }

   }  // end main()

}  // end class Switching