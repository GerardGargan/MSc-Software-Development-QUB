package revision;

import recursiondemos.Factorial;

public class ReverseString2 {

	public static void main(String[] args) {
		String name = "Gerard Gargan";
		
		String reversed = reverseString(name);
		
		System.out.println(reversed);
		
		System.out.println(factorial(5));

	}

	private static String reverseString(String name) {
		if(name.length()<=1) {
			return name;
		} else {
			return reverseString(name.substring(1))+name.charAt(0);
		}

	}
	
	private static int factorial(int num) {
		if(num==1) {
			return num;
		} else {
			return factorial(num-1)*num;
		}
	}
	
	

}
