package practicals;

import java.util.Scanner;

public class MenuSelection {

	public static void main(String[] args) {

		String menuItems = "1. File\n2. Edit\n3. Save\n4. Delete\n5. Exit\n";
		int menuSelection = 0;

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Please select a menu item:\n" + menuItems);

			menuSelection = sc.nextInt();

			switch (menuSelection) {
				
			case 1:
				System.out.println("File selected");
			break;
			case 2:
				System.out.println("Edit selected");
				break;
			case 3: System.out.println("Saved");
			break;
			case 4:
				System.out.println("Deleted");
				break;
			case 5: 
				System.out.println("Exit");
				break;
				default:
					System.out.println("Unrecognised, try again!");
				
			}
		} while (menuSelection!=5);
		
		System.out.println();;
		sc.close();

	}

}
