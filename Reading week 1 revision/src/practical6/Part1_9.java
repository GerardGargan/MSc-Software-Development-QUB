package practical6;

public class Part1_9 {

	public static void main(String[] args) {
		String[] quote = new String[] {"Continuous","effort","not","strength","nor","intelligence","is","the","key","for","unlocking","our","potential"};
		
		outputArray(quote);
		countWords(quote);
		countLetters(quote);
		smallestWord(quote);
		biggestWord(quote);
	}

	public static void biggestWord(String[] quote) {
		String biggestWord;
		biggestWord = quote[0];
		
		for(int i=0; i<quote.length; i++) {
			if(quote[i].length()>biggestWord.length()) {
				biggestWord = quote[i];
			}
		}
		System.out.println("Biggest word: "+biggestWord);
		
	}

	public static void smallestWord(String[] quote) {
		String smallestWord = quote[0];
		for(int i=0; i<quote.length; i++) {
			if(quote[i].length()<smallestWord.length()) {
				smallestWord = quote[i];
			}
		}
		System.out.println("Smallest word: "+smallestWord);
		
	}

	public static void countLetters(String[] quote) {
		int total = 0;
		for(int i=0; i<quote.length; i++) {
			total += quote[i].length();
			}
		System.out.println("Total letters: "+total);
		
	}

	public static void countWords(String[] quote) {
		System.out.println("Number of words: "+quote.length);
		
	}

	public static void outputArray(String[] quote) {
		for(int i=0; i<quote.length; i++) {
			System.out.print(quote[i]+" ");
		}
		System.out.println();
		
	}

}
