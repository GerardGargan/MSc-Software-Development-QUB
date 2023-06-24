package revision;

public class FactorialRecursion {

	public static void main(String[] args) {
		int factorial = factorialOf(4);
		System.out.println(factorial);
	}

	private static int factorialOf(int num) {
		if(num==1) {
			return 1;
		} else {
			return num * factorialOf(num-1);
		}
		
	}

}
