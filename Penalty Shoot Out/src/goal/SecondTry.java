package goal;

import java.util.Random;
import java.util.Scanner;

public class SecondTry {

	public static void main(String[] args) {

		int saves[] = new int[5];
		fillSaves(saves);
		playGame(saves);

	}

	// Method to display net
	public static void displayNet() {
		System.out.println("\t\t_______________________");
		System.out.println("\t\t|  1       2        3  |");
		System.out.println("\t\t|  4       5        6  |");
		System.out.println("\t\t|  7       8        9  |");
		System.out.println("_____________________________________________________\n\n");
		System.out.println("\t\t           X            ");
		System.out.println("\n");
	}

	// Method to fill saves (random 1-9)
	public static void fillSaves(int[] saves) {
		Random rand = new Random();

		// fill the array with random numbers, pass by reference in play (modifying the
		// original saves variable in the main method)
		for (int i = 0; i < saves.length; i++) {
			saves[i] = rand.nextInt(9) + 1;
		}
	}

	// Method to get user input and check if it was saved or a goal
	public static void playGame(int[] saves) {
		int penalty = 1;
		int score = 0;
		int userGuess[] = new int[saves.length];

		Scanner scan = new Scanner(System.in);

		for (int loop = 0; loop < saves.length; loop++) {
			System.out.println("Penalty number: " + penalty + " out of " + saves.length);
			displayNet();
			System.out.println("Select shot...");
			userGuess[loop] = scan.nextInt();
			System.out.print("Placing the ball ... ");
			delay(500);
			System.out.print("Walking back ... ");
			delay(500);
			System.out.print("Run up... ");
			delay(100);
			System.out.print("SHOOT ! ");
			System.out.println();
			delay(1000);
			if (userGuess[loop] == saves[loop]) {
				System.out
						.println("SAVE! You selected " + userGuess[loop] + " The keeper saved position " + saves[loop]);
			} else {
				System.out
						.println("GOAL! You selected " + userGuess[loop] + " The keeper saved position " + saves[loop]);
				score++;
			}
			delay(1000);
			penalty++;
		}
		System.out.println("Goals scored: " + score);
		message(score);
		System.out.println();

	}

	private static void delay(int millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void message(int userScore) {
		String performanceMessage;
		switch (userScore) {

		case 0:
			performanceMessage = "You have disgraced your country and family!";
			break;
		case 1:
			performanceMessage = "You have disgraced your country and family!";
			break;
		case 2:
			performanceMessage = "Back to training for you!";
			break;
		case 3:
			performanceMessage = "Try using your good foot!";
			break;
		case 4:
			performanceMessage = "Not bad - but not perfect!";
			break;
		case 5:
			performanceMessage = "Fluke and the keeper is not very good anyway!";
			break;
		default:
			performanceMessage = "I don't know what to say about that one";
		}
		System.out.println(performanceMessage);
	}

}
