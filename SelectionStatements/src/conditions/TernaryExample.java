package conditions;

public class TernaryExample {

	public static void main(String[] args) {
		
		String message = "";
		int num1 = 100;
		int num2 = 50;
		
//		if (num1>num2) {
//			message = "First num is biggest";
//		}
//		else {
//			message = "Second num is biggest or they are the same";
//		}
		
		message = (num1>num2) ? "Num1 bigger than num2" : "num 2 bigger than num 1";
		
		System.out.println(message);
		
		int max = (num1 > num2) ? num1 : num2;
		System.out.println("Max is: "+max);

	}

}
