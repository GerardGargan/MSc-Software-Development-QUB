package toptrump;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
				/*
				 * TODO Uncomment method call to enable this option (requires TopTrumpCard class
				 * to match expectations of Game Method to compile successfully) deliberately
				 * commented out initially to allow attempting other tasks
				 */
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				System.out.println("Displaying cards in deck: "+mainDeck.size());
				// TODO add required method call(s)
				break;
			case 4:
				System.out.println("Printing details of all cards in deck\n");
				printAllCards(mainDeck);
				// TODO add required method call(s)
				break;
			case 5:
				System.out.println("Displaying summary details for top 5 strongest heros in the deck\n");
				List<TopTrumpCard> heroes = searchByCat(mainDeck, Category.HERO);
				Comparator<TopTrumpCard> sortByStr = new CompareCardByStrength();
				List<TopTrumpCard> top5heroes = topXbyComparison(heroes, 5, sortByStr);
				printSummaryDetails(top5heroes);
				// TODO add required method call(s)
				break;
			case 6:
				System.out.println("Displaying summary details of Villains in the Deck with an agility rating of 75 or more, sorted alphatically by name");
				List<TopTrumpCard> villains = searchByCat(mainDeck, Category.VILLAIN);
				List<TopTrumpCard> searchAgil = searchByAgility(villains, 75);
				Collections.sort(searchAgil, new CompareCardByName());
				printSummaryDetails(searchAgil);
				break;
			case 7:
				System.out.println("Displaying the card name and bio of the card/cards with the longest bio in the Deck.");
				TopTrumpCard maxCardBio = Collections.max(mainDeck, new CompareCardBioLength());
				System.out.println("Card name: "+maxCardBio.getName());
				System.out.println("Bio: "+maxCardBio.getBio());
				break;
			case 8:
				System.out.println("Finding duplicates...");
				List<TopTrumpCard> dupes = findDupes(mainDeck);
				printSummaryDetails(dupes);
				break;
			case 9:
				System.out.println("Removing any duplicate cards from the Deck...");
				System.out.println("Main deck size before.."+mainDeck.size());
				removeDupes(mainDeck);
				System.out.println("Main deck size after.."+mainDeck.size());
				break;
			case 10:
				System.out.println("Sorting the deck from highest to lowest determined by average of the 4 main stats");
				Collections.sort(mainDeck, new CompareCardByAvgScore());
				printSummaryDetails(mainDeck);
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

	public static void removeDupes(List<TopTrumpCard> mainDeck) {
		List<TopTrumpCard> noDupes = new ArrayList<TopTrumpCard>();
		
		if(mainDeck==null || mainDeck.size()==0) {
			throw new IllegalArgumentException("Deck cannot be null or empty");
		} else {
			for(TopTrumpCard card : mainDeck) {
				if(!noDupes.contains(card)) {
					noDupes.add(card);
				}
			}
			
			mainDeck.clear();
			mainDeck.addAll(noDupes);
		}
		
	}

	/**
	 * return a list of duplicate TopTrumpCards in a given deck
	 * @param mainDeck
	 * @return a list of duplicates (one copy only)
	 */
	public static List<TopTrumpCard> findDupes(List<TopTrumpCard> mainDeck) {
		List<TopTrumpCard> dupes = new ArrayList<TopTrumpCard>();
		
		if(mainDeck==null) {
			throw new IllegalArgumentException("Null deck!");
		} else if(mainDeck.size()==0) {
			return dupes;
		} else {
			for(TopTrumpCard card : mainDeck) {
				if(Collections.frequency(mainDeck, card)>1) {
					if(!dupes.contains(card)) {
						dupes.add(card);
					}
				}
			}
		}
		
		return dupes;
	}

	/**
	 * Search a list of TopTrumpCards for agility greater to or more than the score passed in
	 * @param villains
	 * @param agil
	 * @return a list of TopTrumpCards matching the criteria
	 */
	public static List<TopTrumpCard> searchByAgility(List<TopTrumpCard> villains, int agil) {
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		
		if(villains==null || villains.size()==0) {
			return results;
		} else {
			for(TopTrumpCard card : villains) {
				if(card.getAgility()>=agil) {
					results.add(card);
				}
			}
		}
		
		return results;
	}

	/**
	 * Recieves a list of cards and prints their summary details on each line
	 * @param cards
	 */
	public static void printSummaryDetails(List<TopTrumpCard> cards) {
		if(cards==null) {
			throw new IllegalArgumentException("Empty list");
		} else if(cards.size()==0) {
			System.out.println("No cards to display");
		} else {
			for(TopTrumpCard card : cards) {
				System.out.printf("%s / %s (%s)%nsp: %d | st: %d | ag: %d | in: %d | avg: %.2f%n%n",card.getName(),card.getRealName(),card.getCategory(),
						card.getSpeed(),card.getStrength(),card.getAgility(),card.getIntelligence(),card.getAvg());;
			}
		}
		
	}

	/**
	 * Prints the top N number of cards for a specified comparasion (comparator)
	 * @param heroes
	 * @param limit
	 * @param comparator
	 * @returns the top N cards based on the comparator passed in, will return no more than 5 but may return less if there are less than 5 cards in the list
	 */
	public static List<TopTrumpCard> topXbyComparison(List<TopTrumpCard> heroes, int limit,
			Comparator<TopTrumpCard> comparator) {
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		//sort in desc order
		Collections.sort(heroes, comparator);
		
		int toLoop = heroes.size()>=5 ? 5 : heroes.size();
		
		for(int i=0; i<toLoop; i++) {
			results.add(heroes.get(i));
		}
		
		return results;
	}

	/**
	 * Searches a list of TopTrumpCards for a specified category
	 * @param mainDeck
	 * @param cat
	 * @returns a list of cards matching the specified category
	 */
	public static List<TopTrumpCard> searchByCat(List<TopTrumpCard> mainDeck, Category cat) {
		List<TopTrumpCard> results = new ArrayList<TopTrumpCard>();
		if(mainDeck ==null) {
			throw new IllegalArgumentException("Main deck cant be null");
		} else if(mainDeck.size()==0) {
			return results;
		} else {
			for(TopTrumpCard card : mainDeck) {
				if(card.getCategory()==cat) {
					results.add(card);
				}
			}
		}
		return results;
	}

	/**
	 * Prints details for all cards in the deck
	 * Prints No cards to display if empty or null list is passed in
	 * @param mainDeck
	 */
	public static void printAllCards(List<TopTrumpCard> mainDeck) {
		if(mainDeck==null || mainDeck.size()==0) {
			System.out.println("No cards to display");
		} else {
			for(TopTrumpCard card : mainDeck) {
				System.out.println(card.toString());
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
			String parts[];

			while (line != null) {

				try {
					parts = line.split(",");
					String name = parts[0];
					String realName = parts[1];
					String image = parts[2];
					Category cat = Category.valueOf(parts[3].toUpperCase());
					int speed = Integer.parseInt(parts[4]);
					int strength = Integer.parseInt(parts[5]);
					int agility = Integer.parseInt(parts[6]);
					int intelligence = Integer.parseInt(parts[7]);
					String bio = parts[8];

					listFromFile.add(
							new TopTrumpCard(name, realName, image, cat, speed, strength, agility, intelligence, bio));
				} catch (Exception ee) {
					System.out.println("Skipping bad line of data");
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
