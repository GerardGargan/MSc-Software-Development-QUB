package exceptions;

import java.util.Scanner;

public class LoopingTry3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int age = 0;
		boolean valid = false;
		
		do {
		try {
		System.out.println("Please input your age");
		age = scan.nextInt();
		valid = true;
		
		if(age>=18 && age<100) {
		System.out.println("You can register");
		} else {
			System.out.println("Invalid age, cannot register");
			
		}

		} catch(Exception ex) {
			System.out.println("You must enter an integer, try again");
			scan.nextLine();
		}
	
	} while(!valid);
	}
}
