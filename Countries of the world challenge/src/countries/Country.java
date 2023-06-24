package countries;

public class Country {
	private String country;
	private String region;
	private int population;
	private int area;
	private double density;
	
	
	
	/**
	 * @param country
	 * @param region
	 * @param population
	 * @param area
	 * @param density
	 */
	public Country(String country, String region, int population, int area, double density) {
		setCountry(country);
		setRegion(region);
		setPopulation(population);
		setArea(area);
		setDensity(density);
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
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}
	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}
	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(int area) {
		this.area = area;
	}
	/**
	 * @return the density
	 */
	public double getDensity() {
		return density;
	}
	/**
	 * @param density the density to set
	 */
	public void setDensity(double density) {
		this.density = density;
	}
	
	public void printDetails() {
		System.out.println("Country: "+country);
		System.out.println("Region: "+region);
		System.out.println("Population: "+population);
		System.out.println("Area: "+area);
		System.out.println("Density: "+density);
	}
	
	
}
