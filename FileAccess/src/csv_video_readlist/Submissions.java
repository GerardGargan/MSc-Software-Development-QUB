package csv_video_readlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Submissions {

	public static void main(String[] args) {
		String fileName = "examSubmissionsSample.csv";
		String readline;
		
		
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			readline = br.readLine();
			while(readline!=null) {
				if(!readline.equalsIgnoreCase("ID,Name,Indicator (Lab/Email)")) {
					
				System.out.println(readline.replace(',', ' '));
				}
				readline = br.readLine();
			}
			
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
		
		

	}

}
