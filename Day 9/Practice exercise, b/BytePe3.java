import java.io.*;
import java.util.ArrayList;

/**
 * Purpose:     Reads multiple byte files.
 *
 * @author Brienna Herold
 */
public class BytePe3 {
    private ArrayList<Integer> numbers;

    public BytePe3() {
        numbers = new ArrayList<Integer>();

        // Call addInts for each file,
        // with filenames integer1.dat through integer8.dat
        for (int i = 1; i <= 8; i++) {
            File file = new File("PE Data/integer" + i + ".dat");
            addInts(file);
        }
    }

    private void addInts(File file) {
        int count = 0;  // tracks records read
        int sum = 0;  // tracks sum of numbers read

        try {
            // Open stream to binary data file integer1.dat
            FileInputStream in = new FileInputStream(file);
            // Buffer the stream
            BufferedInputStream bin = new BufferedInputStream(in);
            // Access the primitive data
            DataInputStream din = new DataInputStream(bin);

            try {
                // Read file until end reached
                while (true) {
                    int num = din.readInt();
                    numbers.add(num);
                    sum += num;
                    count++;
                }
            } catch (EOFException eof) {
                // Do nothing (other than having broken while loop)
            } finally {
                // Close streams
                din.close();
            }
        } catch (FileNotFoundException fnf) {
            System.out.println("File does not exist: " + file.getName());
            return;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Write info
        System.out.println(
            String.format("%s%s%-5s%s%-8d%-5s%s%-12d%-5s%s%d",
            "Filename = ", file.getName(), "",
            "Count = ", count, "",
            "Sum = ", sum, "",
            "In List = ", numbers.size()));
    }

    public static void main(String[] args) {
        new BytePe3();
    }
}
