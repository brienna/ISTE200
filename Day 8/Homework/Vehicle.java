import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.Serializable;

/**
 * Purpose:     Constructs Vehicle instance, assigning attributes based on user input.
 *
 * Caveats:     Assumes user enters semantically valid values for model and color.
 *
 * @author Brienna Herold
 */
public abstract class Vehicle implements Vinfo, Serializable {

    transient Scanner scan;  // marked as transient to make object serializable
    private String model;
    private String color;
    private String type;
    private double cost;

    /** Constructs a Vehicle instance and sets attributes */
    public Vehicle(String type) {
        setVehIs(type);
        scan = new Scanner(System.in);
    }

    /**
        Tests if index is a valid index for a given String array
        @param index the index to test
        @param list the String array
        @return boolean indicating validity
     */
     protected boolean isValidIndex(int index, String[] list) {
         if (index >= 0 && index < list.length) {
             return true;
         } else {
             return false;
         }
     }

     /** Gets gas usage based on vehicle type */
     public abstract double gasMileage();

     /**
          Sets type of vehicle
          @return boolean indicating success
      */
      public boolean setVehIs(String type) {
          this.type = type;
          return true;
      }

     /**
          Gets type of vehicle
          @return type
      */
     public String getVehIs() {
         return type;
     }

   /**
        Sets model
        @return boolean indicating success
    */
    public boolean setModel(String model) {
        this.model = model;
        return true;
    }

    /**
        Gets model
        @return model
    */
    public String getModel() {
        return model;
    }

    /**
        Sets color
        @return boolean indicating success
    */
    public boolean setColor(String color) {
        this.color = color;
        return true;
    }

    /**
        Gets color
        @return color
    */
    public String getColor() {
        return color;
    }

    /**
        Sets cost
        @return boolean indicating success
    */
    public boolean setCost(double cost) {
        this.cost = cost;
        return true;
    }

    /**
        Gets cost
        @return cost
    */
    public double getCost() {
        return cost;
    }

    /**
        Formats the String representation of the Vehicle instance
        @return the representation
    */
    @Override
    public String toString() {
        return String.format(getVehIs() + "\n%-8s%-10s%s\n%-8s%-10s%s\n%-8s%-10s$%.2f\n%-8s%-10s%.1f",
            "", "Model:", getModel(),
            "", "Color:", getColor(),
            "", "Cost:", getCost(),
            "", "MPG/GPH:", gasMileage());
    }

}
