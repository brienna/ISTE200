import java.awt.*;
import javax.swing.*;

/**
 * Purpose:     Constructs a GUI with a menu that utilizes a separate
 *              class to handle the events of the menu items.
 *
 * @author Brienna Herold
 */
public class MyMenu extends JFrame {

    private JTextArea textArea;
    private JMenuBar menu;
    private JMenu count;
    private JMenuItem inc;
    private JMenuItem dec;
    private JMenuItem reset;
    private JMenuItem exit;

    /** Constructs Menu */
    public MyMenu() {
        // Create JFrame
        super("My Menu");

        // Create scrollable text area
        textArea = new JTextArea(20, 15);  // 20 rows, 15 columns
        JScrollPane scroller = new JScrollPane(textArea);
        add(scroller, BorderLayout.CENTER);

        // Create menu bar and add it to the frame
        menu = new JMenuBar();
        setJMenuBar(menu);

        // Create a menu
        count = new JMenu("Count");
        menu.add(count);

        // Add menu items to the menu
        inc = new JMenuItem("Inc");
        dec = new JMenuItem("Dec");
        reset = new JMenuItem("Reset");
        exit = new JMenuItem("Exit");
        count.add(inc);
        count.add(dec);
        count.add(reset);
        count.add(exit);

        // Add event listener to menu items, passing it the textArea
        MyListenerCnt listener = new MyListenerCnt(textArea);
        inc.addActionListener(listener);
        dec.addActionListener(listener);
        reset.addActionListener(listener);
        exit.addActionListener(listener);

        // Show frame
        pack();
        setVisible(true);
    }

    /** Entry point of program */
    public static void main(String[] args) {
        new MyMenu();
    }

}
