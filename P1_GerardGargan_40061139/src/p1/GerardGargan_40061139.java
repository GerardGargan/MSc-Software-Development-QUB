package p1;

import java.util.Random;
import java.util.Scanner;

public class GerardGargan_40061139 {

	public static int ROUNDS = 5; // set number of rounds, hardcoded but can be adjusted
	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	public static int[] computerGuess = new int[ROUNDS];

	public static void main(String[] args) {

		// create an array to store the random computer guesses, the size of the array
		// is taken from the ROUNDS static variable
		fillComputerGuess(computerGuess);

		// play the game
		playGame(computerGuess);

	}

	/**
	 * Method which plays a rock,paper,scissors game. Prompts user for a guess
	 * (String input), compares to a computer generated random "Rock, paper
	 * scissors" and tracks the wins, losses and draws.
	 * 
	 * @param computerGuess
	 */
	public static void playGame(int[] computerGuess) {
		int wins, losses, currentRound, arrayIndex, draws;
		currentRound = 1;
		arrayIndex = 0;
		wins = 0;
		losses = 0;
		draws = 0;
		String userGuess;
		do {

			// display the question
			System.out.println("***************");
			System.out.println("ROUND " + currentRound);
			System.out.println("***************");
			System.out.println("Choose Rock, Paper or Scissors");
			// get user input
			userGuess = scan.nextLine();
			// convert user guess to an integer value
			// 1=rock, 2=paper, 3=scissors
			int userGuessConverted = convertUserGuessToInt(userGuess);

			// output user and computer choices to screen
			System.out.println("Player played: " + userGuess);
			System.out.println("Computer played: " + convertUserGuessToString(computerGuess[arrayIndex]));

			// check if it was a draw - if the user guess was equal to the array index
			// 1=rock, 2=paper, 3=scissors

			if (userGuessConverted == computerGuess[arrayIndex]) {
				System.out.println("Result: Draw game!");
				draws++;
				// now check if rock beats scissors
			} else if (userGuessConverted == 1 && computerGuess[arrayIndex] == 3) {
				System.out.println("Result: Players wins!");
				wins++;
				// now check if scissors beats paper
			} else if (userGuessConverted == 3 && computerGuess[arrayIndex] == 2) {
				System.out.println("Result: Players wins!");
				wins++;
				// now check if paper beats rock
			} else if (userGuessConverted == 2 && computerGuess[arrayIndex] == 1) {
				System.out.println("Result: Players wins!");
				wins++;
			} else {
				System.out.println("Result: Player Loses!");
				losses++;
			}
			// increment the array index
			arrayIndex++;
			// incremenet the round
			currentRound++;
			// take a new line to tidy up
			System.out.println();

		} while (currentRound <= ROUNDS); // keep looping until we reach the hardcoded value for the number of rounds
		// end of loop, display the statistics
		displayStats(wins, draws, losses);

		// free up resources
		scan.close();
	}

	/**
	 * Recieves the number of wins, draws and losses, prints to screen the
	 * win/loss/draw statistics in %
	 * 
	 * @param winStats
	 * @param drawStats
	 * @param losingStats
	 */
	public static void displayStats(int winStats, int drawStats, int losingStats) {
		double winsDecimal, drawDecimal, lossesDecimal;
		// cast to a double to avoid losing the decimal value
		winsDecimal = (double) winStats / ROUNDS;
		lossesDecimal = (double) losingStats / ROUNDS;
		drawDecimal = (double) drawStats / ROUNDS;
		// print in the correct format, multiply by 100 to give a percentage
		System.out.println("Final statistics");
		System.out.printf("Win percentage: %.2f%%\n", winsDecimal * 100);
		System.out.printf("Loss percentage: %.2f%%\n", lossesDecimal * 100);
		System.out.printf("Draw percentage: %.2f%%\n", drawDecimal * 100);

	}

	/**
	 * Converts rock, paper, scissors to a 1,2 or 3 int value
	 * 
	 * @param userGuess
	 * @return rock=1, paper=2, scissors=3
	 */
	public static int convertUserGuessToInt(String userGuess) {
		// 1=rock, 2=paper, 3=scissors
		int userGuessToInt = 0;
		switch (userGuess.toLowerCase()) {
		case "rock":
			userGuessToInt = 1;
			break;
		case "paper":
			userGuessToInt = 2;
			break;
		case "scissors":
			userGuessToInt = 3;
			break;
		default:
			userGuessToInt = 0;
		}
		return userGuessToInt;
	}

	/**
	 * converts the int value 1,2,3 to its corresponding value for rock paper or
	 * scissors
	 * 
	 * @param userGuessInt
	 * @return a string 1=rock, 2=paper, 3=scissors
	 */
	public static String convertUserGuessToString(int userGuessInt) {
		// 1=rock, 2=paper, 3=scissors
		String userGuessToString = "";
		switch (userGuessInt) {
		case 1:
			userGuessToString = "Rock";
			break;
		case 2:
			userGuessToString = "Paper";
			break;
		case 3:
			userGuessToString = "Scissors";
			break;
		default:
			userGuessToString = "Error";
		}
		return userGuessToString;
	}

	/**
	 * fills an array with random numbers between 1-3
	 * 
	 * @param computerGuess
	 */
	public static void fillComputerGuess(int[] computerGuess) {
		for (int i = 0; i < computerGuess.length; i++) {
			computerGuess[i] = rand.nextInt(3) + 1;
		}

	}

}
