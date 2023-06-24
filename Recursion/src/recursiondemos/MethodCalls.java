package recursiondemos;

public class MethodCalls {

	public static void main(String[] args) {

		countDown(5);


	
}
	private static void countDown(int num) {
		//base case
		if(num<=0) {
			System.out.println("end");
		} else {
			System.out.println(num);
			countDown(--num);
		}
		
	}
}