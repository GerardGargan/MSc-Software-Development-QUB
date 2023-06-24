package toptrump;

import java.util.Objects;

public class TopTrumpCard {

	public static final int MIN_NAME = 1;
	public static final int MAX_NAME = 30;
	public static final int MIN_SCORE = 0;
	public static final int MAX_SCORE = 100;

	private String name;
	private String realName;
	private String imageFileName;
	public Category category;
	private int speed;
	private int strength;
	private int agility;
	private int intelligence;
	private String bio;

	/**
	 * @param name
	 * @param realName
	 * @param imageFileName
	 * @param category
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 */
	public TopTrumpCard(String name, String realName, String imageFileName, Category category, int speed, int strength,
			int agility, int intelligence, String bio) {
		setName(name);
		setRealName(realName);
		setImageFileName(imageFileName);
		setCategory(category);
		setSpeed(speed);
		setStrength(strength);
		setAgility(agility);
		setIntelligence(intelligence);
		setBio(bio);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set, must be between 1 and 30 characters inclusive
	 * 
	 */
	public void setName(String name) {
		if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
			throw new IllegalArgumentException("Name out of bounds");
		} else {
			this.name = name;
		}
	}

	/**
	 * @return the realName
	 */
	public String getRealName() {

		return realName;
	}

	/**
	 * @param realName the realName to set, throws IllegalArgumentException
	 */
	public void setRealName(String realName) {
		if (realName.length() < MIN_NAME || realName.length() > MAX_NAME) {
			throw new IllegalArgumentException("Real Name out of bounds");
		} else {
			this.realName = realName;
		}
	}

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {

		return imageFileName;
	}

	/**
	 * Sets the image file name, must be between 5 and 30 chars long inclusive
	 * 
	 * @param imageFileName
	 * @throws IllegalArgumentException if outside of range, or string doesnt end
	 *                                  with .jpg
	 */
	public void setImageFileName(String imageFileName) throws IllegalArgumentException {
		if (imageFileName.length() < 5 || imageFileName.length() > 30) {
			throw new IllegalArgumentException("File length out of bounds");
		} else if (!imageFileName.endsWith(".jpg")) {
			throw new IllegalArgumentException("File name must end with .jpg");
		} else {
			this.imageFileName = imageFileName;
		}
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Set the category
	 * 
	 * @param category
	 * @throws IllegalArgumentException if set to null
	 */
	public void setCategory(Category category) throws IllegalArgumentException {
		if (category == null) {
			throw new IllegalArgumentException("Category cant be set to null");
		} else {
			this.category = category;
		}

	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed, 1-100
	 * 
	 * @param speed
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if (speed < MIN_SCORE || speed > MAX_SCORE) {
			throw new IllegalArgumentException("Speed must be between 1 and 100");
		} else {
			this.speed = speed;
		}

	}

	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Sets the strength, 1-100
	 * 
	 * @param strength
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setStrength(int strength) throws IllegalArgumentException {
		if (strength < MIN_SCORE || strength > MAX_SCORE) {
			throw new IllegalArgumentException("Strength must be between 1-100");
		} else {
			this.strength = strength;
		}

	}

	/**
	 * @return the agility
	 */
	public int getAgility() {
		return agility;
	}

	/**
	 * Sets the agility, 1-100
	 * 
	 * @param agility
	 * @throws IllegalArgumentException if outside of the range
	 */
	public void setAgility(int agility) throws IllegalArgumentException {
		if (agility < MIN_SCORE || agility > MAX_SCORE) {
			throw new IllegalArgumentException();
		}
		this.agility = agility;
	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * Sets the intelligence, 1-100
	 * 
	 * @param intelligence
	 * @throws IllegalArgumentException if outside of this range
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {
		if (intelligence < MIN_SCORE || intelligence > MAX_SCORE) {
			throw new IllegalArgumentException("intelligence outside of range");
		} else {
			this.intelligence = intelligence;
		}

	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * Set the bio
	 * @param bio
	 * @throws IllegalArgumentException if set to null
	 */
	public void setBio(String bio) throws IllegalArgumentException {
		if (bio == null) {
			throw new IllegalArgumentException("Bio cant be null");
		} else {
			this.bio = bio;
		}
	}
	
	public double getAvg() {
		double total = speed + strength + agility + intelligence;
		double avg = total/4;
		return avg;
	}
	
	/**
	 * returns the element with the maximum score
	 * 0=speed, 1=strength, 2=agility, 3=intelligence
	 * @return
	 */
	public int getMaxStatID() {
		//							0		1		2		3
		int[] scores = new int[] {speed,strength,agility,intelligence};
		
		int biggest = scores[0];
		int biggestIndex = 0;
		for(int i=0; i<scores.length; i++) {
			if(scores[i]>biggest) {
				biggest = scores[i];
				biggestIndex = i;
			}
		}
		
		return biggestIndex;
	}
	
	/**
	 * taken an input int and returns the correponding score
	 * 0=speed, 1=strength, 2=agility, 3=intelligence
	 * @param num
	 * @return
	 * @throws IllegalArgumentException if an invalid param is passed in (<0 or >3)
	 */
	public int getStatScore(int num) throws IllegalArgumentException {
		int toReturn = 0;
		
		switch(num) {
		case 0: toReturn = speed;
		break;
		case 1: toReturn = strength;
		break;
		case 2: toReturn = agility;
		break;
		case 3: toReturn = intelligence;
		break;
		default: throw new IllegalArgumentException("invalid param");
		}
		
		return toReturn;
	}
	
	public void printCardDetails() {
		System.out.printf("Name: %s%n"
				+ "Real Name: %s%n"
				+ "File Name: %s%n"
				+ "Category: %s%n"
				+ "Speed: %d%n"
				+ "Strength: %d%n"
				+ "Agility: %d%n"
				+ "Intelligence: %d%n"
				+ "Bio: %s%n",name, realName, imageFileName, category, speed, strength, agility, intelligence, bio);
	}

	@Override
	public int hashCode() {
		return Objects.hash(agility, bio, category, imageFileName, intelligence, name, realName, speed, strength);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopTrumpCard other = (TopTrumpCard) obj;
		return agility == other.agility && Objects.equals(bio, other.bio) && category == other.category
				&& Objects.equals(imageFileName, other.imageFileName) && intelligence == other.intelligence
				&& Objects.equals(name, other.name) && Objects.equals(realName, other.realName) && speed == other.speed
				&& strength == other.strength;
	}

}
