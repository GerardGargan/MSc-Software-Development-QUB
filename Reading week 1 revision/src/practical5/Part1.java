package practical5;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Part1 {
	
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int userInput;
		
		oddEven(001);

		upperToLowerCase('a');

		multipleOfFirst(20, 10);

		genRanNums(10);
		
		System.out.println("Enter a number between 5 and 50");
		userInput = userIntInput();
		if(userInput>=5 && userInput<=50) {
		countdown(userInput);
		}
		else {
			System.out.println("Error, number input out of range");
		}
		
		sumUp(userInput);
		
		printNumberInWord(1);
		amPm();
		scan.close();
		
		

	}
	
	public static void amPm() {
		Calendar cal = Calendar.getInstance();
		int time = cal.get(Calendar.AM_PM);
		if(time==1) {
			System.out.println("I Hope that morning went well for you, enjoy the rest of your day");
		} else if(time==0){
			System.out.println("Good morning");
		} else {
			System.out.println("Error");
		}
	}
	
	public static void printNumberInWord(int num) {
		switch(num) {
		case 1:
			System.out.println("ONE");
			break;
		case 2: 
			System.out.println("TWO");
		break;
		case 3: 
			System.out.println("THREE");
		break;
		case 4: 
			System.out.println("FOUR");
		break;
		case 5: 
			System.out.println("FIVE");
		break;
		case 6: 
			System.out.println("SIX");
		break;
		case 7: 
			System.out.println("SEVEN");
		break;
		case 8: 
			System.out.println("EIGHT");
		break;
		case 9: 
			System.out.println("NINE");
		break;
		default:
			System.out.println("OTHER");
		}
	}
	
	public static void sumUp(int bound) {
		int sum =0;
		double average;
		
		for(int i=1; i<=bound; i++) {
			sum +=i;
			System.out.println("value of i "+i);
		}
		average = (double)sum/bound;
		
		System.out.println("The sum is "+sum+" and the average is "+average);
		
	}
	
	public static void countdown(int number) {
		for(int i=number; i>=0; i--) {
			System.out.print(i);
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static int userIntInput() {
		int userInput;
		
		userInput = scan.nextInt();
		scan.nextLine();
		
		return userInput;
	}

	public static void genRanNums(int input) {
		int randNum;
		
		for (int i = 0; i < input; i++) {
			randNum = rand.nextInt(100)+1;
			System.out.println("Generated : "+randNum);
		}

	}

	public static void multipleOfFirst(int num1, int num2) {
		if (num2 % num1 == 0) {
			System.out.println("The second number " + num2 + " is divisible by the first " + num1);
		} else {
			System.out.println("The second number " + num2 + " is not divisible by the first " + num1);
		}

	}

	public static void upperToLowerCase(char letter) {

		if (Character.isLowerCase(letter)) {
			System.out.println("Already lower case");
		} else {
			System.out.println(Character.toLowerCase(letter));
		}

	}

	public static void oddEven(int num) {

		if (num % 2 == 0) {
			System.out.println(num + " is even");
		} else {
			System.out.println(num + " is odd");
		}

	}

}
