import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class.
 * 
 * @author (Bibek Shrestha)
 * @version (02/10/2023)
 */
public class Main
{
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the CSV file: ");
        String fileName = scanner.nextLine();
        try {
            // F1: Read data from file 
            
            ArrayList<Student> students = StudentReader.readCSV(fileName);

            System.out.println("Please select a number: ");
            System.out.println("1) Display Student's Detail with total Marks");
            System.out.println("2) Display the list of students with total marks less than a given threshold.");
            System.out.println("3) Display top 5 students with the highest total marks");
            System.out.println("4) Display top 5 students with the lowest total marks");
            System.out.println("5) Exit");
            
            int userEntry;
            userEntry = scanner.nextInt();
            
            while(userEntry != 5){
                if(userEntry == 1){
                    printStudentTotal(students);
                }
                
                // list of students with total marks less than threshold
                if(userEntry == 2) {
                    double threshold;
                    System.out.println("Please enter the threshold: ");
                    threshold = scanner.nextDouble();
                    System.out.println("List of students with total marks less than " + threshold + ": ");
                    printStudentTotalLessThanThreshold(students, threshold);
                }
                
                if(userEntry == 3) {
                    System.out.println("List of 5 students with highest marks");
                    topFiveStudents(students);
                }
                
                if(userEntry == 4) {
                    System.out.println("List of 5 students with lowest marks");
                    topFiveLowestStudents(students);
                }
                
                System.out.println("Please select a number: ");
                System.out.println("1) Display Student's Detail with total Marks");
                System.out.println("2) Display the list of students with total marks less than a given threshold.");
                System.out.println("3) Display top 5 students with the highest total marks");
                System.out.println("4) Display top 5 students with the lowest total marks");
                System.out.println("5) Exit");
                
                userEntry = scanner.nextInt();
            }
            
            if(userEntry == 5){
                System.out.println("terminating...");  
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //F2: Print student total marks
    public static void printStudentTotal(ArrayList<Student> students) {
        for (Student student : students) {
                System.out.println("firstName: " + student.getfirstName() +
                       ", lastName: " + student.getlastName() +
                       ", studentId: " + student.getstudentId() +
                       ", a1: " + student.geta1() +
                       ", a2: " + student.geta2() +
                       ", a3: " + student.geta3() +
                       ", total: " + student.calculateTotal());
            }
         System.out.println();   
    }
    
    //F3: Print list of students with total marks less than threshold
    public static void printStudentTotalLessThanThreshold(ArrayList<Student> students, double threshold) {
        for (Student student : students) {
                if(student.calculateTotal() < threshold) {
                    System.out.println("firstName: " + student.getfirstName() +
                       ", lastName: " + student.getlastName() +
                       ", studentId: " + student.getstudentId() +
                       ", a1: " + student.geta1() +
                       ", a2: " + student.geta2() +
                       ", a3: " + student.geta3() +
                       ", total: " + student.calculateTotal());
                }
        }
         System.out.println();   
    }
    
    //F4: Top 5 students with highest marks
    public static void topFiveStudents(ArrayList<Student> students) {
        ArrayList<Student> topFiveStudents = new ArrayList<>();
        
        for (Student student : students) {
            if (topFiveStudents.size() < 5) {
                topFiveStudents.add(student);
            } else {
                // Find the student with the lowest total marks in the current top 5
                Student lowestTotalStudent = topFiveStudents.get(0);
                for (Student topStudent : topFiveStudents) {
                    if (topStudent.calculateTotal() < lowestTotalStudent.calculateTotal()) {
                        lowestTotalStudent = topStudent;
                    }
                }

                // If the current student has a higher total, replace the lowest total student
                if (student.calculateTotal() > lowestTotalStudent.calculateTotal()) {
                    topFiveStudents.remove(lowestTotalStudent);
                    topFiveStudents.add(student);
                }
            }
        }
            
            for (Student student : topFiveStudents) {
                System.out.println("firstName: " + student.getfirstName() +
                       ", lastName: " + student.getlastName() +
                       ", studentId: " + student.getstudentId() +
                       ", a1: " + student.geta1() +
                       ", a2: " + student.geta2() +
                       ", a3: " + student.geta3() +
                       ", total: " + student.calculateTotal());
        }  
    }
    
    //F5: Top 5 students with lowest marks
    public static void topFiveLowestStudents(ArrayList<Student> students) {
        ArrayList<Student> topFiveLowestStudents = new ArrayList<>();
        
        for (Student student : students) {
            if (topFiveLowestStudents.size() < 5) {
                topFiveLowestStudents.add(student);
            } else {
                // Find the student with the higest total marks in the current top 5
                Student highestTotalStudent = topFiveLowestStudents.get(0);
                for (Student lowestStudent : topFiveLowestStudents) {
                    if (lowestStudent.calculateTotal() > highestTotalStudent.calculateTotal()) {
                        highestTotalStudent = lowestStudent;
                    }
                }

                // If the current student has a lowest total, replace the highest total student
                if (student.calculateTotal() < highestTotalStudent.calculateTotal()) {
                    topFiveLowestStudents.remove(highestTotalStudent);
                    topFiveLowestStudents.add(student);
                }
            }
        }
            
            for (Student student : topFiveLowestStudents) {
                System.out.println("firstName: " + student.getfirstName() +
                       ", lastName: " + student.getlastName() +
                       ", studentId: " + student.getstudentId() +
                       ", a1: " + student.geta1() +
                       ", a2: " + student.geta2() +
                       ", a3: " + student.geta3() +
                       ", total: " + student.calculateTotal());
        }  
    }
}