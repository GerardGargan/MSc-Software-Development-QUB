package toptrump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TopTrumpCard {

	public static final int MIN_NAME = 1;
	public static final int MAX_NAME = 30;
	public static final int MIN_SCORE = 0;
	public static final int MAX_SCORE = 100;

	private String name;
	private String realName;
	private String image;
	private Category category;
	private int speed;
	private int strength;
	private int agility;
	private int intelligence;
	private String bio;

	/**
	 * @param name
	 * @param realName
	 * @param image
	 * @param category
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 */
	public TopTrumpCard(String name, String realName, String image, Category category, int speed, int strength,
			int agility, int intelligence, String bio) {
		setName(name);
		setRealName(realName);
		setImage(image);
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
	 * Sets the name, length must be between 1-30 inclusve
	 * 
	 * @param name
	 * @throws IllegalArgumentException if length <1 or >30
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Name cannot be null or empty");
		} else if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
			throw new IllegalArgumentException("Name outside of allowed range 1-100 inclusive");
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
	 * Sets the real name, length must be between 1-30 inclusve
	 * 
	 * @param realName
	 * @throws IllegalArgumentException if outside of range
	 */
	public void setRealName(String realName) throws IllegalArgumentException {
		if (realName == null || realName.length() == 0) {
			throw new IllegalArgumentException("Real Name cannot be null or empty");
		} else if (realName.length() < MIN_NAME || realName.length() > MAX_NAME) {
			throw new IllegalArgumentException("realName outside of allowed range 1-100 inclusive");
		} else {
			this.realName = realName;
		}
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image file path. Must be between 5 and 30 chars in length. Must end
	 * with .jpg extension.
	 * 
	 * @param image
	 * @throws IllegalArgumentException if business rules not met, or is null
	 */
	public void setImage(String image) throws IllegalArgumentException {
		if (image == null) {
			throw new IllegalArgumentException("Image cant be null");
		} else if (image.length() < 5 || image.length() > 30) {
			throw new IllegalArgumentException("Image must be between 5 and 30 chars in length");
		} else if (!image.endsWith(".jpg")) {
			throw new IllegalArgumentException("Image extension invalid");
		} else if(image.contains(" ")) {
			throw new IllegalArgumentException("Cannot contain spaces");
		} else {
			this.image = image;
		}

	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * Sets the category
	 * 
	 * @param category throws IllegalArgumentException if null
	 */
	public void setCategory(Category category) throws IllegalArgumentException {
		if (category == null) {
			throw new IllegalArgumentException("Cat cant be null");
		} else {
			this.category = category;
		}

	}

	/**
	 * @return the speed
	 */
	public int getSpeed() throws IllegalArgumentException {
		return speed;
	}

	/**
	 * Sets the speed 0-100
	 * 
	 * @param speed
	 * @throws IllegalArgumentException if outside of bounds 0-100 inclusive
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if (speed < MIN_SCORE || speed > MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score outside of range 1-100");
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
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		if (strength < MIN_SCORE || strength > MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score outside of range 1-100");
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
	 * Sets the agility 0-100
	 * 
	 * @param agility
	 * @throws IllegalArgumentException if out of bounds
	 */
	public void setAgility(int agility) throws IllegalArgumentException {
		if (agility < MIN_SCORE || agility > MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score outside of range 1-100");
		} else {
			this.agility = agility;
		}

	}

	/**
	 * @return the intelligence
	 */
	public int getIntelligence() {
		return intelligence;
	}

	/**
	 * Sets the intelligence 0-100
	 * 
	 * @param intelligence
	 * @throws IllegalArgumentException if out of bounds
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {
		if (intelligence < MIN_SCORE || intelligence > MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score outside of range 1-100");
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
	 * Sets the bio
	 * @param bio
	 * @throws IllegalArgumentException if null
	 */
	public void setBio(String bio) throws IllegalArgumentException {
		if (bio == null) {
			throw new IllegalArgumentException("Bio cant be null");
		} else {
			this.bio = bio;
		}

	}
	
	/**
	 * Calculates the average of the 4 scores - speed, strength, agility & intelligence
	 * @return
	 */
	public double getAvg() {
		
		double total = speed+strength+agility+intelligence;
		double avg = total/4;
		
		return avg;
	}

	@Override
	public String toString() {
//		return "TopTrumpCard [name=" + name + ", realName=" + realName + ", image=" + image + ", category=" + category
//				+ ", speed=" + speed + ", strength=" + strength + ", agility=" + agility + ", intelligence="
//				+ intelligence + ", bio=" + bio + "]";
		return String.format("Name: %s%n"
				+ "Real name: %s%n"
				+ "Image: %s%n"
				+ "Category: %s%n"
				+ "Speed: %d%n"
				+ "Strength: %d%n"
				+ "Agility: %d%n"
				+ "Intelligence: %d%n"
				+ "Bio: %s%n", name,realName,image,category,speed,strength,agility,intelligence,bio);
	}
	
	/**
	 * Returns 0,1,2,3 corresponding to the highest actual value
	 * 0=speed, 1=strength, 2=agility, 3=intelligence
	 * @return
	 */
	public int getMaxStatID() {
		//add to list in order specified
		List<Integer> stats = new ArrayList<Integer>(Arrays.asList(new Integer[]{speed,strength,agility,intelligence}));
		
		//get the index of the max value using the indexOf and max functions
		
		return stats.indexOf(Collections.max(stats));
	}
	
	/**
	 * recieves an input of 0-4. Returns corresponding actual value
	 * 0=speed, 1=strength, 2=agility, 3=intelligence
	 * @param statScore
	 * @return the score
	 */
	public int getStatScore(int statScore){
		int toReturn = -1;
		switch(statScore) {
		case 0: toReturn = getSpeed();
		break;
		case 1: toReturn = getStrength();
		break;
		case 2: toReturn = getAgility();
		break;
		case 3: toReturn = getIntelligence();
		break;
		default: throw new IllegalArgumentException("Invalid parameter, must be between 0-3 inclusive");
		}
		return toReturn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agility, bio, category, image, intelligence, name, realName, speed, strength);
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
				&& Objects.equals(image, other.image) && intelligence == other.intelligence
				&& Objects.equals(name, other.name) && Objects.equals(realName, other.realName) && speed == other.speed
				&& strength == other.strength;
	}

}
