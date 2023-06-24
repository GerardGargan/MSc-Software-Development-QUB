package practical6;

public class Part1_1 {

	public static final double RATE = 10.25;

	public static void main(String[] args) {

		int[] hoursWorked = new int[] { 8, 7, 9, 7, 4 };

		int totalHours = totalHours(hoursWorked);
		double totalSalary = salaryCalc(totalHours);
		
		System.out.printf("The total hours worked: %d\nThe total salary: %.2f",totalHours,totalSalary);

	}

	public static int totalHours(int[] hoursWorked) {
		int totalHours = 0;
		for (int i = 0; i < hoursWorked.length; i++) {
			totalHours += hoursWorked[i];
		}
		return totalHours;
	}
	
	public static double salaryCalc(int hoursTotal) {
		double salary;
		salary = hoursTotal*RATE;
		return salary;
	}

}
