package carfactory;

public class Car {

	private String make;
	private String model;
	private int horsePower;
	
	public Car() {
		
	}
	
	public Car(String make, String model, int horsePower) {
		setMake(make);
		setModel(model);
		setHorsePower(horsePower);
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
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
	 * @return the horsePower
	 */
	public int getHorsePower() {
		return horsePower;
	}

	/**
	 * @param horsePower the horsePower to set
	 */
	public void setHorsePower(int horsePower) {
		if(horsePower>=0 && horsePower<=1000) {
		this.horsePower = horsePower;
		} else {
			this.horsePower = -999;
			System.out.println("Invalid horsepower, setting to -999");
		}
	}
	
	public String displayAll() {
		return String.format("Make: %s%n Model: %s%n Horsepower: %d%n", getMake(),getModel(),getHorsePower());
	}
}
