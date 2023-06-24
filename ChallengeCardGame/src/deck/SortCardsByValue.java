package deck;

import java.util.Comparator;

public class SortCardsByValue implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return o1.getValue()-o2.getValue();
	}

}
