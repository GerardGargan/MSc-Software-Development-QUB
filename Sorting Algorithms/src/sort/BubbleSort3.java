package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort3 {

	public static Random rand = new Random();
	public static int bound = 200;
	public static int length = 15;

	public static void main(String[] args) {

		int[] myNums = new int[length];

		// Assign values
		assignNums(myNums, bound);

		// print unsorted
		System.out.println("Unsorted");
		System.out.println(Arrays.toString(myNums)+"\n");

		//sort array using Bubble sort
		sortArray(myNums);

		//print sorted array
		System.out.println("Sorted using bubble sort:");
		System.out.println(Arrays.toString(myNums));

	}

	/**
	 * Method which sorts the integer values of an array into order, using bubble sort.
	 * @param myNums
	 */
	private static void sortArray(int[] myNums) {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < myNums.length - 1; i++) {
				if (myNums[i] > myNums[i + 1]) {
					swap(i, i + 1, myNums);
					flag = true;
				}
			}
		}

	}

	/**
	 * Method which assigns random numbers to an array. Uses static variables for bound of the random number
	 * @param myNums
	 */
	private static void assignNums(int[] myNums, int boundary) {
		int randNum;
		for (int i = 0; i < myNums.length; i++) {
			randNum = rand.nextInt(boundary) + 1;
			myNums[i] = randNum;
		}

	}

	/**
	 * Method which swaps two values within elements of an array.
	 * Swaps the first parameter with the second, utilising a temporary variable
	 * @param i
	 * @param j
	 * @param myNums
	 */
	private static void swap(int i, int j, int[] myNums) {
		int temp = myNums[i];
		myNums[i] = myNums[j];
		myNums[j] = temp;

	}

}
