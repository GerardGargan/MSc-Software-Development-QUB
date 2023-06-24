package importingandconditions;

public class IfElseIfExercise2 {

	public static void main(String[] args) {
		
		int monthOfYear = 20;
		
		if(monthOfYear==1 || (monthOfYear>=9 && monthOfYear<=12)) {
			System.out.println("Semester 1");
		}
		else if (monthOfYear>=2 && monthOfYear<=5) {
			System.out.println("Semester 2");
		}
		else if(monthOfYear >=6 && monthOfYear<=8) {
			System.out.println("Semester 3");
		}
		else {
			System.out.println("Enter a valid number");
		}

	}

}
