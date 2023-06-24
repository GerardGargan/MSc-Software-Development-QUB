package staffmember;

public class Programmer extends StaffMember {
	private String language;
	
	
	public Programmer(String firstName, String lastName, String language) {
		super(firstName, lastName);
		this.setLanguage(language);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	@Override
	public String toString() {
		return String.format("Programmer %s, language %s", this.getFirstName(), this.getLanguage());
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @param firstName
	 * @param lastName
	 */

	
}
