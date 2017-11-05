import java.util.Scanner;

public class PE1b_4 {

    final static double PI = Math.PI; 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt user to input diameter of pool
        System.out.print("Input diameter of pool: ");
        int diameter = sc.nextInt();  

        // Calculate pool area
        double radius = diameter / 2.0;
        double poolArea = PI * Math.pow(radius, 2);

        // Prompt user to enter first and last name
        sc.nextLine(); // eat the previous line
        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();

        System.out.println("The area of the pool owned by " +
            firstName + " " + lastName + " is " +
            poolArea + " square feet");

    }
   
}