import java.io.*;
import java.util.ArrayList;

/**
 * Purpose:     Uses a thread to read each byte file.
 *
 * Caveats:     Errors are thrown due to lack of synchronization for
 *              the access of the Arraylist by multiple threads.
 *
 * @author Brienna Herold
 */
public class BytePe4B {
    private ArrayList<Integer> numbers;

    public BytePe4B() {
        numbers = new ArrayList<Integer>();

        // Start a thread for each file being read,
        // with filenames integer1.dat through integer8.dat
        for (int i = 1; i <= 8; i++) {
            File file = new File("PE Data/integer" + i + ".dat");
            ReadInts thread = new ReadInts(file);
            thread.start();
        }
    }

    /** Represents a Thread instance */
    class ReadInts extends Thread {
        File file;

        public ReadInts(File _file) {
            file = _file;
        }

        @Override
        public void run() {
            int count = 0;  // keeps track of records read in the file
            int sum = 0;  // sum of numbers read in the file

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
                return;  // end thread execution
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
    }

    public static void main(String[] args) {
        new BytePe4B();
    }

}
