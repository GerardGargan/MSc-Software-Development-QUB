package smartdevices;

/**
 * 
 * @author ggargan
 * Gerard Gargan, Student number 40061139
 */

public class SmartRadiator extends SmartDevice {
	
	//Min and Max values used for logic checking - set as final var's at the top of the class - easier to maintain in the future/change and reuse
	public final double MIN_TEMP_NOW = -10;
	public final double MAX_TEMP_NOW = +30;

	public final double MIN_TEMP_TARGET = 5;
	public final double MAX_TEMP_TARGET = 26;

	private double tempNow;
	private double tempTarget;

	/**
	 * default constructor
	 */
	public SmartRadiator() {
		// set default values, using the setters so that the method for updating the power status is triggered
		setTempNow(20);
		setTempTarget(20);
		
	}

	/**
	 * Constructor, sets the values using setters
	 * @param name
	 * @param manufacturer
	 * @param room
	 * @param tempNow
	 * @param tempTarget
	 */
	public SmartRadiator(String name, String manufacturer, Room room, double tempNow, double tempTarget) {
		super(name, manufacturer, room);
		setTempNow(tempNow);
		setTempTarget(tempTarget);
	}

	/**
	 * @return the tempNow
	 */
	public double getTempNow() {
		return tempNow;
	}

	/**
	 * Sets the current temperature in celcius as read from temperature sensons
	 * 
	 * @param tempNow
	 * @throws IllegalArgumentException if outside of the allowed range (-10 to +30
	 *                                  inclusive)
	 */
	public void setTempNow(double tempNow) throws IllegalArgumentException {
		if (tempNow < MIN_TEMP_NOW || tempNow > MAX_TEMP_NOW) {
			throw new IllegalArgumentException("Temp now must be in the range of -10 to +30");
		} else {
			this.tempNow = tempNow;
		}
	}

	/**
	 * @return the tempTarget
	 */
	public double getTempTarget() {
		return tempTarget;
	}

	/**
	 * Sets the target temperature for the smart radiator
	 * 
	 * @param tempTarget
	 * @throws IllegalArgumentException if outside of the allowed range (5 to 26
	 *                                  inclusive)
	 */
	public void setTempTarget(double tempTarget) throws IllegalArgumentException {
		if (tempTarget < MIN_TEMP_TARGET || tempTarget > MAX_TEMP_TARGET) {
			throw new IllegalArgumentException();
		} else {
			this.tempTarget = tempTarget;
			updatePowerState();
		}
	}

	/**
	 * Update the power state, compare the tempNow with the tempTarget
	 * If tempNow is lower than tempTarget, set the power state to ON. Else set to OFF
	 */
	private void updatePowerState() {
		if (this.tempNow < this.tempTarget) {
			setPowerState(PowerState.ON);
		} else {
			setPowerState(PowerState.OFF);
		}
	}
 
	/**
	 * Print all details to screen, implements the contents of the parent class's method (name, manufacturer, room, powerstate) and adds the additional print below - TEMPNOW & TEMPTARGET
	 */
	@Override
	public void showAll() {
		super.showAll();
		System.out.println("TEMPNOW:       " + tempNow);
		System.out.println("TEMPTARGET:    " + tempTarget);
	}

	/**
	 * return a specified string containing the name, room, tempNow, tempTarget and power state. 
	 * The room has been changed to upper case and any spaces removed from it. Temps are shown to 1 decimal place.
	 */
	@Override
	public String status() {
		// SR-NAME-ROOM-NOW:X.X-TARGET:X.X-POWERSTATE
		String toReturn = String.format("SR-%s-%s-NOW:%.1f-TARGET:%.1f-%s", getName().toUpperCase().replace(" ", ""),
				getRoom(), tempNow, tempTarget, getPowerState());

		return toReturn;
	}

}
