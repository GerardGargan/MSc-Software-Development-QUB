package threadingame2;

import java.util.Scanner;

public class Driver {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Count of 30 secs game");
		System.out.println("Press any key and enter to start.. then estimate when 30 secs have elapsed");

		CountDown timer = new CountDown();
		Thread th = new Thread(timer);
		
		String userInput = sc.next();
		th.start();
		
		userInput = sc.next();
		th.interrupt();
		
		
	}

}
