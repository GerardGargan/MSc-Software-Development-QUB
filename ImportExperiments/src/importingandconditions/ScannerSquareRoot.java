package importingandconditions;

import java.util.Scanner;

public class ScannerSquareRoot {

	public static void main(String[] args) {
		
		int num1 =0;
		double result;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a number to calculate the square root:");
		num1 = sc.nextInt();
		
		result = Math.sqrt(num1);
		
		System.out.printf("The square root of %d is: %.2f",num1,result);
		
		sc.close();
		
		
	}

}
