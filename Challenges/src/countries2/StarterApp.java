package countries2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StarterApp {

	public static void main(String[] args) {
		List<Country> countries = readIn("countries.csv");
		//printAllCountries(countries);
		//printAllCountries(searchByRegion(countries, "EuroPe"));
		
		//printCountrysSorted(countries, new CompareCountryByPopulationAsc());
		displayPopByRegion(countries);
	}

	private static void displayPopByRegion(List<Country> countries) {
		Map<String, Long> regions = new HashMap<String, Long>(countries.size());
		
		for(Country country : countries) {
			if(regions.containsKey(country.getRegion())) {
				//update value
				long currentValue = (long)regions.get(country.getRegion());
				long newValue = (long)currentValue+country.getPopulation();
				regions.put(country.getRegion(), newValue);
			} else {
				//add to map and set initial value
				regions.put(country.getRegion(), (long)country.getPopulation());
			}
		}
		
		//display logic
		System.out.println("Population by region");
		for(String region : regions.keySet()) {
			System.out.printf("%-20s%,d%n",region,regions.get(region));
		}
	}

	private static void printCountrysSorted(List<Country> countries,
			Comparator<Country> comparator) {
		List<Country> copy = new ArrayList<Country>(countries);
		
		if(copy==null || copy.size()==0) {
			System.out.println("No countries to show");
		} else {
			Collections.sort(copy, comparator);
			System.out.printf("%-20s%-30s%n","Population","Country");
			for(Country country : copy) {
				System.out.printf("%-20d%-30s%n",country.getPopulation(),country.getCountry());
			}
		}
		
	}

	private static List<Country> readIn(String fileName) {
		List<Country> list = new ArrayList<Country>();

		File file = new File(fileName);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine(); // throw away headers
			line = br.readLine();
			String[] parts;

			while (line != null) {
				try {
					parts = line.split(",");
					String name = parts[0];
					String region = parts[1];
					String mappedRegion = updateRegion(region);
					int pop = Integer.parseInt(parts[2]);
					int area = Integer.parseInt(parts[3]);
					double density = (double) pop / area;
					
					Country co = new Country(name, mappedRegion, pop, area, density);

					list.add(co);
					
					line = br.readLine();
				} catch (Exception e) {
					System.out.println("Skipping bad line of data");
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list.size()+" read in");
		return list;
	}

	private static String updateRegion(String region) {
		String lowerc = region.toLowerCase().strip();
		String toReturn = "";
		switch(lowerc) {
		case "eastern europe":
		case "western europe":
			toReturn = "Europe";
			break;
		case "sub-saharan africa":
		case "northern africa":
			toReturn = "Africa";
			break;
			default: toReturn = lowerc;
		}
		
		
		return toReturn.substring(0,1).toUpperCase()+toReturn.substring(1).toLowerCase();
	}
	
	public static void printAllCountries(List<Country> list) {
		if(list==null) {
			throw new IllegalArgumentException("List is null");
		} else if(list.size()==0) {
			System.out.println("No countries in the list");
		} else {
			for(Country country : list) {
				country.printCountryDetail();
				System.out.println();
			}
		}
	}

	public static List<Country> searchByRegion(List<Country> list, String region){
		List<Country> results = new ArrayList<Country>();
		
		if(list==null) {
			throw new IllegalArgumentException("null list");
		} else if(list.size()==0) {
			return results;
		} else {
			for(Country country : list) {
				if(country.getRegion().equalsIgnoreCase(region)) {
					results.add(country);
				}
			}
		}
		
		return results;
	}

}
