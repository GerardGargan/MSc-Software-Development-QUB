package woofchallenge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class WriteResultsToFile implements Runnable {

	private List<Dog> dogs;
	private String fileName;
	
	
	
	/**
	 * @param dogs
	 * @param fileName
	 */
	public WriteResultsToFile(List<Dog> dogs, String fileName) {
		setDogs(dogs);
		setFileName(fileName);
	}



	/**
	 * @return the dogs
	 */
	public List<Dog> getDogs() {
		return dogs;
	}



	/**
	 * @param dogs the dogs to set
	 */
	public void setDogs(List<Dog> dogs) {
		this.dogs = dogs;
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
		System.out.println("Writing results to file");
		Collections.sort(dogs, new CompareDogsByWeight());
		File file = new File(fileName);
		
		try(FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)){
			
			for(Dog dog : dogs) {
				String toWrite = String.format("%s,%.2f", dog.getBreed(), dog.getWeight());
				bw.write(toWrite);
				bw.newLine();
			}
			
			System.out.println("Writing finished");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
