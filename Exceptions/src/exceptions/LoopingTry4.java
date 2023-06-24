package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoopingTry4 {

	public static void main(String[] args) {
		int userNum;
		boolean valid = false;
		Scanner scan = new Scanner(System.in);
		
		do {
		try {
		System.out.println("Please input a number between 1&10");
		userNum = scan.nextInt();
		valid = true;

		System.out.println("User input: "+userNum);
		} catch(InputMismatchException ex) {
			System.out.println("Oops something went wrong!");
			System.out.println("Try again");
			scan.nextLine();
		}
		} while(!valid);
		
		scan.close();
	}

}
