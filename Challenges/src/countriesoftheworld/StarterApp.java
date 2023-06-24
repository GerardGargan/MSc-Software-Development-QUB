package countriesoftheworld;

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

		List<Country> countries = readCountries("countries.csv");
//		printCountries(countries);
//
//		System.out.println("Showing countries in europe");
//		printCountries(searchByRegion(countries, "europe"));
		
		System.out.println("Sorted by popuation");
		Collections.sort(countries, new CompareCountriesByPopulation());
		printCountries(countries);

	}

	private static List<Country> searchByRegion(List<Country> countries, String string) {
		List<Country> results = new ArrayList<Country>();

		for (Country c : countries) {
			if (c.getRegion().equalsIgnoreCase(string)) {
				results.add(c);
			}
		}

		return results;
	}

	private static void printCountries(List<Country> countries) {
		if (countries == null || countries.size() == 0) {
			System.out.println("No countries to show");
		} else {
			for (Country c : countries) {
				System.out.println(c.toString());
			}
		}
	}

	private static List<Country> readCountries(String fileName) {
		List<Country> countries = new ArrayList<Country>();

		File file = new File(fileName);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine();// throw away headers
			line = br.readLine();
			String[] parts;

			while (line != null) {

				parts = line.split(",");
				String name = parts[0];
				String region = parts[1];
				int population = Integer.parseInt(parts[2]);
				int area = Integer.parseInt(parts[3]);

				region = transformRegion(region);

				countries.add(new Country(name, region, population, area));

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return countries;
	}

	private static String transformRegion(String region) {
		String transformed = region;
		if (region.toLowerCase().equals("eastern europe") || region.toLowerCase().equals("western europe")) {
			transformed = "Europe";
		} else if (region.equalsIgnoreCase("sub-saharan africa") || region.equalsIgnoreCase("northern africa")) {
			transformed = "Africa";
		} else {
			transformed = region.substring(0, 1).toUpperCase() + region.substring(1).toLowerCase();
		}

		return transformed;

	}

}
