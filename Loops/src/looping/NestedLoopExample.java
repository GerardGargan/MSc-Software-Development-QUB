package looping;

public class NestedLoopExample {

	public static void main(String[] args) {
		
		int count=1;
		
		for(int row=1; row<=2; row++) {
			for(int col = 1; col<=3; col++) {
				System.out.print("["+row+"]"+"["+col+"]");
				
			}
			System.out.println(); //take a new line for each row (outer loop);
		}
	}

}
