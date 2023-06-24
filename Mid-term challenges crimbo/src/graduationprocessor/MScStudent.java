package graduationprocessor;

public class MScStudent extends Student {
	
	private int prog;
	private int cf;
	private int db;
	private int web;
	private int se;
	
	public MScStudent() {
		
	}
	
	public MScStudent(String firstName, String lastName, int StudentNumber, int prog, int cf, int db, int web, int se) {
		super(firstName,lastName,StudentNumber);
		setProg(prog);
		setCf(cf);
		setDb(db);
		setWeb(web);
		setSe(se);
	}
	
	@Override
	public String toString() {
		String info = String.format("Student no: %d%nFirst Name: %s%nLast Name: %s%nModule Results:%nProgramming: %d%nComp Found: %d%n DBs: %d%nWeb: %d%nSoftware%d%nAverage: %.2f%nClassification: %s", getStudentNumber(), getFirstName(), getLastName(), getProg(), getCf(),getDb(),getWeb(),getSe(),avgResult(),result());;
		return info;
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

	@Override
	public double avgResult() {
		double total = prog+cf+db+web+se;
		return total/5;
	}
	
	public String result() {
		String result = "blank";
		if(avgResult()<0 || avgResult()>100) {
			result = "Error! Cannot be <0 or >100";
		} else if(avgResult()>=70 && avgResult()<=100) {
			result = "distinction";
		} else if(avgResult()>=60 && avgResult()<=69) {
			result = "commendation";
		} else if (avgResult()>50 && avgResult()<=59) {
			result = "pass";
		} else if(avgResult()>=0 && avgResult()<=49) {
			result = "fail";
		}
		
		return result;
	}
	
}
