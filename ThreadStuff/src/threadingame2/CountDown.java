package threadingame2;

public class CountDown implements Runnable {
	private int seconds;
	private int userGuess;

	public CountDown() {
		seconds = 0;
	}

	/**
	 * @return the userGuess
	 */
	public int getUserGuess() {
		return userGuess;
	}

	/**
	 * @param userGuess the userGuess to set
	 */
	public void setUserGuess(int userGuess) {
		this.userGuess = userGuess;
	}

	@Override
	public void run() {
		System.out.println("Count started..");
		System.out.println("Hiy any key and enter when you think time is up");
		
		while(true) {
			try {
				Thread.sleep(1000);
				seconds++;
				
			} catch (InterruptedException e) {
				if(seconds>userGuess) {
					System.out.println("Too early "+seconds);
				} else if(seconds<userGuess) {
					System.out.println("Too Late "+seconds);
				} else {
					System.out.println("WINNER "+seconds);
				}
			}
			
			
				
			
		}
	}

}
