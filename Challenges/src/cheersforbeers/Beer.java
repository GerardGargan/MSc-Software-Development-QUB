package cheersforbeers;

public class Beer {
	private String name;
	private String style;
	private String country;
	private double alcoholpercent;
	
	
	
	/**
	 * @param name
	 * @param style
	 * @param country
	 * @param alcoholpercent
	 */
	public Beer(String name, String style, String country, double alcoholpercent) {
		setName(name);
		setStyle(style);
		setCountry(country);
		setAlcoholpercent(alcoholpercent);
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
	 * @return the alcoholpercent
	 */
	public double getAlcoholpercent() {
		return alcoholpercent;
	}
	/**
	 * @param alcoholpercent the alcoholpercent to set
	 */
	public void setAlcoholpercent(double alcoholpercent) {
		this.alcoholpercent = alcoholpercent;
	}
	
	public void displayBeerDetails() {
		
		System.out.printf("%-35s%-25s%-25s%-25.2f%n",name,style,country,alcoholpercent);
	}
	
}
