package exercises;

import java.util.Scanner;

public class Part1 {

	public static void main(String[] args) {
		
		double number;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input a decimal point number in the format xx.xxxx");
		number = sc.nextDouble();
		
		System.out.printf("Number rounded (two decimal places) %.2f\n", number);
		System.out.printf("Number squared (three decimal places) %.3f\n", Math.pow(number, 2));
		System.out.printf("Number cubed to (three decimal places) %.3f\n", Math.pow(number, 3));
		System.out.printf("Square root (four decimal places) %.4f\n", Math.sqrt(number));
		
		sc.close();
	}

}
