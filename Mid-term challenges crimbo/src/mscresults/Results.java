package mscresults;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Results {

	public static void main(String[] args) {
		ArrayList<Student> students = readInStudents("ModuleScoresMSc.csv");
		displayStudentInfo(students);
		outputGraduation(students,"Graduation.txt");

	}

	private static void outputGraduation(ArrayList<Student> students, String filename) {
		
		try {
			File file = new File(filename);
			FileWriter fw;
			fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			String toWrite = "";
			
			for(Student s : students) {
				toWrite = String.format("%d, %s, %s, %s%n", s.getStudentNumber(), s.getFirstName(), s.getLastName(), classification(s.avgMark()));
				bw.write(toWrite);
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void displayStudentInfo(ArrayList<Student> students) {
		for(Student s : students) {
			System.out.println("Name: "+s.getFirstName()+" "+s.getLastName());
			System.out.println("Module Results:");
			System.out.println("Programming: "+s.getProg());
			System.out.println("Comp found: "+s.getCf());
			System.out.println("DBs: "+s.getDb());
			System.out.println("Web: "+s.getWeb());
			System.out.println("Software: "+s.getSe());
			System.out.println("Average: "+s.avgMark());
			System.out.println("Classification: "+classification(s.avgMark()));
			System.out.println();
		}
		
	}

	private static String classification(double avgMark) {
		String result ="";
		if(avgMark>100 || avgMark<0) {
			result = "Error!";
		} else if (avgMark>=70 && avgMark<=100) {
			result = "Distinction";
		} else if(avgMark>=60 && avgMark <= 69) {
			result = "commendation";
		} else if(avgMark>=50 && avgMark<=59) {
			result = "pass";
		} else {
			result = "fail";
		}
		return result;
	}

	private static ArrayList<Student> readInStudents(String filename) {
		
		ArrayList<Student> students = new ArrayList<Student>();
		try {
			String line;
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String[] studentDetails;
			
			
			line = br.readLine();//throw away header
			line = br.readLine();
			while(line!=null) {
				studentDetails = line.split(",");
				Student st = new Student(Integer.parseInt(studentDetails[0]), studentDetails[1], studentDetails[2], Integer.parseInt(studentDetails[3]), Integer.parseInt(studentDetails[4]), Integer.parseInt(studentDetails[5]), Integer.parseInt(studentDetails[6]), Integer.parseInt(studentDetails[7]));
				students.add(st);
				line = br.readLine();
			}
			
		
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return students;
	}


}
