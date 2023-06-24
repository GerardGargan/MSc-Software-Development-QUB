package threadingstuff;

public class MultipleThreadsExample {

	public static void main(String[] args) {

		for(int i=1; i<=10; i++) {
			
			NumberedThread numT = new NumberedThread(i);
			Thread thread = new Thread(numT);
			thread.start();
		}

	}

}
