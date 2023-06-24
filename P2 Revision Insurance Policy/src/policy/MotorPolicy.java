package policy;

import java.util.Calendar;

public class MotorPolicy extends GenPolicy {

	private MotorType motorType;
	private String motorPolicyId;

	/**
	 * General constructor
	 */
	public MotorPolicy() {
		// assigning default values
		motorType = null;
		motorPolicyId = "default";
	}

	/**
	 * Constructor with arguments
	 * 
	 * @param surname
	 * @param age
	 * @param motorType
	 */
	public MotorPolicy(String surname, int age, MotorType motorType) {
		super(surname, age);
		setMotorType(motorType);
		generatePolId();
	}

	/**
	 * Generates and sets the motorPolicyId <SUR> - First 3 letters from surname
	 * <TIME STAMP> - year+month integer <PARITY> timestamp even = 0, odd = 1
	 */
	private void generatePolId() {
		// first 3 chars of surname
		String sur = getSurname().substring(0, 3);
		// timestamp
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int timestamp = year + month;
		// Parity, if timestamp even return 0, else return 1
		int parity = (timestamp % 2 == 0) ? 0 : 1;

		this.motorPolicyId = sur + timestamp + parity;
	}

	/**
	 * @return the motorType
	 */
	public MotorType getMotorType() {
		return motorType;
	}

	/**
	 * Sets the motor type (enum)
	 * 
	 * @param motorType
	 * @throws IllegalArgumentException if null is passed in
	 */
	public void setMotorType(MotorType motorType) throws IllegalArgumentException {
		if (motorType == null) {
			throw new IllegalArgumentException("Motor Type cant be null");
		} else {
			this.motorType = motorType;
		}
	}

	/**
	 * @return the motorPolicyId
	 */
	public String getMotorPolicyId() {
		return motorPolicyId;
	}

	@Override
	public void displayAll() {
		super.displayAll();
		System.out.println("Motor Type: " + motorType);
		System.out.println("Motor policy ID: " + motorPolicyId);
	}

}
