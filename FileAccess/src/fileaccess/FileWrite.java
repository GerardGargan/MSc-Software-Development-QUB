package fileaccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

	public static void main(String[] args) {
		
		
		try {
			String termToAdd = "I wrote this!";
			File File = new File("File.txt");
			
			FileWriter filewrite = new FileWriter(File, true);
			BufferedWriter bw = new BufferedWriter(filewrite);
			bw.write(termToAdd);
			bw.close();
			filewrite.close();
			
		} catch(IOException ex) {
			System.out.println("File not found...");
			ex.printStackTrace();
		}

	}

}
