package trainchallenge;

public class Passenger {
	private String firstName;
	private String surName;
	private int ID;
	private PassengerClass PassengerClass;
	
	
	/**
	 * @param firstName
	 * @param surName
	 * @param iD
	 * @param passengerClass
	 */
	public Passenger(String firstName, String surName, int iD, trainchallenge.PassengerClass passengerClass) {
		setFirstName(firstName);
		setSurName(surName);
		setID(iD);
		setPassengerClass(passengerClass);
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
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}
	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the passengerClass
	 */
	public PassengerClass getPassengerClass() {
		return PassengerClass;
	}
	/**
	 * @param passengerClass the passengerClass to set
	 */
	public void setPassengerClass(PassengerClass passengerClass) {
		PassengerClass = passengerClass;
	}

	@Override
	public String toString() {
		return String.format("Name: %s %s%n"
				+ "ID: %d%n"
				+ "Class: %s%n", firstName, surName, ID, PassengerClass);
	}
	
	
	
}
