package pizzashop;

public class MenuItem implements IDetail {

	private String name;
	private double price;

	/**
	 * @param name
	 * @param price
	 */
	public MenuItem(String name) {
		setName(name);
	}
	
	public MenuItem(String name, double price) {
		setName(name);
		setPrice(price);
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Name cannot be set to null, or cannot be 0 in length");
		} else {
			this.name = name;
		}
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
		if (price < 0) {
			throw new IllegalArgumentException("Price cannot be negative");
		} else {
			this.price = price;
		}
	}

	@Override
	public void printDetails() {
		System.out.printf("%s\t%.2f%n",name,price);

	}

}
