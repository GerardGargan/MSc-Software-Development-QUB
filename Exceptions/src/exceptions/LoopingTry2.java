package exceptions;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class LoopingTry2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int userInput = 0;
		boolean valid = false;
		int randNum = rand.nextInt(10)+1;
		
		do {
		try {
		System.out.println("Please input a guess between 1-10");
		userInput = scan.nextInt();
		
		
		System.out.println("You chose: "+userInput);
		System.out.println("Computer chose: "+randNum);
		valid = true;
		} catch(InputMismatchException ex) {
			System.out.println("You did not put in an integer value, try again");
			scan.nextLine();
		}
		} while(!valid);

	}

}
