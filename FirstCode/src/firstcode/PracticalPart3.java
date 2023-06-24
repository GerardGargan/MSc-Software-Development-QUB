package firstcode;

public class PracticalPart3 {

	public static void main(String[] args) {
		int squareSide = 6;
		int area = squareSide*squareSide;
		System.out.println("The area of the square is: "+area);
		
		double radius;
		radius = 9;
		double pie = 3.142;
		double circleArea = pie*(radius*radius);
		System.out.printf("The area of the circle is: %.2f\n",circleArea);
		
		int number1;
		int number2;
		
		number1 = 44;
		number2 = 10;
		
		if(number1>number2) {
			System.out.println("The biggest value is: "+number1);
		}
		else {
			System.out.println("The biggest value is: "+number2);
		}
		
		
		int yearOfBirth;
		int yearWhenITurn21;
		int yearWhenITurn40;
		int yearWhenIRetireAt60;
		
		yearOfBirth = 1980;
		yearWhenITurn21 = yearOfBirth+21;
		yearWhenITurn40 = yearOfBirth+40;
		yearWhenIRetireAt60 = yearOfBirth + 60;
		
		System.out.println("\nBirth: "+yearOfBirth);
		System.out.println("Turn 21: "+yearWhenITurn21);
		System.out.println("Turn 40: "+yearWhenITurn40);
		System.out.println("Reture: "+yearWhenIRetireAt60);

	}

}
