package hospital;

public abstract class Employee {
	
	public static final double MIN_RATE = 7.82;

	/**
	 * First Name, must be at least 1 character long
	 */
	private String firstName;
	
	/**
	 * Last name, must be at least 1 character long
	 */
	private String lastName;
	/**
	 * Base rate, must be more than minimum wage BASE RATE
	 */
	private double baseRate;

	public Employee() {
		firstName = "DefaultName";
		lastName = "DefaultLastName";
		baseRate = 0.00;

	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param baseRate
	 */
	public Employee(String firstName, String lastName, double baseRate) {
		setFirstName(firstName);
		setLastName(lastName);
		setBaseRate(baseRate);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name, throws IllegalArgmentException if it is not at least 1 char long
	 * @param firstName
	 * @throws IllegalArgumentException
	 */
	public void setFirstName(String firstName) throws IllegalArgumentException {
		if(firstName.length()<1) {
			throw new IllegalArgumentException("First name must be at least 1 char long");
		} else {
		this.firstName = firstName;
		}
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name, throws illegal argument exception if it is not at least 1 char long
	 * @param lastName
	 * @throws IllegalArgumentException
	 */
	public void setLastName(String lastName) throws IllegalArgumentException {
		if(lastName.length()<1) {
			throw new IllegalArgumentException("Last name must be at least 1 char long");
		}
		this.lastName = lastName;
	}

	/**
	 * @return the baseRate
	 */
	public double getBaseRate() {
		return baseRate;
	}


	/**
	 * Sets the base rate for the employee, throws an illegal argument exception if it is lower than 
	 * the minimum wage base rate
	 * @param baseRate
	 * @throws IllegalArgumentException
	 */
	public void setBaseRate(double baseRate) throws IllegalArgumentException {
		if(baseRate<MIN_RATE) {
			throw new IllegalArgumentException("Cant be lower than minimum wage base rate");
		} else {
		this.baseRate = baseRate;
		}
	}
	
	public void printAll() {
		System.out.println("Fist Name: "+firstName);
		System.out.println("Last Name:"+lastName);
		System.out.println("Base Rate: "+baseRate);
	}
	
	public abstract double calculateSalary(double hours);

}
