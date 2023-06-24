package practicals;

public class Part1Q6 {

	public static void main(String[] args) {

		createArrayEvenNumbers();

	}

	/**
	 * Creates an array of all of the even numbers between 0 and 100 Prints the
	 * total of the array values by adding them up
	 */
	public static void createArrayEvenNumbers() {

		int[] evens = new int[50];
		int nextFreeIndex = 0;
		int total = 0;

		// Assign values to array (even numbers only)
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				// number is even, add to array
				evens[nextFreeIndex] = i;
				nextFreeIndex++;
			}
		}

		for (int j : evens) {
			total += j;
		}

		System.out.println("The total is " + total);

	}

}
