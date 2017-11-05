/**
 * Purpose:     Contains information about a student.
 *
 * Caveats:     Must create new instance if name or student ID happen to change.
 *              Assumes GPA is within scale, major exists, and student ID is valid.
 *
 * @author Brienna Herold
 */
public class Student {

    private String name;
    private String major;
    private double gpa;
    private int studentId;

    /** Constructs Student instance 
    @accept */
    public Student(String _name, String _major, double _gpa, int _studentId) {
        name = _name;
        major = _major;
        gpa = _gpa;
        studentId = _studentId;
    }

    /** Gets name */
    public String getName() {
        return name;
    }

    /** Gets major */
    public String getMajor() {
        return major;
    }

    /** Gets gpa */
    public double getGpa() {
        return gpa;
    }

    /** Gets studentId */
    public int getStudentId() {
        return studentId;
    }

    /** Sets gpa */
    public boolean setGpa(double _gpa) {
        gpa = _gpa;
        return true;
    }

    /** Sets major */
    public boolean setMajor(String _major) {
        major = _major;
        return true;
    }

    /** 
        Formats String representation of the Student instance
        @return the representation
    */
    public String toString() {
        return String.format("%-22s %-22s %-22.2f %-22d", getName(), getMajor(), getGpa(), getStudentId());
    }

}

