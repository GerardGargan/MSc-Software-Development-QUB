package practicals;

public class Part1Q7 {

	public static void main(String[] args) {
		
		int testArray[] = new int[] {1,2,3,4,5};
		displayArray(testArray);

	}
	
	public static void displayArray(int[] myArray) {
		for(int i=0; i<myArray.length; i++) {
			System.out.println(myArray[i]);
		}
	}

}
