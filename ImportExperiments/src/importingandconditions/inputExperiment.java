package importingandconditions;

import java.util.Scanner;

public class inputExperiment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2;
		
		num1 = 100;
		System.out.println("Please enter a number and press enter");
		num1 = sc.nextInt();
		
		System.out.println("Please enter another number and press enter");
		num2 = sc.nextInt();
		
		int result = num1 / num2;
		
		System.out.println(num1 + " div "+ num2 + " is "+ result);
		
		sc.close();

	}

}
