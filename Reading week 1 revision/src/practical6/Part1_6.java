package practical6;

public class Part1_6 {

	public static void main(String[] args) {
		
		//numbersEven();
		numbersEven2(33,100);
	}

	public static void numbersEven2(int start, int finish) {
		int arrayLength = ((finish-start))/2;
		int[] evenNums = new int[arrayLength+1];
		int arrayIndex =0;
		int total=0;
		
		for(int i=start; i<=finish; i++) {
			if(i%2==0) {
				evenNums[arrayIndex] = i;
				arrayIndex++;
			}
		}
		
		for(int j : evenNums) {
			total +=j;
			System.out.println(j);
		}
		
		System.out.println("Total: "+total);
		
	}

	public static void numbersEven() {
		int[] evenNums = new int[50];
		int nextFreeElement=0;
		int total = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				evenNums[nextFreeElement] = i;
				nextFreeElement++;
			}
			
		}
		
		for(int j : evenNums) {
			total +=j;
			System.out.println(j);
		}
		
		System.out.println("Total :"+total);
	}

}
