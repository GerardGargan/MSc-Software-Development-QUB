package toptrump;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TopTrumpCard implements Comparable<TopTrumpCard> {

	public static final int MIN_NAME = 1;
	public static final int MAX_NAME = 30;

	public static final int MIN_IMAGE = 5;
	public static final int MAX_IMAGE = 30;

	public static final int MIN_SCORE = 0;
	public static final int MAX_SCORE = 100;

	private String name;
	private String realName;
	private Category category;
	private String image;
	private int speed;
	private int strength;
	private int agility;
	private int intelligence;
	private String bio;

	/**
	 * @param name
	 * @param realName
	 * @param category
	 * @param speed
	 * @param strength
	 * @param agility
	 * @param intelligence
	 * @param bio
	 */
	public TopTrumpCard(String name, String realName, Category category, String image, int speed, int strength, int agility,
			int intelligence, String bio) {
		setName(name);
		setRealName(realName);
		setCategory(category);
		setSpeed(speed);
		setStrength(strength);
		setAgility(agility);
		setIntelligence(intelligence);
		setBio(bio);
		setImage(image);
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		if(image.length()<MIN_IMAGE || image.length()>MAX_IMAGE) {
			throw new IllegalArgumentException("image length out of bounds");
		} else if(!image.contains(".jpg")) {
			throw new IllegalArgumentException("invalid file extension");
		} else if(image.contains(" ")) {
			throw new IllegalArgumentException("no spaces allowed in image path");
		} else {
			this.image = image;
		}
		
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
		if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
			throw new IllegalArgumentException("Invalid name length");
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
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) throws IllegalArgumentException {
		if (realName.length() < MIN_NAME || realName.length() > MAX_NAME) {
			throw new IllegalArgumentException("Invalid real name length");
		} else {
			this.realName = realName;
		}

	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) throws IllegalArgumentException {
		if (category == null) {
			throw new IllegalArgumentException("Category cant be null");
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
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) throws IllegalArgumentException {
		if(speed<MIN_SCORE || speed>MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score - speed");
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
		if(strength<MIN_SCORE || strength>MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score - strength");
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
	 * @param agility the agility to set
	 */
	public void setAgility(int agility) throws IllegalArgumentException {
		if(agility<MIN_SCORE || agility>MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score - agility");
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
	 * @param intelligence the intelligence to set
	 */
	public void setIntelligence(int intelligence) throws IllegalArgumentException {
		if(intelligence<MIN_SCORE || intelligence>MAX_SCORE) {
			throw new IllegalArgumentException("Invalid score - intelligence");
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
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		if(bio==null) {
			throw new IllegalArgumentException("bio cant be null");
		} else {
			this.bio = bio;
		}
		
	}
	
	public int getMaxStatID() {
		
		
		
		Integer[] scores = new Integer[] {speed,strength,agility,intelligence};
		List<Integer> scoreList = new ArrayList<Integer>(Arrays.asList(scores));
		
		//another way to do it below - Get the index of the max function
		//scoreList.indexOf(Collections.max(scoreList));
		
		int biggest = scoreList.get(0);
		int index = 0;
		
		for(int i = 1; i<scoreList.size(); i++) {
			if(scoreList.get(i)>biggest) {
				biggest = scoreList.get(i);
				index = i;
				
			}
		}
		
		return index;
	}
	
	public int getStatScore(int statChoice) {
		
		int toReturn = -1;
		
		switch(statChoice) {
		case 0: toReturn = speed;
		break;
		case 1: toReturn = strength;
		break;
		case 2: toReturn = agility;
		break;
		case 3: toReturn = intelligence;
		break;
		default: throw new IllegalArgumentException("Invalid parameter - get stat score param must be between 0 and 3");
		}
		
		return toReturn;
	}
	
	public void displayDetails() {
		System.out.printf("%-15s%-20s%n%-15s%-20s%n%-15s%-20s%n%-15s%-20s%n%-15s%-20d%n%-15s%-20d%n%-15s%-20d%n%-15s%-20d%n%-15s%-20s%n","Name:",name,"Real name:",realName,"File name:",image,"Category:",category,"Speed:",speed,"Strength:",
				strength,"Agility:",agility,"Intelligence:",intelligence,"Bio:",bio);
	}
	
	public void displaySummaryDetails() {
		System.out.printf("%s / %s (%s)%n",name,realName,category);
		System.out.printf("sp: %d | st: %d | ag: %d | in: %d %n",speed,strength,agility,intelligence);
	}

	@Override
	public int compareTo(TopTrumpCard o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
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
