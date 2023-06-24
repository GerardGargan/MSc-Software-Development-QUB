package bookcipher;

public class Cipher {

	public static void main(String[] args) {
//		Book cipher is a technique of hiding a message in the text of a book. 
//		Without altering the following 2D array of strings write a program that will extract 
//		the last character in each row to reveal (print it to screen) a hidden message... 
//		the hint on the message is already looking at you !  Print the message in UPPERCASE.
		
		String message[][] = { { "Buzz", "LightYear" ,"was"},
				{"once", "apon", "a"}, { "time","probably" ,"the "},
				{ "coolest", "character", "in", "Toy", "Story 2"},
				{ "but ", "Woody "},{ "was ", "always ", "Andy's " , "wow"},
				{ "toy.", "i"},{ "was", "never", "keen" },
				{ "because ", "I ", "don't "}, { "rate","Tom","Hanks.", "Woody ", "is","quite","dour"},
				{ "but"," Lightyear,", "could fly, sort of...", "Anyhow"},{ "the","movies","are", "classic"}
				};
		
		extractArray(message);

	}
	
	public static void extractArray(String[][] myArray) {
		for(int row=0; row<myArray.length; row++) {
			for(int col=0; col<myArray[row].length; col++) {
				if(col==myArray[row].length-1) {
					System.out.print(myArray[row][col].toUpperCase().charAt(myArray[row][col].length()-1));
				}
			}
		}
		System.out.println();
		//Aidens solution
		
		String word;
		// loop to go through each row in the 2D array
		for (int sentence=0; sentence<myArray.length; sentence++) {
			// get the last string element in the row
			word = myArray[sentence][myArray[sentence].length-1].toUpperCase();
			// output the last character in the string (IN UPPERCASE)
			System.out.print(word.charAt(word.length()-1));
		}
	}
	
	

}
