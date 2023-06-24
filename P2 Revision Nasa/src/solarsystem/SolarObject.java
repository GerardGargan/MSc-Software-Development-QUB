package solarsystem;

public abstract class SolarObject {
	private String name;
	private double distanceFromSun;

	public SolarObject() {

	}

	public SolarObject(String name, double distanceFromSun) {
		setName(name);
		setDistanceFromSun(distanceFromSun);
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
	public void setName(String name) throws IllegalArgumentException {
		if (name.length() < 1) {
			throw new IllegalArgumentException("Name must be at least 1 character long");
		} else {
			this.name = name;
		}
	}

	/**
	 * @return the distanceFromSun
	 */
	public double getDistanceFromSun() {

		return distanceFromSun;

	}

	/**
	 * @param distanceFromSun the distanceFromSun to set
	 */
	public void setDistanceFromSun(double distanceFromSun) throws IllegalArgumentException {
		if(distanceFromSun<0) { 
			throw new IllegalArgumentException("Distance cant be negative");
		} else {
		this.distanceFromSun = distanceFromSun;
	}
	}

	/**
	 * @param name
	 * @param distanceFromSun
	 */

	public void printDetails() {
		System.out.println("Name: " + name);
		System.out.println("Distance from sum: " + distanceFromSun);
	}

}
