
/**
 * Student class.
 *
 * @author (Bibek Shrestha)
 * @version (02/10/2023)
 */
public class Student
{
     private String lastName;
    private String firstName;
    private int studentId;
    private double a1;
    private double a2;
    private double a3;
    private double totalMarks;

    public Student(String firstName, String lastName, int studentId, double a1,double a2,double a3 ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    // Getter for firstName
    public String getfirstName() {
        return firstName;
    }

    // Setter for firstName
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    
    // Getter for lastName
    public String getlastName() {
        return lastName;
    }

    // Setter for lastName
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for studentId
    public int getstudentId() {
        return studentId;
    }

    // Setter for studentId
    public void setstudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter for a1
    public double geta1() {
        return a1;
    }

    // Setter for a1
    public void seta1(double a1) {
        this.a1 = a1;
    }
    
        // Getter for a2
    public double geta2() {
        return a2;
    }

    // Setter for a2
    public void seta2(double a2) {
        this.a2 = a2;
    }
    
        // Getter for a3
    public double geta3() {
        return a3;
    }

    // Setter for a3
    public void seta3(double a3) {
        this.a3 = a3;
    }
    
    public double calculateTotal () {
        return this.a1+this.a2+ this.a3;
    }
}

