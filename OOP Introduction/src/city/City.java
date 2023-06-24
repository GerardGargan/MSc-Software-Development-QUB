package city;

public class City {
	private String cityName;
	private int population;
	private boolean countryCapital;
	private String country;
	
	public City() {
		
	}
	
	public City(String cityName, int population, boolean countryCapital, String country) {
		setCityName(cityName);
		setPopulation(population);
		setCountryCapital(countryCapital);
		setCountry(country);
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setPopulation(int population) {
		if(population>=0 && population<=50) {
			this.population = population;
		} else {
			this.population = 1;
			System.out.println("Invalid population, cannot be less than 0 or more than 50");
		}
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setCountryCapital(boolean countryCapital) {
		this.countryCapital = countryCapital;
	}
	
	public boolean getCountryCapital() {
		return countryCapital;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String toString() {
		return String.format("City Name: %s, Population: %d, Country Capital: %b, Country: %s", getCityName(),getPopulation(), getCountryCapital(), getCountry());
	}
}
