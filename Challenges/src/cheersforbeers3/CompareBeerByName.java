package cheersforbeers3;

import java.util.Comparator;

public class CompareBeerByName implements Comparator<Beer> {

	@Override
	public int compare(Beer o1, Beer o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

}
