package first;

public class ReverseString {

	public static void main(String[] args) {
		String palindrome = "Dot saw I was Tod";
		int length = palindrome.length();
		char[] tempCharArray = new char[length];
		char[] charArray = new char[length];
		
		for(int i=0; i<length; i++) {
			//assign each char to temp char array
			tempCharArray[i] = palindrome.charAt(i);
		}
		
		int position = length-1;
		for(int j=0; j<length; j++) {
			charArray[j] = tempCharArray[position];
			position--;
		}
		
		System.out.println(charArray);

	}

}
