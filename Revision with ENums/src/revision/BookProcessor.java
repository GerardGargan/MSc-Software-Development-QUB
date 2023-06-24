package revision;

import java.util.ArrayList;

public class BookProcessor {

	public static void main(String[] args) {
		Book b1 = new Book("Emma", Genres.CLASSIC, 10.50);
		Book b2 = new Book("4 Davids", Genres.EDUCATION, 5.99);
		Book b3 = new Book("Baking bread", Genres.COOKERY, 7.99);
		Book b4 = new Book("Twilight", Genres.CLASSIC, 6.50);
		Book b5 = new Book("Big book of java", Genres.EDUCATION, 450.99);
		
		System.out.println(b2.getName() + " " + b2.getPrice());
		
		ArrayList<Book> books = new ArrayList<Book>(); 
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		books.add(b5);
		
		
		for(Book b : books) {
			if(b.getGenre()==Genres.CLASSIC) {
			System.out.println(b.getName()+" "+b.getGenre());
			}
		}

	}

}
