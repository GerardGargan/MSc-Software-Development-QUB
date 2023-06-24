package recursiondemos;

public class FunWithStrings {
	public static void main(String[] args) {
		String name = "aidan";
		String fiipped = reverseString(name);
		System.out.println(fiipped);

		System.out.println("Rec version " + reverseRecursive(name));
	}

	//reverse a string with recursion
	private static String reverseRecursive(String str) {
		
		System.out.println("In method with "+str);
		
		if(str.length()<=1) {
			System.out.println("base case reached");
			System.out.println("returning "+str);
			return str;
		} 
			//take the head off
			//move it to the end
			//reverse the rest (the tail)
			String result = reverseRecursive(str.substring(1))+str.charAt(0);
			
			System.out.println("Returning "+result);
		return result;
	}

	// reversing a string with a loop approach
	private static String reverseString(String str) {

		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}

		return result;
	}

}
