package practical5;

import java.util.Random;
import java.util.Scanner;

public class Part2 {
	
	public static Scanner scan = new Scanner(System.in);
	public static Random rand= new Random();

	public static void main(String[] args) {
		
		System.out.println(rectangleArea(10, 10));
		
		for(int i=1; i<=12; i++) {
		System.out.println(nameOfMonth(i));
		}
		
		System.out.println(avg(4,5,4));
		
		coinToss();
			
		

	}
	
	public static void coinToss() {
		String userGuess;
		int coinToss;
		
		coinToss = rand.nextInt(2);
		System.out.println("Please guess Heads or Tails");
		userGuess = scan.nextLine();
		//heads is 0, tails is 1
		
		if(userGuess.equalsIgnoreCase("heads") && coinToss==0) {
			System.out.println("Correct! It was heads");
		} else if(userGuess.equalsIgnoreCase("tails") && coinToss==1) {
			System.out.println("Correct it was tails!");
		} else if(userGuess.equalsIgnoreCase("heads") && coinToss==1) {
			System.out.println("Wrong, it was tails");
		} else if(userGuess.equalsIgnoreCase("tails") && coinToss==0) {
			System.out.println("Wrong, it was heads");
		}
		System.out.println("coinToss: "+coinToss);
		System.out.println("User Guess: "+userGuess);
		
	}

	public static double avg(int num1, int num2, int num3) {
		int total;
		double result;
		
		total = num1 + num2 + num3;
		result = (double)total/3;
		
		return result;
		
	}
	
	public static double rectangleArea(double height, double base) {
		double area;
		area = height*base;
		return area;
	}
	
	public static String nameOfMonth(int month) {
		String nameMonth = "Default";
		
		switch(month){
		case 1:
			nameMonth = "January";
			break;
		case 2:
			nameMonth = "Feburary";
			break;
		case 3:
			nameMonth = "March";
			break;
		case 4:
			nameMonth = "April";
			break;
		case 5:
			nameMonth = "May";
			break;
		case 6:
			nameMonth = "June";
			break;
		case 7:
			nameMonth = "July";
			break;
		case 8:
			nameMonth = "August";
			break;
		case 9:
			nameMonth = "September";
			break;
		case 10:
			nameMonth = "October";
			break;
		case 11:
			nameMonth = "November";
			break;
		case 12:
			nameMonth = "December";
			break;
			default:
				System.out.println("Invalid month! Value must be between 1-12");
		}
		return nameMonth;
	}

}
