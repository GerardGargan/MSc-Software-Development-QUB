package threadingstuff;

public class NumberedThread implements Runnable {
	
	private int num;
	
	public NumberedThread(int num) {
		this.num = num;
	}

	@Override
	public void run() {
		System.out.println("Thread "+num+" started");
		System.out.println("Thread "+num+" ending");
		
	}

}
