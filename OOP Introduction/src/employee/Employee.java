package employee;

public class Employee {
	
	private String firstName;
	private String lastName;
	private int employeeNum;
	private static int count=0;
	
	
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public Employee(String firstName, String lastName) {
		count++;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		employeeNum = count; //guarantees a unique employee number
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
	 * @return the count
	 */
	public static int getCount() {
		return count;
	}
	
	
	public void displayDetails() {
		System.out.println("Employee [firstName=" + firstName + ", lastName=" + lastName + 
				", employeeNum=" + employeeNum + "]");
	}
	
	
}
