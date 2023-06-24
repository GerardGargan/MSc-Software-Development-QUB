package exercises;

import java.util.Scanner;

public class Part3 {

	public static void main(String[] args) {

		int age;
		String name;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your age:");
		age = sc.nextInt();

		if (age > 17) {

			System.out.println("Please enter your name");
			name = sc.next();
			
			System.out.printf("Your name is %s and your age is %d", name, age);

		} else if (age <= 0) {
			System.out.println("Sorry dont recognise your input");
		}

		else {
			System.out.println("Too young to continue");
		}

	}

}
