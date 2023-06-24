package staffmember;

public class Doctor extends StaffMember {

	private int ward;
	
	/**
	 * @param firstName
	 * @param lastName
	 */
	public Doctor(String firstName, String lastName, int ward) {
		super(firstName, lastName);
		this.setWard(ward);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Doctor "+this.getFirstName()+" "+" in ward "+ward;
	}

	/**
	 * @return the ward
	 */
	public int getWard() {
		return ward;
	}

	/**
	 * @param ward the ward to set
	 */
	public void setWard(int ward) {
		this.ward = ward;
	}

	
	

}
