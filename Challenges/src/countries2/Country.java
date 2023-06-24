package countries2;

import java.util.Objects;

public class Country implements Comparable<Country> {
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
	 */
	public Country(String country, String region, int population, int area, double density) {
		setCountry(country);
		setRegion(region);
		setPopulation(population);
		setArea(area);
		setDensity(density);
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
	
	public void printCountryDetail() {
		System.out.printf("%-30s%-30s%n"
				+ "%-30s%-30s%n"
				+ "%-30s%-30d%n"
				+ "%-30s%-30d%n"
				+ "%-30s%-30.2f%n",
				"Name",country,"Region",region,"Population",population,"Area",area,"Density",density);
	}


	@Override
	public int hashCode() {
		return Objects.hash(area, country, density, population, region);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return area == other.area && Objects.equals(country, other.country)
				&& Double.doubleToLongBits(density) == Double.doubleToLongBits(other.density)
				&& population == other.population && Objects.equals(region, other.region);
	}


	@Override
	public int compareTo(Country o) {
		// TODO Auto-generated method stub
		return this.getCountry().compareTo(o.getCountry());
	}
	
	
	
	
}
