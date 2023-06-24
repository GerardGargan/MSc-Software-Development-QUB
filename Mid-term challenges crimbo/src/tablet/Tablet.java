package tablet;

public class Tablet {
	private String manufacturer;
	private String model;
	private double price;
	private boolean android;
	private double size;
	private String notes;
	/**
	 * @param manufacturer
	 * @param model
	 * @param price
	 * @param android
	 * @param size
	 * @param notes
	 */
	public Tablet(String manufacturer, String model, double price, boolean android, double size, String notes) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.price = price;
		this.android = android;
		setSize(size);
		setNotes(notes);
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
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
	 * @return the android
	 */
	public boolean isAndroid() {
		return android;
	}
	/**
	 * @param android the android to set
	 */
	public void setAndroid(boolean android) {
		this.android = android;
	}
	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		if(size>5 && size<21) {
		this.size = size;
		} else {
			System.out.println("Size outside limits, setting to default -1");
			this.size = -1;
		}
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		if(notes.length()<250) {
		this.notes = notes;
		} else {
			System.out.println("Notes cannot be longer than 250 characters. Truncating to 250 chars.");
			this.notes = notes.substring(0, 250);
		}
	}
	
	public void allDetails() {
		System.out.printf("Tablet details ____________%nManufacturer: %s%nModel: %s%nPrice: %.2f%nAndroid: %b%nSize: %.1f%nNotes: %s%n%n",getManufacturer(),getModel(),getPrice(),isAndroid(),getSize(),getNotes());
	}
	@Override
	public String toString() {
		return "Tablet [manufacturer=" + manufacturer + ", model=" + model + ", price=" + price + ", android=" + android
				+ ", size=" + size + ", notes=" + notes + "]";
	}
	
	
}
