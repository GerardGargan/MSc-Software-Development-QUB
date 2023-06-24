package magic8ball;

import java.util.Random;
import java.util.Scanner;

public class Magic8Ball {

	public static void main(String[] args) {
		// declare vars
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		int randNum;
		String cont = "Y";
		String[] answers = new String[] { "As I see it, yes.", "Ask again later.", "Better not tell you now.",
				"Cannot predict now.", "Concentrate and ask again.", "Don't count on it.", "It is certain.",
				"It is decidedly so." };

		// ask for user input
		do {
		System.out.println("Magic 8 ball...");
		System.out.println("Whats your question?");
		scan.nextLine();
		// output a random answer
		randNum = rand.nextInt(8)+1;
		System.out.println(answers[randNum-1]);
		System.out.println("Continue? Y/N");
		cont = scan.next();
		scan.nextLine();
		} while(cont.equalsIgnoreCase("Y"));
		System.out.println("End of program");
		scan.close();
	}

}
