import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;



/**
 * Write a description of class Main here.
 *
 * @author (Bibek Shrestha)
 * @version (28/09/2023)
 */
public class Main
{
    public static void main(String[] args){
        Tasks tsk = new Tasks();
        tsk.readingFile();
        //tsk.filterStudent();
        //tsk.topHighestStudents();
        tsk.topLowestStudents();
    }   
}

class Tasks{
    
        static String csvPath = "grades.csv";
	static String[] data;
	static ArrayList<Double> total = new ArrayList<>();
	static ArrayList<String> lastName = new ArrayList<>();
	static ArrayList<String> firstName = new ArrayList<>();
	static ArrayList<String> id = new ArrayList<>();
	static ArrayList<String> a1 = new ArrayList<>();
	static ArrayList<String> a2 = new ArrayList<>();
	static ArrayList<String> a3 = new ArrayList<>();
	
	//top highest students variable
	static ArrayList<String> hLastName = new ArrayList<>();
	static ArrayList<String> hFirstName = new ArrayList<>();
	static ArrayList<Double> hMarks = new ArrayList<>();
	
	//top Lowest students variable
	static ArrayList<String> lLastName = new ArrayList<>();
	static ArrayList<String> lFirstName = new ArrayList<>();
	static ArrayList<Double> lMarks = new ArrayList<>();
	
	// parse the string value to double and returns the sum
	public static double parseValue(String num1, String num2, String num3) {
		double value1 = Double.parseDouble(num1);
		double value2 = Double.parseDouble(num2);
		double value3 = Double.parseDouble(num3);
		double sum = value1 + value2 + value3;
		return sum;
	}  
    
        // reads the csv file and calculated the total of the students
	public static void readingFile() {
		try {
		BufferedReader reader = new BufferedReader(new FileReader(csvPath));
		String line;
		while ((line = reader.readLine()) != null) {
                    data = line.split(",");
                    lastName.add(data[0]);
                    firstName.add(data[1]);
                    id.add(data[2]);
                    a1.add(data[3]);          
                    a2.add(data[4]);          
                    a3.add(data[5]); 

           		
           			System.out.println(Arrays.toString(data));
           			System.out.println();
           		

                }   

                for( int i = 0; i<a1.size(); i++) {
                		total.add(parseValue(a1.get(i), a2.get(i), a3.get(i))); 
                	}
                
                System.out.println("Total: " + total);
                
        
                reader.close(); 

		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	// listing the student's detail below threshold
	public static void filterStudent() {
		double marks;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter threshold marks: ");
		marks = sc.nextDouble();
		
		for(int i = 0; i < a1.size(); i++) {
			if(total.get(i) < marks) {

				System.out.println(firstName.get(i)+ "\t" + lastName.get(i) + "\t" +total.get(i));
			}
		}
	}
	
	// displaying the top 5 students with highest marks
	public static void topHighestStudents() {
		for(int i =0; i<5; i++) {
			double max = Double.MIN_VALUE;
			String last = "";
			String first = "";
			int maxIndex = -1;

			for(int j = 0; j < total.size(); j++) {
				if(!hMarks.contains(total.get(j)) && total.get(j) > max
					&& !hFirstName.contains(firstName.get(j)) && 
					!hLastName.contains(lastName.get(j))
				) {
					max = total.get(j);
					last = firstName.get(j);
					first = lastName.get(j);
					maxIndex = j;
				}
			}

			if(maxIndex != -1) {
				hMarks.add(max);
				hFirstName.add(first);
				hLastName.add(last);
			}
		}
        		System.out.println("Top five students with highest marks");

		for(int i = 0; i < hMarks.size(); i++) {
				System.out.println(hFirstName.get(i)+ "\t" + hLastName.get(i) + "\t" + hMarks.get(i));
			}
	}
	
	
	// displaying the top 5 students with lowest marks
	public static void topLowestStudents() {
		for(int i =0; i<5; i++) {
			double min = Double.MAX_VALUE;
			String last = "";
			String first = "";
			int minIndex = -1;

			for(int j = 0; j < total.size(); j++) {
				if(!lMarks.contains(total.get(j)) && total.get(j) < min
					&& !hFirstName.contains(firstName.get(j)) && 
					!hLastName.contains(lastName.get(j))) {
						min = total.get(j);
						last = firstName.get(j);
						first = lastName.get(j);
						minIndex = j;
					}
			}
			if(minIndex != -1) {
				lMarks.add(min);
				lFirstName.add(first);
				lLastName.add(last);
			}
		}
		
		System.out.println("Top five students with lowest marks");
		for(int i = 0; i < lMarks.size(); i++) {
			System.out.println(lFirstName.get(i)+ "\t" + lLastName.get(i) + "\t" +lMarks.get(i));
		}
	}
	
	
}