package city;

public class CityAdmin {

	public static void main(String[] args) {
		City c1 = new City("Beijing", 11, true, "China");
		City c2 = new City("Madrid", 5, true, "Spain");
		City c3 = new City("Rome", 6, true, "Italy");
		City c4 = new City("New York", 8, false, "USA");
		City c5 = new City("Washington", 2, true, "USA");
		City c6 = new City("Dallas", 3, false, "USA");
		
		City[] cities = {c1,c2,c3,c4,c5,c6};
		
		displayAll(cities);
		smallestCity(cities);
		capitalCitySearch(cities);
		cityByCountry(cities, "USA");
		avgPop(cities);
	}
	
	public static void displayAll(City[] cities) {
		for(City city : cities) {
			System.out.println(city.toString());
		}
	}
	
	public static void smallestCity(City[] cities) {
		String name = "";
		int smallest = cities[0].getPopulation();
		for(int i=0; i<cities.length; i++) {
			if(cities[i].getPopulation()<smallest) {
				smallest = cities[i].getPopulation();
				name = cities[i].getCityName();
			}
		}
		System.out.println("Smallest city is: "+name+" with a population of "+smallest+" million people");
	}
	
	public static void capitalCitySearch(City[] cities) {
		System.out.println("Capital cities: ");
		for(City c : cities) {
			if(c.getCountryCapital()==true) {
				System.out.println(c.getCityName());
			}
		}
	}
	
	public static void cityByCountry(City[] cities, String country) {
		System.out.println("City by country: "+country);
		for(City c : cities) {
			if(c.getCountry().equalsIgnoreCase(country)) {
				System.out.println(c.getCityName()+" "+c.getCountry());
			}
		}
	}
	
	public static void avgPop(City[] cities) {
		int sum = 0;
		double avg = 0;
		
		for(int i=0; i<cities.length; i++) {
			sum += cities[i].getPopulation();
		}
		avg = (double)sum/cities.length;
		System.out.printf("Average population: %.2f",avg);
	}

}
