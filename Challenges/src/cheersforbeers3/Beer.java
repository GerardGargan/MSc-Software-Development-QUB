package cheersforbeers3;

public class Beer {
	private String name;
	private String style;
	private String country;
	private double percentage;
	
	
	/**
	 * @param name
	 * @param style
	 * @param country
	 * @param percentage
	 */
	public Beer(String name, String style, String country, double percentage) {
		setName(name);
		setStyle(style);
		setCountry(country);
		setPercentage(percentage);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}
	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the percentage
	 */
	public double getPercentage() {
		return percentage;
	}
	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return String.format("%-35s%-30s%-30s%-5.2f%%",name,style,country,percentage);
	}
	
	
	
	
}
