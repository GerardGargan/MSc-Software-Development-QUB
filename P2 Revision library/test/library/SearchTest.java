package library;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchTest {
	
	Book b1,b2,b3,b4;
	ArrayList<Book> books;

	@BeforeEach
	void setUp() throws Exception {
		books = new ArrayList<Book>();
		b1 = new Book("x".repeat(10), "author", "title", 1);
		b2 = new Book("x".repeat(13), "author", "title", 1);
		b3 = new Book("x".repeat(13), "jim", "counting", 3);
		b4 = new Book("r".repeat(10), "Arthur", "Guinness", 5);
		
		
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		
	}

	@Test
	void testSearchByRating() {
		ArrayList<Book> result = LibrarySearch.searchByRating(books, 1);
		assertTrue(result.size()==2);
		assertTrue(result.contains(b1));
		assertTrue(result.contains(b2));
	}

	@Test
	void testSearchByISBN() {
		ArrayList<Book> result = LibrarySearch.searchByISBN(books, "r".repeat(10));
		assertTrue(result.size()==1);
		assertTrue(result.contains(b4));
	}

	@Test
	void testSearchByTitle() {
		ArrayList<Book> result = LibrarySearch.searchByTitle(books, "title");
		assertTrue(result.size()==2);
		assertTrue(result.contains(b1));
		assertTrue(result.contains(b2));
	}

	@Test
	void testSearchByAuthor() {
		ArrayList<Book> results = LibrarySearch.searchByAuthor(books, "jim");
		assertTrue(results.size()==1);
		assertTrue(results.contains(b3));
	}

}
