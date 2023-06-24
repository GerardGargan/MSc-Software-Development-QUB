package hospital;

public class Surgeon extends Employee {
	
	private String specialistArea;
	private double consultationFee;

	public Surgeon() {
		specialistArea = "None";
		consultationFee = 0;
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
	 * set the consultation fee, must be positive
	 * @param consultationFee
	 * @throws IllegalArgumentException if negative is given
	 */
	public void setConsultationFee(double consultationFee) throws IllegalArgumentException {
		if(consultationFee<0) {
			throw new IllegalArgumentException("Consultation fee must be a positive number");
		} else {
		this.consultationFee = consultationFee;
		}
	}

	@Override
	public double calculateSalary(double hours) {
		double salary = hours*getBaseRate()+consultationFee;
		return salary;

	}

	@Override
	public void printAll() {
		System.out.println("Surgeon - ");
		System.out.println("Specialist area: "+specialistArea);
		System.out.println("Consultation fee: "+consultationFee);
		super.printAll();
	}

}
