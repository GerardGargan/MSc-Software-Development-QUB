package csvfootball;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AnalyseThis {

	public static void main(String[] args) {
		String filename = "scores.csv";
			
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();
			String gameInfo[] = null;
			int game1, game2;
			
			
			while(line!=null) {
				gameInfo = line.split(",");
				game1 = Integer.parseInt(gameInfo[1]); //1st score
				game2 = Integer.parseInt(gameInfo[3]); //2nd score
				
				
				System.out.printf("%s %d\t %s %d\t\t",gameInfo[0],game1,gameInfo[2],game2);
				if(game1>game2) {
					System.out.print("Winner: "+gameInfo[0]+"\n");
				} else if(game2>game1) {
					System.out.print("Winner: "+gameInfo[2]+"\n");
				} else {
					System.out.println("Draw"+"\n");
				}
				
				line = br.readLine();
			}
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found, check filename and path location");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
