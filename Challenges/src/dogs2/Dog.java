package dogs2;

public class Dog {
	private String breed;
	private double weight;
	private double height;
	private double lifeexp;
	private String colour;
	private String country;
	
	
	/**
	 * @param breed
	 * @param weight
	 * @param height
	 * @param lifeexp
	 * @param colour
	 * @param country
	 */
	public Dog(String breed, double weight, double height, double lifeexp, String colour, String country) {
		this.breed = breed;
		this.weight = weight;
		this.height = height;
		this.lifeexp = lifeexp;
		this.colour = colour;
		this.country = country;
	}
	/**
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * @param breed the breed to set
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the lifeexp
	 */
	public double getLifeexp() {
		return lifeexp;
	}
	/**
	 * @param lifeexp the lifeexp to set
	 */
	public void setLifeexp(double lifeexp) {
		this.lifeexp = lifeexp;
	}
	/**
	 * @return the colour
	 */
	public String getColour() {
		return colour;
	}
	/**
	 * @param colour the colour to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return String.format("%-30s%-10.2f%-10.2f%-20.2f%-30s%-20s", breed,height,weight,lifeexp,colour,country);
	}
	
	
	
	
}
