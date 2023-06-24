package challenge;

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
				System.out.println("Option currently disabled...");
				/* TODO Uncomment method call to enable this option 
				 * (requires TopTrumpCard class to match expectations of Game Method to compile successfully)
				 * deliberately commented out initially to allow attempting other tasks
				 */
				CardGame.playDemo(mainDeck);
				break;
			case 3:
				System.out.println("Number of cards in deck: "+mainDeck.size());
				// TODO add required method call(s)
				break;
			case 4:
				System.out.println("Displaying all card details");
				displayAllCardDetails(mainDeck);
				// TODO add required method call(s)
				break;
			case 5:
				System.out.println("Top 5 strongest heroes");
				ArrayList<TopTrumpCard> copy = new ArrayList<TopTrumpCard>(mainDeck);
				Collections.sort(copy, new SortCardByStrength());
				
				int count=0;
				
				for(TopTrumpCard c : copy) {
					
				}
				
				break;
			case 6:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 7:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 8:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 9:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
				break;
			case 10:
				System.out.println("Not yet implemented...");
				// TODO add required method call(s)
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
			String token[];
			String name = "";
			String realName = "";
			String imageFile = "";
			Category cat = null;
			int speed = 0;
			int strength = 0;
			int agility = 0;
			int intelligence = 0;
			String bio = "";
			
			while (line != null) {
				
				token = line.split(",");
				name = token[0];
				realName = token[1];
				imageFile = token[2];
				cat = Category.valueOf(token[3].toUpperCase());
				
				speed = Integer.parseInt(token[4]);
				strength = Integer.parseInt(token[5]);
				agility = Integer.parseInt(token[6]);
				intelligence = Integer.parseInt(token[7]);
				bio = token[8];
				
				listFromFile.add(new TopTrumpCard(name, realName, imageFile, cat, speed, strength, agility, intelligence, bio));

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
			e.printStackTrace();
		}
		System.out.println(listFromFile.size() + " lines read successfully");
		return listFromFile;
	}
	
	public static void displayAllCardDetails(List<TopTrumpCard> cards) {
		for(TopTrumpCard c : cards) {
			c.displayDetails();
			System.out.println();
		}
	}

}
