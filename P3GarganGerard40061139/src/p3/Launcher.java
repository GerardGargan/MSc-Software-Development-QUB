package p3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Launcher {

	private static Scanner scanner = new Scanner(System.in);
	private static final int QUIT = 10;

	/**
	 * Entry point of program - no need to modify this method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		launchMenu();
		scanner.close();// close scanner once menu system completes
	}

	// TODO modify readData method to populate List appropriately - method partially
	// completed already
	// TODO add static methods to this class as required to achieve tasks outlined
	// in menu
	// TODO modify launchMenu method to add calls to new methods you write etc to
	// accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user
	 * choices Partially implemented already. Requires updating to add calls to
	 * other methods written to achieve the tasks described in tasks 3-9
	 */
	public static void launchMenu() {

		List<Accommodation> mainList = readRoomData("Rooms.csv");
		System.out.println();
		int option;
		System.out.println("AccommyNation.com - Wherever you go, you'll need to stay");

		// repeat until quit chosen
		do {
			displayOptions();

			// get input
			option = getMenuChoice("Enter choice ...");
			System.out.println();

			try {
				// process choice - invoke relevant methods etc.
				switch (option) {

				case 1:
					mainList = readRoomData("Rooms.csv");
					break;
				case 2:
					// improving to check for null and print an appropriate message to console (dont
					// want the program to crash)
					if (mainList == null) {
						System.out.println("Main list is null, canot display size");
					} else {
						System.out.println("Number of places to stay is " + mainList.size());
					}

					break;
				case 3:
					System.out.println("Displaying printed details for all places to stay in the current list:");
					printAllDetails(mainList);
					// TODO add required method calls etc
					break;
				case 4:
					System.out.println(
							"Displaying the 3 least expensive places to stay in Los Angeles, with a 4 star rating,"
									+ "ordered by price - low to high");
					// using multiple search methods for reusability
					// find the hotels in losAngeles
					List<Accommodation> losAngeles = searchByCity(mainList, "Los Angeles");
					// now use this list to search for accomodation with a 4 star rating
					List<Accommodation> fourStar = searchByStars(losAngeles, 4);
					// now use this list and get the TopN based on comparator passed in - we were
					// asked for 3
					List<Accommodation> topx = topXSorted(fourStar, 3, new CompareAccomByPrice());
					// print the details
					printAllDetails(topx);
					break;
				case 5:
					System.out.println("Displaying the number of unique city names in the current list");
					Set<String> uniqueCities = getUniqueCities(mainList);
					System.out.println("Number of cities: " + uniqueCities.size());
					// TODO add required method calls etc
					break;
				case 6:
					System.out.println(
							"Displaying the details of the 4 most expensive BnBs in Dublin, ordered by price - high to low");
					// search for BnBs
					List<Accommodation> bnbs = searchByType(mainList, Type.BNB);
					// now search by city - already have a method for this which we can reuse thanks
					// to separating out (thanks for teaching single responsibility matthew!!)
					List<Accommodation> dublin = searchByCity(bnbs, "Dublin");
					// now show TopX based on comparator (ordered by price -low to high) note
					// different comparator used than previous for different ordering (high to low)
					List<Accommodation> topXhighToLow = topXSorted(dublin, 4, new CompareByPriceHighToLow());
					printAllDetails(topXhighToLow);
					break;
				case 7:
					System.out.println("Displaying average price of a hotel in new york, correct to 2 D.P");
					// use existing method to get hotels in new york, store in a list
					List<Accommodation> newYorkHotels = searchByCity(mainList, "New York");

					// now pass to calculateAvgMethod
					double avgPrice = calcAvgPrice(newYorkHotels);
					System.out.printf("Average price new york: £%.2f", avgPrice);
					// TODO add required method calls etc
					break;
				case 8:
					System.out.println(
							"Remove all entries from the current list with fewer than 10 rooms available in paris");
					// get a list of hotels in paris using existing method
					List<Accommodation> parisHotels = searchByCity(mainList, "Paris");
					// now search for those with fewer room than 10
					List<Accommodation> lessThanTenRooms = searchByRoomNum(parisHotels, 10);
					System.out.println("In main list before removal: " + mainList.size());
					removeFromList(mainList, lessThanTenRooms);
					System.out.println("After removal: " + mainList.size());
					break;
				case 9:
					System.out.println(
							"Writing in a separate thread the list of city names and average cost of hotels there");
					Map<String, Double> cityAvg = getAvgPriceByCity(mainList);
					// pass in the required data
					WriterThreadClass writer = new WriterThreadClass(cityAvg, "AverageCosts.csv");
					// create thread
					Thread th = new Thread(writer);
					// start thread
					th.start();
					break;
				case QUIT:
					System.out.println("Quitting");
					break;
				default:
					System.out.println("Try options again...");
				}

			} catch (Exception e) {
				System.out.println("Exception caught");
				System.out.println(e.getMessage());
				System.out.println("please try again");
			}

		} while (option != QUIT);
	}

	/**
	 * Maps a Unique City (String) against a Double (Average price) Puts the average
	 * price for all hotels in that city into the map
	 * 
	 * @param mainList
	 * @returns a Map of cities and average prices
	 * @throws IllegalArgumentException if list is null
	 */
	private static Map<String, Double> getAvgPriceByCity(List<Accommodation> mainList) throws IllegalArgumentException {
		if (mainList == null) {
			throw new IllegalArgumentException("List cant be null");
		}
		// using a tree map so that city name is ordered by its natural ordering at
		// insertion time (alphabetically)
		Map<String, Double> map = new TreeMap<String, Double>();

		for (Accommodation accom : mainList) {

			// update the map using the helper method below
			map.put(accom.getCity(), getCityAvgPrice(accom.getCity(), mainList));

		}

		// return the map
		return map;
	}

	/**
	 * Recieves a city (String) and a list of Accomodation objects Calculates and
	 * returns the average price per city as a double
	 * 
	 * @param city
	 * @param list
	 * @returns the average price as a double
	 * @throws illegal argument exception if either list is null
	 */
	public static double getCityAvgPrice(String city, List<Accommodation> list) throws IllegalArgumentException {
		if (city == null || list == null) {
			throw new IllegalArgumentException("Lists cant be null");
		} else {
			double totalPrice = 0;
			int totalCity = 0;
			for (Accommodation accom : list) {
				if (accom.getCity().equals(city)) {
					totalPrice += accom.getPrice();
					totalCity++;
				}
			}
			return totalPrice / totalCity;
		}

	}

	/**
	 * Recieves tww lists, first the list to be modified, second list with the
	 * objects to remove from the first list Removes all objects including
	 * duplicates from the original lis that are in the secon list (toRemove)
	 * 
	 * @param mainList
	 * @param toRemove
	 */
	private static void removeFromList(List<Accommodation> mainList, List<Accommodation> toRemove) {
		if (mainList == null || toRemove == null) {
			throw new IllegalArgumentException("lists cant be null");
		} else if (mainList.size() == 0 || toRemove.size() == 0) {
			// either no objects to be removed, or no objects passed in to remove from main
			// list - no point just return
			return;
		} else {
			// loop through the objects to be removed
			for (Accommodation acc : toRemove) {
				// check if mainList contains this object
				if (mainList.contains(acc)) {
					// remove all instances of the object (in case there are duplicates)
					mainList.remove(acc);
				}
			}
		}

	}

	/**
	 * Searches a list of Accomodation objects - checks if they have less than a
	 * specified number of rroms
	 * 
	 * @param list
	 * @param rooms (int)
	 * @returns a list of accomodation objects with less rooms than passed into the
	 *          method
	 * @throws IllegalArgumentException if list is null or rooms is <0 (passed in)
	 */
	private static List<Accommodation> searchByRoomNum(List<Accommodation> list, int rooms)
			throws IllegalArgumentException {
		List<Accommodation> results = new ArrayList<Accommodation>();
		if (list == null) {
			throw new IllegalArgumentException("list cant be null");
		} else if (list.size() == 0) {
			// no need to loop
			return results;
		} else if (rooms < 1) {
			throw new IllegalArgumentException("Invalid rooms specified, must be more than 0");
		} else {

			for (Accommodation acc : list) {
				if (acc.getRooms() < rooms) {
					// if num of rooms less than the search key, add to list
					results.add(acc);
				}
			}

		}
		return results;
	}

	/**
	 * Loops through a list of accomodation objects, calculates the total average
	 * price and returns the result as a double
	 * 
	 * @param list
	 * @returns the average price of the hotels in the list as a double
	 * @throws IllegalArgumentException if a null list is passed in
	 */
	private static double calcAvgPrice(List<Accommodation> list) throws IllegalArgumentException {
		double totalPrice;
		int numOfHotels;
		if (list == null) {
			throw new IllegalArgumentException("List cant be null");
		} else if (list.size() == 0) {
			// average will be zero, dont need to loop
			return 0.0;
		} else {
			// loop and calculate average
			totalPrice = 0;
			numOfHotels = 0;

			for (Accommodation acc : list) {
				// add to the totalPrice
				totalPrice += acc.getPrice();
				// increment number of hotels for the calc
				numOfHotels++;
			}
		}
		// do the division and return result
		double average = totalPrice / numOfHotels;
		return average;
	}

	/**
	 * Recieves a list of Accommodation objects and searches it for a specified Type
	 * (Enum)
	 * 
	 * @param mainList
	 * @param type
	 * @returns a list of matching Accomodation objects whose type matches the type
	 *          passed in
	 * @throws IllegalArgumentException if the type or list is null
	 */
	private static List<Accommodation> searchByType(List<Accommodation> mainList, Type type)
			throws IllegalArgumentException {
		List<Accommodation> results = new ArrayList<Accommodation>();
		// check for nulls
		if (mainList == null) {
			throw new IllegalArgumentException("List cannot be null");
		} else if (type == null) {
			throw new IllegalArgumentException("Type cannot be null");
		} else if (mainList.size() == 0) {
			// no point looping reuturn the empty list
			return results;
		} else {
			for (Accommodation acc : mainList) {
				if (acc.getType() == type) {
					// we have a match, add it to results list
					results.add(acc);
				}
			}
		}
		return results;
	}

	/**
	 * Recieves a list of Accomodation objects
	 * 
	 * @param mainList
	 * @returns the number of unique cities in the list of objects
	 * @throws IllegalArgumentException if a null list is passed in
	 */
	private static Set<String> getUniqueCities(List<Accommodation> mainList) throws IllegalArgumentException {
		Set<String> cities = new HashSet<String>();

		if (mainList == null) {
			throw new IllegalArgumentException("Main list cant be null");
		} else if (mainList.size() == 0) {
			// no point looping, the answer is 0,return empty list
			return cities;
		} else {
			for (Accommodation accom : mainList) {
				// add the city to the set (wont allow duplicates in the set)
				cities.add(accom.getCity());
			}
		}

		// return the size of the set as it will be unique
		return cities;
	}

	/**
	 * Recieves a list of Accomodation objects, and a specified top number to return
	 * based on a given comparator Will not modify the original list, will return a
	 * new list of top N Accomodation objects where N is the number of top items to
	 * return The sorting will be done based on the comparator passed in
	 * 
	 * @param list
	 * @param limit
	 * @param comparator
	 * @return a list of top N Accomodation objects based on the comparator passed
	 *         in
	 */
	private static List<Accommodation> topXSorted(List<Accommodation> list, int limit,
			Comparator<Accommodation> comparator) {
		List<Accommodation> copy = new ArrayList<Accommodation>(list);
		List<Accommodation> results = new ArrayList<Accommodation>();

		if (list == null) {
			throw new IllegalArgumentException("List cannot be null");
		} else if (copy.size() == 0) {
			return results;
		} else if (limit < 1) {
			throw new IllegalArgumentException("Limit must be more than 0");
		} else {
			// safe to loop

			Collections.sort(copy, comparator);
			// loop for the specified amount of times, check the list is of sufficient size
			// - loop less if needed
			int toLoop = copy.size() >= limit ? limit : copy.size();

			// loop specified times and add top X based on the sorted list to the results
			for (int i = 0; i < toLoop; i++) {
				results.add(copy.get(i));
			}
		}

		// return results
		return results;
	}

	/**
	 * Search a list of Accomodation objects for a specified star rating match
	 * 
	 * @param list
	 * @param stars (int)
	 * @returns a list of Accomodation objects where their star rating is equal to
	 *          the star rating passed into the search
	 * @throws IllegalArgumentException if list is null, star rating is <1 or >5.
	 */
	private static List<Accommodation> searchByStars(List<Accommodation> list, int stars)
			throws IllegalArgumentException {
		List<Accommodation> results = new ArrayList<Accommodation>();

		if (list == null) {
			// if empty list is pass in throw exception
			throw new IllegalArgumentException("List cant be null");
		} else if (stars < 1 || stars > 5) {
			// if outside of range throw exception
			throw new IllegalArgumentException("Star rating must be between 1-5 inclusive");
		} else if (list.size() == 0) {
			// if list is empty no point in looping - return empty list and allow other
			// methods to deal with it
			return results;
		} else {
			for (Accommodation accom : list) {
				// if the object stars match the specified stars, add to list
				if (accom.getStars() == stars) {
					results.add(accom);
				}
			}
		}
		// return results
		return results;
	}

	/**
	 * Searches a list of Accommodation objects for a specified city (String) - non
	 * case sensitive
	 * 
	 * @param mainList (ArrayList)
	 * @param city     (String)
	 * @returns a list of Accomodation objects that match the city being searched
	 *          for
	 * @throws IllegalArgumentException if the list is null, or the string is null
	 */
	public static List<Accommodation> searchByCity(List<Accommodation> mainList, String city)
			throws IllegalArgumentException {
		List<Accommodation> results = new ArrayList<Accommodation>();

		if (mainList == null || city == null) {
			throw new IllegalArgumentException("List/Search string cannot be null");
		} else if (mainList.size() == 0) {
			// no point looping, return empty list and allow the print method to deal with
			// the empty list
			// i.e. it is currently already set up to print "No Accommodation in the list"
			return results;
		} else {
			// loop through and check for a match, add to the list
			for (Accommodation accom : mainList) {
				if (accom.getCity().equalsIgnoreCase(city)) {
					// we have a match - add to the list
					results.add(accom);
				}
			}
		}
		// return the results list
		return results;
	}

	/**
	 * Recieves a list of Accomodation objects and prints their details to console
	 * by invoking their PrintDetails() method Includes a numberial print out of
	 * order
	 * 
	 * @param mainList
	 */
	private static void printAllDetails(List<Accommodation> mainList) {
		if (mainList == null) {
			throw new IllegalArgumentException("Main list cannot be null");
		} else if (mainList.size() == 0) {
			// safe to check size now, if 0 print message to screen
			// no point looping if there are no objects in the list, expensive
			System.out.println("No accomodation in the list to display");
		} else {
			// safe to display and loop
			int num = 1;
			for (Accommodation accom : mainList) {
				// print the numerical number
				System.out.println(num + ")");
				accom.printDetails();
				// take a new line
				System.out.println();
				// increment the number
				num++;
			}
		}

	}

	/**
	 * Read data from a given filename for a formatted csv file of accommodation
	 * data
	 * 
	 * @param filename
	 * @return list of accommodation objects for each row of the file containing
	 *         valid data
	 */
	public static List<Accommodation> readRoomData(String filename) {
		List<Accommodation> rooms = new ArrayList<Accommodation>();

		File file = new File(filename);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine(); // throw away headers
			line = br.readLine();
			String[] parts;

			// whille line is not null keep looping
			while (line != null) {

				try {
					parts = line.split(",");
					String name = parts[0];
					Type type = Type.valueOf(parts[1].toUpperCase());
					int stars = Integer.parseInt(parts[2]);
					String city = parts[3];
					double price = Double.parseDouble(parts[4]);
					int roomsavail = Integer.parseInt(parts[5]);

					rooms.add(new Accommodation(name, type, stars, city, price, roomsavail));

				} catch (Exception ex) {
					System.out.println("Skipping bad line of data, printing details:");
					ex.printStackTrace();
				}
				// read next line
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO update method to read from formatted csv
		// TODO create an Accommodation object for each line of the file and add to
		// rooms list
		// TODO skip any lines which contain data which doesnt match business rules

		System.out.println(rooms.size() + " entries read successfully");
		return rooms;
	}

	/**
	 * Display prompt and get int user input via static scanner repeat if invalid
	 * input type given - no need to modify this method
	 * 
	 * @return int value entered via scanner
	 */
	private static int getMenuChoice(String prompt) {
		try {
			System.out.println(prompt);
			int choice = scanner.nextInt();
			return choice;
		} catch (Exception e) {
			System.out.println("Invalid input try again");
			// clear buffer if required
			if (scanner.hasNext()) {
				scanner.next();// read and discard line break
			}
			return getMenuChoice(prompt);// return recursive call to method to recover
		}
	}

	/**
	 * Writes menu options to console - no need to modify this method
	 */
	private static void displayOptions() {
		System.out.println();
		System.out.println("Menu Options:");
		System.out.println("1. (Re)read Data From Original File (use to restore removed data for example)");
		System.out.println("2. Display the number of places to stay in the current list");
		System.out.println("3. Display details for all places to stay in the current list");
		System.out.println(
				"4. Display details of the 3 least expensive 4 Star places to stay in Los Angeles (low to high)");
		System.out.println("5. Display the number of cities in the current list");
		System.out.println("6. Display details of the 4 most expensive BnBs in Dublin (high to low)");
		System.out.println("7. Display the average price of a hotel in New York");
		System.out.println("8. Remove all entries with fewer than 10 rooms available for Paris from the current list");
		System.out.println("9. (Separate Thread) Write out to a formatted csv, "
				+ "\nthe name of each city and the average price of a hotel there (2 decimal places, alphabetcically by City name)");
		System.out.println("10. Quit");
	}

}
