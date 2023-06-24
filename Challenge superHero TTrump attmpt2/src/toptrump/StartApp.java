package toptrump;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * PUT YOUR NAME HERE AND YOUR STUDENT NUMBER
 * 
 *
 */
public class StartApp {

	/**
	 * Entry point of program - no need to modify this method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();
	}

	// TODO modify readData method to populate List appropriately - method partially
	// completed already
	// TODO add static methods to this class as required to achieve tasks outlined
	// in menu
	// TODO modify showMenu method to add calls to new methods you write to
	// accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user
	 * choices Partially implemented already requires updating to add calls to other
	 * methods written to achieve the tasks described in tasks 3-10
	 */
	public static void showMenu() {
		List<TopTrumpCard> mainDeck = readData();

		System.out.println();
		Scanner scanner = new Scanner(System.in);
		int option;
		System.out.println("Hero Card Processing");
		do {
			System.out.println("1. (Re)read Data From File (use to restore removed card for example)");
			System.out.println("2. Play Demo Game with Current Deck");
			System.out.println("3. Display the number of Cards in the Current Deck");
			System.out.println("4. Display full details for all cards in the current Deck");
			System.out.println("5. Display summary details of the top 5 strongest Heroes in the Deck");
			System.out.println(
					"6. Display summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
			System.out.println("7. Display the card name and bio of the card/cards with the longest bio in the Deck");
			System.out.println(
					"8. Find Swapsies: Identify and display summary details of any duplicate cards in the Deck");
			System.out.println("9. Remove any duplicate cards from the Deck.");
			System.out.println(
					"10. Sort the deck from highest to lowest determined by average of the 4 main stats. \n\tDisplay summary details of all cards and include the average as part of the summary.");
			System.out.println("11. Quit");
			System.out.println("Enter option ...");
			option = scanner.nextInt();
			System.out.println();
			switch (option) {

			case 1:
				mainDeck = readData();
				break;
			case 2:
				//System.out.println("Option currently disabled...");
				/*
				 * TODO Uncomment method call to enable this option (requires TopTrumpCard class
				 * to match expectations of Game Method to compile successfully) deliberately
				 * commented out initially to allow attempting other tasks
				 */
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				System.out.println("Cards in deck: " + mainDeck.size());
				System.out.println();
				// TODO add required method call(s)
				break;
			case 4:
				printAllCardDetails(mainDeck);
				// TODO add required method call(s)
				break;
			case 5:
				System.out.println("Displaying summary details of the top 5 strongest in the deck...");
				// TODO add required method call(s)
				List<TopTrumpCard> top5strongest = top5strongest(mainDeck);
				printSummary(top5strongest);
				break;
			case 6:
				System.out.println(
						"Displaying top 5 villains with agility of 75 or more, sorted alphabetically by name...");
				List<TopTrumpCard> resultList = searchAgility(mainDeck, 75, Category.VILLAIN);
				Collections.sort(resultList);
				printSummary(resultList);
				// TODO add required method call(s)
				break;
			case 7:
				System.out.println(
						"Displaying the card name and bio of the card/cards with the longest bio in the Deck..");
				TopTrumpCard maxCard = Collections.max(mainDeck, new CompareByBioLength());
				maxCard.displayDetails();
				break;
			case 8:
				System.out.println("Find Swapsies: Displaying duplicates found in the deck");
				List<TopTrumpCard> dupes = findDupes(mainDeck);
				printSummary(dupes);
				break;
			case 9:
				System.out.println("Deck size before..." + mainDeck.size());
				System.out.println("Removing any duplicate cards from the deck...");

				removeDupes(mainDeck);
				System.out.println("Deck size after: " + mainDeck.size());
				break;
			case 10:
				System.out.println("Sorting the deck from highest to lowest determined by average of the 4 main stats..");
				List<TopTrumpCard> copy = new ArrayList<TopTrumpCard>(mainDeck);
				Collections.sort(copy, new CompareByAvgStats());
				printSummary(copy);
				break;
			case 11:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Try options again...");
			}
		} while (option != 11);
		scanner.close();
	}

	private static void removeDupes(List<TopTrumpCard> mainDeck) {
		for(int i=0; i<mainDeck.size(); i++) {
			if(Collections.frequency(mainDeck, mainDeck.get(i))>1) {
				mainDeck.remove(i);
			}
		}

	}

	/**
	 * Searches a list of TopTrumpCards for duplicates
	 * 
	 * @param mainDeck
	 * @returns a list of duplicates found.
	 */
	private static List<TopTrumpCard> findDupes(List<TopTrumpCard> mainDeck) {
		List<TopTrumpCard> result = new ArrayList<TopTrumpCard>();

		for (TopTrumpCard card : mainDeck) {
			if (Collections.frequency(mainDeck, card) > 1) {
				if (!result.contains(card)) {
					result.add(card);
				}

			}
		}
		return result;
	}

	/**
	 * Searches a list with for TopTrumpCards above a minimum agility (inclusive) and a specific category
	 * @param mainDeck
	 * @param agility
	 * @param cat
	 * @returns a list of results matching the criteria passed in
	 */
	private static List<TopTrumpCard> searchAgility(List<TopTrumpCard> mainDeck, int agility, Category cat) {
		List<TopTrumpCard> result = new ArrayList<TopTrumpCard>();

		if (mainDeck == null || mainDeck.size() == 0) {
			throw new IllegalArgumentException("Deck cant be null or empty");
		} else {
			for (TopTrumpCard card : mainDeck) {
				if (card.getAgility() >= agility && card.getCategory() == cat) {
					result.add(card);
				}
			}
		}

		return result;
	}

	private static List<TopTrumpCard> top5strongest(List<TopTrumpCard> mainDeck) {
		// take a copy of the deck
		List<TopTrumpCard> list = new ArrayList<>(mainDeck);
		List<TopTrumpCard> results = new ArrayList<>();

		Collections.sort(list, new CompareByStrength());

		for (int i = 0; i < 5; i++) {
			results.add(list.get(i));
		}

		return results;
	}

	private static void printAllCardDetails(List<TopTrumpCard> list) {
		for (TopTrumpCard card : list) {
			card.displayDetails();
			System.out.println();
		}

	}

	private static void printSummary(List<TopTrumpCard> list) {

		for (TopTrumpCard card : list) {
			card.displaySummaryDetails();
			System.out.println();
		}
	}

	/**
	 * Reads in the data from the provided csv and returns a list of TopTrumpCard
	 * objects for further processing - requires updating for full functionality
	 */
	public static List<TopTrumpCard> readData() {

		List<TopTrumpCard> listFromFile = new ArrayList<TopTrumpCard>();

		File file = new File("toptrumpscards.csv"); // hard coded to specific file

		// try with resources - auto closes reader resources when finished/exception
		// occurs
		try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr);) {

			String line = reader.readLine(); // discard header
			line = reader.readLine(); // read first line
			String[] parts;

			String name;
			String realName;
			String imageFile;
			Category category;
			int speed;
			int strength;
			int agility;
			int intelligence;
			String bio;

			while (line != null) {

				// TODO Code to process current line
				try {
				parts = line.split(",");
				name = parts[0];
				realName = parts[1];
				imageFile = parts[2];
				category = Category.valueOf(parts[3].toUpperCase());
				speed = Integer.parseInt(parts[4]);
				strength = Integer.parseInt(parts[5]);
				agility = Integer.parseInt(parts[6]);
				intelligence = Integer.parseInt(parts[7]);
				bio = parts[8];

				// TODO instantiate TopTrumpCard object
				// TODO and add to list
				listFromFile.add(new TopTrumpCard(name, realName, category, imageFile, speed, strength, agility,
						intelligence, bio));
				} catch(Exception ex1)
				{
					System.out.println("Unexpected error in data read in, skipping line..");
				}
				line = reader.readLine();// attempt to read next line and loop again
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found error");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			System.out.println("Exception occured");
			System.out.println(listFromFile.size() + " lines read successfully");
			System.out.println(e.getMessage());
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		return listFromFile;
	}

}
