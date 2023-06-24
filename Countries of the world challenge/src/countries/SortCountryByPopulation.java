package countries;

import java.util.Comparator;

public class SortCountryByPopulation implements Comparator<Country> {

	@Override
	public int compare(Country o1, Country o2) {
		// TODO Auto-generated method stub
		return o1.getPopulation()-o2.getPopulation();
	}

}
