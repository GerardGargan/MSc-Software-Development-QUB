package practical4;

import java.util.Scanner;

public class Part2 {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		int menuSel=0;
		
		do {
		displayMenu();
		menuSel = selectMenu();
		displaySel(menuSel);
		} while(menuSel!=5);
	}

	public static void displaySel(int menuSel) {
		switch(menuSel) {
		case 1:
			System.out.println("You selected 1. File");
			break;
		case 2:
			System.out.println("You selected 2. Edit");
			break;
		case 3: System.out.println("You selected 3. Save");
		break;
		case 4: System.out.println("You selected 4. Delete");
		break;
		case 5: System.out.println("Exiting!");
		break;
		default: System.out.println("Oops, invalid choice.. Try again");
		}
		
	}

	public static int selectMenu() {
		int selection;
		selection = scan.nextInt();
		
		return selection;
		
	}

	public static void displayMenu() {
		System.out.println("1. File");
		System.out.println("2. Edit");
		System.out.println("3. Save");
		System.out.println("4. Delete");
		System.out.println("5. Exit");
		System.out.println("Select option...");
		
		}

}
