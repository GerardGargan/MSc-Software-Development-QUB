package examples;

public class ShoeSizes {

	public static void main(String[] args) {

		int[] shoeSizes = new int[] { 10, 6, 4, 12 };

		System.out.println("Avg before modify array method");
		double avg = arrayAvg(shoeSizes);
		System.out.println(avg);
		modifyArray(shoeSizes);
		System.out.println("Avg after modify array method");
		System.out.println(arrayAvg(shoeSizes));

	}

	public static double arrayAvg(int[] numbers) {

		int total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total += numbers[i];
		}
		double average = (double) total / numbers.length;
		return average;
	}
	
	public static void modifyArray(int[] values) {
		
		for(int i=0; i<values.length; i++) {
			values[i] += 10;
		}
	}

}
