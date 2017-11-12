import java.awt.*;
import javax.swing.*;

/**
 * Draws a simple 5-pointed star using the formula for a circle:
 * (x,y) = (cos(t),sin(t))
 */
public class StarGraphic {
    private JFrame frame;
    private int height;
    private int width;
    private int sides;
    private int centerX;
    private int centerY;

    public StarGraphic() {
        height = 75;
        width = 75;
        sides = 5;
        centerX = 100;
        centerY = 90;

        frame = new JFrame("Star");
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StarPanel starPanel = new StarPanel();
        frame.add(starPanel);

        frame.pack();
        frame.setVisible(true);
    }

    class StarPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Calculate 5 points on a circle
            for (int i = 0; i < sides; i++) {
                int x1 = (int)(circleX(sides,i) * (double)(width)) + centerX;
                int y1 = (int)(circleY(sides,i) * (double)(height)) + centerY;
                int x2 = (int)(circleX(sides,(i+2)%sides) * (double)(width)) + centerX;
                int y2 = (int)(circleY(sides,(i+2)%sides) * (double)(height)) + centerY;
                g.drawLine(x1,y1,x2,y2);
            }
        }

        public double circleX(int sides, int angle) {
            double coeff = (double)angle/(double)sides;
            return Math.cos(2*coeff*Math.PI-(Math.PI/2));
        }

        public double circleY(int sides, int angle) {
            double coeff = (double)angle/(double)sides;
            return Math.sin(2*coeff*Math.PI-(Math.PI/2));
        }
    }

    public static void main(String[] args) {
        new StarGraphic();
    }

}
