package europeancup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ECWinners {

	public static void main(String[] args) {
		String filename = "ECWinners.txt";
		String line;
		ArrayList<String> winners = new ArrayList<String>();
		
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine();
			
			
			while(line!=null) {
				winners.add(line);
				line = br.readLine();
			}
			
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		displayAllWinners(winners);
		System.out.println();
		displayWinnersNoDuplicates(winners);
	}
	
	public static void displayWinnersNoDuplicates(ArrayList<String> winners) {
		ArrayList<String> winnersNoDuplicates = new ArrayList<String>();
		for(int i=0; i<winners.size(); i++) {
			
			if(!winnersNoDuplicates.contains(winners.get(i))) {
				winnersNoDuplicates.add(winners.get(i));
			}
		}
		
		for(String wins : winnersNoDuplicates) {
			System.out.println(wins);
		}
		
	}

	public static void displayAllWinners(ArrayList<String> winners) {
		int year = 1956;
		for(String winner : winners) {
			System.out.println(year++ +": "+winner);
		}
	}

}
