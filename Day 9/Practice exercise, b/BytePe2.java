import java.io.*;
import java.util.ArrayList;

/**
 * Purpose:     Reads one byte file.
 *
 * @author Brienna Herold
 */
public class BytePe2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int count = 0;  // track number of records read
        int sum = 0;  // tracks sum of numbers read

        try {
            // Open stream to binary data file integer1.dat
            FileInputStream in = new FileInputStream("PE Data/integer1.dat");
            // Buffer the stream
            BufferedInputStream bin = new BufferedInputStream(in);
            // Access primitive data
            DataInputStream din = new DataInputStream(bin);

            try {
                // Read file until end reached
                while (true) {
                    int num = din.readInt();  // get num
                    numbers.add(num);  // add num to ArrayList
                    sum += num;  // update sum
                    count++;  // update record count
                }
            } catch (EOFException eof) {
                System.out.println("End of file reached.");
            } finally {
                // Close streams
                din.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // Write info
        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
        System.out.println("In List = " + numbers.size());
    }
}
