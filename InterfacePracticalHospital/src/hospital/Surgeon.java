package hospital;

public class Surgeon extends Employee implements AdministerDrugs {
	
	private String specialistArea;
	private double consultationFee;

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
	public void calculateWeeklySalary(double hours) {
		double salary = (hours*getBaseRate())+consultationFee;
		System.out.println("Salary: "+salary);
		System.out.println("Rate: "+getBaseRate());
		System.out.println("Hours: "+hours);
		System.out.println("Fee: "+consultationFee);
	}

	@Override
	public void printAll() {
		System.out.println("Surgeon");
		super.printAll();
		System.out.println("Specialist area: "+specialistArea);
		System.out.println("Consultation fee: "+consultationFee);
		
	}

	@Override
	public boolean adminControlledDrugs() {
		//should not be allowed to administer
		return false;
	}

	@Override
	public boolean adminNonControlledDrugs() {
		//should be allowed to administer
		return true;
	}
	
	


}
