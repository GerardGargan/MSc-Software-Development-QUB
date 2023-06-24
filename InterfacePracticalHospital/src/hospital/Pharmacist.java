package hospital;

public class Pharmacist extends Employee implements AdministerDrugs {
	
	private int grade;
	private double bonus;

	public Pharmacist(String firstName, String lastName, double baseRate, int grade, double bonus) {
		super(firstName, lastName, baseRate);
		setGrade(grade);
		setBonus(bonus);
	}
	
	

	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}



	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}



	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}



	/**
	 * @param bonus the bonus to set
	 */
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}



	@Override
	public void calculateWeeklySalary(double hours) {
		System.out.println("Salary: "+(hours*getBaseRate()+bonus));
	}



	@Override
	public void printAll() {
		System.out.println("Pharmacist");
		super.printAll();
		System.out.println("Grade: "+grade);
		System.out.println("Bonus: "+bonus);
	}



	@Override
	public boolean adminControlledDrugs() {
		// can administer
		return true;
	}

	@Override
	public boolean adminNonControlledDrugs() {
		// can administer
		return true;
	}

}
