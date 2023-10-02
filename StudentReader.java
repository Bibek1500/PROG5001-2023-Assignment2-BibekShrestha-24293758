import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

/**
 * StudentReader class.
 *
 * @author (Bibek Shrestha)
 * @version (02/10/2023)
 */
public class StudentReader
{
    public static ArrayList<Student> readCSV(String fileName) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String lastName = parts[0];
                String firstName = parts[1];
                int studentId = Integer.parseInt(parts[2]);
                double a1 = parts.length > 3 ? parseValueForAssignment(parts[3]) : 0; 
                double a2 = parts.length > 4 ? parseValueForAssignment(parts[4]) : 0;
                double a3 = parts.length > 5 ? parseValueForAssignment(parts[5]) : 0;

                    Student student = new Student(lastName, firstName, studentId, a1, a2, a3);
                    students.add(student);
                }
            }
            
             return students;
        }
        
        private static double parseValueForAssignment(String input) {
        if(input.isEmpty()) {
            return 0;
        }
        
        return Double.parseDouble(input);
    }
}
