package fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadingExampleDuringLecutre {

	public static void main(String[] args) {
		
		try {
			String line;
			File myFile = new File("listofnames.txt");
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine();
			
			while(line!=null) {
			System.out.println(line);
			line = br.readLine();
			}
			//for reading a string array with ints and casting it back to integers - use this Integer.parseInt(String[index]);
			//double equivilent Double.parseDouble();
			fr.close();
			br.close();
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find file");
			e.printStackTrace();
		} catch(IOException ex) {
			System.out.println("Oops, reading failed");
		} 
		
		System.out.println("End of program");

	}

}
