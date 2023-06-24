package practical3;

import java.util.Scanner;

public class Part3_2 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		vote();
		
		scan.close();

	}

	public static void vote() {

		String userVote = "Empty";
		System.out.println("Voting...");
		System.out.println("Enter 'con' for Conservative and 'lab' for labour");
		userVote = getUserInput();
		message(userVote);
	}

	public static void message(String userVote) {
		switch(userVote.toLowerCase()) {
		case "con":
			System.out.println("Vote registered for conservative");
			break;
		case "lab":
			System.out.println("Vote registered for labour");
			break;
			default:
				System.out.println("Invalid vote!");
		}
		
	}

	public static String getUserInput() {
		String input;
		input = scan.next();
		
		return input;
	}

}
