package thirdtry;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToFile implements Runnable {

	private String winner;
	
	
	
	/**
	 * @param winner
	 */
	public ToFile(String winner) {
		this.winner = winner;
	}



	@Override
	public void run() {
		File file = new File("winner.txt");
		
		try(FileWriter fr = new FileWriter(file,true); BufferedWriter bw = new BufferedWriter(fr)){
			bw.write(winner);
			bw.newLine();
			System.out.println("Winner written to file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
