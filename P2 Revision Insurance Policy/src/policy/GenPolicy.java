package policy;

public abstract class GenPolicy {

	public final int MIN_AGE = 18;
	public final int MAX_AGE = 50;

	/**
	 * Surname must be between 3 and 20 characters (inclusive)
	 */
	private String surname;
	/**
	 * Age must be between 18 and 50 (inclusive)
	 */
	private int age;

	/**
	 * Default constructor
	 */
	public GenPolicy() {
		// assign default values
		surname = "default";
		age = -1;
	}

	/**
	 * @param surname
	 * @param age
	 */
	public GenPolicy(String surname, int age) {
		setSurname(surname);
		setAge(age);
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Set the surname, must be between 3 and 20 characters, inclusive
	 * 
	 * @param surname
	 * @throws IllegalArgumentException if outside of allowable range
	 */
	public void setSurname(String surname) throws IllegalArgumentException {
		if (surname.length() < 3 || surname.length() > 20) {
			throw new IllegalArgumentException("Surname cant be less than 3 or more than 20 characters");
		} else {
			this.surname = surname;
		}
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set the age, must be between 18 and 50 inclusive
	 * 
	 * @param age
	 * @throws IllegalArgumentException if outside of the allowed range
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age < MIN_AGE || age > MAX_AGE) {
			throw new IllegalArgumentException("Age must be between 18 and 50 inclusive");
		} else {
			this.age = age;
		}
	}

	/**
	 * print all details to screen
	 */
	public void displayAll() {
		System.out.println("Surname: " + surname);
		System.out.println("Age: " + age);
	}

}
