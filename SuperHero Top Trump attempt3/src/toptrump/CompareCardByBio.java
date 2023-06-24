package toptrump;

import java.util.Comparator;

public class CompareCardByBio implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		return o1.getBio().length()-o2.getBio().length();
	}

}
