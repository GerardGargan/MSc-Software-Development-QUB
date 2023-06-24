import java.util.Random;
import java.util.Scanner;

public class GoalChallenge {
	
	public static int saves[] = new int[5];
	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();

	public static void main(String[] args) {
		
		//Methods
		//Display net?
		//Fill saves (array with 5 random numbers 1-9)
		fillSaves();
		playGame();
		//get user input (5 penaltys (loop))... & check if their guess corresponds with the saves array

	}

	private static void playGame() {
		int pen =1;
		int goals = 0;
		int userInput = 0;
		for(int i=0; i<saves.length; i++) {
		System.out.println("Game on...");
		System.out.println("Penalty number: "+pen+" out of "+saves.length);
		displayNet();
		System.out.println("Select shot...");
		userInput = scan.nextInt();
		scan.nextLine();
		if(userInput==saves[i]) {
			System.out.println("SAVE! You chose position "+userInput+" and the keeper went to position "+saves[i]);
		} else {
			System.out.println("GOAL! You chose position "+userInput+" and the keeper went to position "+saves[i]);
			goals++;
		}
		pen++;
		}
		System.out.println("You scored "+goals+" out of "+saves.length);
	}

	public static void displayNet() {
		System.out.println("        _______________________\r\n"
				+ "        |  1       2        3  |\r\n"
				+ "        |  4       5        6  |\r\n"
				+ "        |  7       8        9  |\r\n"
				+ "_____________________________________________________\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "                   X            \r\n"
				+ "");
		
	}

	private static void fillSaves() {
		for(int i=0; i<saves.length; i++) {
			saves[i] = rand.nextInt(9)+1;
		}
	}

}
