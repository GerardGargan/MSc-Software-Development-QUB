package practicals;

public class Part1Q8 {

	public static void main(String[] args) {
		
		int[] assignment1 = new int[] {24,42,29,66,77};
		int[] assignment2 = new int[] {79,68,31,22,42};
		
		avgAss(assignment1,assignment2);

	}
	
	public static int totalMarks(int[] results) {
		int total = 0;
		for(int i=0; i<results.length; i++) {
			total += results[i];
		}
		
		return total;
	}
	
	public static void avgAss(int[] assign1, int[] assign2) {
		double aver1 = (double)totalMarks(assign1)/assign1.length;
		double aver2 = (double)totalMarks(assign2)/assign2.length;
		double overallAvg = (aver1+aver2)/2;
		
		System.out.printf("Overall average: %.1f%n",overallAvg);
		System.out.println("Assignment 1 average: "+aver1);
		System.out.println("Assignment 2 average: "+aver2);
		
		if(aver1>aver2) {
			System.out.println("Assignment 1 had the highest average");
		} else if(aver2>aver1) {
			System.out.println("Assignment 2 had the highest average");
		} else {
			System.out.println("Both assignments had the same average");
		}
		
	}

}
