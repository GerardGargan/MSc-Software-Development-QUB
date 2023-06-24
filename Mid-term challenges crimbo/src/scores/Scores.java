package scores;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Scores {

	public static void main(String[] args) {
		
		
		try {
			File file = new File("Scores.csv");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String match = br.readLine();
			String[] matchInfo;
			
			while(match!=null) {
				matchInfo = match.split(",");
				int score1 = Integer.parseInt(matchInfo[1]);
				int score2 = Integer.parseInt(matchInfo[3]);
				String winner = (score1>score2) ? matchInfo[0]:matchInfo[2];
				System.out.printf("%s %d : %s %d \tWinner: %s%n",matchInfo[0],score1,matchInfo[2],score2,winner);
				match = br.readLine();
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

	}

}
