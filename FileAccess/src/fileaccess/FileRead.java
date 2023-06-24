package fileaccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

	public static void main(String[] args) {
		String line;
		
		try {
		File file = new File("File.txt");
		
		FileReader filereader = new FileReader(file.getName());
		
		BufferedReader bufferReader = new BufferedReader(filereader);
		
		line = bufferReader.readLine();
		while(line!=null) {
			System.out.println(line);
			line = bufferReader.readLine();
		}
		bufferReader.close();
		filereader.close();
		
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

}
