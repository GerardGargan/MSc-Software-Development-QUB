package practical3;

import java.util.Scanner;

public class Menu {
	
	public static Scanner scan = new Scanner(System.in);
	public static String[] menu = new String[] {"1. File", "2. Add", "3. Edit", "4. Delete", "5. Exit"};

	public static void main(String[] args) {
		
		fileMenuSelect();
		
		scan.close();

	}

	public static void fileMenuSelect() {
		int userSelection;
		do {
		displayMenu();
		System.out.println("Enter option...");
		userSelection = getSelection();
		outputSelection(userSelection);
		} while(userSelection<1 || userSelection >menu.length);
		
	}

	public static void outputSelection(int userSelection) {
		if(userSelection<1 || userSelection>menu.length) {
			System.out.println("Invalid, try again!");
		} else {
		System.out.println("You selected: "+menu[userSelection-1]);
		}
		
	}

	public static int getSelection() {
		int select;
		
		select = scan.nextInt();
		return select;
	}

	public static void displayMenu() {
		for(int i=0; i<menu.length; i++) {
			System.out.println(menu[i]);
		}
		
	}

}
