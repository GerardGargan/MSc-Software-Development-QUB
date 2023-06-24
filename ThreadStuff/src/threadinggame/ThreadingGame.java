package threadinggame;

import java.util.Scanner;



public class ThreadingGame {

	public static final int COUNT = 10;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Count of "+COUNT+" secs game");
		System.out.println("Press any key and enter to start.. then estimate when "+COUNT+" secs have elapsed");
		
		sc.nextLine();
		System.out.println("Start counting...");
		System.out.println("Hit any key and enter when you think the time is up");
		
		//start thread
		CountingThread ct = new CountingThread();
		Thread th = new Thread(ct);
		th.start();
		
		sc.nextLine();
		
		
		
		if(th.isAlive()) {
			System.out.println("Thread alive");
			if(ct.getCount()<COUNT) {
				System.out.println("Too early: "+ct.getCount());
			} else if(ct.getCount()>COUNT) {
				System.out.println("Too late: "+ct.getCount());
			} else {
				System.out.println("You got it exactly right");
			}
			
			th.interrupt();
			
		} else {
			System.out.println("Way too late, thead was stopped.");
			th.interrupt();
		}
		
		System.out.println("Game over");
	}
	


}
