package secondattempt;

public class Passenger {
	private String firstName;
	private int ID;
	private PassengerType passengerType;
	private String surName;
	
	
	
	/**
	 * @param firstName
	 * @param iD
	 * @param passengerType
	 * @param surName
	 */
	public Passenger(String firstName, int iD, PassengerType passengerType, String surName) {
		setFirstName(firstName);
		setID(iD);
		setPassengerType(passengerType);
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
	 * @return the passengerType
	 */
	public PassengerType getPassengerType() {
		return passengerType;
	}
	/**
	 * @param passengerType the passengerType to set
	 */
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
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
	
	public void displayPassengerDetails() {
		System.out.println("Name :"+firstName);
		System.out.println("LName: "+surName);
		System.out.println("Class: "+passengerType);
	}
	
}

