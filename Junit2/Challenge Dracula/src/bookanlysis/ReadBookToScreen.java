package bookanlysis;

import java.util.Queue;

public class ReadBookToScreen implements Runnable {
	
	public Queue<String> bookText;
	private boolean stopRead;
	
	

	

public void setStopRead(boolean setting) {
	
	this.stopRead = setting;
}

	private void displayTextLineByLine() {
		while(!bookText.isEmpty()) {
			System.out.println(bookText.remove());
			
			if(stopRead) {
				System.out.println("Stopping read to screen..");
				return;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		displayTextLineByLine();
		
	}

}
