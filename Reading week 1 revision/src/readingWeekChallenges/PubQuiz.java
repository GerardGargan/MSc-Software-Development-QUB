package readingWeekChallenges;

import java.util.Random;
import java.util.Scanner;

public class PubQuiz {
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
		
		int randQuestionIndex;
		String userInput, cont;
		cont = "";
		
		do {
		randQuestionIndex = rand.nextInt(4);
		System.out.println(jokeQuestions[randQuestionIndex]);
		
		userInput = scan.nextLine();
		
		if(userInput.equalsIgnoreCase(jokeAnswers[randQuestionIndex])) {
			System.out.println("Correct!");
		} else {
			System.out.println("Incorrect! The correct answer was: "+jokeAnswers[randQuestionIndex]);
		}
		System.out.println("Another Question? Y/N");
		cont = scan.nextLine();
		
		} while(cont.equalsIgnoreCase("y"));
		System.out.println("Program ended");
	}

}
