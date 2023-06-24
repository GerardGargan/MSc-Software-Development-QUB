package hospital;

public class Porter extends Employee {
	private String site;

	/**
	 * @param firstName
	 * @param lastName
	 * @param baseRate
	 * @param site
	 */
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

	@Override
	public void printAll() {
		System.out.println("Porter");
		super.printAll();
		System.out.println("Site: "+site);
	}
	

}
