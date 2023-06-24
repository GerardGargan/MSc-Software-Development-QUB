package magic8ball;

import java.util.Scanner;
import java.util.Random;

public class Magic8Ball {

	public static void main(String[] args) {
		
		String userInput;
		int randomNum;
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		System.out.println("Please input a question for the magic 8 ball to answer: ");
		userInput = sc.nextLine();
		
		randomNum = rand.nextInt(8)+1;
		
		switch(randomNum) {
		
		case 1:
			System.out.println("As i see it, yes.");
		break;
		case 2:
			System.out.println("Ask again later");
			break;
		case 3: 
			System.out.println("Better not tell you now.");
			break;
		case 4:
			System.out.println("Cannot predict now");
			break;
		case 5:
			System.out.println("Concentrate and ask again.");
			break;
		case 6:
			System.out.println("Dont count on it.");
			break;
		case 7:
			System.out.println("It is certain.");
			break;
		case 8:
			System.out.println("It is decidely so");
			break;
			default:
				System.out.println("Error...");
		}
		
		

	}

}
