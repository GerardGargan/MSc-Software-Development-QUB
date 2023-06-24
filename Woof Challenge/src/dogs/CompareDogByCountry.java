package dogs;

import java.util.Comparator;

public class CompareDogByCountry implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.getCountry().compareTo(o2.getCountry());
	}

}
