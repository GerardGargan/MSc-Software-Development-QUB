package arrays2D;

public class TwoDeeArray {

	public static void main(String[] args) {
		
		int[][] grid = new int[3][4];
		
		displayArray(grid);
		
		}

	public static void displayArray(int[][] grid) {

		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[i].length; j++) {
				System.out.print("grid["+i+","+j+"] ");
			}
			System.out.println();
			
		
	}

}
}
