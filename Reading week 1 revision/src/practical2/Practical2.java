package practical2;

public class Practical2 {

	public static void main(String[] args) {

		// Part 1
		System.out.println("\tHappy Christmas\n");
		System.out.println("\t\t*");
		System.out.println("\t       ***");
		System.out.println("\t      *****");
		System.out.println("\t     *******");
		System.out.println("\t    *********");

		// Part 2
		String name = "Gerard Gargan";

		System.out.println(name);
		System.out.println(name.length());
		System.out.println(name.charAt(0) + "" + name.charAt(1));
		System.out.println(name.toUpperCase());
		System.out.println(name.replace('a', '%'));
		System.out.println(name.indexOf('n'));
		System.out.println();

		// Part 3
		System.out.println(calcAreaSquare(6));
		System.out.printf("%.3f%n", calcAreaCircle(9));

		// part 4
		System.out.println("The biggest number is: "+biggestNum(11, 10));
		
		// part 5
		System.out.println();
		int yearOfBirth, yearWhenITurn21, yearWhenITurn40, yearWhenIRetireAt60;
		yearOfBirth = 1980;
		yearWhenITurn21 = yearOfBirth + 21;
		yearWhenITurn40 = yearOfBirth + 40;
		yearWhenIRetireAt60 = yearOfBirth+60;
		
		System.out.println("Birth: "+yearOfBirth);
		System.out.println("Turn 21: "+yearWhenITurn21);
		System.out.println("Turn 40: "+yearWhenITurn40);
		System.out.println("Retire at 60: "+yearWhenIRetireAt60);
	}

	/**
	 * Calculates the area of a square
	 * 
	 * @param length
	 * @returns the area as an int
	 */
	public static int calcAreaSquare(int length) {
		int area = length * length;

		return area;
	}

	public static double calcAreaCircle(double radius) {
		double area = Math.PI * (radius * radius);

		return area;
	}
	
	public static int biggestNum(int num1, int num2) {
		int biggestNum = num1;
		
		if(num1>num2) {
			biggestNum = num1;
		} else if (num2>num1) {
			biggestNum = num2;
		} 
			
		return biggestNum;
	}

}
