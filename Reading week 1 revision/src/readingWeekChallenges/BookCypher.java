package readingWeekChallenges;

public class BookCypher {

	public static void main(String[] args) {
		// 2D array of strings with hidden message
		String message[][] = { { "Buzz", "LightYear" ,"was"},
		{"once", "apon", "a"}, { "time","probably" ,"the "},
		{ "coolest", "character", "in", "Toy", "Story 2"},
		{ "but ", "Woody "},{ "was ", "always ", "Andy's " , "wow"},
		{ "toy.", "i"},{ "was", "never", "keen" },
		{ "because ", "I ", "don't "}, { "rate","Tom","Hanks.", "Woody ", "is","quite","dour"},
		{ "but"," Lightyear,", "could fly, sort of...", "Anyhow"},{ "the","movies","are", "classic"}
		};
		
		String word;
		for(int row=0; row<message.length; row++) {
			word = message[row][message[row].length-1].toUpperCase();
			System.out.print(word.charAt(word.length()-1));
		}

	}

}
