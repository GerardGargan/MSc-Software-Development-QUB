package cheersforbeers2;

import java.util.Comparator;

public class CompareBeersByPercentage implements Comparator<Beer> {

	@Override
	public int compare(Beer o1, Beer o2) {
		int result;
		
		if(o1.getPercentage()==o2.getPercentage()) {
			result = 0;
			
		} else if(o1.getPercentage()<o2.getPercentage()) {
			result = 1;
		} else {
			result = -1;
		}
		
		// TODO Auto-generated method stub
		return result;
	}

}
