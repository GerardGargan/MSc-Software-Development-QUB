package methods;

public class MethodExample1 {

	public static void main(String[] args) {
		
		invokeMe();

	}
	
	/**
	 * Basic method to print message to screen
	 */
	public static void invokeMe() {
		for(int i = 1; i<5; i++) {
		System.out.println("Invoke me method called -"+i);
		}
	}

}
