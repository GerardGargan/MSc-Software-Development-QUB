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
	 * @param args
	 */
	public static void main(String[] args) {
		showMenu();	
	}
	
	//TODO modify readData method to populate List appropriately - method partially completed already
	//TODO add static methods to this class as required to achieve tasks outlined in menu
	//TODO modify showMenu method to add calls to new methods you write to accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user choices
	 * Partially implemented already
	 * requires updating to add calls to other methods written to achieve the tasks described in tasks 3-10
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
				System.out.println("Playing the game..");
				/* TODO Uncomment method call to enable this option 
				 * (requires TopTrumpCard class to match expectations of Game Method to compile successfully)
				 * deliberately commented out initially to allow attempting other tasks
				 */
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				System.out.println("Number of cards in deck: "+mainDeck.size());
				break;
			case 4:
				System.out.println("Displaying all cards in deck:");
				printAllCards(mainDeck);
				break;
			case 5:
				//create a copy
				System.out.println("Displaying top 5 heroes by strength");
				List<TopTrumpCard> top5byStr = Top5byCat(mainDeck, Category.HERO);
				printSummaryDetails(top5byStr);
				
				break;
			case 6:
				System.out.println("Displaying Villains with an agility rating of 75 or more, sorted alphabetically");
				List<TopTrumpCard> search = searchByCatAndAgility(mainDeck, 75, Category.VILLAIN);
				printSummaryDetails(search);
				break;
			case 7:
				System.out.println("Displaying card with the max number of words");
				TopTrumpCard maxBio = Collections.max(mainDeck, new CompareCardByBio());
				System.out.println("Card name: "+maxBio.getName());
				System.out.println("Card bio: "+maxBio.getBio());
				// TODO add required method call(s)
				break;
			case 8:
				System.out.println("Displaying duplicate cards found");
				List<TopTrumpCard> dupes = findDupes(mainDeck);
				printSummaryDetails(dupes);
				break;
			case 9:
				System.out.println("Removing duplicates");
				removeDupes(mainDeck);
				break;
			case 10:
				System.out.println("Displaying cards by average of the 4 main stats");
				List<TopTrumpCard> copy = new ArrayList<TopTrumpCard>(mainDeck);
				Collections.sort(copy, new CompareByAvgStat());
				printSummaryDetails(copy);
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
		List<TopTrumpCard> noDupes = new ArrayList<TopTrumpCard>();
		
		//adding all cards, checking first if they are already there (skip if so)
		for(TopTrumpCard card : mainDeck) {
			if(!noDupes.contains(card)) {
				noDupes.add(card);
			}
		}
		
		//clear main deck and re add the noDupes list
		mainDeck.clear();
		mainDeck.addAll(noDupes);
		
	}

	/**
	 * Search a list and return a list of found duplicates
	 * @param mainDeck
	 * @return
	 */
	private static List<TopTrumpCard> findDupes(List<TopTrumpCard> mainDeck) {
		List<TopTrumpCard> dupes = new ArrayList<TopTrumpCard>();
		if(mainDeck==null || mainDeck.size()==0) {
			throw new IllegalArgumentException("Deck cant be empty or null");
		} else {
			for(TopTrumpCard card : mainDeck) {
				if(!dupes.contains(card)) {
					if(Collections.frequency(mainDeck, card)>1) {
						dupes.add(card);
					}
				}
			}
		}
		return dupes;
	}

	/**
	 * Searches a list of TopTrumpCards for a match against category, and an agility of more than/equal to a specified value
	 * @param mainDeck
	 * @param agility
	 * @param cat
	 * @returns a list of TopTrumpCards matching the criteria specified, sorted in alphabetical order
	 * @throws IllegalArgumentException
	 */
	private static List<TopTrumpCard> searchByCatAndAgility(List<TopTrumpCard> mainDeck, int agility, Category cat) throws IllegalArgumentException {
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		
		if(mainDeck==null || mainDeck.size()==0) {
			throw new IllegalArgumentException("Deck cant be empty or null");
		} else {
			for(TopTrumpCard card : mainDeck){
				if(card.getCategory()==cat && card.getAgility()>=agility) {
					results.add(card);
				}
			}
		}
		Collections.sort(results, new CompareCardsByName());
		return results;
	}

	/**
	 * Search a list of TopTrumpCards by a specific category, return the top 5 by strength (Desc)
	 * @param mainDeck
	 * @param cat
	 * @return
	 * @throws IllegalArgumentException
	 */
	private static List<TopTrumpCard> Top5byCat(List<TopTrumpCard> mainDeck, Category cat) throws IllegalArgumentException {
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		List<TopTrumpCard> top5 = new ArrayList<TopTrumpCard>();
		
		if(mainDeck==null || mainDeck.size()==0) {
			throw new IllegalArgumentException("empty or null deck");
		} else {
			for(TopTrumpCard c : mainDeck) {
				if(c.getCategory()==cat) {
					results.add(c);
				}
			}
			Collections.sort(results, new SortCardsByStrength());
			//check how many times to loop (cant assume there will always be 5 matches, if there are less we need to loop less than 5 times)
			int toLoop = results.size()>=5 ? 5 : results.size();
			
			//print top 5 (or less if less matches)
			for(int i=0; i<toLoop; i++) {
				top5.add(results.get(i));
			}
			
		}
		
		return top5;
	}

	/**
	 * print summary details for a list of cards
	 * @param mainDeck
	 */
	private static void printSummaryDetails(List<TopTrumpCard> mainDeck) {
		if(mainDeck==null || mainDeck.size()==0) {
			System.out.println("No cards to display");
		} else {
			for(TopTrumpCard c : mainDeck) {
				System.out.printf("%s / %s (%s)%nsp: %d | st: %d | ag: %d | in: %d | avg: %.2f%n%n",c.getName(),c.getRealName(),c.category,c.getSpeed(),c.getStrength(),c.getAgility(),c.getIntelligence(), c.getAvg());
			}
		}
		
	}

	/**
	 * Print all card details from a list
	 * @param mainDeck
	 */
	private static void printAllCards(List<TopTrumpCard> mainDeck) {
		if(mainDeck==null || mainDeck.size()==0) {
			System.out.println("No cards to display");
		} else {
			for(TopTrumpCard c : mainDeck) {
				c.printCardDetails();
				System.out.println();
			}
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

			while (line != null) {

				parts = line.split(",");
				String name = parts[0];
				String realName = parts[1];
				String image = parts[2];
				Category cat = Category.valueOf(parts[3].toUpperCase());
				int speed = Integer.parseInt(parts[4]);
				int stength = Integer.parseInt(parts[5]);
				int agility = Integer.parseInt(parts[6]);
				int intelligence = Integer.parseInt(parts[7]);
				String bio = parts[8];
				
				listFromFile.add(new TopTrumpCard(name, realName, image, cat, speed, stength, agility, intelligence, bio));

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
