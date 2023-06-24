package amazonbook;

public class AmazonBook {
	private String title;
	private String author;
	private double price;
	private int pages;
	private String language;
	private String ISBN10;
	private double custRank;
	
	public AmazonBook() {
		
	}
	
	public AmazonBook(String title, String author, double price, int pages, String language, String ISBN10, double custRank) {
		setTitle(title);
		setAuthor(author);
		setPrice(price);
		setPages(pages);
		setLanguage(language);
		setISBN10(ISBN10);
		setCustRank(custRank);
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the pages
	 */
	public int getPages() {
		return pages;
	}
	/**
	 * @param pages the pages to set
	 */
	public void setPages(int pages) {
		this.pages = pages;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the iSBN10
	 */
	public String getISBN10() {
		return ISBN10;
	}
	/**
	 * @param iSBN10 the iSBN10 to set
	 */
	public void setISBN10(String iSBN10) {
		ISBN10 = iSBN10;
	}
	/**
	 * @return the custRank
	 */
	public double getCustRank() {
		return custRank;
	}
	@Override
	public String toString() {
		return "AmazonBook [title=" + title + ", author=" + author + ", price=" + price + ", pages=" + pages
				+ ", language=" + language + ", ISBN10=" + ISBN10 + ", custRank=" + custRank + "]";
	}

	/**
	 * @param custRank the custRank to set
	 */
	public void setCustRank(double custRank) {
		this.custRank = custRank;
	}
	
	
}
