package threadingstuff;

public class Starter {

	public static void main(String[] args) {

		System.out.println("in main, start");
		
		MyRunableThread myThread = new MyRunableThread();
		Thread userThread = new Thread(myThread, "My thread name");
		
		userThread.start();
		
		
		try {
			System.out.println("Main sleeping");
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("in main, end");

	}

}
