package woofchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		List<Dog> dogs = readDogs("DogData.csv");
		
		displayMenu(dogs);
		
		sc.close();

	}

	private static void displayMenu(List<Dog> dogs) {
		int userInput = 0;
		do {
		System.out.println("Please select from the following options: ");
		System.out.println("1. Show all");
		System.out.println("2. Order and show by height");
		System.out.println("3. Order and show by weight");
		System.out.println("4. Group and show by country (frequency of breeds for each country)");
		System.out.println("5. Output all dogs over 6kg to file, ordered by weight descending");
		System.out.println("6. Quit");
		
		try {
		userInput = sc.nextInt();
		} catch(Exception ee) {
			System.out.println("Invalid character");
			sc.nextLine(); //clear the scanner
		}
		
		switch(userInput) {
		case 1: System.out.println("Showing all dogs");
		displayDogs(dogs);
		break;
		case 2: System.out.println("Ordering and displaying by height");
		//create a copy so not to change original list
		List<Dog> copy1 = new ArrayList<Dog>(dogs);
		Collections.sort(copy1, new CompareDogsByHeight());
		displayDogs(copy1);
		break;
		case 3: System.out.println("Ordering and displaying by weight");
		List<Dog> copy2 = new ArrayList<Dog>(dogs);
		Collections.sort(copy2, new CompareDogsByWeight());
		displayDogs(copy2);
		break;
		case 4: System.out.println("Grouping and showing by country (frequency for each country)");
		Map<String, Integer> byCountry = displayFreqByCountry(dogs);
		displayCountryStats(byCountry);
		break;
		case 5: System.out.println("Outputting all dogs over 6kg to file, ordered by weight descending");
		List<Dog> searchResult = searchByWeight(dogs, 6);
		writeToFile(searchResult, "searchDogsByWeight.txt");
		break;
		case 6: System.out.println("Quitting");
		break;
		default: System.out.println("Invalid option! Try again");
		}
		
		} while(userInput!=6);
		
		
		
	}

	/**
	 * Writes results in a separate file
	 * @param searchResult
	 * @param fileName
	 */
	private static void writeToFile(List<Dog> searchResult, String fileName) {
		WriteResultsToFile writer = new WriteResultsToFile(searchResult, "resultsDogWeight.csv");
		Thread th = new Thread(writer);
		th.start();
		
	}

	/**
	 * Searches a list of dogs for dogs over a certain weight passed in
	 * @param dogs
	 * @param i
	 * @param string
	 * @return
	 */
	private static List<Dog> searchByWeight(List<Dog> dogs, int weightOver) {
		List<Dog> results = new ArrayList<Dog>();
		
		for(Dog dog : dogs) {
			if(dog.getWeight()>weightOver) {
				results.add(dog);
			}
		}
		
		return results;
	}

	private static void displayCountryStats(Map<String, Integer> byCountry) {
		for(String country : byCountry.keySet()) {
			System.out.println("Country: "+country);
			System.out.println("Value: "+byCountry.get(country));
		}
		
	}

	private static Map<String, Integer> displayFreqByCountry(List<Dog> dogs) {
		Map<String, Integer> countryMap = new TreeMap<String, Integer>();
		
		for(Dog dog : dogs) {
			if(countryMap.containsKey(dog.getCountry())){
				//country exists, get it and increment value by 1
				int value = countryMap.get(dog.getCountry());
				countryMap.put(dog.getCountry(), value+1);
			} else {
				countryMap.put(dog.getCountry(), 1);
			}
		}
		
		return countryMap;
		
	}

	/**
	 * Print all dog details from the list, using the toString method in Dog
	 * @param dogs
	 */
	private static void displayDogs(List<Dog> dogs) {
		if(dogs==null || dogs.size()==0) {
			System.out.println("No dogs to show");
		} else {
			for(Dog dog : dogs) {
				System.out.println(dog.toString());
				
			}
		}
		
	}

	/**
	 * Reads a specified file and creates dog objects using the data inside the file
	 * @param fileName
	 * @returns a list of dog objects created
	 */
	private static List<Dog> readDogs(String fileName) {
		List<Dog> dogslist = new ArrayList<Dog>();
		
		File file = new File(fileName);
		try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
			
			String line = br.readLine(); //throw away header
			line = br.readLine();
			String[] parts;
			int linenum = 1;
			
			while(line!=null) {
				
				try {
				parts = line.split(",");
				String breed = parts[0];
				double weight = Double.parseDouble(parts[1]);
				double height = Double.parseDouble(parts[2]);
				double lifeExp = Double.parseDouble(parts[3]);
				String colour = parts[4];
				String country = parts[5];
				
				dogslist.add(new Dog(breed, weight, height, colour, country, lifeExp));
				} catch(Exception ee) {
					System.out.println("Skipping bad line of data on line "+linenum);
				}
				linenum++;
				
				//read next line
				line = br.readLine();
			}
			
			System.out.println("Dogs created: "+dogslist.size());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dogslist;
	}

}
