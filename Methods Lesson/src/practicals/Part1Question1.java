package practicals;

import java.util.Calendar;
import java.util.Random;

public class Part1Question1 {

	public static void main(String[] args) {
		
		oddEven(3);
		
		convertToLowerCase('a');
		
		isMultipleOfFirst(2, 10);
		
		randNumGenerator();
		
		promptCountdown(50);
		
		printNumberInWord(9);
		
		sumLoop(10);
		
		morningAfternoon();

	}
	
	public static void oddEven(int num1) {
		
		if(num1%2==0) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
		
	}
	
	public static void convertToLowerCase(char character) {
		
		if(Character.isLowerCase(character))
		{
			System.out.println("Already lower case");
		}
		else {
			System.out.println(Character.toLowerCase(character));
		}
	}
	
	public static void isMultipleOfFirst(int num1, int num2) {
		
		if(num2 % num1 == 0) {
			System.out.println("Multiple of the first");
		}else {
			System.out.println("Not a multiple of the first");
		}
		
	}
	
	public static void randNumGenerator() {
		
		Random rand = new Random();
		
		for(int i=0; i<10; i++) {
		int number = rand.nextInt(100)+1;
		System.out.println("Generated "+number);
		}
		
	}
	
	public static void promptCountdown(int num) {
		
		int start = num;
		
		if(start<5 || start > 50) {
			System.out.println("Did not enter a number between 5 and 50");
		} else {
		
		for(int i=num; i>=0; i--) { //outer loop
			System.out.print(i);
			for(int k=1; k<=i; k++) { //inner loop
				System.out.print("*");
			}
			System.out.println();
			
		}
		}
	}
	
	public static void printNumberInWord(int num) {
		
		switch(num) {
		case 1: System.out.println("ONE");
		break;
		case 2: System.out.println("TWO");
		break;
		case 3: System.out.println("THREE");
		break;
		case 4:System.out.println("FOUR");
		break;
		case 5: System.out.println("FIVE");
		break;
		case 6: System.out.println("SIX");
		break;
		case 7: System.out.println("SEVEN");
		break;
		case 8: System.out.println("EIGHT");
		break;
		case 9: System.out.println("NINE");
		break;
		default: System.out.println("ERROR");
		}
		
	}
	
	public static void sumLoop(int finishNum) {
		
		int sum = 0;
		double avg = 0;
		
		for(int i = 0; i<finishNum; i++) {
			sum +=i;
		}
		avg = (double)sum/(double)finishNum;
		System.out.println("Sum is: "+sum);
		System.out.println("Avg is: "+avg);
		
	}
	
	public static void morningAfternoon() {
		
		Calendar cal = Calendar.getInstance();
		
		int timeOfDay = cal.get(Calendar.AM_PM);
		
		switch(timeOfDay) {
		case 0: System.out.println("Good morning");
		break;
		case 1: System.out.println("Good afternoon");
		break;
		default: System.out.println("Error");
		}
		
	}

}
