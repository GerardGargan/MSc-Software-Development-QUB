package p3;

import java.util.Comparator;

/**
 * @author GarganGerard - 40061139
 */
public class CompareByPriceHighToLow implements Comparator<Accommodation> {
//sorted high to low
	@Override
	public int compare(Accommodation o1, Accommodation o2) {
		if (o1.getPrice() == o2.getPrice()) {
			return 0;
		} else if (o1.getPrice() < o2.getPrice()) {
			return 1;
		} else {
			return -1;
		}

	}

}
