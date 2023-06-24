package toptrump;

import java.util.Comparator;

public class CompareByAvgStats implements Comparator<TopTrumpCard> {

	@Override
	public int compare(TopTrumpCard o1, TopTrumpCard o2) {
		double o1Avg = (o1.getAgility()+o1.getIntelligence()+o1.getSpeed()+o1.getStrength())/4;
		double o2Avg = (o2.getAgility()+o2.getIntelligence()+o2.getSpeed()+o2.getStrength())/4;
		
		if(o1Avg==o2Avg) {
			return 0;
			
		} else if (o1Avg<o2Avg){
			return 1;
		} else {
			return -1;
		}
		
	}

}
