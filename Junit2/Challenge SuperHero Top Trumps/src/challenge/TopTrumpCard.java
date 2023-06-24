package challenge;

import java.util.ArrayList;
import java.util.Collections;

public class TopTrumpCard {

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 30;
	private static final int MIN_IMAGE_LENGTH = 5;
	private static final int MAX_IMAGE_LENGTH = 30;
	private static final int MIN_STAT_SCORE = 0;
	private static final int MAX_STAT_SCORE = 100;

	private String name;
	private String realName;
	private String imageFileName;
	private Category category;
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
	public String getName() throws IllegalArgumentException {

		return name;

	}

	/**
	 * sets the name - length must be between {@value TopTrumpCard#MIN_NAME_LENGTH}
	 * and {@value TopTrumpCard#MAX_NAME_LENGTH} inclusive
	 * 
	 * @param name
	 * @throws IllegalArgumentException if outside of the range
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("name length invalid");
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
	 * Sets the realName, length must be between
	 * {@value TopTrumpCard#MIN_NAME_LENGTH} and
	 * {@value TopTrumpCard#MAX_NAME_LENGTH} inclusive
	 * 
	 * @param realName
	 * @throws IllegalArgumentException
	 */
	public void setRealName(String realName) throws IllegalArgumentException {
		if (realName.length() < MIN_NAME_LENGTH || realName.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("realname length invalid");
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
	 * Sets the image file name, Length must be at least
	 * {@value TopTrumpCard#MIN_IMAGE_LENGTH} characters long, and no longer than
	 * {@value TopTrumpCard#MAX_IMAGE_LENGTH}. The last four characters of string
	 * must equal .jpg The string must not contain any spaces
	 * 
	 * @param imageFileName
	 * @throws IllegalArgumentException if any of the business rules are not met
	 */
	public void setImageFileName(String imageFileName) throws IllegalArgumentException {
		String imageExtension = imageFileName.substring(imageFileName.length() - 4).toLowerCase();
		if (imageFileName.length() < MIN_IMAGE_LENGTH || imageFileName.length() > MAX_IMAGE_LENGTH) {
			throw new IllegalArgumentException("image file name invalid length");
		} else if (!imageExtension.equals(".jpg")) {
			throw new IllegalArgumentException("invalid file extension, must be .jpg");
		} else if (imageFileName.contains(" ")) {
			throw new IllegalArgumentException("image file name cannot contain spaces");
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
	 * Sets the category (enum)
	 * 
	 * @param category
	 * @throws IllegalArgumentException if null
	 */
	public void setCategory(Category category) throws IllegalArgumentException {
		if (category == null) {
			throw new IllegalArgumentException("Category cannot be null");
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
	 * sets the speed - must be between {@value TopTrumpCard#MIN_STAT_SCORE} and
	 * {@value TopTrumpCard#MAX_STAT_SCORE} inclusive.
	 * 
	 * @param speed
	 * @throws IllegalArgumentException if outside of the specified range.
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if (speed < MIN_STAT_SCORE || speed > MAX_STAT_SCORE) {
			throw new IllegalArgumentException("invalid speed");
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
	 * sets the strength - must be between {@value TopTrumpCard#MIN_STAT_SCORE} and
	 * {@value TopTrumpCard#MAX_STAT_SCORE} inclusive.
	 * 
	 * @param strength
	 * @throws IllegalArgumentException if outside of the specified range.
	 */
	public void setStrength(int strength) throws IllegalArgumentException {
		if (strength < MIN_STAT_SCORE || strength > MAX_STAT_SCORE) {
			throw new IllegalArgumentException("invalid strength score");
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
	 * sets the agility - must be between {@value TopTrumpCard#MIN_STAT_SCORE} and
	 * {@value TopTrumpCard#MAX_STAT_SCORE} inclusive.
	 * 
	 * @param agility
	 * @throws IllegalArgumentException if outside of the specified range.
	 */
	public void setAgility(int agility) throws IllegalArgumentException {
		if (agility < MIN_STAT_SCORE || agility > MAX_STAT_SCORE) {
			throw new IllegalArgumentException("invalid agility score");
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
	 * sets the intelligence - must be between {@value TopTrumpCard#MIN_STAT_SCORE}
	 * and {@value TopTrumpCard#MAX_STAT_SCORE} inclusive.
	 * 
	 * @param intelligence
	 * @throws IllegalArgumentException if outside of the specified range.
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {
		if (intelligence < MIN_STAT_SCORE || intelligence > MAX_STAT_SCORE) {
			throw new IllegalArgumentException("invalid intelligence score");
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
	 * 
	 * @param bio
	 * @throws IllegalArgumentException if null
	 */
	public void setBio(String bio) throws IllegalArgumentException {
		if (bio == null) {
			throw new IllegalArgumentException("bio cannot be null");
		} else {
			this.bio = bio;
		}

	}

	/**
	 * @return maximum stat id, 0=speed, 1=strength, 2=agility, 3=intelligence
	 */
	public int getMaxStatID() {
		// return 0,1,2,3 depending on whether speed,strength,agiity or intelligence
		// have the highest value

		if (speed > strength && speed > agility && speed > intelligence) {
			return 0;
		} else if (strength > speed && strength > agility && strength > intelligence) {
			return 1;
		} else if(agility>speed && agility > strength && agility > intelligence) {
			return 2;
		} else if(intelligence>speed && intelligence>strength && intelligence>agility) {
			return 3;
		} else {
			return -1;
		}
	}

	/**
	 * returns the actual value of the corresponding attribute Speed, Strength,
	 * Agility or Intelligence
	 * 
	 * @param statChoice - 0=speed, 1=strength, 2=agility, 3=intelligence
	 * @return
	 * @throws IllegalArgumentException if an invalid statChoice is given
	 */
	public int getStatScore(int statChoice) throws IllegalArgumentException {
		// 0=speed, 1=strength, 2=agility, 3=intelligence
		int result = -1;

		switch (statChoice) {
		case 0:
			result = getSpeed();
			break;
		case 1:
			result = getStrength();
			break;
		case 2:
			result = getAgility();
			break;
		case 3:
			result = getIntelligence();
			break;
		default:
			throw new IllegalArgumentException("invalid choice");
		}

		return result;
	}
	
	public void displayDetails() {
		System.out.printf("Name:%-10s%nReal Name:%-10s%nCategory:%-10s%nSpeed:%-10d%nStrength:%-10s%nAgility:%-10s%n"
				+ "Intelligence%10s%nBio:%10s%n",name,realName,category,speed,strength,agility,intelligence,bio);
	}

}
