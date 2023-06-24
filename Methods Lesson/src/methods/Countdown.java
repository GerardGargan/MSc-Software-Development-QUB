package methods;

public class Countdown {

	public static void main(String[] args) {
		
		countdownMethod(10);

	}
	
	public static void countdownMethod(int start) {
		
		for(int i=start; i>=0; i--) {
			
			System.out.println(i);
			
		}
		
	}

}
