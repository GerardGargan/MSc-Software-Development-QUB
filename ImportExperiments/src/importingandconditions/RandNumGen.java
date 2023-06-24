package importingandconditions;

import java.util.Scanner;
import java.util.Random;

public class RandNumGen {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		int choice = rand.nextInt(10)+1;
		System.out.println(choice);

	}

}
