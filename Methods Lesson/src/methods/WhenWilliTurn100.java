package methods;

public class WhenWilliTurn100 {

	public static void main(String[] args) {
		
		oneHundred();
		oneHundredParamater(40);
		

	}
	
	//Method without parameter
	public static void oneHundred() {
		
		int currentAge = 30;
		int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		int yearTurning100 = 0;
		
		yearTurning100 = 100 - currentAge + currentYear;
		
		System.out.println("You will turn 100 in "+yearTurning100);
		
		
		
	}
	
	//Method with parameter
	public static void oneHundredParamater(int age) {
		
		int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
		int yearTurning100 = 0;
		
		yearTurning100 = 100 - age + currentYear;
		
		System.out.println("You will be 100 in the year: "+yearTurning100);
		
	}

}
