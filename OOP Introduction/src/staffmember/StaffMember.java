package staffmember;

public class StaffMember {
	
	private String firstName;
	private String lastName;
	
	public StaffMember(String firstName, String lastName) {
		this.setFirstName(firstName); 
		this.setLastName(lastName);
	}
	
	
	@Override
	public String toString() {
		return "StaffMember [firstName=" + firstName + ", lastName=" + lastName + "]";
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
	 * @param firstName
	 * @param lastName
	 */

	
	
}
