package practicals;

import java.util.Scanner;


public class ForLoopsPractical {

	public static void main(String[] args) {
		
	String name = "";
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Please input your name: ");
	name = sc.nextLine();
	
	for(int i=1; i<=10; i++) {
		
		System.out.println(name);
		
	}

	sc.close();
	}
	

}
