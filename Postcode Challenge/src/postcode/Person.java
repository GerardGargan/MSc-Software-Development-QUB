package postcode;

public class Person {
	
	private String name;
	private String surName;
	private Address address;
	
	
	/**
	 * @param name
	 * @param surName
	 * @param address
	 */
	public Person(String name, String surName, Address address) {
		setName(surName);
		setSurName(surName);
		setAddress(address);
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
	public void setName(String name) {
		this.name = name;
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
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return String.format("%s %s,%nAddress: %s%n", getName(),getSurName(),getAddress());
	}
	
	

}
