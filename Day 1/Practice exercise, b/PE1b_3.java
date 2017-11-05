public class PE1b_3 {

    final static double PI = Math.PI; 

    public static void main(String[] args) {

        int diameter = 25;  // diameter of swimming pool, in feet
        double radius = diameter / 2.0;
        double poolArea = PI * Math.pow(radius, 2);

        // Calculation for swimming pool area
        System.out.println("The area of the pool is " +
        poolArea + " square feet");

    }

}