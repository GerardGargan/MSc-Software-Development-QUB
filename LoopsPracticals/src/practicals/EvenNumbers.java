package practicals;

public class EvenNumbers {

	public static void main(String[] args) {
		
		//Output only the even numbers between 1 and 100
		
		for(int i = 1; i<=100; i++) {
			
			if((i%2==0)) {
				System.out.print(i+", ");
			}
			
		} //End of for loop
		
		//take a new line
		System.out.println();
		
		//Output the odd numbers between 10 and 40
		
		for(int b=10; (b>=10) && (b<=40); b++) {
			
			if(b%2!=0) {
				System.out.print(b+", ");
			}
			
		}
		

	} //End of main method

} //end of class
