package threadingstuff;

public class MyRunableThread implements Runnable {

	@Override
	public void run() {
		// put your thread functionality here
		
		System.out.println("My thread "+Thread.currentThread().getName()+" is alive");
		int num = 5;
		try {
			while(num>0) {
			System.out.println(num--);
			Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Still alive and about to terminate");

	}

}
