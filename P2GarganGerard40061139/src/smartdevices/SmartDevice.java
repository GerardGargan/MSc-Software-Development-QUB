package smartdevices;

/**
 * 
 * @author ggargan
 * Gerard Gargan, Student number 40061139
 */

public abstract class SmartDevice {
 
	//Set up the min and max data so it is easier to maintain should it need to be changed/adjusted later
	public final int MIN_NAME_LENGTH = 3;
	public final int MAX_NAME_LENGTH = 20;
	public final int MIN_MANU_LENGTH = 3;
	public final int MAX_MANU_LENGTH = 20;

	/**
	 * Name of the device, allowed to be between 3-20 characters in length
	 */
	private String name;
	/**
	 * Name of the manufacturer, allowed to be between 3-20 characters in length
	 */
	private String manufacturer;
	/**
	 * The room (enum)
	 */
	private Room room;
	/**
	 * The power state of the device, ON or OFF
	 */
	private PowerState powerState;

	public SmartDevice() {
		// setting default values
		name = "default";
		manufacturer = "default";
		room = Room.HOUSE;
		powerState = PowerState.OFF;
	}

	/**
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param powerState
	 */
	public SmartDevice(String name, String manufacturer, Room room) {
		setName(name);
		setManufacturer(manufacturer);
		setRoom(room);
		
		// setting default value of powerState in the constructors to OFF - it will be
		// overwritten by child class when the child constructor is called anyway, as it will
		// trigger the method which compares the temp now against temp target and sets this appropriately to ON or OFF
		// Although it is set in the child class, I have chosen to still default it in the parent class to OFF should this be useful for future devices 
		// that will be built to extend from this - as they may not have the same implementation as our SmartRadiator.
		setPowerState(PowerState.OFF);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name. Allowed to be between 3 and 20 characters in length.
	 * 
	 * @param name
	 * @throws IllegalArgumentException if outside of the length range.
	 */
	public void setName(String name) throws IllegalArgumentException {
		if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("Name must be between 3 and 20 charaters in length, inclusive");
		} else {
			this.name = name;
		}
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * Sets the manufactuerer. Allowed to be between 3 and 20 characters in length.
	 * 
	 * @param manufacturer
	 * @throws IllegalArgumentException if outside of the length range.
	 */
	public void setManufacturer(String manufacturer) throws IllegalArgumentException {
		if (manufacturer.length() < MIN_MANU_LENGTH || manufacturer.length() > MAX_MANU_LENGTH) {
			throw new IllegalArgumentException(
					"Manufacturer name must be between 3 and 20 characters in length, inclusive");
		} else {
			this.manufacturer = manufacturer;
		}
	}

	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the room enum.
	 * 
	 * @param room
	 * @throws IllegalArgumentException if null is passed in
	 */
	public void setRoom(Room room) throws IllegalArgumentException {
		if (room == null) {
			throw new IllegalArgumentException("Room cannot be set to null");
		} else {
			this.room = room;
		}
	}

	/**
	 * @return the powerState
	 */
	public PowerState getPowerState() {
		return powerState;
	}

	/**
	 * Setter for the power state (enum)
	 * @param powerState
	 * @throws IllegalArgumentException if null is passed in
	 */
	public void setPowerState(PowerState powerState) throws IllegalArgumentException {
		if (powerState == null) {
			throw new IllegalArgumentException("powerState cannot be null");
		} else {
			this.powerState = powerState;
		}
	}

	/**
	 * Method to print details of the SmartRadiator - Prints name, manufacturer, room and power state
	 */
	public void showAll() {
		System.out.println("NAME:          " + name);
		System.out.println("MANUFACTURER:  " + manufacturer);
		System.out.println("ROOM:          " + room);
		System.out.println("POWERSTATE:    " + powerState);
	}

	public abstract String status();

}
