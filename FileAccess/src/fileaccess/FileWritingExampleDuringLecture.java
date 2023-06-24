package fileaccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingExampleDuringLecture {

	public static void main(String[] args) {
		
		
		try {
			File myFile = new File("output.txt");
			FileWriter fw = new FileWriter(myFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Words");
			bw.newLine();
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("Something wrong");
			e.printStackTrace();
		}
		
	}

}
