package threadinggame;

public class CountingThread implements Runnable {

	private int num;
	

	@Override
	public void run() {
		num =1;
		while(true) {
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}
	
	public int getCount() {
		return num;
	}
	


}
