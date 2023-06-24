package importingandconditions;

import java.util.Scanner;

public class ImportExercise {


	public static void main(String[] args) {
		
		int age;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input your age: ");
		age = sc.nextInt();
		
		if(age>=18) {
		System.out.println("Old enough to vote");
		}
		else {
			System.out.println("Not old enough to vote");
		}
		
		sc.close();
	
		
	}

}
