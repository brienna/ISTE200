/**
 * Truck.java
 *
 * Object representation of a truck
 *
 * @author John Carr - jxc9224@rit.edu
 */

public class Motorcycle extends Vehicle {
    private final String[] BUILD = { "Bulky", "Compact" };
    private final String[] TYPE = { "Leisure", "Sport" };

    private int type;
    private int build;

    public Motorcycle(String model, String color, double cost) {
        super(model, color, cost);
    }

    public int getType() {
        return this.type;
    }

    public int getBuild() {
        return this.build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        int type = this.getType();
        int build = this.getBuild();

        return "Boat:\r\n\tModel: " + this.getModel()
                + "\r\n\tColor: " + this.getColor()
                + "\r\n\tCost: $" + this.getCost()
                + "\r\n\tType: " + this.TYPE[type - 1]
                + "\r\n\tMade of: " + this.BUILD[build - 1];
    }
}
