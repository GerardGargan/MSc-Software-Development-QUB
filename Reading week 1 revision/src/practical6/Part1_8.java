package practical6;

public class Part1_8 {

	public static void main(String[] args) {
		int[] assign1 = new int[] { 24, 42, 29, 66, 77 };
		int[] assign2 = new int[] { 79, 68, 31, 22, 42 };
		
		assignAnalyser(assign1, assign2);
	}

	public static int sumArray(int[] myNums) {
		int sum = 0;
		for (int i = 0; i < myNums.length; i++) {
			sum += myNums[i];
		}
		return sum;
	}

	public static void assignAnalyser(int[] myArray1, int[] myArray2) {

		double average1, average2, totalAvg;
		average1 = (double) sumArray(myArray1) / myArray1.length;
		average2 = (double) sumArray(myArray2) / myArray2.length;
		totalAvg = (average1 + average2) / 2;
		
		System.out.println("Average mark assignment 1: "+average1);
		System.out.println("Average mark assignment 2: "+average2);
		System.out.println("Average mark both assignments: "+totalAvg);
		System.out.println();

		if (average1 > average2) {
			System.out.println("Assignment 1 had the highest average");
		} else if (average2 > average1) {
			System.out.println("Assignment 2 had the highest average");
		} else {
			System.out.println("Both assignments had the same average");
		}

	}

}
