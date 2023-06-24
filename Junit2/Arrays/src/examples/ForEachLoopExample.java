package examples;

public class ForEachLoopExample {

	public static void main(String[] args) {

		int[] nums = new int[] {5,8,9,10,3};
		int sum = 0;
		
		for(int number : nums) {
			System.out.println("Adding 10 to "+number);
			number +=10;
			
		}
		
		
		
		for(int a : nums) {
			System.out.println(a);
			
			sum+=a;
		}
		
		System.out.println("Final total: "+sum);

	}

}
