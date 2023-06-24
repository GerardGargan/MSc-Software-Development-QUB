package practical4;

import java.util.Scanner;

public class Part3_10 {

	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int userAge;
		// prompt user age
		// check user age range
		
		do {
		userAge = getUserAge();
		if (userAgeCheckRange(userAge) == true) {
			displayMessage(userAge);
		} else {
			System.out.println("Invalid age, try again");
		}
		} while(userAgeCheckRange(userAge)==false);

		scan.close();
	}

	public static void displayMessage(int userAge) {
		if(userAge>=1 && userAge<=30) {
			System.out.println("You are young");
		} else if(userAge>=31 && userAge<=60) {
			System.out.println("You are getting on!");
		} else if(userAge>=61 && userAge<=120) {
			System.out.println("You look amazing for your age!");
		}
		
	}

	public static boolean userAgeCheckRange(int userAge) {

		boolean rangeOk = false;

		if (userAge <= 0 || userAge > 120) {
			rangeOk = false;
		} else {
			rangeOk = true;
		}

		return rangeOk;

	}

	public static int getUserAge() {
		int age;
		System.out.println("Please enter your age");
		age = scan.nextInt();
		scan.nextLine();
		return age;
	}

}
