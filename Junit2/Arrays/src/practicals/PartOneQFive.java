package practicals;

import java.util.Scanner;

public class PartOneQFive {

	public static void main(String[] args) {

		checkVowelsName();

	}
	
	public static void checkVowelsName() {
		// declare vars
		char[] vowels = new char[] { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		String name;
		int vowelMatch = 0;
		int vowelA, vowelE, vowelI, vowelO, vowelU;
		vowelA = 0;
		vowelE = 0;
		vowelI = 0;
		vowelO = 0;
		vowelU = 0;

		// Create scanner
		Scanner scan = new Scanner(System.in);

		// Prompt for user input
		System.out.println("Please enter your first name: ");

		// Get user input
		name = scan.next();

		// Assign each value to a char array
		char nameArray[] = new char[name.length()];

		// looping through each letter of the string and using charAt to assign the character
		// at that index to the array
		for (int i = 0; i < name.length(); i++) {
			nameArray[i] = name.charAt(i);
		}

		// Count the occurrences of the different vowels taking into account lowercase uppercase. 
		// Uses a nested for loop to check each character of user input against an array of vowels
		// Outer loop goes through each character of the user Inputted name
		// Second loop checks the specificed character from the outer loop against each of the caracters in the vowel Array
		// Switch statement to increment the specific count of the vowels
		
		for (int count = 0; count < nameArray.length; count++) {
			for (int countArray = 0; countArray < vowels.length; countArray++) {

				if (nameArray[count] == vowels[countArray]) {
					vowelMatch++;
					switch (vowels[countArray]) {
					case 'a':
					case 'A':
						vowelA++;
						break;
					case 'e':
					case 'E':
						vowelE++;
					break;
					case 'i':
					case 'I':
						vowelI++;
						break;
					case 'o':
					case 'O':
						vowelO++;
						break;
					case 'u':
					case'U':
						vowelU++;
						break;
						
					}
				}

			} // end of inner loop
		} // end of outer loop

		// Display the total number of occurrences for each vowel
		System.out.printf("There were %d vowels in the name provided%n", vowelMatch);
		System.out.println("A: "+vowelA);
		System.out.println("E: "+vowelE);
		System.out.println("I: "+vowelI);
		System.out.println("O: "+vowelO);
		System.out.println("U: "+vowelU);
		
		scan.close();
	}

}
