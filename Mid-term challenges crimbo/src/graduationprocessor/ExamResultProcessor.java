package graduationprocessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExamResultProcessor {

	public static void main(String[] args) {

		
		String fileName = "ModuleScoresMSc.csv";
		//read in students from the file, store in array list
		ArrayList<Student> students = readInStudents(fileName, ",");
		//display all students
		displayStudents(students);
		//write to file all students who achieve a pass mark or above which is set in the arguments
		writeToFile(studentsToGraduate(students, 50), "Graduation2.txt");


	}
	
	/**
	 * Search the array list of students, check if they are equal to or above the pass mark passed in, return array list of students that are equal to or above the pass mark
	 * @param students
	 * @param passMark
	 * @return
	 */
	public static ArrayList<Student> studentsToGraduate(ArrayList<Student> students, double passMark){
		//set up array list to hold results from the search
		ArrayList<Student> result = new ArrayList<Student>();
		
		//iterate through each student
		for(Student s : students) {
			//if the students average mark is above the pass mark, add them to the results
			if(s.avgResult()>=passMark) {
				result.add(s);
			}
		}
		//return the array list with students added
		return result;
	}
	
	/**
	 * Write to file an array list of student objects, file name passed in arguments
	 * @param students
	 * @param fileName
	 */
	public static void writeToFile(ArrayList<Student> students, String fileName) {
		
		try {
			//set up the file writing
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String toWrite = "";
			
			//iterate through each student in the array list
			for(Student s : students) {
				toWrite = String.format("Student number: %d%nFirst Name: %s%nLast Name: %s%nClassification: %s%n%n",s.getStudentNumber(),
						s.getFirstName(),s.getLastName(),s.result());
				//write the string to file
				bw.write(toWrite);
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of writing");
		
	}
	
	/**
	 * Read from a file containing student details, create a student object for each student and return an array list of students
	 * @param source
	 * @param delimiter
	 * @return
	 */
	public static ArrayList<Student> readInStudents(String source, String delimiter){
		//set up array list to add students to
		ArrayList<Student> students = new ArrayList<Student>();
		
		try {
			//open file, prepare to read
			File file = new File(source);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//read first line
			String line = br.readLine(); //throw away headers
			line = br.readLine(); //read the first line of student data
			String[] studentInfo; //create array to hold the details when we separate out from the delimiter
			
			while(line!=null) {
				studentInfo = line.split(delimiter);//split by the delimiter
				//create the student, parse as appropriate for data which needs to be converted from string to another type
				Student s1 = new MScStudent(studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[0]), Integer.parseInt(studentInfo[3]), Integer.parseInt(studentInfo[4]), Integer.parseInt(studentInfo[5]), Integer.parseInt(studentInfo[6]), Integer.parseInt(studentInfo[7]));
				//add the student to an array list
				students.add(s1);
				//read the next line and go around the while loop if !=null
				line = br.readLine();
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}
	
	/**
	 * method to display details of students stored in an array list
	 * @param students
	 */
	public static void displayStudents(ArrayList<Student> students) {
		for(Student s : students) {
			System.out.println(s.toString());
			System.out.println();
		}
	}

}
