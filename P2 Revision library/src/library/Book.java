package library;

public class Book {
	/**
	 * The book's ISBN
	 */
	private String ISBN;

	/**
	 * The autor of the book
	 */
	private String author;

	/**
	 * The title of the book
	 */
	private String title;

	/**
	 * The rating of the book 1-5
	 */
	private int rating;

	/**
	 * Default constructor
	 */
	public Book() {

	}

	/**
	 * @param iSBN
	 * @param author
	 * @param title
	 * @param rating
	 */
	public Book(String iSBN, String author, String title, int rating) {
		setISBN(iSBN);
		setAuthor(author);
		setTitle(title);
		setRating(rating);
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param set the rating business rules only allow 1-5 Throws an
	 *            IllegalArgumentException if <1 or >5
	 */
	public void setRating(int rating) throws IllegalArgumentException {
		if (rating < 1 || rating > 5) {
			throw new IllegalArgumentException("Invalid rating");
		} else {
			this.rating = rating;
		}
	}

	/**
	 * Gets the ISBN number
	 * 
	 * @return
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Sets the ISBN number
	 * 
	 * @param iSBN 10 or 13 chars
	 * @throws Exception
	 */
	public void setISBN(String iSBN) throws IllegalArgumentException {
		if (iSBN.length() == 10 || iSBN.length() == 13) {
			this.ISBN = iSBN;
		} else {
			throw new IllegalArgumentException("ISBN Must be 10 or 13 characters");
		}

	}

	/**
	 * Get the book's author
	 * 
	 * @return
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the book's author
	 * 
	 * @param author
	 */
	public void setAuthor(String author) throws IllegalArgumentException {
		if (author.length() < 1) {
			throw new IllegalArgumentException("Author must be at least 1 character long");
		} else {
			this.author = author;
		}

	}

	/**
	 * Gets the book's title
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the books title
	 * 
	 * @param title
	 */
	public void setTitle(String title) throws IllegalArgumentException {
		if (title.length() < 1) {
			throw new IllegalArgumentException("Title must be 1 or more characters long");
		} else {
			this.title = title;
		}

	}

}
