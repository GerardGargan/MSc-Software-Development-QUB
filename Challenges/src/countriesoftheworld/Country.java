package countriesoftheworld;

public class Country {
	private String name;
	private String region;
	private int population;
	private int area;
	private double density;
	
	
	/**
	 * @param name
	 * @param region
	 * @param population
	 * @param area
	 * @param density
	 */
	public Country(String name, String region, int population, int area) {
		setName(name);
		setRegion(region);
		setPopulation(population);
		setArea(area);
		setDensity();
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
	public void setDensity() {
		this.density = (double)population/area;
	}
	
	public String toString() {
		return String.format("Name: %s%nRegion: %s%nPopulation: %d%nArea: %d%nDensity: %.2f%n", name,region,population,area,density);
	}
	
}
