package practicals;

public class Part1 {
	
	public static final double HOURLY_RATE_OF_PAY = 11.50;

	public static void main(String[] args) {

		int[] hoursInput = { 8,7,9,7,4,6 };
		hoursAndWages(hoursInput);
		
		double[] tempInput = { 3.4, 4.2, 9.0, 2.2, 4.5, 6.4, 3.1 };
		avgTemp(tempInput);
		double[] height = {1.4,1.9,1.31,1.2};
		calcHeights(height );
	} //end of main method
	
	//start of static methods
	
	/**
	 * Takes a list of hours and outputs the weekly hours worked, total hours worked and the total salary for the week
	 * @param hours
	 */
	public static void hoursAndWages(int[] hours) {
		int totalHours =0;
		double salary;
		
		for(int i=0; i<hours.length; i++) {
			totalHours +=hours[i];
			System.out.println("Number of hours worked on day: "+i+" Hours: "+hours[i]);
		} //end of for loop
		
		salary = totalHours*HOURLY_RATE_OF_PAY;
		
		System.out.println("Total hours worked this week: "+totalHours);
		System.out.println("Total salary for the week: "+salary);
		
	} //end of method
	
	/**
	 * Works out the average temperature of an array of temperatures inputed.
	 * Works out the minimum and maximum values of the temperature and prints to screen.
	 * The output is a double rounded to 1 decimal place
	 * @param temp
	 */
	public static void avgTemp(double[] temp) {
		
		double total = 0;
		double average;
		double min = temp[0];
		double max = temp[0];
		
		for(int i=0; i<temp.length; i++) {
			total += temp[i];
			
			//if the current value of temp in the loop is smaller than the minimum value, reassign it to the current value which is smaller.
			if(temp[i]<min) {
				min = temp[i];
			}
			//if the current value of temp in the loop is bigger than the minimum value, reassign it to the current value which is bigger.
			if(temp[i]>max) {
				max = temp[i];
			}
			
		}
		
		average = total / (temp.length);
		System.out.printf("The average temperature was: %.1f%n",average);
		System.out.printf("The minimum temperature was %.1f and the maximum temperature was %.1f\n",min,max);
		
	}
	
	/**
	 * Receives an array of persons heights, calculates the average, min and max height and prints this to screen
	 * @param height
	 */
	public static void calcHeights(double[] height) {
		
		double total = 0;
		double average = 0;
		double maxHeight = height[0];
		double minHeight = height[0];
		
		for(int i=0; i<height.length; i++) {
			total +=height[i];
			
			if(height[i]<minHeight) {
				minHeight = height[i];
			}
			
			if(height[i]>maxHeight) {
				maxHeight = height[i];
			}
			
		}
		average = total/height.length;
		
		System.out.printf("The average height is: %.2f\nThe min height is %.2f\nThe max height is %.2f\n",average, minHeight, maxHeight);
		
		
	}

}
