import java.util.ArrayList;

/**
 * Purpose:     Creates and mutates Student objects and prints info about each.
 *
 * Caveats:     Implicity prints students? And would be better to test which student
 *              is Jay Can rather than selecting 'student1' myself. 
 *
 * @author Brienna Herold
 */
public class TestStudent {

    /** TestStudent execution starts here */
    public static void main(String[] args) {
        // Create collection to hold all Students
        ArrayList<Student> students = new ArrayList<Student>();

        // Print heading
        System.out.printf("%-22s %-22s %-22s %-22s", "Name", "Major", "GPA", "Student Number");
        System.out.println();

        // Create Student objects
        Student student1 = new Student("Jay Can", "CS", 4.00, 1123);
        Student student2 = new Student("Ed Holdum", "SE", 3.45, 3256);
        Student student3 = new Student("Mike Floatsman", "IST", 3.53, 7765);
        Student student4 = new Student("Brienna Herold", "Biology", 3.97, 38752353);

        // Add each Student to collection
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        // Change Jay Can's major to be IST
        student1.setMajor("IST");

        // Add 0.1 to Ed Holdum's GPA
        double gpa = student2.getGpa();
        student2.setGpa(gpa + 0.1);

        // Print all students implicitly using toString
        for (Student person : students) {
            if (person instanceof Student) {
                System.out.println(person.toString());
            } 
        }

    }

}