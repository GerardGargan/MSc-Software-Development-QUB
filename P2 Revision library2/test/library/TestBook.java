package library;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBook {
	Book book;
	String titleValid, titleInvalid;
	String authorValid, authorInvalid;
	
	String ISBNValid10, ISBNValid13;
	String ISBNInvalidLow, ISBNInvalidMid, ISBNInvalidHigh;
	
	int ratingValidLow, ratingValidMid, ratingValidHigh;
	int ratingInvalidLow, ratingInvalidHigh;
	

	@BeforeEach
	void setUp() throws Exception {
		book = new Book();
		
		titleValid = "x";
		titleInvalid = "";
		
		authorValid = "x";
		authorInvalid = "";
		
		ISBNValid10 = "x".repeat(10);
		ISBNValid13 = "x".repeat(13);
		ISBNInvalidLow = "x".repeat(9);
		ISBNInvalidMid = "x".repeat(11);
		ISBNInvalidHigh = "x".repeat(14);
		
		ratingValidLow = 1;
		ratingValidMid = 3;
		ratingValidHigh = 5;
		ratingInvalidLow = 0;
		ratingInvalidHigh = 6;
	}

	@Test
	void testBook() {
		assertNotNull(book);
		assertEquals("default", book.getAuthor());
		assertEquals("default", book.getTitle());
		assertEquals("default", book.getISBN());
		assertEquals(1, book.getRating());
		
	}

	@Test
	void testBookSConstructorWithArgsValid() {
		Book b = new Book(titleValid, authorValid, ISBNValid10, ratingValidLow);
		assertEquals(authorValid, b.getAuthor());
		assertEquals(titleValid, b.getTitle());
		assertEquals(ISBNValid10, b.getISBN());
		assertEquals(ratingValidLow, b.getRating());
	}
	
	@Test
	void testBookSConstructorWithArgsInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Book(titleInvalid, authorValid, ISBNValid10, ratingValidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Book(titleValid, authorInvalid, ISBNValid10, ratingValidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Book(titleValid, authorValid, ISBNInvalidHigh, ratingValidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Book(titleValid, authorValid, ISBNValid10, ratingInvalidHigh);
		});
	}

	@Test
	void testSetRatingValid() {
		book.setRating(ratingValidLow);
		assertEquals(ratingValidLow, book.getRating());
		
		book.setRating(ratingValidMid);
		assertEquals(ratingValidMid, book.getRating());
		
		book.setRating(ratingValidHigh);
		assertEquals(ratingValidHigh, book.getRating());
	}

	@Test
	void testSetRatingInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			book.setRating(ratingInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			book.setRating(ratingInvalidHigh);
		});
	}
	
	@Test
	void testSetTitleValid() {
		book.setTitle(titleValid);
		assertEquals(titleValid, book.getTitle());
		
	}
	
	@Test
	void testSetTitleInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			book.setTitle(titleInvalid);
		});
	}

	@Test
	void testSetAuthorValid() {
		book.setAuthor(authorValid);
		assertEquals(authorValid, book.getAuthor());
	}
	
	@Test
	void testSetAuthorInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			book.setAuthor(authorInvalid);
		});
	}

	@Test
	void testSetISBNValid() {
		book.setISBN(ISBNValid10);
		assertEquals(ISBNValid10, book.getISBN());
		
		book.setISBN(ISBNValid13);
		assertEquals(ISBNValid13, book.getISBN());
	}
	
	@Test
	void testSetISBNInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			book.setISBN(ISBNInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			book.setISBN(ISBNInvalidMid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			book.setISBN(ISBNInvalidHigh);
		});
		
		
	}

}
