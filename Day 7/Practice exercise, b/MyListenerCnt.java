import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;

/**
 * Purpose:     Handles specific menu item selections to update
 *              the count in the passed JTextArea.
 *
 * Caveats:     Does not check if JTextArea already contains an input
 *              or if the input is a valid integer.
 *              Any exceptions thrown will end program.
 *
 * @author Brienna Herold
 */
public class MyListenerCnt implements ActionListener {
    private JTextArea jta;

    public MyListenerCnt(JTextArea _jta) {
        jta = _jta;
    }

    public void actionPerformed(ActionEvent ae) {
        String[] lines = jta.getText().split("\n");
        int count = Integer.parseInt(lines[lines.length - 1]);
        String command = ae.getActionCommand();
        if (command.equals("Inc")) {
            count += 1;
        } else if (command.equals("Dec")) {
            count -= 1;
        } else if (command.equals("Reset")) {
            count = 0;
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
        jta.append("\n" + count);
    }

}
