package goal;

import java.util.Random;
import java.util.Scanner;

public class goalGuess {

	public static void main(String[] args) {
		
		int saves[] = new int[5];
		
		System.out.println("Game on... ");
		fillSaves(saves);
		userGuess(saves);
		
		// method to get user input, each guess compared to a random number between 1-9

	}
	
	public static void userGuess(int[] saves) {
		Scanner scan = new Scanner(System.in);
		int userShot;
		int userScore = 0;
		int pen = 1;
		
		for(int i=0; i<saves.length; i++) {
			System.out.printf("Penalty number %d\n",pen);
			System.out.println("Take a guess: ");
			displayNet();
			userShot = scan.nextInt();		
			pen++;
			
			if(userShot==saves[i]) {
				System.out.println("SAVE");
			} else {
				System.out.println("GOAL");
				userScore++;
			}
		}
		System.out.println("Total score: "+userScore);
	}
	
	public static void fillSaves(int[] saves) {
		Random rand = new Random();
		for(int i=0; i<saves.length; i++) {
			saves[i] = rand.nextInt(9)+1;
		}
	}
	
	

	public static void displayNet() {
		
		System.out.println("\t\t_______________________");
		System.out.println("\t\t|  1       2        3  |");
		System.out.println("\t\t|  4       5        6  |");
		System.out.println("\t\t|  7       8        9  |");
		System.out.println("_____________________________________________________\n\n");
		System.out.println("\t\t           X            ");
		System.out.println("\n");
		
	}

}
