package cheersforbeers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ResultWriter implements Runnable {
	
	private List<Beer> beers;
	private String fileName;
	
		
	/**
	 * List of beers and filename to be used in the writing method
	 * @param beers
	 * @param fileName
	 */
	public ResultWriter(List<Beer> beers, String fileName) {
		this.beers = beers;
		this.fileName = fileName;
	}


	/**
	 * Method which will write to file the details of beers (comma separated).
	 */
	public void writeFile() {
		
		if(beers==null || beers.size()==0) {
			throw new IllegalArgumentException("Beer list null or empty, cant write");
		} else {
			File file = new File(fileName);
			
			try(FileWriter fw = new FileWriter(file); BufferedWriter br = new BufferedWriter(fw)){
				
				for(Beer beer : beers) {
					String line = String.format("%s,%s,%s,%.2f", beer.getName(),beer.getStyle(),beer.getCountry(),beer.getAlcoholpercent());
					br.write(line);
					br.newLine();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	@Override
	public void run() {
		System.out.println("Writing to file...");
		writeFile();
		System.out.println("Finished writing to file...");
		
	}

}
