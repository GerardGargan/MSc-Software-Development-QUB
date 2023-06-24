package looping;

import java.util.Scanner;
import java.util.Random;

public class ExerciseWhileLoop {

	public static void main(String[] args) {
		
		int guess, target;
		
		Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		target = rand.nextInt(10)+1;
		
		System.out.println("Guess a number 1-10: ");
		guess = sc.nextInt();
		
		while(guess != target) {
			System.out.println("Wrong! "+target);
			System.out.println("Try again 1-10: ");
			guess = sc.nextInt();
		}
		// if we get this far it must be correct
		System.out.println("Correct!! it was "+target); 
		
		sc.close();

	}

}
