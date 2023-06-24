package pubquiz;

import java.util.Random;
import java.util.Scanner;

public class PubQuiz {

	public static void main(String[] args) {
		
//		1. The user should be given a random question from the question Array (see below)

//
//		2. User responds


//		3. User answer should be checked against the answer in the answer Array (see below)
		
//
//		4. User is notified of outcome
		
//
//		5. User is prompted to continue (get another question) or quit
		
		String[] jokeQuestions = { "Largest planet ? ", "Worse song ever ? ", "Capital of Peru?",
		"Roman god of War ?" };
		String[] jokeAnswers = { "Jupiter", "Castles in the Sky", "Lima", "Mars" };
		
		Scanner scan = new Scanner(System.in);
		String userAnswer;
		Random rand = new Random();
		String anotherQuestion = "N";
		
		System.out.println("General knowledge quiz!...");
		
		do {
			int randIndex = rand.nextInt(jokeQuestions.length);
			System.out.println(jokeQuestions[randIndex]);
			System.out.println("Your answer...");
			userAnswer = scan.nextLine();
			
			if(userAnswer.equalsIgnoreCase(jokeAnswers[randIndex])) {
				System.out.println("Correct!");
			} else {
				System.out.println("Wrong answer, the answer was "+jokeAnswers[randIndex]);
			}
			
			System.out.println("Would you like another go? Y/N?");
			anotherQuestion = scan.next();
			scan.nextLine();
			
		} while(anotherQuestion.equalsIgnoreCase("Y"));
		
		System.out.println("End of quiz, thanks for playing!");
		
		scan.close();
		

	}
	
	

}
