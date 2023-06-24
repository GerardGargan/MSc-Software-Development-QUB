package challengeSquareup;

import java.util.Scanner;

public class SquareMeUp {

	public static void main(String[] args) {

//		Drawing a box - this challenge will involve user input, loops and methods (with parameter passing). 
//		Ask the user for the size (length of the side) of a box. 
//		Prompt the user for the character to use as each point on the box 

		// Declare the variables
		int inputLength;
		String character;
		char characterConverted;

		Scanner scan = new Scanner(System.in);

		// Prompt the user for the length of the side of a box
		System.out.println("Please enter the length of the box you wish to creare: ");

		inputLength = scan.nextInt();

		// Prompt for the character

		System.out.println("Please enter a character: ");
		character = scan.next(); // Get the character input from the user
		characterConverted = character.charAt(0); // Takes the first character from the string and returns it as a char
													// type

		// pass the scanner inputs into the method parameters
		drawHorizontal(inputLength, characterConverted);
		drawSides(inputLength, characterConverted);
		drawHorizontal(inputLength, characterConverted);

		scan.close();

	}

	public static void drawHorizontal(int length, char character) {
		//print a the top, loop for the length and print the character repeatedly
		for (int i = 0; i < length; i++) {
			System.out.print(character+" ");
		}
		System.out.println();

	}

	public static void drawSides(int length, char character) {
		// outer loop row - takes a new row after each iteration with a printline at the end of this loop
		for (int row = 0; row < length; row++) {

			// inner loop loops for the length and only prints a character at the start and end
			for (int i = 0; i < length; i++) {

				if (i == 0 || i == (length - 1)) {
					System.out.print(character+" ");
				} else {
					System.out.print("  ");
				}
				
			}
			
			System.out.println();
		}

	}

}
