import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

/**
 * Purpose:     Creates GUI for vehicle ordering system.
 *
 * Caveats:     Includes data logic, which should be separate.
 *
 * @author Brienna Herold
 */
public class OrdersScreen extends JFrame implements ActionListener, ItemListener {

    private static String ORDERS_FILENAME = "VehicleOrders.dat";
    private final static String[] VEHICLE_TYPES = new String[] {"Select Vehicle...", "Truck", "Car",
        "Boat", "Bicycle"};  // order is sensitive
    private static ArrayList<Vehicle> orders = new ArrayList<Vehicle>();
    private static int currentOrderNum;

    // Menu bar
    private JMenuBar menuBar;
    private JMenu file;
    private JMenu help;
    private JMenuItem about;
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
        about = new JMenuItem("About");
        help.add(about);

        // Add event handlers
        exit.addActionListener(this);
        about.addActionListener(this);
        load.addActionListener(this);
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
        saveButton.addActionListener(this);
        firstButton.addActionListener(this);
        prevButton.addActionListener(this);
        nextButton.addActionListener(this);
        lastButton.addActionListener(this);
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
        // If File > Exit or EXIT button selected, exit program
        if (source == exitButton || source == exit) {
            saveOrders();
            printOrders();
            System.exit(0);
        } else if (source == load) {
            // If File > Load selected, load previous orders
            readFile();
            // Update current order number to reflect added orders
            currentOrderNum = orders.size();
            System.out.println("Order num: " + currentOrderNum);
        } else if (source == about) {
            // If Help > About selected, display program info
            String message = "Author: Brienna Herold\n" +
                            "Java for Programmers ISTE-200 2017-Fall\n" +
                            "Homework 8 GUI Ordering\n" +
                            "Prof. Tanweer Alam";
            JOptionPane.showMessageDialog(this, message);
        } else if (source == firstButton) {
            // If FIRST button selected, show first order
            currentOrderNum = 0;
            showOrder(currentOrderNum);
        } else if (source == lastButton) {
            // If LAST button selected, show last order
            System.out.println("Order num: " + currentOrderNum);
            currentOrderNum = orders.size() - 1;
            showOrder(currentOrderNum);
        } else if (source == nextButton) {
            // If NEXT button selected, show next order
            if (currentOrderNum < orders.size() - 1) {
                System.out.println("Order num: " + currentOrderNum);
                currentOrderNum++;
                showOrder(currentOrderNum);
            } else {
                // Show error dialog & clear screen for new order
                currentOrderNum++;
                vehicleTypeSelection.setSelectedIndex(0);
                JOptionPane.showMessageDialog(this, "No further orders", "", JOptionPane.ERROR_MESSAGE);
            }
        } else if (source == prevButton) {
            // If PREV button selected, show previous order
            if (currentOrderNum > 0) {
                currentOrderNum--;
                System.out.println("Order num: " + currentOrderNum);
                showOrder(currentOrderNum);
            } else {
                JOptionPane.showMessageDialog(this, "No more previous orders", "", JOptionPane.ERROR_MESSAGE);
            }
        } else if (source == saveButton) {
            // If SAVE button selected, save order to ArrayList
            System.out.println("Saving order...");
            // If Save button selected, save current order to ArrayList
            String vehicleName = String.valueOf(vehicleTypeSelection.getSelectedItem());

            // If order is not for valid vehicle, return
            if (vehicleName.equals(VEHICLE_TYPES[0])) {
                return;
            }

            // Retrieve order details from fields & combo boxes
            String color = colorField.getText().trim();
            String model = modelField.getText().trim();
            double cost = 0.00;
            try {
                cost = Double.parseDouble(costField.getText());
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid cost. Please do not enter $ or any other non-digit characters other than one decimal.");
                return;
            }
            int prompt1Answer = prompt1Choices.getSelectedIndex();
            int prompt2Answer = prompt2Choices.getSelectedIndex();

            switch (vehicleName) {
                case "Truck":
                    Truck truck = new Truck(prompt1Answer, prompt2Answer);
                    truck.setModel(model);
                    truck.setColor(color);
                    truck.setCost(cost);
                    orders.add(truck);
                    break;
                case "Car":
                    Car car = new Car(prompt1Answer, prompt2Answer);
                    car.setModel(model);
                    car.setColor(color);
                    car.setCost(cost);
                    orders.add(car);
                    break;
                case "Boat":
                    Boat boat = new Boat(prompt1Answer, prompt2Answer);
                    boat.setModel(model);
                    boat.setColor(color);
                    boat.setCost(cost);
                    orders.add(boat);
                    break;
                case "Bicycle":
                    Bicycle bicycle = new Bicycle(prompt1Answer, prompt2Answer);
                    bicycle.setModel(model);
                    bicycle.setColor(color);
                    bicycle.setCost(cost);
                    orders.add(bicycle);
                    break;
            }

            // Clear screen for next order
            vehicleTypeSelection.setSelectedIndex(0);
            currentOrderNum = orders.size();
            System.out.println("Order num: " + currentOrderNum);
        }
    }

    /** Show vehicle order
     * @param orderNum the ArrayList index of the order
     */
    private void showOrder(int orderNum) {
        Vehicle firstOrder = orders.get(orderNum);
        String vehicleType = firstOrder.getVehIs();
        vehicleTypeSelection.setSelectedItem(vehicleType);
        modelField.setText(firstOrder.getModel());
        colorField.setText(firstOrder.getColor());
        costField.setText(Double.toString(firstOrder.getCost()));
        switch (vehicleType) {
            case "Truck":
                Truck truck = (Truck) firstOrder;
                prompt1Choices.setSelectedItem(truck.getLoad());
                prompt2Choices.setSelectedItem(truck.getEngine());
                break;
            case "Car":
                Car car = (Car) firstOrder;
                prompt1Choices.setSelectedItem(car.getType());
                prompt2Choices.setSelectedItem(car.getTowing());
                break;
            case "Boat":
                Boat boat = (Boat) firstOrder;
                prompt1Choices.setSelectedItem(boat.getBoatType());
                prompt2Choices.setSelectedItem(boat.getConstruction());
                break;
            case "Bicycle":
                Bicycle bicycle = (Bicycle) firstOrder;
                prompt1Choices.setSelectedItem(bicycle.getFunction());
                prompt2Choices.setSelectedItem(bicycle.getMaterial());
                break;
        }
    }

    /**
     * Handles ItemEvents triggered by vehicleTypeSelection item selections
     * to label other ComboBoxes with prompts and fill them with
     * appropriate choices
     */
    public void itemStateChanged(ItemEvent ie) {
        // Quit method if state change is not SELECTED
        if (ie.getStateChange() != ItemEvent.SELECTED) {
            return;
        }

        // Get the item that was selected
        String vehicleType = (String) ie.getItem();

        // Clear screen
        prompt1Choices.removeAllItems();
        prompt2Choices.removeAllItems();
        modelField.setText("");
        colorField.setText("");
        costField.setText("");

        // Return if "Select Vehicle..." was selected
        if (vehicleType.equals("Select Vehicle...")) {
            prompt1Label.setText("");
            prompt2Label.setText("");
        } else {
            // Otherwise get prompts & choices based on item selected
            String[] prompts = new String[2];
            String[][] choices = new String[2][];

            switch (vehicleType) {
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

            // Set prompts and choices
            prompt1Label.setText(prompts[0]);
            prompt2Label.setText(prompts[1]);
            for (String str : choices[0]) {
                prompt1Choices.addItem(str);
            }
            for (String str2 : choices[1]) {
                prompt2Choices.addItem(str2);
            }
        }
    }

    /** Execution starts here */
    public static void main(String[] args) {
        // Show GUI
        new OrdersScreen();
    }

    /** Prints vehicle orders to text file */
    public static void printOrders() {
        try {
            // Open buffered stream (if file exists, it will be overwritten)
            PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter("VehicleOrders.txt")));

            // Print each vehicle order
            for (Vehicle vehicle : orders) {
                out.println();
                out.println(vehicle.toString());

                // Also print to Terminal for now
                System.out.println();
                System.out.println(vehicle.toString());
            }

            // Flush the buffer and close the stream
            out.flush();
            out.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /** Saves orders to DAT file */
    public static void saveOrders() {
        try {
            // Open buffered stream
            File ordersFile = new File(ORDERS_FILENAME);
            FileOutputStream fos = new FileOutputStream(ordersFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            // Save each object
            for (Vehicle order : orders) {
                oos.writeObject(order);
            }

            // Flush the buffer and close the stream
            oos.flush();
            oos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /** Adds any previously saved orders */
    public static void readFile() {
        try {
            // Create File object representing file
            File ordersFile = new File(ORDERS_FILENAME);
            // If actual file exists, open input streams on it
            if (ordersFile.exists()) {  // prevents FileNotFoundException
                System.out.println("Some orders already exist.");
                FileInputStream fis = new FileInputStream(ordersFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);

                // While file contains objects, read object into ArrayList
                while (true) {
                    try {
                        Vehicle order = (Vehicle) ois.readObject();
                        orders.add(order);
                        System.out.println("Adding existing order...");
                    } catch (EOFException eof) {
                        System.out.println("End of file");
                        break;  // loop only breaks at end of file
                    }
                }

                ois.close();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

}
