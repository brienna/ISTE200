import java.io.*;

/**
 * Purpose:     Reads binary file ClassList.dat, calculates grades,
 *              and prints results.
 *
 * @author Brienna Herold
 */
public class BytePe1 {

    /** Execution begins here */
    public static void main(String[] args) {

        try {
            // Create File object representing file
            File classFile = new File("ClassList.dat");
            // If actual file exists, open input streams on it
            if (classFile.exists()) {
                FileInputStream fis = new FileInputStream(classFile);
                BufferedInputStream bis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bis);

                // While file contains unread data, read & print next student record
                // Note: PDF handout specifies the following structure
                // of record, which has to be specified in order to be read.
                System.out.printf("%-20s%20s%10s%10s%10s%10s%10s\n",
                    "Name", "ID", "Grade1", "Grade2", "Grade3", "Grade4", "Avg.");
                while (dis.available() > 0) {
                    String name = dis.readUTF();
                    int num = dis.readInt();
                    double grade1 = dis.readDouble();
                    double grade2 = dis.readDouble();
                    double grade3 = dis.readDouble();
                    double grade4 = dis.readDouble();
                    // Calculate grade average
                    double gradeAvg = (grade1 + grade2 + grade3 + grade4) / 4;
                    System.out.printf("%-20s%20d%10.1f%10.1f%10.1f%10.1f%10.1f\n",
                        name, num, grade1, grade2, grade3, grade4, gradeAvg);
                }

                dis.close();
            } else {
                System.out.println("File doesn't exist");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }  // end try-catch block

    }  // end main()

}  // end class BytePe1
