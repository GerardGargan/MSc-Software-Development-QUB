package practical6;

import java.util.Scanner;

public class Part1_5 {

	public static void main(String[] args) {
		String userName;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please input your first name");
		userName = scan.next();
		
		printVowels(userName);
		scan.close();
	}

	public static void printVowels(String userName) {
		char letters[] = new char[userName.length()];
		int countVowelTotal, countA, countE, countI, countO, countU;
		countVowelTotal = 0;
		countA = 0;
		countE=0;
		countI=0;
		countO=0;
		countU=0;
		
		for(int i=0; i<userName.length(); i++) {
			letters[i] = userName.charAt(i);
		}
		
		for(int j=0; j<letters.length; j++) {
			switch(Character.toLowerCase(letters[j])) {
			case 'a':
				countVowelTotal++;
				countA++;
				break;
			case 'e':
				countVowelTotal++;
				countE++;
				break;
			case 'i':
				countVowelTotal++;
				countI++;
				break;
			case 'o':
				countVowelTotal++;
				countO++;
				break;
			case 'u':
				countVowelTotal++;
				countU++;
				break;
			}
		}
		
		System.out.printf("Hi %s, your name contains a total of %d vowels. A:%d, E:%d, I:%d, O:%d, U:%d",userName, countVowelTotal, countA, countE, countI, countO, countU);
		
		
	}

}
