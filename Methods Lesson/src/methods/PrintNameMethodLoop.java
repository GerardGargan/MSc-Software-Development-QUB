package methods;

public class PrintNameMethodLoop {

	public static void main(String[] args) {
		
		printNameLoop(10, "Gerard");

	}
	
	public static void printNameLoop(int loop, String name) {
		
		for(int i=0; i<loop; i++) {
			
			System.out.println(name);
			
		}
		
	}

}
