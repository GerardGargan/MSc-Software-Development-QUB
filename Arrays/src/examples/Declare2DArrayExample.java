package examples;

import java.util.Arrays;

public class Declare2DArrayExample {

	public static void main(String[] args) {
		
		int[] myList = new int[] {4,6,7,89,12,12};
		
		int[][] my2D = new int[][] {{34,12,10},{1,2,3},{5,8,20},{9,8,7}}; //4 rows
	
	int[][] other2D = new int[4][3];
	other2D[0][0] = 34;
	other2D[0][1] = 12;
	other2D[0][2] = 10;
	other2D[1][0] = 1;
	other2D[3][0] = 9;
	
	print2D(my2D);
	System.out.println(Arrays.toString(myList));

}
	public static void print2D(int[][] myArray) {
		for(int row=0; row<myArray.length; row++) {
			for(int col=0; col<myArray[row].length; col++) {
				System.out.printf("[%d,%d] - %d",row,col,myArray[row][col]);
			}
			System.out.println();
		}
	}
	
}