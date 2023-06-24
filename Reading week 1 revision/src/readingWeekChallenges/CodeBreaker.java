package readingWeekChallenges;

import java.util.Arrays;

public class CodeBreaker {

	public static void main(String[] args) {

		String name;
		name = "Gerard";
		int ascii[];
		ascii = convertToAscii(name);
		System.out.println(Arrays.toString(ascii));
		decodeAscii(ascii);

	}

	public static int[] convertToAscii(String name) {
		int[] ascii = new int[name.length()];

		for(int i=0; i<name.length(); i++) {
			ascii[i] = (int)name.charAt(i);
		}
		return ascii;
		
	}
	
	public static void decodeAscii(int[] asciiArray) {
		for(int i=0; i<asciiArray.length; i++) {
			System.out.print((char)asciiArray[i]);
		}
	}
}
	

