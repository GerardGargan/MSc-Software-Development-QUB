package library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

	Book book;
	String ISBNValidLow, ISBNValidHigh, ISBNInvalidLow, ISBNInvalidMid, ISBNInvalidHigh;
	String authorValid, authorInvalid;
	String titleValid, titleInvalid;
	int ratingValidLow, ratingValidMid, ratingValidHigh, ratingInvalidLow, ratingInvalidHigh;

	@BeforeEach
	void setUp() throws Exception {
		book = new Book();
		ISBNValidLow = "x".repeat(10);
		ISBNValidHigh = "x".repeat(13);
		ISBNInvalidLow = "x".repeat(9);
		ISBNInvalidMid = "x".repeat(11);
		ISBNInvalidHigh = "x".repeat(14);

		authorValid = "Author";
		authorInvalid = "";

		titleValid = "Title";
		titleInvalid = "";

		ratingValidLow = 1;
		ratingValidMid = 3;
		ratingValidHigh = 5;
		ratingInvalidLow = 0;
		ratingInvalidHigh = 6;

	}

	@Test
	void testBook() {
		assertNotNull(book);
	}

	@Test
	void testBookConstrValid() {
		Book b1 = new Book(ISBNValidHigh, authorValid, titleValid, ratingValidHigh);

		assertEquals(ISBNValidHigh, b1.getISBN());
		assertEquals(authorValid, b1.getAuthor());
		assertEquals(titleValid, b1.getTitle());
		assertEquals(ratingValidHigh, b1.getRating());
	}

	@Test
	void testBookConstrInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Book(ISBNInvalidHigh, authorValid, titleValid, ratingValidHigh);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Book(ISBNValidHigh, authorInvalid, titleValid, ratingValidHigh);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Book(ISBNValidHigh, authorValid, titleInvalid, ratingValidHigh);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Book(ISBNValidHigh, authorValid, titleValid, ratingInvalidHigh);

		});
	}

	@Test
	void testSetGetRatingValid() {
		book.setRating(ratingValidLow);
		assertEquals(ratingValidLow, book.getRating());

		book.setRating(ratingValidMid);
		assertEquals(ratingValidMid, book.getRating());

		book.setRating(ratingValidHigh);
		assertEquals(ratingValidHigh, book.getRating());
	}

	@Test
	void testSetGetRatingInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			book.setRating(ratingInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			book.setRating(ratingInvalidHigh);
		});
	}

	@Test
	void testSetGetISBNValid() {
		book.setISBN(ISBNValidLow);
		assertEquals(ISBNValidLow, book.getISBN());

		book.setISBN(ISBNValidHigh);
		assertEquals(ISBNValidHigh, book.getISBN());
	}

	@Test
	void testSetGetISBNInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			book.setISBN(ISBNInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			book.setISBN(ISBNInvalidHigh);
		});
	}

	@Test
	void testSetAuthorValid() {
		book.setAuthor(authorValid);
		assertEquals(authorValid, book.getAuthor());
	}

	@Test
	void testSetAuthorInValid() {
		assertThrows(IllegalArgumentException.class, () -> {
			book.setAuthor(authorInvalid);
		});
	}

	@Test
	void testSetGetTitleValid() {
		book.setTitle(titleValid);
		assertEquals(titleValid, book.getTitle());
	}

	@Test
	void testSetGetTitleInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			book.setTitle(titleInvalid);
		});

	}

}
