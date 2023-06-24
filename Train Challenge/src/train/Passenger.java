package train;

public class Passenger {
	private String firstName;
	private int ID;
	private PASSENGER_CLASS passengerClass;
	private String surName;
	
	
	
	/**
	 * @param firstName
	 * @param iD
	 * @param passengerClass
	 * @param surName
	 */
	public Passenger(String firstName, int iD, PASSENGER_CLASS passengerClass, String surName) {
		setFirstName(firstName);
		setID(iD);
		setPassengerClass(passengerClass);
		setSurName(surName);
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
	public PASSENGER_CLASS getPassengerClass() {
		return passengerClass;
	}
	/**
	 * @param passengerClass the passengerClass to set
	 */
	public void setPassengerClass(PASSENGER_CLASS passengerClass) {
		this.passengerClass = passengerClass;
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
	@Override
	public String toString() {
		return "Passenger [firstName=" + firstName + ", ID=" + ID + ", passengerClass=" + passengerClass + ", surName="
				+ surName + "]";
	}
	
	
	
	
}
