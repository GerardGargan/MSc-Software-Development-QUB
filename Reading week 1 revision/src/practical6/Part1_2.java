package practical6;

public class Part1_2 {

	public static void main(String[] args) {
		double[] temps = new double[] {3.4,4.2,9.0,2.2,4.5,6.4,3.1};
		double average;
		
		average = avgDoubles(temps);
		System.out.printf("The average temp was: %.2f",average);
	}
	
	public static double avgDoubles(double[] input) {
		double total = 0;
		double average;
		
		for(int i=0; i<input.length; i++) {
			total += input[i];
		}
		average = total/input.length;
		return average;
	}

}
