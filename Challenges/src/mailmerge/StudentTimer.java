package mailmerge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class StudentTimer {

	public static void main(String[] args) {

		analyseStudentTimes("input.csv");

	}

	private static void analyseStudentTimes(String fileName) {
		File file = new File(fileName);
		
		try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
			
			String line = br.readLine(); //throw headers away
			line = br.readLine();
			String[] parts;
			
			while(line!=null) {
				
				parts = line.split(",");
				String name = parts[0];
				int studentNum = Integer.parseInt(parts[1]);
				LocalTime logon = LocalTime.parse(parts[2]);
				LocalTime logoff = LocalTime.parse(parts[3]);
				String email = parts[4];
				
				//calc difference
				
				Duration duration = Duration.between(logon, logoff);
				long durInMins = duration.toMinutes();
				
				if(durInMins<100) {
					//create a file
					createStudentLateFile(name, durInMins, email,logon,logoff, studentNum);
				}
				
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void createStudentLateFile(String name, long durInMins, String email, LocalTime logon, LocalTime logoff, int studentNum) {
		String fileName = name+".txt";
		
		String toWrite = String.format("Dear %s,%n"
				+ "You didnt last too long at the lecture today (%d mins.) You need to stay the full duration."
				+ "%n%nName: %s%n"
				+ "Student No: %d%n"
				+ "Logon Time: %s%n"
				+ "Logoff Time: %s%n"
				+ "Email: %s", name, durInMins,name,studentNum,logon.toString(),logoff.toString(),email);
		
		File file = new File(fileName);
		try(FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)){
			bw.write(toWrite);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File written "+fileName);
		
	}

}
