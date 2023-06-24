package tablet2;

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
			System.out.println("Invalid size, setting to default 0");
			this.size = 0;
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
		if(notes.length()>250) {
			System.out.println("over 250 characters, trunchating..");
			this.notes = notes.substring(0, 250);
		}
		this.notes = notes;
	}
	
	
	public String allDetails() {
		return String.format("Tablet details_____________%nManufacturer: %s%nModel: %s%nPrice: %.2f%nAndroid: %b%nSize: %.1f%nNotes: %s%n%n", 
				getManufacturer(),getModel(),getPrice(),isAndroid(),getSize(),getNotes());
	}
	
	
}
