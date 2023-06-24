package importingandconditions;

public class IfElseExercise1 {

	public static void main(String[] args) {
		
		int age;
		boolean goodCreditHistory;
		
		age = 18;
		goodCreditHistory = true;
		
		if(age >= 18 && goodCreditHistory) {
		System.out.println("Successful");
		}
		else {
			System.out.println("Not successful - due to credit history or age");
		}

	}

}
