package shapes;

import java.util.Random;

public class Driver {
	
	public static final int NUMBER_OF_SHAPES = 10;

	public static void main(String[] args) {
		
		IMyShape[] shapes = new IMyShape[NUMBER_OF_SHAPES];
		
		Random rand = new Random();
		int temp = 0;

		for(int i=0; i<NUMBER_OF_SHAPES; i++) {
			temp = rand.nextInt(3);
			
			switch(temp) {
			case 0:
				shapes[i] = new Circle(rand.nextDouble()*rand.nextInt(10));
				break;
			case 1:
				shapes[i] = new Square(rand.nextDouble()*rand.nextInt(10));
				break;
			case 2:
				shapes[i] = new Rectangle(rand.nextDouble()*rand.nextInt(10), rand.nextDouble()*rand.nextInt(10));
				break;
				default: throw new IllegalArgumentException("Hit the default");
			}
			
		}
		
		
		
		for(IMyShape s : shapes) {
			System.out.printf("Shape Name: %s%nShape Area: %.2f%nShape Perimeter: %.2f%n%n",s.getShapeName(),
					s.calculateArea(),s.calculatePerimiter());
			
		}
	}

}
