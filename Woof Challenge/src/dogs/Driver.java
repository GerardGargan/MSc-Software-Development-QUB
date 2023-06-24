package dogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Driver {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		
		List<Dog> dogList = readin("DogData.csv");
		
		displayMenu(dogList);
		
		sc.close();

	}

	private static void displayMenu(List<Dog> dogList) {
		
		int userChoice = 0;
		
		do {
		System.out.println("Please select an option and press enter:");
		System.out.println("1. Show all dogs");
		System.out.println("2. Order and show by height");
		System.out.println("3. Order and show by weight");
		System.out.println("4. Group and show by country");
		System.out.println("5. Exit");
		
		//open keyboard for user input
		
		try {
		userChoice = sc.nextInt();
		} catch(InputMismatchException ee) {
			System.out.println("Invalid data entered");
			sc.next(); //throw away stored exception/tokens?
			continue; //skip the rest of this iteration, go to the next iteration
			
		}
		
		
		switch(userChoice) {
		case 1: System.out.println("Displaying all dogs..");
		displayAllDogs(dogList);
		break;
		case 2: 
			List<Dog> copy = new ArrayList<Dog>(dogList);
			Collections.sort(copy, new CompareDogsByHeight());
			
			System.out.println("Displaying dogs sorted by height...");
			System.out.println();
			displayAllDogs(copy);
		break;
		case 3: System.out.println("Order and show by weight..");
		List<Dog> copy2 = new ArrayList<Dog>(dogList);
		Collections.sort(copy2, new CompareDogsByWeight());
		System.out.println();
		displayAllDogs(copy2);
		break;
		case 4: System.out.println("Grouping and showing by country");
		Map<String, Integer> countryMap = countryStats(dogList);
		displayCountryStats(countryMap);
		
		break;
		case 5: System.out.println("Quitting..");
		break;
		default: System.out.println("Invalid selection");
		}
		
		} while (userChoice!=5);
		
		
		
		
	}
	
	private static void displayCountryStats(Map<String, Integer> map) {
		
		for(String country : map.keySet()) {
			System.out.println(country+": "+map.get(country));
		}
		
	}
	
	private static Map<String, Integer> countryStats(List<Dog> list) {
		TreeMap<String, Integer> countryFreq = new TreeMap<String, Integer>();
		
		for(Dog dog : list) {
			if(countryFreq.containsKey(dog.getCountry())) {
				//country already exists in map, increment value
				int freq = countryFreq.get(dog.getCountry());
				countryFreq.put(dog.getCountry(), freq+1);
				
			} else {
				//country doesnt exist, add it to the map
				countryFreq.put(dog.getCountry(), 1);
			}
		}
		
		return countryFreq;
	}

	public static void displayAllDogs(List<Dog> list) {
		if(list==null || list.size()==0) {
			throw new IllegalArgumentException("List cant be empty or null");
		} else {
			for(Dog dog : list) {
				dog.displayDogDetail();
				System.out.println();
			}
		}
	}

	private static List<Dog> readin(String fileName) {
		List<Dog> list = new ArrayList<Dog>();
		
		File file = new File(fileName);
		
		
		try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)){
			
			String[] parts;
			String line = br.readLine(); //throw away headers
			line = br.readLine(); //getting the first line of data
			
			int badLines = 0;
			
			while(line!=null) {
				try {
				parts = line.split(",");
				String breed = parts[0];
				double weight = Double.parseDouble(parts[1]);
				double height = Double.parseDouble(parts[2]);
				double lifeexp = Double.parseDouble(parts[3]);
				String color = parts[4];
				String country = parts[5].strip();
				
				list.add(new Dog(breed, weight, lifeexp, color, country, height));
				} catch(Exception exp) {
					System.out.println("Skipping bad line of data ("+(++badLines)+")");
				}
				line = br.readLine();
			}
			
			System.out.println("Dogs created: "+list.size());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
