package exercises;

import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {
		
		int result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the final mark: ");
		result = sc.nextInt();
		
		if(result>=0 && result<=49) {
			System.out.println("Fail");
		}
		else if(result>=50 && result<=59) {
			System.out.println("Pass");
		}
		else if(result >=60 && result<= 69) {
			System.out.println("Merit");
		}
		else if(result>=70 && result<=100) {
			System.out.println("Distinction");
		}
		else {
			System.out.println("Unknown");
		}
		

	}

}
