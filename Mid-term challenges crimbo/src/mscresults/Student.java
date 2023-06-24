package mscresults;

public class Student {
	private int studentNumber;
	private String firstName;
	private String lastName;
	private int prog;
	private int cf;
	private int db;
	private int web;
	private int se;
	
	public Student() {
		
	}
	
	public Student(int studentNumber, String firstName, String lastName, int prog, int cf, int db, int web, int se) {
		setStudentNumber(studentNumber);
		setFirstName(firstName);
		setLastName(lastName);
		setProg(prog);
		setCf(cf);
		setDb(db);
		setWeb(web);
		setSe(se);
	}
	
	/**
	 * @return the studentNumber
	 */
	public int getStudentNumber() {
		return studentNumber;
	}
	/**
	 * @param studentNumber the studentNumber to set
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the prog
	 */
	public int getProg() {
		return prog;
	}
	/**
	 * @param prog the prog to set
	 */
	public void setProg(int prog) {
		this.prog = prog;
	}
	/**
	 * @return the cf
	 */
	public int getCf() {
		return cf;
	}
	/**
	 * @param cf the cf to set
	 */
	public void setCf(int cf) {
		this.cf = cf;
	}
	/**
	 * @return the db
	 */
	public int getDb() {
		return db;
	}
	/**
	 * @param db the db to set
	 */
	public void setDb(int db) {
		this.db = db;
	}
	/**
	 * @return the web
	 */
	public int getWeb() {
		return web;
	}
	/**
	 * @param web the web to set
	 */
	public void setWeb(int web) {
		this.web = web;
	}
	/**
	 * @return the se
	 */
	public int getSe() {
		return se;
	}
	/**
	 * @param se the se to set
	 */
	public void setSe(int se) {
		this.se = se;
	}
	
	public double avgMark() {
		double total = getCf()+getDb()+getProg()+getSe()+getWeb();
		double average = total / 5;
		return average;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", prog=" + prog + ", cf=" + cf + ", db=" + db + ", web=" + web + ", se=" + se + "]";
	}
	
	
}
