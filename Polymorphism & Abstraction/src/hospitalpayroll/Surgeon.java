package hospitalpayroll;

public class Surgeon extends Employee {
	private String specialistArea;
	private double consultationFee;

	public Surgeon() {
		
	}

	public Surgeon(String firstName, String lastName, double baseRate, String specialistArea, double consultationFee) {
		super(firstName, lastName, baseRate);
		setSpecialistArea(specialistArea);
		setConsultationFee(consultationFee);
	}

	/**
	 * @return the specialistArea
	 */
	public String getSpecialistArea() {
		return specialistArea;
	}

	/**
	 * @param specialistArea the specialistArea to set
	 */
	public void setSpecialistArea(String specialistArea) {
		this.specialistArea = specialistArea;
	}

	/**
	 * @return the consultationFee
	 */
	public double getConsultationFee() {
		return consultationFee;
	}

	/**
	 * @param consultationFee the consultationFee to set
	 */
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	@Override
	public double calculateWeeklySalary(double hours) {
		
		return hours*getBaseRate()+getConsultationFee();
	}
	
	public String printAll() {
		return String.format("First Name: %s, Last Name: %s, Base Rate: %.2f, Specialist area: %s, Consultation fee: %.2f", getFirstName(),getLastName(),getBaseRate(),getSpecialistArea(),getConsultationFee());
	}

}
