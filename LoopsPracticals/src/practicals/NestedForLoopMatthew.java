package practicals;

public class NestedForLoopMatthew {

	public static void main(String[] args) {

		// Goal - print numbers 1 to 10 in rows with "Row" number of stars in front of
		// each number

		int target = 7;
		int rows = 5;
		for (int i = 1; i <= rows; i++) {

			for (int j = 1; j <= target; j++) {

				// loop to print stars
				for (int k = 1; k <= i; k++) {
					System.out.print("*");
				}
				//Another way instead of the FOR loop above using a function
				//System.out.println("*".repeat(i));

				System.out.print(j + "");
				if (j < target) {
					System.out.print(", ");
				}

			}
			System.out.println();

		}

	}

}
