package cheersforbeers2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Pub {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Beer> beers = readBeers("beer_data.csv");
		displayMenu(beers);

		sc.close();

	}

	private static void displayMenu(List<Beer> beers) {
		int userChoice = 0;
		do {
			System.out.println("Please select an option:");
			System.out.println("1. Show all beers");
			System.out.println("2. Order by name");
			System.out.println("3. Output to file all beers over 6% alcohol percentage");
			System.out.println("4. Remove duplicate beers");
			System.out.println("5. Search the list and determine if a beer is in the list");
			System.out.println("6. Shuffle the beers in the list");
			System.out.println("7. Find the beer with the biggest alcohol percentage");
			System.out.println("8. Find the beer with the lowest alcohol percentage");
			System.out.println("9. Reverse the beer names");
			System.out.println("10. Search a list by country, return all beers in that country");
			System.out.println("11. Order by alcohol percentage (largest first)");
			System.out.println("12. Quit");

			try {
			userChoice = sc.nextInt();
			} catch(InputMismatchException eee) {
				// dont need to print as already printed in default switch System.out.println("Invalid data entered, try again");
				sc.next(); //throw away exception in the scanner
			}

			switch (userChoice) {
			case 1:
				System.out.println("Displaying all beers..\n");
				displayBeers(beers);
				break;
			case 2:
				System.out.println("Sorting beers by name\n");
				Collections.sort(beers, new CompareBeerByName());
				break;
			case 3:
				System.out.println("Output to file all beers over 6% alcohol percentage");
				List<Beer> search = searchByPercent(beers, 6);
				Collections.sort(search, new CompareBeersByPercentage());
				writeToFile(search, "over6percent.csv");
				break;
			case 4:
				System.out.println("Remove duplicate beers from the list");
				removeDupes(beers);
				break;
			case 5:
				System.out.println("Searching the list and determine if a beer is in the list");
				System.out.println("Search for a beer.. Type the beer name and press enter");
				sc.nextLine();//throw away token
				String userSearchName = sc.nextLine();
				List<Beer> results = searchBeerByName(userSearchName.toLowerCase(), beers);
				System.out.println("Beers matching "+userSearchName+":");
				displayBeers(results);
				break;
			case 6:
				System.out.println("Shuffling beers in the list");
				Collections.shuffle(beers);
				break;
			case 7:
				System.out.println("Beer with the largest alcohol %");
				Beer maxBeerP = Collections.min(beers, new CompareBeersByPercentage());
				System.out.println(maxBeerP.toString());
				break;
			case 8:
				System.out.println("Beer with lowest alcohol %");
				Beer minBeerP = Collections.max(beers, new CompareBeersByPercentage());
				System.out.println(minBeerP);
				break;
			case 9:
				System.out.println("Reversing beer names (not altering original list)");
				reverseNames(beers);
				
				break;
			case 10:
				System.out.println("Search a beer by country.. enter country and press enter");
				sc.nextLine(); //throw away token
				String countryChoice = sc.nextLine();
				List<Beer> searchResultCountry = searchByCountry(countryChoice, beers);
				displayBeers(searchResultCountry);
				break;
			case 11:
				System.out.println("Ordering by alcohol percentage, largest first");
				Collections.sort(beers, new CompareBeersByPercentage());
				break;
			case 12:
				System.out.println("Quitting...");
				break;
			default: System.out.println("Invalid input try again");
			}

		} while (userChoice != 12);
	}

	

	private static List<Beer> searchByCountry(String countryChoice, List<Beer> beers) {
		List<Beer> result = new ArrayList<Beer>();
		
		if(countryChoice==null || countryChoice.length()==0) {
			System.out.println("You must enter a country");
		} else {
			for(Beer beer : beers) {
				if(beer.getCountry().toLowerCase().equals(countryChoice.toLowerCase())){
					result.add(beer);
				}
			}
		}
		
		return result;
	}

	private static void reverseNames(List<Beer> beers) {
		
		//using recursion
		for(Beer beer : beers) {
			String name = beer.getName();
			String reversed = recursiveReverse(name);
			System.out.println("Name reversed: "+reversed);
		}
		
		
		//String builder method
//		if(beers==null || beers.size()==0) {
//			System.out.println("Null or empty list");
//		} else {
//			for(Beer beer : beers) {
//				String currentName = beer.getName();
//				StringBuilder sb = new StringBuilder(currentName);
//				String reverseName = sb.reverse().toString();
//				System.out.println(reverseName);
//			}
//		}
		
	}

	private static String recursiveReverse(String name) {
		
		if(name.length()<2) {
			return name;
		}
		return recursiveReverse(name.substring(1))+name.charAt(0);
		
	}

	private static List<Beer> searchBeerByName(String name, List<Beer> beersPassedIn) {
		List<Beer> result = new ArrayList<Beer>();
		
		if(name==null || name.length()==0) {
			System.out.println("Invalid name or null list");
		} else {
			for(Beer beer : beersPassedIn) {
				if(beer.getName().toLowerCase().equals(name)) {
					result.add(beer);
				}
			}
		}
		
		return result;
	}

	/**
	 * Removes duplicate beers from the list, updates the beers list with only one occurence of each beer
	 * @param beers
	 */
	private static void removeDupes(List<Beer> beers) {
		
		List<Beer> noDupes = new ArrayList<Beer>();
		
		for(Beer beer : beers) {
			if(!noDupes.contains(beer)) {
				noDupes.add(beer);
			}
		}
		
		beers.clear();
		beers.addAll(noDupes);
		 
	}

	private static void writeToFile(List<Beer> beerList, String fileName) {
		WriteBeers wb = new WriteBeers(beerList, fileName);
		Thread th = new Thread(wb);
		th.start();
	}

	/**
	 * Search a list of beers for all beers over a specified percentage alcohol
	 * content
	 * 
	 * @param beers
	 * @param percentOver
	 * @return a list of matching beers, over the specified alcohol percentage
	 */
	private static List<Beer> searchByPercent(List<Beer> beers, int percentOver) {
		List<Beer> results = new ArrayList<Beer>();

		if (beers == null || beers.size() == 0) {
			throw new IllegalArgumentException("Beer list cannot be null or empty");
		} else {
			for (Beer beer : beers) {
				if (beer.getPercentage() > percentOver) {
					results.add(beer);
				}
			}
		}

		return results;
	}

	private static void displayBeers(List<Beer> beers) {
		if (beers == null | beers.size() == 0) {
			System.out.println("No beers to show in list");
		} else {
			System.out.printf("%-35s   %-25s   %-25s  %-20s%n", "Beer Name", "Beer Style", "Beer Country",
					"Alcohol Percentage %");
			for (Beer beer : beers) {

				System.out.println(beer.toString());
			}
			System.out.println();
		}
	}

	private static List<Beer> readBeers(String fileName) {
		List<Beer> beerList = new ArrayList<Beer>();

		File file = new File(fileName);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine(); // throw away headers
			line = br.readLine();
			String[] parts;
			int linenum = 0;

			while (line != null) {
				try {
					linenum++;
					parts = line.split(",");
					String name = parts[0];
					String style = parts[1];
					String country = parts[2];
					double percent = Double.parseDouble(parts[3]);

					beerList.add(new Beer(name, style, country, percent));
				} catch (NumberFormatException ex) {
					System.out.println("Skipping bad line of data on line .." + linenum);
				}

				line = br.readLine();
			}

			System.out.println("Successfully read in " + beerList.size() + " beers");

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Something pretty major went wrong with reading");
			e.printStackTrace();
		}

		return beerList;
	}

}
