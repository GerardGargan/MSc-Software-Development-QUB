package lecture;

import java.util.Objects;

public class Person implements Comparable<Person> {
	
	private String firstName;
	private String surName;
	private int age;
	
	/**
	 * @param firstName
	 * @param surName
	 */
	public Person(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
	}
	
	public Person(String firstName, String surName, int age) {
		this.firstName = firstName;
		this.surName = surName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", surName=" + surName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, surName);
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(firstName, other.firstName) && Objects.equals(surName, other.surName);
	}

	@Override
	public int compareTo(Person o) {
		//natural ordering by age
		return this.age - o.age;
		
		//sorting by surname
		//return this.surName.compareTo(o.surName);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
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
	public void setAge(int age) {
		this.age = age;
	}

	
	
	
}
