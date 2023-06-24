package practicals;

public class Part2 {

	public static void main(String[] args) {
		
		//Create the 2D array
		int[][] array2D = new int[4][4];
		
		int value = 2;
		int total = 0;
		int average = 0;
		int numOfElements = 0;
		
		for(int outer=0; outer<array2D.length; outer++) {
			for(int inner=0; inner<array2D[outer].length; inner++) {
				array2D[outer][inner] = value;
				value +=2;
				numOfElements++;
			}
		}
		
		//Display the 2D array
		
		for(int outer=0; outer<array2D.length; outer++) {
			for(int inner=0; inner<array2D[outer].length; inner++) {
				System.out.print(array2D[outer][inner]+"\t");
				total +=array2D[outer][inner];
			}
			System.out.println();
		}
		
		System.out.println("Total sum: "+total);
		System.out.println("Average: "+((double)total/numOfElements));

	}
	
	
	

}
