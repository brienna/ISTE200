import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

/**
 * Purpose:     Races icons across the screen. Each icon is drawn to its
 *              own JPanel that fills a row within a container's single-column
 *              GridLayout, and each JPanel races on its own thread.
 *
 * @author Brienna Herold
 */
public class Races implements ActionListener {

    private JFrame frame;
    private JPanel gui;  // to hold all components
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem restart;
    private int finishLineXPos;  // x-coordinate of finish line
    private Icon racerImg;
    private int racerImgWidth;
    private int racerImgHeight;
    private int numOfRacers;
    private double maxNumOfRacers;
    private ArrayList<Racer> racers;
    private int CEILING;  // upper racer speed limit
    private int FLOOR;  // lower racer speed limit
    private Racer winner;
    private int windowHeight;
    private int windowWidth;
    private Object sharedObj;

    /** Executes program */
    public static void main(String[] args) {
        // If valid num of threads provided, construct GUI with the num
        if (args.length > 0) {
            try {
                new Races(Integer.parseInt(args[0]));
            } catch (NumberFormatException ex) {
                System.out.println("Error: Please enter a number");
                System.exit(0);
            }
        } else {
            // Otherwise, construct GUI with default num
            new Races(5);
        }
    }

    /**
     * Constructs the race GUI and calls method to begin race
     * @param num number of racers, or threads that will be used
     */
    public Races(int num) {
        numOfRacers = num;

        racerImg = new ImageIcon("races.png");
        racerImgWidth = racerImg.getIconWidth();
        racerImgHeight = racerImg.getIconHeight();

        // Determine max number of racers allowed, based on icon size and screen height
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        maxNumOfRacers = screenSize.getHeight() / racerImgHeight;
        // If user entered a number higher than max - 2 (cuz of menubar), exit with message
        if (numOfRacers > (maxNumOfRacers - 2)) {
            String msg = "ERROR: Too many racers to fit on the screen, based on icon and screen height." +
                " Please specify a smaller number.";
            JOptionPane.showMessageDialog(null, msg);
            System.exit(0);
        }
        // If icon is smaller/larger than min/max size, exit with message
        if (racerImgWidth > 50 || racerImgWidth < 20 || racerImgHeight > 50 || racerImgHeight < 20) {
            String msg = "IMAGE ERROR: Racer icon either does not exist or is not within allowed size. " +
                "Please use a different icon.";
            JOptionPane.showMessageDialog(null, msg);
            System.exit(0);
        }

        windowHeight = racerImgHeight * numOfRacers;
        windowWidth = racerImgWidth * 20;
        finishLineXPos = racerImgWidth * 18;  // two icon widths from the right
        sharedObj = new Object();  // for synchronization

        frame = new JFrame("Off to the Races - by Brienna Herold");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        file = new JMenu("File");
        menuBar.add(file);
        restart = new JMenuItem("Restart");
        file.add(restart);
        restart.addActionListener(this);

        gui = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(finishLineXPos, 0, finishLineXPos, windowHeight);
            }
        };
        gui.setLayout(new GridLayout(numOfRacers,1));
        gui.setPreferredSize(new Dimension(windowWidth, windowHeight));

        // Create and add racers to gui panel
        racers = new ArrayList<Racer>();
        for (int i = 1; i <= numOfRacers; i++) {
            Racer racer = new Racer(Integer.toString(i));
            gui.add(racer);
            racers.add(racer);
        }

        frame.add(gui);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  // centers window, needs to be specified after setVisible

        startRace();
    }

    /** Begins the race */
    public void startRace() {
        winner = null;

        // Pause application for one second to let user see icons before race
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }

        // Start race
        for (Racer racer : racers) {
            racer.setPosX(0);
            Thread racerThread = new Thread(racer);
            racerThread.start();
        }
    }

    /**
     * Handles ActionEvents triggered by menu item selections
     */
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        // If File > Restart selected, restart race
        if (source == restart) {
            startRace();
        }
    }

    /** Inner class representing a racer */
    protected class Racer extends JPanel implements Runnable {
        private int lastPosX;
        private int posX;
        private String name;

        /**
         * Constructs a racer
         * @param _name the name of the racer
         */
        public Racer(String _name) {
            posX = 0;
            this.setOpaque(false);
            name = _name;
            //this.setBorder(BorderFactory.createLineBorder(Color.RED));  // for troubleshooting
        }

        /** Paints icon and winner string */
        @Override
        public void paintComponent(Graphics g) {
            // Tells JPanel to start painting
            super.paintComponent(g);
            // Instructs JPanel to paint icon
            racerImg.paintIcon(this, g, posX, 0);

            // If current racer is the winner, print that it is the winner
            if (winner == this) {
                g.drawString("Racer " + name + " wins!", 10, 10);
            }
        }

        /** Executes when thread starts */
        @Override
        public void run() {
            // While the race has not been won yet, proceed with race
            while (winner == null) {
                System.out.println("\nRacing... " + name);
                System.out.println("Finish line: " + finishLineXPos + ". Current pos: " + posX);

                try {
                    Thread.sleep(100);  // slows down racing a bit
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // If racer passes specified x-coordinate, set racer as winner
                synchronized (sharedObj) {
                    if (posX >= finishLineXPos && winner == null) {
                        System.out.println("Winner: " + Thread.currentThread().getName());
                        winner = this;
                    }
                }

                if (winner == null) {
                    setPosX(posX + (int)(Math.random() * racerImgWidth));
                }

                repaint();
            }
        }

        /**
         * Sets the x-coordinate of painted icon
         * @param pos the x-coordinate
         */
        public void setPosX(int pos) {
            posX = pos;
        }
    }
}
