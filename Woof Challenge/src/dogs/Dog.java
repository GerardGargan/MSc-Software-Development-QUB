package dogs;

public class Dog {
	private String breed;
	private double weight;
	private double lifeexp;
	private String colour;
	private String country;
	private double height;
	
	
	
	public Dog(String breed, double weight, double lifeexp, String colour, String country, double height) {
		setBreed(breed);
		setWeight(weight);
		setLifeexp(lifeexp);
		setColour(colour);
		setCountry(country);
		setHeight(height);
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
	
	public void displayDogDetail() {
		System.out.printf("%-20s%-20s%n%-20s%-20.2f%n%-20s%-20.2f%n%-20s%-20.2f%n%-20s%-20s%n%-20s%-20s%n","Breed:",breed,"Weight:",weight,"Height:",height,"Life Expectancy:",lifeexp,"Colour:",colour,"Country of origin:", country);
	}

}
