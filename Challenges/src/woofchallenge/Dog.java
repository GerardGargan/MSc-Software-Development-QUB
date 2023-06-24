package woofchallenge;

public class Dog {
	private String breed;
	private double weight;
	private double height;
	private String colour;
	private String country;
	private double lifeExp;
	
	
	
	/**
	 * @param breed
	 * @param weight
	 * @param height
	 * @param colour
	 * @param country
	 */
	public Dog(String breed, double weight, double height, String colour, String country, double lifeExp) {
		setBreed(breed);
		setWeight(weight);
		setHeight(height);
		setColour(colour);
		setCountry(country);
		setLifeExp(lifeExp);
	}
	
	
	
	/**
	 * @return the lifeExp
	 */
	public double getLifeExp() {
		return lifeExp;
	}



	/**
	 * @param lifeExp the lifeExp to set
	 */
	public void setLifeExp(double lifeExp) {
		this.lifeExp = lifeExp;
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
		return String.format("Breed: %s%n"
				+ "Weight: %.2f%n"
				+ "Height: %.2f%n"
				+ "Colour: %s%n"
				+ "Country: %s%n", breed, weight, height, colour, country);
	}
	
	
	
	
}
