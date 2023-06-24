package library;

import java.util.ArrayList;

public class LibrarySearch {

	public static ArrayList<Book> searchByRating(ArrayList<Book> allBooks, int rating) {

		ArrayList<Book> results = new ArrayList<Book>();
		for (Book books : allBooks) {
			if (books.getRating() == rating) {
				results.add(books);
			}
		}

		return results;
	}

	public static ArrayList<Book> searchByISBN(ArrayList<Book> allBooks, String ISBN) {
		ArrayList<Book> results = new ArrayList<Book>();

		for (int i = 0; i < allBooks.size(); i++) {
			if (allBooks.get(i).getISBN().equals(ISBN)) {
				results.add(allBooks.get(i));
			}
		}

		return results;
	}

	/**
	 * Search by title
	 * 
	 * @param title - String
	 * @return ArrayList of found books matching search criteria
	 */
	public static ArrayList<Book> searchByTitle(ArrayList<Book> allBooks, String title) {
		ArrayList<Book> results = new ArrayList<Book>();
		for (int loop = 0; loop < allBooks.size(); loop++) {
			if (allBooks.get(loop).getTitle().equals(title)) {
				// add book to search
				results.add(allBooks.get(loop));
			}
		}
		return results;
	}

	/**
	 * Search by Author
	 * 
	 * @param author - string
	 * @return ArrayList of found books matching search criteria
	 */
	public static ArrayList<Book> searchByAuthor(ArrayList<Book> allBooks, String author) {
		ArrayList<Book> results = new ArrayList<Book>();

		for (int loop = 0; loop < allBooks.size(); loop++) {
			if (allBooks.get(loop).getAuthor().equals(author)) {
				// add book to search
				results.add(allBooks.get(loop));
			}
		}
		return results;
	}

}
