package practicals;

public class Part1Q9 {

	public static void main(String[] args) {

		String quote[] = new String[] {"Continuous","effort", "not", "strength", "nor", "intelligence", "is", "the", "key", "for", "unlocking", "our", "potential"};

		displayArray(quote);
		countWords(quote);
		countLetters(quote);
		smallestWord(quote);
		biggestWord(quote);
			
	}
	
	public static void displayArray(String[] myArray) {
		for(int i=0; i<myArray.length; i++) {
			System.out.print(myArray[i]+" ");
		}
		System.out.println();
	}
	
	public static void countWords(String[] myArray) {
		int total = 0;
		for(int i=0; i<myArray.length; i++) {
			total ++;
		}
		System.out.println("Total number of words: "+total);
	}
	
	public static void countLetters(String[] myArray) {
		int totalLetters = 0;
		
		for(int i=0; i<myArray.length; i++) {
			for(int j=0; j<myArray[i].length(); j++) {
				totalLetters ++;
			}
			
		}
		System.out.println("Total number of letters: "+totalLetters);
	}
	
	
	public static void smallestWord(String[] myArray) {
		int smallestWordLength = myArray[0].length();
		String smallestWord = myArray[0];
		
		for(int i=0; i<myArray.length; i++) {
			if(myArray[i].length()<smallestWordLength) {
				smallestWordLength = myArray[i].length();
				smallestWord = myArray[i];
			}
		}
		System.out.println("The smallest word was: "+smallestWord);
	}
	
	public static void biggestWord(String[] myArray) {
		int biggestWordCount = myArray[0].length();
		String biggestWord = myArray[0];
		
		for(int i=0; i<myArray.length; i++) {
			if(myArray[i].length()>biggestWordCount) {
				biggestWordCount = myArray[i].length();
				biggestWord = myArray[i];
			}
		}
		System.out.println("Biggest word was: "+biggestWord);
	}

}
