package asciiConverter;

import java.util.Scanner;

public class ASCII {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Declare vars
		int userChoice = 0;
		//Show the menu again unless the user selects 4. Quit
		do {
		//display the menu
		displayMenu();
		
		//ask the user to select an option from the menu
		userChoice = scan.nextInt();
		scan.nextLine();
		
		//switch on the users input, perform the appropriate method.
		switch (userChoice) {
		case 1:
			asciiTable();
			break;
		case 2:
			convertChar();
			break;
		case 3:
			convertName();
			break;
		case 4:
			System.out.println("Quitting...");
			break;
		default:
			System.out.println("Invalid number");
		}
		} while(userChoice!=4);

	}
	
	/**
	 * Prompts the user to input a name. Casts each characer to an ASCII value and prints to screen
	 */
	private static void convertName() {
		String name;
		System.out.println("Please enter your name and press reutrn\n");
		name = scan.nextLine();

		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i)+"\t"+(int) name.charAt(i));
		}
		System.out.println();

	}

	/**
	 * Prompts user for a character and prints the ASCII value
	 */
	private static void convertChar() {
		char character;
		System.out.println("Enter a character to be converted to ASCII");
		character = scan.next().charAt(0);
		System.out.println((int)character);
		System.out.println();
	}

	/**
	 * Prints the asciiTable to screen
	 */
	public static void asciiTable() {
		int start, end;
		start = 32;
		end = 127;

		for (int i = start; i <= end; i++) {
			System.out.println(i + "\t" + (char) i);
		}
		System.out.println();

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

}
