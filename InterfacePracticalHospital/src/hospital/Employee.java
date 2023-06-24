package hospital;

public abstract class Employee {
	private String firstName;
	private String lastName;
	private double baseRate;
	
	
	
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
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the baseRate
	 */
	public double getBaseRate() {
		return baseRate;
	}
	/**
	 * @param baseRate the baseRate to set
	 */
	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}
	
	public void calculateWeeklySalary(double hours) {
		System.out.println("Salary: "+hours*this.baseRate);
	}
	
	public void printAll() {
		System.out.println("First name: "+firstName);
		System.out.println("Last name: "+lastName);
		System.out.println("Base rate: "+baseRate);
	}

}
