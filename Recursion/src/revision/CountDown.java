package revision;

public class CountDown {

	public static void main(String[] args) {
		//System.out.println(factorial(3));
		
		System.out.println(reverseSrt("Gerard"));

	}
	
	public static void countDown(int num) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num <= 0) {

		} else {
			System.out.println(num);
			countDown(num -1);
		}
	}
	
	public static int factorial(int num) {

		if(num==1) {
			return 1;
		}
		
		return num * factorial(num-1);
		
	}
	
	public static String reverseSrt(String str) {
		
		System.out.println("In method with "+str);
		
		if(str.length()<2) {
			return str;
		}
		
		return reverseSrt(str.substring(1)) + str.charAt(0);
		
		
	}

	

}
