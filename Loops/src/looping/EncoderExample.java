package looping;

import java.util.Scanner;

public class EncoderExample {

	public static void main(String[] args) {

		String name;
		Scanner sc = new Scanner(System.in);

		System.out.println("Please input your name: ");
		name = sc.nextLine();

		for (int i = 0; i < name.length(); i++) {

			if (name.charAt(i) == ' ') {
				System.out.print(" ");
			} else {
				System.out.print("*");
			}
			
			sc.close();

		}

	}

}
