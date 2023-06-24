package maths.examples;

public class Employee {
	private static final int MIN_LEN = 2;
	private static final int MAX_LEN = 20;
	private static final int MIN_AGE = 0;
	private static final int MAX_AGE = 65;

	private String name;
	private int age;
	private double salary;
	
	public Employee() {
		
	}
	

	/**
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name, int age, double salary) {
		setName(name);
		setAge(age);
		setSalary(salary);
		
		
	}

	/**
	 * @return the anme
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param anme the anme to set
	 */
	public void setName(String name) throws IllegalArgumentException {
		if(name==null) {
			throw new IllegalArgumentException("Name cant be null");
		} else if(name.length()<MIN_LEN || name.length()>MAX_LEN) {
			throw new IllegalArgumentException("Invalid name length");
		} else {
		this.name = name;
		}
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) throws IllegalArgumentException {
		if (age < MIN_AGE || age > MAX_AGE) {
			throw new IllegalArgumentException("Invalid age");
		} else {
			this.age = age;
		}
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * 
	 * @param salary
	 * @throws IllegalArgumentException - must be non negative
	 */
	public void setSalary(double salary) throws IllegalArgumentException {
		if(salary>=0) {
		this.salary = salary;
		} else {
			throw new IllegalArgumentException("Cant set negative salary");
		}
	}
}
