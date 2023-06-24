package thirdtry;

import java.util.Comparator;

public class CompareBySuit implements Comparator<Card> {

	@Override
	public int compare(Card o1, Card o2) {
		// TODO Auto-generated method stub
		return o1.getSuit().compareTo(o2.getSuit());
	}

}
