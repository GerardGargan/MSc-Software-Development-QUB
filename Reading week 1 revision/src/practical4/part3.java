package practical4;

import java.util.Scanner;

public class part3 {
	
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		String userName;
		System.out.println("Enter name");
		userName = scan.nextLine();
		
		printUserName10(userName);

	}

	private static void printUserName10(String userName) {
		for(int i=0; i<10; i++) {
			System.out.println(userName);
		}
		
	}
	
	

}
