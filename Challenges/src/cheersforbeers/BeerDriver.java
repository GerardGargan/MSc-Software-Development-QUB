package cheersforbeers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BeerDriver {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Beer> beers = readInBeers("beer_data.csv");
		displayMenu(beers);

	}

	/**
	 * Display menu, opens a scanner which accepts user input
	 * Will keep looping until user chooses option 4 - Quit.
	 * User input will determine method calls to display the appropriate result
	 * @param beerList
	 */
	private static void displayMenu(List<Beer> beerList) {
		int userInput;
		do {
			System.out.println("Please select an option:");
			System.out.println("1. Show all beers");
			System.out.println("2. Order by name");
			System.out.println("3. Output to file all beers over 6% alcohol percentage");
			System.out.println("4. Quit");
			// get the users choice
			userInput = sc.nextInt();

			switch (userInput) {
			case 1:
				System.out.println("Showing all beers..");
				System.out.printf("%-35s%-25s%-25s%-25s%n%n", "Beer name", "Beer style", "Country",
						"Alcohol Percentage");
				printBeers(beerList);
				break;
			case 2:
				System.out.println("Ordering all beers by name..");
				Collections.sort(beerList, new CompareBeerByName());
				break;
			case 3:
				System.out.println("Outputting to file all beers over 6%...");
				List<Beer> result = searchByAlc(beerList, 6);
				writeToFile(result, "searchResults.csv");
				break;
			case 4:
				System.out.println("Quitting...");
				break;
			default:
				System.out.println("Invalid selection");
			}
			System.out.println();
		} while (userInput != 4);

	}

	/**
	 * Method initiates another thread which writes the beer objects in the list to a file
	 * @param result
	 * @param fileName
	 */
	private static void writeToFile(List<Beer> result, String fileName) {
		
		//create runnable object, pass in the beer objects to be written and the filename
		ResultWriter rw = new ResultWriter(result, fileName);
		Thread th = new Thread(rw);
		
		//start the thread
		th.start();
		
	}

	/**
	 * Search method, search a list of Beers for a minimum alcohol percentage (non inclusive)
	 * @param beerList
	 * @param key
	 * @return A list of beers over the specified key (alcohol percentage)
	 */
	private static List<Beer> searchByAlc(List<Beer> beerList, int key) {
		List<Beer> resultList = new ArrayList<Beer>();

		if (beerList == null || beerList.size() == 0) {
			throw new IllegalArgumentException("Beer list null or empty");
		} else {
			
			for(Beer beer : beerList) {
				if(beer.getAlcoholpercent()>key) {
					resultList.add(beer);
				}
			}
			
		}
		return resultList;

	}

	/**
	 * Print all beer details in a given list
	 * @param beers
	 */
	private static void printBeers(List<Beer> beers) {

		if (beers == null || beers.size() == 0) {
			System.out.println("No beers to show");
		} else {
			for (Beer beer : beers) {
				beer.displayBeerDetails();
			}
		}
	}

	/**
	 * Read in beer objects from a file
	 * @param fileName
	 * @returnreturn a list of beer objects
	 */
	private static List<Beer> readInBeers(String fileName) {
		List<Beer> list = new ArrayList<Beer>();
		String line = "";

		// connect to file
		File file = new File(fileName);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			line = br.readLine(); // throw away headers
			line = br.readLine();

			String[] parts;
			String beerName = "";
			String beerStyle = "";
			String beerCountry = "";
			double alcper = 0.0;

			while (line != null) {

				parts = line.split(",");
				beerName = parts[0];
				beerStyle = parts[1];
				beerCountry = parts[2];
				alcper = Double.parseDouble(parts[3]);

				list.add(new Beer(beerName, beerStyle, beerCountry, alcper));

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Read in " + list.size() + " beers");

		return list;
	}
	
	

}

