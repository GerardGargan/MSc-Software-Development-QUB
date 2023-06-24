package whale;

public class Whale extends Animal {
	private String mainOcean;
	private int weight;
	private int maxSpeed;
	private int length;
	
	public Whale() {
		
	}
	
	public Whale(String name, String mainOcean, int weight, int maxSpeed, int length) {
		super(name);
		setMainOcean(mainOcean);
		setWeight(weight);
		setMaxSpeed(maxSpeed);
		setLength(length);	
	}

	/**
	 * @return the mainOcean
	 */
	public String getMainOcean() {
		return mainOcean;
	}

	/**
	 * @param mainOcean the mainOcean to set
	 */
	public void setMainOcean(String mainOcean) {
		this.mainOcean = mainOcean;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the maxSpeed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	public String toString() {
		
		return String.format("Name: %s, Main ocean: %s, Weight (Tonnes) %d, Max Speed: %d, Length (Meters): %d", getName(),getMainOcean(),getWeight(),getMaxSpeed(),getLength());
	}
}
