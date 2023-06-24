package importingandconditions;

import java.util.Scanner;

public class SquareExampleScanner {

	public static void main(String[] args) {
		
		double sideLength;
		double area;
		double perimiter;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please input the length of the side of the square:");
		sideLength = sc.nextDouble();
		
		area = Math.pow(sideLength, 2);
		perimiter = sideLength*4;
		
		System.out.printf("The area of the square is: %.2f cm^2\n",area);
		System.out.printf("The perimiter of the square is: %.2f cm",perimiter);
		
		sc.close();
	}

}
