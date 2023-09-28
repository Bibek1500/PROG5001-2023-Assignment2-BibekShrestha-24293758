import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;


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
}