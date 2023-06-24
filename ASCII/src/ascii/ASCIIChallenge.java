package ascii;

import java.util.Scanner;

public class ASCIIChallenge {

	public static final int SPACE_CHAR = 32;

	public static void main(String[] args) {

		// initialise vars
		int menuSel;
		String character;
		String name;

		Scanner sc = new Scanner(System.in);
		// display the menu
		do {
			System.out.println(
					"ASCII converter menu.....\n" + "1. Show ASCII Table\n" + "2. Convert a character to ASCII\n"
							+ "3. Convert your name to ASCII\n" + "4. Quit\n" + "Enter a number and return\n");

			// get user selection

			menuSel = sc.nextInt();
			sc.nextLine(); //clear the scanner from the return button

			// switch on their choice and run each set of code

			switch (menuSel) {

			case 1:
				System.out.println("Show ASCII Table");
				for (int i = 32; i <= 127; i++) {
					System.out.println(i + "\tASCII\t" + (char) i);
				}
				System.out.println("\n");
				break;
			case 2:
				System.out.println("Enter a character, it will be converted to ASCII: ");
				character = sc.next();
				char character2 = character.charAt(0);

				System.out.println(character2 + "\t" + (int) character2 + "\n\n");

				break;
			case 3:
				System.out.println("Enter your name to be converted to ASCII");
				name = sc.nextLine(); 

				for (int i = 0; i < name.length(); i++) {

					char charValue = name.charAt(i);
					if ((int) charValue != SPACE_CHAR) {
						System.out.println(charValue + "\tASCII\t" + (int) charValue);
					}

				}
				System.out.println("\n");

				break;
			case 4:
				System.out.println("Quitting...\n\n");
				break;
			default:
				System.out.println("Invalid selection... Try again!\n\n");
			}
		} while (menuSel != 4);

		sc.close();
		System.out.println("Bye!");
	}

}
