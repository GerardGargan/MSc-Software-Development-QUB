package carfactory;

public class RallyCar extends Car {
	private double area;

	public RallyCar() {

	}
	
	public RallyCar(String make, String model, int horsePower, double area) {
		super(make, model, horsePower);
		setArea(area);
	}

	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}
	
	public String displayAll() {
		return String.format("Rally Car %nMake: %s%nModel:%s%nHorse Power: %d%nArea: %f%n%n",getMake(),getModel(),getHorsePower(),getArea());
	}

}
