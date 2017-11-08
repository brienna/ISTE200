import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Purpose:     Handles Reset button event to update a passed JTextField.
 *
 * @author Brienna Herold
 */
public class ResetListener implements ActionListener {

    private JTextField jtf;

    /**
     * Constructs the event listener
     * @param _jtf a JTextField to be updated based on event
     */
    public ResetListener(JTextField _jtf) {
        jtf = _jtf;
    }

    /**
     * Handles Reset button event to update jtf
     * @param ae the event
     */
    public void actionPerformed(ActionEvent ae) {
       jtf.setText("0");
    }

}
