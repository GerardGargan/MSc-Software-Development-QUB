package toptrump;

import java.util.Comparator;

public class CompareByBioLength implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		// TODO Auto-generated method stub
		if(o1.getBio().length()==o2.getBio().length()) {
			return 0;
		} else if(o1.getBio().length()<o2.getBio().length()) {
			return -1;
		} else {
			return 1;
		}
		
	}

}
