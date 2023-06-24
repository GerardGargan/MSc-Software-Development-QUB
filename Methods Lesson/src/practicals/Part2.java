package practicals;

import java.util.Random;

public class Part2 {

	public static void main(String[] args) {

		// print the return value of the method
		System.out.println(areaRectangle(10, 2));

		// Print all months to test switch statement
		for (int i = 1; i <= 12; i++) {
			System.out.println(monthName(i));
		}

		System.out.println(avgNum(1, 2, 7));
		
		System.out.println(capitalCity("united states"));
		
		coinToss("HEADS");

	}

	/**
	 * Calculates the area of a rectangle
	 * 
	 * @param height
	 * @param base
	 * @return the area of the rectangle as an integer
	 */
	public static int areaRectangle(int height, int base) {

		// calculate the area using the arguments passed in
		int area = height * base;

		// return the area
		return area;
	}

	/**
	 * Method which returns the name of the month of a string from an integer input
	 * (1-12)
	 * 
	 * @param month
	 * @return the name of the month as a string
	 */
	public static String monthName(int month) {

		String monthName = "Default";

		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "Feburary";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
			break;
		default:
			monthName = "ERROR";
		}
		return monthName;

	}

	/**
	 * Calculate the average of three integers
	 * 
	 * @param num1
	 * @param num2
	 * @param num3
	 * @returns the average as a double
	 */
	public static double avgNum(int num1, int num2, int num3) {

		int sum = num1 + num2 + num3;
		double average = (double) sum / 3;

		return average;
	}
	
	
	/**
	 * Takes the country name as a string and returns the capital of the country
	 * @param country
	 * @return the capital city of the country as a string
	 */
	public static String capitalCity(String country) {
		
		String capital = "Default";
		String countryLower = country.toLowerCase();
		
		switch(countryLower) {
		
		case "france":
			capital = "Paris";
			break;
		case "germany":
			capital = "Berlin";
			break;
		case "italy":
			capital = "Rome";
			break;
		case "japan":
			capital = "Tokyo";
			break;
		case "russia":
			capital = "Moscow";
			break;
		case "united kingdom":
			capital = "London";
			break;
		case "united states":
			capital = "Washington";
		break;
		default:
			capital = "Something has gone wrong";
		
		}
		
		return capital;
		
	}
	
	public static void coinToss(String userInput) {
		
		String userInputLC = userInput.toLowerCase();
		int call = 0;
		int result = 0;
		Random rand = new Random();
		int randToss = rand.nextInt(2);
		
		
		switch(userInputLC) {
		
		case "heads":
			call = 0;
			break;
		case "tails":
			call = 1;
			break;
			default:
				call = -1;
		}
		
	System.out.println("Your guess was: "+userInput);
		if(randToss==0) {
			System.out.println("Coin toss: Heads ");
		}else {
			System.out.println("Coin toss: Tails ");
		}
		
		if(call==randToss) {
			System.out.println("You win");
		} else {
			System.out.println("You lose");
		}
		
		
	}

}
