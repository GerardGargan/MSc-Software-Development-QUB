package firstcode;

public class ComparisonIfs {

	public static void main(String[] args) {
		
		int num1, num2, num3;
		num1 = 3;
		num2 = 5;
		num3 = 5;
		
		if(num1 < num3) {
			System.out.println("Statement 1 is true");
			num1 = num1 +2;
		}
		
		if(num2 == num1) {
			System.out.println("Statement 2 is true");
		}
		
		String name = "Gerard";
		String otherName = "Gerard";
		
		if(name.equals(otherName)) {
			System.out.println("The names are the same");
		}
		
		if(!name.equals(otherName)) {
			System.out.println("The names are not the same");
		}
		
		System.out.println("End of program");

	}

}
