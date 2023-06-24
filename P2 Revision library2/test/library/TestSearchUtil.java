package library;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSearchUtil {
	
	ArrayList<Book> booklist;
	Book b1,b2,b3,b4,b5;

	@BeforeEach
	void setUp() throws Exception {
		booklist = new ArrayList<Book>();
		
		b1 = new Book("test", "test", "x".repeat(10), 1);
		b2 = new Book("test", "test", "x".repeat(13), 5);
		b3 = new Book("test", "test", "r".repeat(10), 3);
		b4 = new Book("test", "test", "y".repeat(13), 4);
		b5 = new Book("test", "test", "b".repeat(10), 4);
		
		booklist.add(b1);
		booklist.add(b2);
		booklist.add(b3);
		booklist.add(b4);
		booklist.add(b5);
	}

	@Test
	void testSearchByRatingValid() {
		ArrayList<Book> result = SearchUtil.searchByRating(booklist, 1);
		assertTrue(result.size()==1);
		assertTrue(result.contains(b1));
		
		ArrayList<Book> result2 = SearchUtil.searchByRating(booklist, 4);
		assertTrue(result2.size()==2);
		assertTrue(result2.contains(b4));
		assertTrue(result2.contains(b5));
	}
	
	@Test
	void testSearchByRatingInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByRating(booklist, 0);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByRating(booklist, 6);
		});
			
			assertThrows(IllegalArgumentException.class, ()->{
				SearchUtil.searchByRating(null, 2);
			});
		
	}

	@Test
	void testSearchByISBNValid() {
		ArrayList<Book> result = SearchUtil.searchByISBN(booklist, "x".repeat(10));
		assertTrue(result.size()==1);
		assertTrue(result.contains(b1));
	}
	
	@Test
	void testSearchByISBNInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByISBN(booklist, "x".repeat(9));
		});
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByISBN(booklist, "x".repeat(11));
		});
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByISBN(booklist, "x".repeat(12));
		});
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByISBN(booklist, "x".repeat(14));
		});
		assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByISBN(null, "x".repeat(10));
		});
	}

}
