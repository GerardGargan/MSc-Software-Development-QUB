package deck;

import java.util.Comparator;

public class SortCardsBySuit implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return o1.getSuit().compareTo(o2.getSuit());
	}

	

}
