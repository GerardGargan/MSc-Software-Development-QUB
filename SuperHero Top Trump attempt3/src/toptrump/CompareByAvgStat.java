package toptrump;

import java.util.Comparator;

public class CompareByAvgStat implements Comparator<TopTrumpCard>{

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {

		if(o1.getAgility()==o2.getAvg()) {
			return 0;
		} else if(o1.getAvg()>o2.getAvg()) {
			return -1;
		} else {
			return 1;
		}
	}

}
