package exercises;

import java.util.Scanner;

public class Voting {

	public static void main(String[] args) {
		
		String userInput;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Voting...\n Enter 'con' for Conservative and 'lab' for Labour");
		userInput = sc.next();
		
		String lowerCaseUserInput = userInput.toLowerCase();
		
		switch (lowerCaseUserInput) {
		
		case "con":
			System.out.println("Vote registered for Conservative");
			break;
			
		case "lab":
			System.out.println("Vote registered for Labour");
			break;
			
			default: 
				System.out.println("Invalid vote");
		
		}
		
		
	}

}
