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
                
                }
                
                if(userEntry == 4) {
                
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
}