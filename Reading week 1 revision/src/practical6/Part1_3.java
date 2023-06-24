package practical6;

public class Part1_3 {

	public static void main(String[] args) {
		
		double heights[] = new double[] {1.4,1.9,1.31,1.2};
		double average, tallest, smallest;
		average = averageHeight(heights);
		tallest = tallest(heights);
		smallest = smallest(heights);
		
		System.out.printf("The average height is: %.2f. The tallest is %.2f, the smallest is %.2f",average,tallest,smallest);

	}

	public static double tallest(double[] heightsArray) {
		double tallest = heightsArray[0];
		for(int i=0; i<heightsArray.length; i++) {
			if(heightsArray[i]>tallest) {
				tallest = heightsArray[i];
			}
		}
		return tallest;
	}
	
	public static double smallest(double[] heightsArray) {
		double smallest = heightsArray[0];
		for(int i=0; i<heightsArray.length; i++) {
			if(heightsArray[i]<smallest) {
				smallest = heightsArray[i];
			}
		}
		return smallest;
	}

	public static double averageHeight(double[] heights) {
		double total = 0;
		double average;
		
		for(int i=0; i<heights.length; i++) {
			total +=heights[i];
		}
		average = total/heights.length;
		return average;
	}

}
