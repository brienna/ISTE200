import java.util.Scanner;

/**
 * Purpose:     Calculates the population standard deviation 
 *              of N number of values, with N and the values 
 *              given by the user on prompt. 
 * 
 * Caveats:     No validity check when user enters values.
 *
 * @author      Brienna Herold
 */
public class Stdev {
    private static int count;
    private static int[] numbers;
    private static double answer;

    /** Stdev execution starts here
        Calls the function to get user values, 
        and then the function to calculate stdev. 
     */
    public static void main(String[] args) {

        getUserValues();
        calculateStdev();
        System.out.print("The standard deviation of the numbers ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println("is " + answer);

    }  // end main()

    /** Method that gets N number of values and the values. */
    public static void getUserValues() {

        Scanner scan = new Scanner(System.in);

        // Prompt user to enter N
        while (true) {
            System.out.print("Enter the count of numbers for " +
                "which you want to calculate a standard deviation: ");
            if (!scan.hasNextInt()) {
                System.out.println("Invalid input");
                scan.nextLine(); // eats previous line to avoid infinite loop
            } else {
                count = scan.nextInt();
                // Initialize numbers array to be of N length
                numbers = new int[count];
                break;
            }
        }

        // Prompt user to enter N number of values
        System.out.println("You will be asked to enter " + count + " values.");
        scan.nextLine();  // eats previous line
        for (int i = 0; i < count; i++) {
            System.out.print("Enter a value: ");
            numbers[i] = scan.nextInt();
        }

    }  // end getUserValues()

    /**
     * Method that calculates the standard deviation.
     */
    public static void calculateStdev() {

        // Calculate mean
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        double mean = total / numbers.length;

        // Calculate sum of squared differences
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += Math.pow(numbers[i] - mean, 2);
        }

        // Divide by N
        answer = Math.sqrt(sum/count);

    }  // end calculateStdev()

}  // end class Stdev