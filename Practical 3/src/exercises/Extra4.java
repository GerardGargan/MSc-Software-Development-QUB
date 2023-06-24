package exercises;

import java.util.Scanner;

public class Extra4 {

	public static void main(String[] args) {
		
		int menu;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1. File\n2. Add\n3. Edit\n4. Delete\n5. Exit\nEnter option...");

		
		menu = sc.nextInt();
		
		switch(menu) {
		
		case 1:
			System.out.println("You selected 1. File");
			break;
		case 2:
			System.out.println("You selected 2. Add");
			break;
		case 3:
			System.out.println("You selected 3. Edit");
			break;
		case 4:
			System.out.println("You selected 4. Delete");
			break;
		case 5:
			System.out.println("You selected 5. Exit");
			break;
			default: System.out.println("You did not enter a valid menu item");
		
		}
		
		

	}

}
