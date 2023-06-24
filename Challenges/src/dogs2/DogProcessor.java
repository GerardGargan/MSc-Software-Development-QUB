package dogs2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class DogProcessor {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Dog> dogs = readDogs("DogData.csv");
		displayMenu(dogs);
		sc.close();
	}

	private static void displayMenu(List<Dog> dogs) {
		int userInput = 0;
		do {
			System.out.println("Please choose an option from the menu");
			System.out.println("1. Display all dogs");
			System.out.println("2. Order and show by height, smallest first");
			System.out.println("3. Order and show by weight, heaviest first");
			System.out.println("4. Group and show by country (freq of breeds in each country)");
			System.out.println("5. Search for dogs in a specific country");
			System.out.println("6. Quit");

			try {
				userInput = sc.nextInt();
			} catch (Exception ee) {
				System.out.println("Invalid input, must be a number");
				sc.nextLine(); // clear the exeption from the scanner
			}

			switch (userInput) {
			case 1:
				System.out.println("Displaying all dogs");
				printDogs(dogs);
				break;
			case 2:
				System.out.println("Ordering and displaying by height, smallest first");
				List<Dog> byHeight = new ArrayList<Dog>(dogs); //copy list
				Collections.sort(byHeight, new CompareDogByHeight());
				printDogs(byHeight);
				break;
			case 3:
				System.out.println("Ordering and showing by weight, heaviest first");
				List<Dog> byWeight = new ArrayList<Dog>(dogs);
				Collections.sort(byWeight, new CompareDogsByWeight());
				printDogs(byWeight);
				break;
			case 4:
				System.out.println("Grouping and showing freq by country");
				printFreqByCountry(dogs);
				break;
			case 5:
				System.out.println("Searching for dogs in country");
				String userCountryInput = sc.next();
				List<Dog> byCountry = searchByCountry(dogs, userCountryInput);
				System.out.println("Country: "+userCountryInput);
				printDogs(byCountry);
				break;
			case 6:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Invalid choice, please select a valid option");
			}

		} while (userInput != 6);

	}

	private static List<Dog> searchByCountry(List<Dog> dogs, String userCountryInput) {
		List<Dog> results = new ArrayList<Dog>();
		if(dogs==null || dogs.size()==0) {
			System.out.println("Empty dogs list passed in");
		} else if(userCountryInput.isEmpty()) {
			System.out.println("Country being searched for must not be empty!");
		} else {
			for(Dog dog : dogs) {
				if(dog.getCountry().equalsIgnoreCase(userCountryInput)) {
					results.add(dog);
				}
			}
		}
		return results;
	}

	private static void printFreqByCountry(List<Dog> dogs) {
		Map<String, Integer> countryFreq = new TreeMap<String, Integer>();	
		
		for(Dog dog : dogs) {
			if(countryFreq.containsKey(dog.getCountry())) {
				//country is already in the map, just increment the count by 1
				countryFreq.put(dog.getCountry(), countryFreq.get(dog.getCountry())+1);
			} else {
				//country doesnt exist in the map add it with a value of 1
				countryFreq.put(dog.getCountry(), 1);
			}
		}
		
		for(String country : countryFreq.keySet()) {
			System.out.println("Country: "+country);
			System.out.println("Frequency: "+countryFreq.get(country));
		}
		
	}

	private static void printDogs(List<Dog> dogs) {
		if(dogs==null || dogs.size()==0) {
			System.out.println("No dogs to display");
		} else {
			
			System.out.printf("%-30s%-10s%-10s%-20s%-30s%-20s%n","Breed","Height","Weight","Life Expectancy","Colour","Country");
			for(Dog dog : dogs) {
				System.out.println(dog.toString());
			}
		}
		
	}

	private static List<Dog> readDogs(String fileName) {
		List<Dog> list = new ArrayList<Dog>();

		File file = new File(fileName);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine(); // throw away headers
			line = br.readLine();
			String[] parts;

			while (line != null) {

				parts = line.split(",");
				String breed = parts[0];
				double weight = Double.parseDouble(parts[1]);
				double height = Double.parseDouble(parts[2]);
				double lifeexp = Double.parseDouble(parts[3]);
				String colour = parts[4];
				String country = parts[5].strip();

				list.add(new Dog(breed, weight, height, lifeexp, colour, country));

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(list.size() + " Dogs read in");
		return list;
	}
}
