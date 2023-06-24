package hospital;

public class Pharmacist extends Employee {

	private int grade;
	private double bonus;

	public Pharmacist() {
		grade = 0;
		bonus = 0;
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
	 * Set the grade, cant be less than 0
	 * @param grade
	 * @throws IllegalArgumentException if less than 0
	 */
	public void setGrade(int grade) throws IllegalArgumentException {
		if (grade < 0) {
			throw new IllegalArgumentException("Grade cant be less than 0");
		} else {
			this.grade = grade;
		}
	}

	/**
	 * @return the bonus
	 */
	public double getBonus() {
		return bonus;
	}

	/**
	 * Set the bonus, cant be a negative number
	 * @param bonus
	 * @throws IllegalArgumentException if less than 0
	 */
	public void setBonus(double bonus) throws IllegalArgumentException {
		if(bonus<0) {
			throw new IllegalArgumentException("bonus cant be a minus number");
		} else {
		this.bonus = bonus;
		}
	}

	@Override
	public double calculateSalary(double hours) {
		double salary = hours*getBaseRate()+bonus;
		return salary;

	}

	@Override
	public void printAll() {
		System.out.println("Pharmacist -");
		System.out.println("Grade: "+grade);
		System.out.println("Bonus: "+bonus);
		super.printAll();
	}

}
