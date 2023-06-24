package library;

public class Book {

	public final int TITLE_MIN_LENGTH = 1;
	public final int AUTHOR_MIN_LENGTH = 1;

	public final int MIN_RATING = 1;
	public final int MAX_RATING = 5;
	
	private String title;
	private String author;
	private String ISBN;
	private int rating;

	public Book() {
		title = "default";
		author = "default";
		ISBN = "default";
		rating = 1;
	}

	/**
	 * @param title
	 * @param author
	 * @param iSBN
	 */
	public Book(String title, String author, String iSBN, int rating) {
		setTitle(title);
		setAuthor(author);
		setISBN(iSBN);
		setRating(rating);

	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Set the rating, must be between 1-5 (inclusive)
	 * @param rating
	 * @throws IllegalArgumentException if outside of the allowed range
	 */
	public void setRating(int rating) throws IllegalArgumentException {
		if(rating<MIN_RATING || rating>MAX_RATING) {
			throw new IllegalArgumentException("Rating must be between 1 and 5");
		} else {
		this.rating = rating;
		}
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title
	 * 
	 * @param title
	 * @throws IllegalArgumentException if the title is less than the minimum length
	 *                                  (1)
	 */
	public void setTitle(String title) throws IllegalArgumentException {
		if (title.length() < TITLE_MIN_LENGTH) {
			throw new IllegalArgumentException("Title must be at least 1 character long");
		} else {
			this.title = title;
		}
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set the author, must be at least 1 character long
	 * @param author
	 * @throws IllegalArgumentException if length is less than 1 character
	 */
	public void setAuthor(String author) throws IllegalArgumentException {
		if (author.length() < AUTHOR_MIN_LENGTH) {
			throw new IllegalArgumentException("Author must be at least 1 character long");
		} else {
			this.author = author;
		}
	}

	/**
	 * @return the iSBN
	 */
	public String getISBN() {
		return ISBN;
	}

	/**
	 * Sets the ISBN, must be either 10 or 13 characters long
	 * @param iSBN
	 * @throws IllegalArgumentException if business rule is not met
	 */
	public void setISBN(String iSBN) throws IllegalArgumentException {
		if(iSBN.length()==10 || iSBN.length()==13) {
		ISBN = iSBN;
		} else {
			throw new IllegalArgumentException("ISBN must be 10 or 13 characters");
		}
	}

}
