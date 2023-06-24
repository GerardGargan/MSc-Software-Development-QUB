package revision2;

public class ReverseString {

	public static void main(String[] args) {
		String reversed = reverseStr("Gerard Gargan");
		System.out.println(reversed);

	}

	private static String reverseStr(String string) {
		
		if(string.length()<=1) {
			return string;
		} else {
			return reverseStr(string.substring(1))+string.charAt(0);
		}
		
		
	}

}
