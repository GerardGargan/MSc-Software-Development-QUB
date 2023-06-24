package recursiondemos;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(10));

	}

	private static int factorial(int num) {
		// base case
		if (num == 1) {
			return 1;
		} else {
			// recursive step
			return num * factorial(num - 1);
		}
	}

}
