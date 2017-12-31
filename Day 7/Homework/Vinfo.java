/**
 * Purpose:     Provides interface for vehicle classes,
 *              with constants all in one place for easy access.
 *
 * @author Brienna Herold
 */
public interface Vinfo {

    // Define Boat gas usage constants (gallons of gas per hour)
    public static final double BOAT_PONTOON_MPG = 3.5;
    public static final double BOAT_PWC_MPG = 2.2;
    public static final double BOAT_SAILBOAT_MPG = 0;
    // Define Car gas usage constants (mpg)
    public static final double CAR_SEDAN_MPG = 23.7;
    public static final double CAR_COUPE_MPG = 28.2;
    public static final double CAR_WAGON_MPG = 19.5;
    // Define Bicycle gas usage constant
    public static final double BICYCLE_MPG = 0.0;

    /** Gets gas usage based on vehicle type */
    public abstract double gasMileage();

}
