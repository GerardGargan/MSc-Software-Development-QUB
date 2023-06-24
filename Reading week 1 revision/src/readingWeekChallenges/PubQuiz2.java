package readingWeekChallenges;

import java.util.Random;
import java.util.Scanner;

public class PubQuiz2 {
//	Actions:
//		1. The user should be given a random question from the question Array (see below)
//		2. User responds
//		3. User answer should be checked against the answer in the answer Array (see below)
//		4. User is notified of outcome
//		5. User is prompted to continue (get another question) or quit

	public static Scanner scan = new Scanner(System.in);
	public static Random rand = new Random();
	

	public static void main(String[] args) {
		
		String[] jokeQuestions = { "Largest planet ? ", "Worse song ever ? ", "Capital of Peru?",
		"Roman god of War ?" };
String[] jokeAnswers = { "Jupiter", "Castles in the Sky", "Lima", "Mars" };

		//declare vars - userInput, random number, anotherQuestion
		
		String userInput, anotherQuestion, randQuestion, randAnswer;
		int randNum;
		
		do {
		randNum = rand.nextInt(jokeQuestions.length); //generate a random number (index)
		randQuestion = jokeQuestions[randNum]; //Access and store the random question
		randAnswer = jokeAnswers[randNum]; //Store the corresponding answer
		
		System.out.println(randQuestion); //Print the question to screen
		userInput = getUserInput(); //Get and store the users input
		checkAnswer(userInput, randAnswer); //check if the users input matches the corresponding answer, display result
		
		System.out.println("Play again? Y/N"); //ask if the user wants to play again
		anotherQuestion = getUserInput(); //get the users input
		} while (anotherQuestion.equalsIgnoreCase("y")); //keep performing the loop while the user enters y for yes
		
		System.out.println("End of program, thanks for playing.");
		scan.close();
	}

	/**
	 * Checks if the users answer matches the actual answer from the question, outputs result to screen
	 * @param userInput
	 * @param randAns
	 */
	public static void checkAnswer(String userInput, String randAns) {
		if(userInput.equalsIgnoreCase(randAns)) {
		System.out.println("Correct!");
		} else {
			System.out.println("Incorrect, the answer was: "+randAns);
		}
	}

	/**
	 * Scanner requests user input and returns it in a string
	 * @returns the users input as a string
	 */
	private static String getUserInput() {
		String userText;
		userText = scan.nextLine();
		return userText;
	}
}
