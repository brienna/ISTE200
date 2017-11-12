// TestPolygons.java: Demonstrate drawing polygons
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;
import javax.swing.*;

public class TestPolygons extends JFrame
{
  // Default constructor for TestPolygons
  public TestPolygons()
  {
    setTitle("Show Polygons");
    add(new PolygonsPane());
  }

  // Main method
  public static void main(String[] args)
  {
    TestPolygons myFrame = new TestPolygons();
    myFrame.setSize(200,250);
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 myFrame.setLocationRelativeTo(null);
    myFrame.setVisible(true);
  }
}

// Draw a polygon on the panel
class PolygonsPane extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
	 g.drawString("Java draws", 5, 15);

    // Create a Polygon object
    Polygon poly = new Polygon();

    // Add points to the polygon
    poly.addPoint(10, 30);
    poly.addPoint(60, 45);
    poly.addPoint(35, 55);
    poly.addPoint(90, 85);
    poly.addPoint(100, 155);
    poly.addPoint(50, 155);

    // Draw the polygon
    g.drawPolygon(poly);
  }
}
