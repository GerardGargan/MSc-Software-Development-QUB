package importingandconditions;

public class ifElseExercise3 {

	public static void main(String[] args) {

		int num1, num2;
		
		num1 = 3;
		num2 = 2;
		
		if(num1>num2) {
			System.out.println(num1+" is bigger than "+num2);
		}
		else if (num2>num1){
			System.out.println(num2+" is bigger than "+num1);
		}
		else if(num1==num2){
			System.out.println(num1+" is the same as "+num2);
		}
		
		System.out.println(num1>num2 ? "num1 is greater than num2" : "num2 is greater than num1");

	}

}
