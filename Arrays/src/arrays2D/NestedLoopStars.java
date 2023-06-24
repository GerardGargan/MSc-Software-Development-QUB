package arrays2D;

//revision for nested loops, no arrays yet

public class NestedLoopStars {

	public static void main(String[] args) {
		
		int rows=30;
		int cols=50;
		
		for (int i=1; i<=rows; i++) {
			
			for (int j=1; j<=cols; j++) {
				System.out.print("*");
			} //end of inner loop
			System.out.println();
		}//end of outer loop

	}

}
