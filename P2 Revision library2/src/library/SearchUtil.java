package library;

import java.util.ArrayList;

public class SearchUtil {

	/**
	 * Search method, searches through a given array list of books for a given
	 * rating match
	 * 
	 * @param booklist - ArrayList<Book>
	 * @param rating   - int (1-5)
	 * @return returns an array list of Books matching the rating passed in
	 * @throws IllegalArgumentException if array list is null, or rating is outside
	 *                                  allowed range
	 */
	public static ArrayList<Book> searchByRating(ArrayList<Book> booklist, int rating) throws IllegalArgumentException {
		if (booklist == null) {
			throw new IllegalArgumentException("Array list cant be null");
		} else if (rating < 1 || rating > 5) {
			throw new IllegalArgumentException("Search criteria must be between 1 and 5");
		} else {
			ArrayList<Book> result = new ArrayList<Book>();

			for (Book b : booklist) {
				if (b.getRating() == rating) {
					result.add(b);
				}
			}

			return result;

		}
	}

	/**
	 * Search a given array list of books for a particular ISBN match (passed in)
	 * @param booklist - ArrayList<Book>
	 * @param isbn - String (10 or 13 chars)
	 * @return ArrayList<Book> of matches
	 * @throws IllegalArgumentException if arraylist is null or isbn is not 10 or 13 characters
	 */
	public static ArrayList<Book> searchByISBN(ArrayList<Book> booklist, String isbn) throws IllegalArgumentException {
		if (booklist == null) {
			throw new IllegalArgumentException("Array list cannot be null");
		} else if (isbn.length()!= 10 && isbn.length() != 13) {
			throw new IllegalArgumentException("ISBN must be 10 or 13 characters long");
		} else {
			ArrayList<Book> result = new ArrayList<Book>();

			for (Book b : booklist) {
				if (b.getISBN().equals(isbn)) {
					result.add(b);
				}
			}

			return result;
		}
	}
}
