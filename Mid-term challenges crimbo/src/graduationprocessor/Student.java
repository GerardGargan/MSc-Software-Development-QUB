package graduationprocessor;

public abstract class Student {
	private String firstName;
	private String lastName;
	private int studentNumber;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, int studentNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setStudentNumber(studentNumber);
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentNumber=" + studentNumber + "]";
	}
	
	public abstract double avgResult();
	
	public abstract String result();

}
