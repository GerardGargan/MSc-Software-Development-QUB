package practicals;

import java.util.Scanner;

public class Part1Q5v2 {

	public static void main(String[] args) {
		
		String userName;
		int totalVowels =0;
		int A = 0;
		int E = 0;
		int I = 0;
		int O = 0;
		int U = 0;
				
		
		//prompt user to enter name
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter your name: ");
		userName = scan.nextLine();
		//loop through and assign each value to a char array
		char[] nameChar = new char[userName.length()];
		
		for(int i=0; i<userName.length(); i++) {
			nameChar[i] = userName.charAt(i);
		}
		
		for(int i=0; i<nameChar.length; i++) {
			
			System.out.print(nameChar[i]);
			switch(nameChar[i]) {
			case 'A':
			case 'a':
				totalVowels++;
				A++;
				break;
			case 'E':
			case 'e':
				totalVowels++;
				E++;
				break;
			case 'I':
			case 'i':
				totalVowels++;
				I++;
				break;
			case 'O':
			case 'o':
				totalVowels++;
				O++;
				break;
			case 'U':
			case 'u':
				totalVowels++;
				U++;
				break;
			}
			
		}
		
		System.out.printf("%nThere were %d vowels total, A: %d, E: %d, I: %d, O: %d, U: %d",totalVowels,A,E,I,O,U);
		//count the occurences of vowels (lower and upper case)
		//total number of vowels calculated
		
		scan.close();
	}
	

}
