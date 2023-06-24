package tvrater;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TvRatings {
	
	public static ArrayList<TvProgramme> progs = new ArrayList<TvProgramme>();

	public static void main(String[] args) {
		
		//takes csv and populates arraylist with TvProgramme objects
		PopulateTvList("TvProgrammes.csv");
		//display tostrig for all tv shows in the arraylist
		displayTvList(progs);
		//search & display results
		displayTvList(searchTvProg(progs, "BBC"));
		//recieves an arraylist and writes to file specified
		writeProgrammesToFile("BBCProgs.csv", searchTvProg(progs, "BBC"));

	}
	
	/**
	 * Revieces a filename as a string, recieves an Array List of type TvProgrammes
	 * Iterates through each TvProgramme, converts the data into CSV format and writes to the file specified
	 * NOTE that each time this is ran, the file will be overwritten.
	 * @param fileName
	 * @param tvProgs
	 */
	public static void writeProgrammesToFile(String fileName, ArrayList<TvProgramme> tvProgs) {
		
		try {
			//open the file
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);
			BufferedWriter br = new BufferedWriter(fw);
			
			for(TvProgramme prog : tvProgs) {
				//output in CSV format, store in variable to be written
				String toWrite = String.format("%s,%s,%d,%f%n", prog.getName(),prog.getBroadcaster(),prog.getRating(),prog.getAverageAudience());
				br.write(toWrite); //write to file
			}
			
			br.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Method for searching an ArrayList of type TvProgramme
	 * Recieves an ArrayList and a search key
	 * Iterates through the ArrayList, checks if the toString contains the search key
	 * returns an ArrayList of TvProgrammes that contained the search key (case sensitive).
	 * @param tvProg
	 * @param key
	 * @return
	 */
	public static ArrayList<TvProgramme> searchTvProg(ArrayList<TvProgramme> tvProg, String key){
		ArrayList<TvProgramme> results = new ArrayList<TvProgramme>();
		
		//iterate through all of the TvProgrammes in the ArrayList
		for(TvProgramme tv : tvProg) {
			//if the object's to string method contains the search key, add it to the results list
			if(tv.toString().contains(key)) {
				results.add(tv);
			}
		}
		
		//return the results
		return results;
	}
	
	/**
	 * Recieves an ArrayList of type TvProgramme
	 * Iterates through and outputs the toString method for each TvProgram in the ArrayList
	 * @param progs2
	 */
	public static void displayTvList(ArrayList<TvProgramme> progs2) {
		for(TvProgramme tv : progs2) {
			System.out.println(tv.toString());
		}
		
	}

	/**
	 * Revieves the fileName of the file to read
	 * Reads the file (CSV), splits by the comma and creates a TvProgramme object for each line in the file
	 * Stores the objects in an ArrayList of type TvProgramme (static ArrayList at the start of this class).
	 * @param fileName
	 */
	public static void PopulateTvList(String fileName){
		
		try {
			File file = new File(fileName);	
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			line = br.readLine(); //throw away the header
			line = br.readLine(); //read the first line
			String[] progInfo; //set up an array to hold the information when it is split out by the comma
			
			
			while(line!=null) {
				progInfo = line.split(","); //split by the comma seperator
				//Create an object and add it to the ArrayList
				progs.add(new TvProgramme(progInfo[0], progInfo[1], Integer.parseInt(progInfo[2]), Double.parseDouble(progInfo[3])));
				
				line = br.readLine(); //read the next line
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
