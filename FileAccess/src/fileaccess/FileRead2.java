package fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead2 {

	public static void main(String[] args) {

		try {
		String line;
		File file = new File("File.txt");
		FileReader filereader = new FileReader(file.getName());
		BufferedReader buffread = new BufferedReader(filereader);
		
		line = buffread.readLine();
		while(line!=null) {
			System.out.println(line);
			line = buffread.readLine();
		}
		
		buffread.close();
		filereader.close();
		

		} catch(IOException ex) {
			System.out.println("File does not exist");
			ex.printStackTrace();
		}
	}

}
