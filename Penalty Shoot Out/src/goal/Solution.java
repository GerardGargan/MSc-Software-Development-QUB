package goal;

import java.util.Random;
import java.util.Scanner;

/**
 * Challenge penalty taking game
 * @author Aidan
 *
 */
public class Solution {

	/**
	 * THis is starter 
	 * @param args
	 */
	public static void main(String[] args) {

		// array to store the saves to be made (note this could be defined class wide - but defined with her to illustrate how to pass the ref to the array about via methods 
		int[] saves = new int[5];

		System.out.println("Game on... ");

		// fill the saves array with random numbers between 1 - 9 inclusive
		fillSavePositions(saves);

		// game on
		playTheGame(saves);

		System.out.println("Thanks for playing...");
	}

	/**
	 * Fills the sequence of saves as digits between 1-9 in a 5 element array
	 * @param saves
	 */
	private static void fillSavePositions(int[] saves) {
		Random random = new Random();

		// fill the saves array with random numbers between 1 - 9 inclusive
		for (int savePosition = 0; savePosition < saves.length; savePosition++) {
			saves[savePosition] = random.nextInt(9) + 1;
		}
		
		// note as the array is an object no need to pass the array back (pass by reference)! 
	}

	/**
	 * Shows the goal and shooting options
	 */
	private static void displayGoals() {
		// display the goals
		System.out.println("\t\t_______________________");
		System.out.println("\t\t|  1       2        3  |");
		System.out.println("\t\t|  4       5        6  |");
		System.out.println("\t\t|  7       8        9  |");
		System.out.println("_____________________________________________________\n\n");
		System.out.println("\t\t           X            ");
		System.out.println("\n");
	}

	/**
	 * Play the game...
	 * @param saves
	 */
	private static void playTheGame(int[] saves) {

		Scanner scanner = new Scanner(System.in);
		int userShot, userScore, pen;
		userScore = 0;
		pen =1;

		// go through each shot - save attempt sequence
		for (int savePosition = 0; savePosition < saves.length; savePosition++) {
			System.out.println("Penalty number : "+pen +" out of "+saves.length);
			displayGoals();

			// get user shot position
			System.out.println("Select shot  ... ");
			userShot = scanner.nextInt();

			// sleep (suspense building!!)

			System.out.print("Placing the ball ... ");
			delay(500);
			System.out.print("Walking back ... ");
			delay(500);
			System.out.print("Run up... ");
			delay(100);
			System.out.print("SHOOT ! ");
			System.out.println();
			delay(1000);

			if (userShot == saves[savePosition]) {
				// save !
				System.err.println("SAVE ! ");
			} else {
				// goal !
				System.err.println("GOAL ! ");
				System.out.println("Keeper went to " + saves[savePosition]);
				// update score
				userScore++;
			}
			System.out.println();

			delay(1000);
			pen++;
		} // end of the pens

		// outcome messages
		System.out.println("Goals scored : " + userScore + "/" + saves.length);
		System.out.println(assessPerformanace(userScore));

		scanner.close();
	}

	/**
	 * Uses Thread sleep to add a configurable delay
	 * 
	 * @param millisecs
	 */
	private static void delay(int millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Provides a message on performance (goals scored)
	 * 
	 * @param userScore
	 * @return A Smart message !
	 */
	private static String assessPerformanace(int userScore) {
		String performanceMessage;

		switch (userScore) {
		case 0:
			performanceMessage = "You have disgraced your country and family!";
			break;
		case 1:
			performanceMessage = "You have disgraced your country!";
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
		return performanceMessage;
	}

}
