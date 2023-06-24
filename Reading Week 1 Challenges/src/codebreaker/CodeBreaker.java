package codebreaker;

import java.util.Arrays;

public class CodeBreaker {

	public static void main(String[] args) {
		

		
		String name = "Gerard Gargan";
		int[] coded = asciiCode(name);
		System.out.println(Arrays.toString(coded));
		asciiDecode(coded);
		
		

	}
	
	/**
	 * Decodes an array of integer values into their respective ASCII character
	 * @param charArray
	 */
	public static void asciiDecode(int[] charArray) {
		
		for(int i=0; i<charArray.length; i++) {
			char character = (char)charArray[i];
			System.out.print(character);
		}
		
	}

	/**
	 * Codes a string into an array of characters & returns the ASCII integer value for each character in the string
	 * @param nameInput
	 * @return
	 */
	public static int[] asciiCode(String nameInput) {
		int[] coded = new int[nameInput.length()];
		for(int i=0; i<nameInput.length(); i++) {
			coded[i] = (int)nameInput.charAt(i);
		}
		return coded;
	}

}
