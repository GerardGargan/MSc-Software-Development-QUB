package hospitalpayroll;

public class Pharmacist extends Employee {
	private int grade;
	private double bonus;
	
	public Pharmacist() {
		
	}

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
	public double calculateWeeklySalary(double hours) {
		
		return hours*getBaseRate()+getBonus();
	}
	
	public String printAll() {
		return String.format("First Name: %s, Last Name: %s, Base Rate: %.2f, grade: %d, bonus: %f", getFirstName(),getLastName(),getBaseRate(),getGrade(),getBonus());
	}

}
