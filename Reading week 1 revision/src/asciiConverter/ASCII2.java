package asciiConverter;

import java.util.Arrays;
import java.util.Scanner;

public class ASCII2 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Declare vars
		int userMenuChoice;
		String userInputParam;
		char userInputChar;

		do {
			// display the menu
			displayMenu(); 
			// ask the user for their menu choice
			userMenuChoice = scan.nextInt(); 
			// throw away the return key in the scanner
			scan.nextLine(); 
			
			//Switch on the users choice and perform the appropriate method
			switch (userMenuChoice) {
			case 1:
				displayAsciiTable(32, 127);
				System.out.println();
				break;
			case 2:
				System.out.println("Input a single character and press return");
				userInputChar = getUserInput().charAt(0);
				System.out.printf("Character: %s, ASCII: %d%n%n", userInputChar, charToInt(userInputChar));
				break;
			case 3:
				System.out.println("Input your name to be converted to ASCII and press return");
				userInputParam = getUserInput();
				int[] nameAscii = asciiName(userInputParam);
				System.out.println("Name:"+userInputParam+", \nASCII " + Arrays.toString(nameAscii)+"\n");
				break;
			case 4:
				System.out.println("Quitting...");
				break;
			default:
				System.out.println("Invalid choice.. try again \n");
			}
		} while (userMenuChoice != 4);

	}

	/**
	 * Displays the main menu
	 */
	public static void displayMenu() {
		System.out.println("ASCII Converter menu.........");
		System.out.println("1. Show ASCII Table");
		System.out.println("2. Convert a character to ASCII");
		System.out.println("3. Convert your name to ASCII");
		System.out.println("4. Quit");
		System.out.println("Enter a number and press return\n");
	}

	/**
	 * Prompts the user to enter a string
	 * 
	 * @returns the inputted string
	 */
	public static String getUserInput() {
		String userInput;
		userInput = scan.nextLine();
		return userInput;
	}

	/**
	 * Recieves a character and converts it to the ASCII value
	 * 
	 * @param character
	 * @return the ASCII value as an int
	 */
	public static int charToInt(char character) {
		int converted = (int) character;
		return converted;
	}

	/**
	 * Recieves a string and converts it to its ASCII numerical value
	 * 
	 * @param name
	 * @returns an array of integers
	 */
	public static int[] asciiName(String name) {
		int converted[] = new int[name.length()];
		for (int i = 0; i < name.length(); i++) {
			converted[i] = charToInt(name.charAt(i));
		}
		return converted;
	}

	/**
	 * Displays the ASCII Table
	 * @param start value
	 * @param end value
	 */
	public static void displayAsciiTable(int start, int end) {
		for (int i = start; i < end; i++) {
			System.out.printf("%d \t %s%n", i, (char) i);
		}
	}

}
