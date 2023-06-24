package hospital;

public class Porter extends Employee {
	private String site;

	public Porter() {
		site = "DefaultSite";
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
	 * Set the site, must be at least 1 char long
	 * @param site
	 * @throws IllegalArgumentException if business rule not met
	 */
	public void setSite(String site) throws IllegalArgumentException {
		if(site.length()<1) {
			throw new IllegalArgumentException("Site must be at least 1 char long");
		} else {
		this.site = site;
		}
	}

	@Override
	public double calculateSalary(double hours) throws IllegalArgumentException {
		if(hours<0) {
			throw new IllegalArgumentException("hours cant be less than 0");
		} else {
		return hours*getBaseRate();
		}
	}

	@Override
	public void printAll() {
		System.out.println("Porter - ");
		super.printAll();
	}
	
	

}
