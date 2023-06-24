package practical6;

public class Part2_1 {

	public static void main(String[] args) {
		int twoDeeArray[][] = new int[4][4];
		
		populateArray(twoDeeArray);
		displayArray(twoDeeArray);

	}

	public static void displayArray(int[][] twoDeeArray) {
		int total = 0;
		for(int row=0; row<twoDeeArray.length; row++) {
			for(int col=0; col<twoDeeArray[row].length; col++) {
				System.out.print(twoDeeArray[row][col]+"\t");
				total +=twoDeeArray[row][col];
			}
			System.out.println();
		}
		System.out.println("Total: "+total);
	}

	public static void populateArray(int[][] twoDeeArray) {
		int assign = 2;
		for(int row=0; row<twoDeeArray.length; row++) {
			for(int col=0; col<twoDeeArray[row].length; col++) {
				twoDeeArray[row][col] = assign;
				assign +=2;
			}
		}
		
	}

}
