package hospitalpayroll;

public class Porter extends Employee {

	private String site;
	
	public Porter() {
		
	}

	public Porter(String firstName, String lastName, double baseRate, String site) {
		super(firstName, lastName, baseRate);
		setSite(site);
	}

	

	/**
	 * @return the site
	 */
	public String getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(String site) {
		this.site = site;
	}

	public double calculateWeeklySalary(double hours) {
		
		return hours*getBaseRate();
	}

	public String printAll() {
		return String.format("First Name: %s, Last Name: %s, Base Rate: %.2f, site: %s", getFirstName(),getLastName(),getBaseRate(),getSite());
	}
	

}
