package practical3;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		
		double userInput;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a decimal point number in the format xx.xxxx e.g. 12.3456");
		userInput = scan.nextDouble();
		
		System.out.printf("Number rounded (Two DP) %.2f%n", userInput);
		System.out.printf("Number rounded (Three DP) %.3f%n", userInput);
		System.out.printf("Number cubed (Three DP) %.3f%n", Math.pow(userInput, 3));
		System.out.printf("Square root (Four DP) %.4f%n", Math.sqrt(userInput));

		scan.close();
	}

}
