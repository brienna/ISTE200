import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Purpose:     Creates GUI specified in "07b PE.pdf",
 *              and has the GUI itself serve as the
 *              event listener, and using a separate class
 *              to implement the event listener for the
 *              reset button.
 *
 * @author Brienna Herold
 */
public class MyEventC implements ActionListener {

    private JFrame frame;
    private JPanel textPanel;
    private JTextField textField;
    private JLabel textLabel;
    private JPanel gui;
    private JPanel buttonPanel;
    private JButton addButton;
    private JButton subtractButton;
    private JButton resetButton;
    private JButton quitButton;

    public static void main(String[] args) {
        new MyEventA();
    }

    public MyEventC() {
        customizeFrame();
        customizeText();
        customizeButtonPanel();
        addComponentsToFrame();

        // Show frame
        frame.setVisible(true);
    }

    /** Create and customize frame */
    private void customizeFrame() {
        // Set the look and feel to the cross-platform look and feel,
        // otherwise mac os will have quirks like gaps between jbuttons
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Unsupported look and feel.");
            e.printStackTrace();
        }

        frame = new JFrame("C. Using separate class for Reset Button");
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);  // centers window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /** Create and customize text panel and components */
        private void customizeText() {
        textPanel = new JPanel();
        textField = new JTextField("0", 5);
        textLabel = new JLabel("Current Value:");
    }

    private void customizeButtonPanel() {
        // Create button panel and components
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        resetButton = new JButton("Reset");
        quitButton = new JButton("Quit");

        // Add action listener to each button
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        ResetListener resetListener = new ResetListener(textField);
        resetButton.addActionListener(resetListener);
        quitButton.addActionListener(this);
    }

    private void addComponentsToFrame() {
        // Add all components to frame
        textPanel.add(textLabel);
        textPanel.add(textField);
        frame.add(textPanel, BorderLayout.NORTH);
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(quitButton);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
    }

    /**
     * Handles specific button events to update jtf,
     * using getActionCommand() to recognize events
     * @param ae the event
     */
    public void actionPerformed(ActionEvent ae) {
        int value = Integer.parseInt(textField.getText());
        if (ae.getActionCommand().equals("+")) {
            value += 1;
        } else if (ae.getActionCommand().equals("-")) {
            value -= 1;
        } else if (ae.getActionCommand().equals("Quit")) {
            System.exit(0);
        }
        textField.setText(Integer.toString(value));
    }

}
