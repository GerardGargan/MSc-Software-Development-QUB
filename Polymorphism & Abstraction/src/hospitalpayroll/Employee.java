package hospitalpayroll;

public abstract class Employee {
	private String firstName;
	private String lastName;
	private double baseRate;
	
	public Employee() {
		
	}
	
	public Employee(String firstName, String lastName, double baseRate) {
		setFirstName(firstName);
		setLastName(lastName);
		setBaseRate(baseRate);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}
	
	public double getBaseRate() {
		return baseRate;
	}
	
	public abstract double calculateWeeklySalary(double hours);
	
	public String printAll() {
		return String.format("First Name: %s, Last Name: %s, Base Rate: %.2f", getFirstName(),getLastName(),getBaseRate());
	}
}
