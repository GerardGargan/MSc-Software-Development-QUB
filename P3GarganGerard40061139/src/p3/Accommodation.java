package p3;

import java.util.Objects;

/**
 * @author GarganGerard - 40061139
 */
public class Accommodation {

	public static final int MIN_STRING_LENGTH = 1;
	public static final int MIN_STARS = 1;
	public static final int MAX_STARS = 5;
	private static final double MIN_PRICE = 0.0;
	private static final int MIN_ROOMS = 0;

	private String name;
	private Type type;
	private int stars;
	private String city;
	private double price;
	private int rooms;

	/**
	 * @param name
	 * @param type
	 * @param stars
	 * @param city
	 * @param price
	 * @param rooms
	 */
	public Accommodation(String name, Type type, int stars, String city, double price, int rooms) {
		setName(name);
		setType(type);
		setStars(stars);
		setCity(city);
		setPrice(price);
		setRooms(rooms);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name, must be at least 1 character in length (non empty)
	 * 
	 * @param name
	 * @throws IllegalArgumentException if less than 1 character long/empty, or is
	 *                                  null
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException("Name cant be null");
		} else if (name.length() < MIN_STRING_LENGTH) {
			throw new IllegalArgumentException("Name must be at least 1 character, non empty");
		} else {
			this.name = name;
		}

	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Set the type (Enum)
	 * 
	 * @param type
	 * @throws IllegalArgumentException if null passed in
	 */
	public void setType(Type type) throws IllegalArgumentException {
		if (type == null) {
			throw new IllegalArgumentException("Type cannot be set to null");
		} else {
			this.type = type;
		}

	}

	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * Sets the star rating, must be between 1 and 5 inclusive
	 * 
	 * @param stars
	 * @throws IllegalArgumentException if outside of the allowed range
	 */
	public void setStars(int stars) throws IllegalArgumentException {
		if (stars < MIN_STARS || stars > MAX_STARS) {
			throw new IllegalArgumentException("Invalid star rating");
		} else {
			this.stars = stars;
		}

	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city (String) - must be at least 1 character long (non empty)
	 * 
	 * @param city
	 * @throws IllegalArgumentException if less than 1 character in length, or null
	 *                                  is passed in
	 */
	public void setCity(String city) throws IllegalArgumentException {
		if (city == null) {
			throw new IllegalArgumentException("City cannot be null");
		} else if (city.length() < MIN_STRING_LENGTH) {
			throw new IllegalArgumentException("City must be at least 1 character, cannot be empty");
		} else {
			this.city = city;
		}

	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets the price (double) - must be a positive number, cannot be <0 and
	 * therefore negative
	 * 
	 * @param price
	 * @throws IllegalArgumentException if a negative number (<0) is passed in
	 */
	public void setPrice(double price) throws IllegalArgumentException {
		if (price < MIN_PRICE) {
			throw new IllegalArgumentException("Price cannot be negative (<0)");
		} else {
			this.price = price;
		}

	}

	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return rooms;
	}

	/**
	 * Sets the number of rooms (int) - must be non negative
	 * 
	 * @param rooms
	 * @throws IllegalArgumentException if a negative number is passed in (<0>
	 */
	public void setRooms(int rooms) throws IllegalArgumentException {
		if (rooms < MIN_ROOMS) {
			throw new IllegalArgumentException("Rooms cannot be a negative number");
		} else {
			this.rooms = rooms;
		}

	}

	/**
	 * Prints a * a set number of times accoridng to the actual star rating. e.g. 3
	 * stars will return ***
	 * 
	 * @return a String with the appropriate number of stars corresponding to the
	 *         star rating
	 */
	private String printStars() {
		StringBuilder starsString = new StringBuilder();

		for (int i = 1; i <= stars; i++) {
			starsString.append("*");
		}

		return starsString.toString();

	}

	/**
	 * Returns a string of the capacity in the below formar
	 * 
	 * @returns a string describing the capacity - N Rooms at £X.XX price
	 */
	private String getCapacity() {
		return String.format("%d Rooms @ %.2f", rooms, price);
	}

	public void printDetails() {
		System.out.printf("%-15s%-15s%n" + "%-15s%-15s%n" + "%-15s%-15s%n" + "%-15s%-15s%n" + "%-15s%-15s%n", "Name",
				name, "City", city, "Type", type, "Capacity", getCapacity(), "Rating", printStars());
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, name, price, rooms, stars, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accommodation other = (Accommodation) obj;
		return Objects.equals(city, other.city) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && rooms == other.rooms
				&& stars == other.stars && type == other.type;
	}

}
