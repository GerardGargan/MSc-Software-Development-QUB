package importingandconditions;

import java.util.Random;


public class RandomNumberGenerator {

	public static void main(String[] args) {
		
		int randomInt;
		
		System.out.println("Generating 5 random numbers in the range from 0 to 99...");
		
		Random randomGenerator = new Random();
		
		for(int i = 1; i<=5; i++) {
			
			randomInt = randomGenerator.nextInt(100);
			System.out.println("Random number: "+randomInt);
			
		}
		
		System.out.println("End of program");

	}

}
