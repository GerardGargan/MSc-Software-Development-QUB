package examples;

public class DynamicPop {

	public static void main(String[] args) {

		int[] numbers = new int[5];
		
		int val = 0;
		
		for(int i=0; i<numbers.length; i++) {
			numbers[i]=val;
			val+=2;
		}
		
		for (int i=0; i<numbers.length; i++) {
			System.out.printf("%d \t %d\n",i, numbers[i]);
		}
		System.out.println();
		
		for(int i = numbers.length-1; i>=0; i--) {
			System.out.printf("%d \t %d\n",i, numbers[i]);
		}

	}

}
