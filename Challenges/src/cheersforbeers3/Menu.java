package cheersforbeers3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Beer> beers = readBeers("beer_data.csv");

		displayMenu(beers);

		sc.close();

	}

	private static void displayMenu(List<Beer> beers) {
		int userChoice;
		do {
			System.out.println("Please select an option: ");
			System.out.println("1. Show all beers\n" + "2. Order by name\n"
					+ "3. Output to file all beers over 6% alcohol percentage\n" + "4. Quit");

			userChoice = sc.nextInt();

			switch (userChoice) {
			case 1:
				System.out.println("Showing all beers");
				printBeers(beers);
				break;
			case 2:
				System.out.println("Ordering by name");
				Collections.sort(beers, new CompareBeerByName());
				break;
			case 3:
				System.out.println("Outputting to file all beets over 6%");
				List<Beer> over6 = searchByPercent(beers, 6);
				writeToFile(over6);
				break;
			case 4:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Invalid choice");
			}
		} while (userChoice != 4);

	}

	private static void writeToFile(List<Beer> over6) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Search a list of beers for all beers over a specified % alcohol
	 * @param beers
	 * @param percent
	 * @return a list of beers that match the criteria
	 */
	private static List<Beer> searchByPercent(List<Beer> beers, int percent) {
		List<Beer> result = new ArrayList<Beer>();
		if(beers==null || beers.size()==0) {
			System.out.println("No beers matching search criteria");
		} else {
			for(Beer beer : beers) {
				if(beer.getPercentage()>percent) {
					result.add(beer);
				}
			}
		}
		return result;
	}

	private static void printBeers(List<Beer> beers) {
		if(beers==null || beers.size()==0) {
			System.out.println("No beers to display");
		} else {
			System.out.printf("%-35s%-30s%-30s%-5s%n","Name","Style","Country","Percentage");
			for(Beer beer : beers) {
				System.out.println(beer.toString());
			}
		}
		
	}

	private static List<Beer> readBeers(String fileName) {
		List<Beer> list = new ArrayList<Beer>();

		File file = new File(fileName);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
			String line = br.readLine();
			line = br.readLine();
			String[] parts;
			int lineNum = 1;

			while (line != null) {

				try {
					parts = line.split(",");

					String name = parts[0];
					String style = parts[1];
					String country = parts[2];
					double percent = Double.parseDouble(parts[3]);

					list.add(new Beer(name, style, country, percent));
				} catch (Exception ee) {
					System.out.println("Skipping bad line of data on row: " + lineNum);
				}
				lineNum++;
				line = br.readLine();
			}

			System.out.println(list.size() + " beers read in");

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
