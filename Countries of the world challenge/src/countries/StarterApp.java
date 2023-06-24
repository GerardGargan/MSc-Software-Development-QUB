package countries;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StarterApp {

	public static void main(String[] args) {
		String filename = "countries.csv";
		List<Country> countries = readcountries(filename);
		
		//displayAllCountryDetails(countries);
		showAllByRegion(countries, "Europe");
		
		System.out.println();
		System.out.println("Sorting by population");
		Collections.sort(countries, new SortCountryByPopulation());
		showAllByRegion(countries, "Europe");

	}

	public static List<Country> readcountries(String filename) {
		List<Country> allCountries = new ArrayList<Country>();
		
		String line;
		String[] parts;
		File file;
		FileReader fr;
		BufferedReader br;
		try {
			file = new File(filename);
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			line = br.readLine(); //throw away headers
			line = br.readLine();
			
			while(line!=null) {
				parts = line.split(",");
				String countryName = parts[0];
				String countryRegion = parts[1];
				String countryRegionConverter = convertCountry(countryRegion);
				int countrypop = Integer.parseInt(parts[2]);
				int countryarea = Integer.parseInt(parts[3]);
				double density = (double)countrypop/countryarea;
				Country c =  new Country(countryName, countryRegionConverter, countrypop, countryarea, density);
				allCountries.add(c);
				
				//read next line
				line = br.readLine();
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();			
		} catch (IOException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		} 
		
		
		return allCountries;
	}
	
	private static String convertCountry(String countryRegion) {
		String region = countryRegion.strip().toLowerCase();
		
		if(region.equals("eastern europe") || region.equals("western europe")) {
			return "Europe";
		} else if(region.equals("sub-saharan africa") || region.equals("northern africa")) {
			return "Africa";
		}
		
		String transform = countryRegion.strip().toLowerCase();
		return transform.substring(0,1).toUpperCase() + transform.substring(1);
		
	}

	public static void displayAllCountryDetails(List<Country> list) {
		if(list==null || list.size()==0) {
			System.out.println("No countries to show");
		} else {
			for(Country c : list) {
				c.printDetails();
				System.out.println();
			}
		}
	}
	
	public static void showAllByRegion(List<Country> list, String region) {
		if(list==null || list.size()==0) {
			System.out.println("No items in the list or null");
		} else {
			System.out.println("Printing matches");
			for(Country c : list) {
				if(c.getRegion().toLowerCase().equals(region.toLowerCase())) {
					System.out.println(c.getRegion()+" "+c.getCountry()+" "+c.getPopulation());
				}
			}
		}
	}
	
	

}
