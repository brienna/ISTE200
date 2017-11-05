import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Purpose:     Accepts credits and letter grades for 4 courses,
 *              calculates and prints the sum of the credits, the sum 
 *              of the grade points, and the GPA for all 4 courses.
 *
 * Caveats:     Throws error if credits is not an integer, or if grade 
 *              is not of value A, B, C, D, or F (upper or lower case).
 *              Assumes that credits is between 0 and 9, inclusive.
 *
 * @author:     Brienna Herold
 */
public class GpaCalculator {

    final static int NUMBER_OF_COURSES = 4;
    
    /** GpaCalculator execution starts and ends here. */
    public static void main(String[] args) {
        Scanner scannr = new Scanner(System.in);
        int[] credits = new int[NUMBER_OF_COURSES];
        String[] grades = new String[NUMBER_OF_COURSES]; 

        // For each course
        for (int i = 0; i < NUMBER_OF_COURSES; i++) {
            // Prompt user to enter valid number of credits
            System.out.print("Enter credits for course " + (i+1) + ": ");
            try {
                credits[i] = scannr.nextInt();
            } catch (InputMismatchException err) {
                System.out.println("Invalid input. Please enter an integer.");
                System.exit(1);
            }

            // Prompt user to enter valid grade
            System.out.print("Enter grade for course " + (i+1) + ": ");
            try {
                grades[i] = scannr.next("[AaBbCcDdFf]$");
            } catch (Exception err) {
                System.out.println(err);
                System.out.println("Invalid input. Please enter a letter " +
                    "of value A, B, C, D, or F.");
                System.exit(1);
            }
        }
        
        // Calculate sum of the credits
        int totalCredits = 0;
        for (int cr : credits) {
            totalCredits += cr;
        }

        // Calculate sum of grade points
        int totalPoints = 0;
        for (int i = 0; i < grades.length; i++) {
            switch (grades[i]) {
                case "A":
                    totalPoints += 4 * credits[i];
                    break;
                case "B": 
                    totalPoints += 3 * credits[i];
                    break;
                case "C":
                    totalPoints += 2 * credits[i];
                    break;
                case "D":
                    totalPoints += 1 * credits[i];
                    break;
            }
        }

        // Calculate GPA
        double gpa = 0; 
        try {
            gpa = (double) totalPoints / totalCredits;
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // Display sum of credits, sum of grade points, and GPA
        System.out.println("Total number of credits: " + totalCredits);
        System.out.println("Total number of points: " + totalPoints);
        System.out.printf("GPA: %.2f", gpa);
        System.out.println();

    }  // end main()

}  // end class GpaCalculator
