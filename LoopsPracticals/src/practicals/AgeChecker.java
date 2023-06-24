package practicals;

import java.util.Scanner;

public class AgeChecker {

	public static void main(String[] args) {
		
		// declare the variables
		
		int age;
		
		// prompt the user for age between 1 and 100
		
		Scanner sc = new Scanner(System.in);
		
		do {
			//Prompt the user inside the do loop - will always get asked once minimum
			System.out.println("Please enter your age. Must be between 1 and 100 :");
			age = sc.nextInt();
		
			
		}
		while(age<=0 || age >= 120); // go back into the loop and prompt again if the user does not enter a valid age between 1 and 120
		
		// The rest of the code will only get executed once the loop is exited - therefore a valid age has been input
		
		//Check the age and output the response according to instructions
			if(age>0 && age<31) {
				System.out.println("You are young");
			}
			else if (age >30 && age < 61) {
				System.out.println("You are getting on!");
			}
			else if (age > 60 && age < 120) {
				System.out.println("You look amazing for your age!");
			}
			
		
		
		
		// check range validation between 1 and 120
		
		//if outside prompt the user to check their age input and try again
		
		//loop until the input is within range - ask again
		
		// output a message based on the rules

	}

}
