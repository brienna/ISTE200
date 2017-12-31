import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Purpose:     Creates GUI for vehicle ordering system.
 *
 * Caveats:     Currently not fully functional.
 *
 * @author Brienna Herold
 */
public class OrdersScreen extends JFrame implements ActionListener, ItemListener {

    private final static String[] VEHICLE_TYPES = new String[] {"Select Vehicle...", "Truck", "Car",
        "Boat", "Bicycle"};

    // Menu bar
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu help;
    private JMenuItem load;
    private JMenuItem exit;

    // Title variable
    private JLabel title;

    // Fields and labels
    private JPanel fields;
    private JLabel vehicleTypeLabel;
    private JComboBox<String> vehicleTypeSelection;
    private JLabel modelLabel;
    private JTextField modelField;
    private JLabel colorLabel;
    private JTextField colorField;
    private JLabel costLabel;
    private JTextField costField;
    private JLabel prompt1Label;
    private JComboBox<String> prompt1Choices;
    private JLabel prompt2Label;
    private JComboBox<String> prompt2Choices;

    // Buttons
    private JPanel buttons;
    private JButton saveButton;
    private JButton firstButton;
    private JButton prevButton;
    private JButton nextButton;
    private JButton lastButton;
    private JButton exitButton;

    /** Constructs and shows GUI */
    public OrdersScreen() {
        // Create GUI
        super();
        customizeAndSetMenu();
        customizeTitle();
        customizeFieldsAndLabels();
        customizeButtons();
        addComponentsToFrame();

        // Display GUI
        pack();
        setVisible(true);
    }

    /** Customizes and sets menu bar */
    private void customizeAndSetMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Add menus to menu bar
        file = new JMenu("File");
        help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(help);

        // Add menu items to menus
        load = new JMenuItem("Load");
        exit = new JMenuItem("Exit");
        file.add(load);
        file.add(exit);
        JMenuItem about = new JMenuItem("About");
        help.add(about);

        // Add event handlers
        exit.addActionListener(this);
    }

    /** Customizes title */
    private void customizeTitle() {
        // Create title
        title = new JLabel("Brienna's Ordering System", JLabel.CENTER);

        // Style title
        title.setForeground(Color.RED);
        Font look = new Font("Times New Roman", Font.PLAIN, 20);
        title.setFont(look);
    }

    /** Customizes fields and their labels */
    private void customizeFieldsAndLabels() {
        // Create panel to hold fields and labels
        fields = new JPanel(new GridLayout(6, 2));

        // Create & add vehicle type drop down selection & label
        vehicleTypeLabel = new JLabel("Vehicle type: ", JLabel.RIGHT);
        vehicleTypeSelection = new JComboBox<String>(VEHICLE_TYPES);
        vehicleTypeSelection.addItemListener(this);  // to listen for selection
        fields.add(vehicleTypeLabel);
        fields.add(vehicleTypeSelection);

        // Create & add model input field & label
        modelLabel = new JLabel("Model", JLabel.RIGHT);
        modelField = new JTextField(20);
        fields.add(modelLabel);
        fields.add(modelField);

        // Create & add color input field & label
        colorLabel = new JLabel("Color", JLabel.RIGHT);
        colorField = new JTextField(20);
        fields.add(colorLabel);
        fields.add(colorField);

        // Create & add cost input field & label
        costLabel = new JLabel("Cost", JLabel.RIGHT);
        costField = new JTextField(20);
        fields.add(costLabel);
        fields.add(costField);

        // Create & add prompts and choices
        prompt1Label = new JLabel();
        prompt2Label = new JLabel();
        prompt1Choices = new JComboBox<String>();
        prompt2Choices = new JComboBox<String>();
        prompt1Label.setHorizontalAlignment(JLabel.RIGHT);
        prompt2Label.setHorizontalAlignment(JLabel.RIGHT);
        fields.add(prompt1Label);
        fields.add(prompt1Choices);
        fields.add(prompt2Label);
        fields.add(prompt2Choices);
    }

    /** Customizes buttons */
    private void customizeButtons() {
        // Create panel to hold all buttons
        buttons = new JPanel();

        // Create and add buttons
        saveButton = new JButton("SAVE");
        firstButton = new JButton("FIRST");
        prevButton = new JButton("PREV");
        nextButton = new JButton("NEXT");
        lastButton = new JButton("LAST");
        exitButton = new JButton("Exit");
        buttons.add(saveButton);
        buttons.add(firstButton);
        buttons.add(prevButton);
        buttons.add(nextButton);
        buttons.add(lastButton);
        buttons.add(exitButton);

        // Add event handlers
        exitButton.addActionListener(this);
    }

    /** Adds components to the JFrame */
    private void addComponentsToFrame() {
        add(title, BorderLayout.NORTH);
        add(fields, BorderLayout.EAST);
        add(buttons, BorderLayout.SOUTH);
    }

    /**
     * Handles ActionEvents triggered by menu item selections
     * or button clicks.
     */
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        // If File > Exit or Exit button selected, exit program
        if (source == exitButton || source == exit) {
            System.exit(0);
        }
    }

    /**
     * Handles ItemEvents triggered by ComboBox item selections
     * to label other ComboBoxes with prompts and fill them with
     * appropriate choices
     */
    public void itemStateChanged(ItemEvent ie) {
        // Quit method if state change is not SELECTED
        if (ie.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        // Get prompts & choices based on item selected
        String item = (String) ie.getItem();
        String[] prompts = new String[2];
        String[][] choices = new String[2][];
        switch (item) {
            case "Truck":
                prompts = Truck.PROMPTS;
                choices = Truck.getPromptChoices();
                break;
            case "Car":
                prompts = Car.PROMPTS;
                choices = Car.getPromptChoices();
                break;
            case "Boat":
                prompts = Boat.PROMPTS;
                choices = Boat.getPromptChoices();
                break;
            case "Bicycle":
                prompts = Bicycle.PROMPTS;
                choices = Bicycle.getPromptChoices();
                break;
        }

        // Fill in prompts and choices
        prompt1Label.setText(prompts[0]);
        prompt2Label.setText(prompts[1]);
        prompt1Choices.removeAllItems();
        prompt2Choices.removeAllItems();
        for (String str : choices[0]) {
            prompt1Choices.addItem(str);
        }
        for (String str2 : choices[1]) {
            prompt2Choices.addItem(str2);
        }
    }

    /** Execution starts here */
    public static void main(String[] args) {
        new OrdersScreen();
    }

}
