package practical6;

public class Test {
	
	//testing a method which prints AND returns a value and how it behaves

	public static void main(String[] args) {

		int num1, num2, result;
		num1 = 10;
		num2 = 20;
		
		result = maxNum(num1,num2);
		System.out.println(result);
		
	}

	private static int maxNum(int num1, int num2) {
		int result = num1;
		
		if(num1>num2) {
			result = num1;
		} else if(num2>num1) {
			result = num2;
		}
		
		System.out.println("Max is: "+result);
		return result;
		
	}

}
