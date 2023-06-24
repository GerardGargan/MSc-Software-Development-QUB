package revision;

public class Book {
	private String name;
	private Genres genre;
	private double price;

	/**
	 * @param name
	 * @param genre
	 * @param price
	 */
	public Book(String name, Genres genre, double price) {
		setName(name);
		setGenre(genre);
		setPrice(price);
	}

	/**
	 * @param name
	 * @param genre
	 * @param price
	 */

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param validates and sets name field
	 * if invalid, overrides with default value
	 */
	public void setName(String name) {
		if(name != null && name.length()>1) {
			this.name = name;
			
		} else {
			System.err.println("Name must not be empty, setting to default (INVALID NAME)");
			this.name = "INVALID NAME";
		}
	}

	/**
	 * @return the genre
	 */
	public Genres getGenre() {
		return genre;
	}

	/**
	 * @param genre2 the genre to set
	 */
	public void setGenre(Genres genre2) {
		this.genre = genre2;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param set the price, if negative error message and override to 0
	 */
	public void setPrice(double price) {
		if (price < 0) {
			System.err.println("Price cannot be negative, setting to default (0)");
			this.price = 0;
		} else {
			this.price = price;
		}
	}

}
