package amazonbook;

public class Driver {

	public static void main(String[] args) {
		
		AmazonBook book1 = new AmazonBook("The Body: A Guide for Occupants - THE SUNDAY TIMES NO.1 BESTSELLER", "Bill Bryson", 7.99, 464, "English", "0857522418", 4.7);
		AmazonBook book2 = new AmazonBook("Ulysses (Wordsworth Classics)", "James Joyce", 1.49, 736, "English", "1840226358", 4.4);
		
		compareNumPages(book1, book2);
		
		System.out.println(book1.toString());
	}
	
	public static void compareNumPages(AmazonBook book1, AmazonBook book2) {
		int length1, length2;
		length1 = book1.getPages();
		length2 = book2.getPages();
		
		if(length1>length2) {
			System.out.printf("%s has more pages (%d) than %s (%d)",book1.getTitle(), book1.getPages(), book2.getTitle(), book2.getPages());
		} else if(length2>length1) {
			System.out.printf("%s has more pages (%d) than %s (%d)",book2.getTitle(), book2.getPages(), book1.getTitle(), book1.getPages());
		} else {
			System.out.println("Both books have the same number of pages");
		}
	}

}
