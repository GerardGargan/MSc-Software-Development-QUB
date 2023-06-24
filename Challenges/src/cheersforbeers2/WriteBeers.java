package cheersforbeers2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WriteBeers implements Runnable {
	
	private List<Beer> beers;
	private String fileName;
	
	

	/**
	 * @param beers
	 * @param fileName
	 */
	public WriteBeers(List<Beer> beers, String fileName) {
		setBeers(beers);
		setFileName(fileName);
	}



	/**
	 * @return the beers
	 */
	public List<Beer> getBeers() {
		return beers;
	}



	/**
	 * @param beers the beers to set
	 */
	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}



	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}



	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public void run() {
		
		System.out.println("Starting to write to file..");

		File file = new File(fileName);
		Collections.sort(beers, new CompareBeersByPercentage());	
		try(FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)){
			//for each beer in the list, write it to a csv file
			for(Beer beer : beers) {
				String toWrite = String.format("%s,%s,%s,%.2f%n", beer.getName(),beer.getStyle(),beer.getCountry(),beer.getPercentage());
				bw.write(toWrite);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished writing to file");
		
	}

}
