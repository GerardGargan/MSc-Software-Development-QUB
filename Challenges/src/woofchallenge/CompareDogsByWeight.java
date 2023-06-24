package woofchallenge;

import java.util.Comparator;

public class CompareDogsByWeight implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		if(o1.getWeight()==o2.getWeight()) {
			return 0;
		} else if(o1.getWeight()<o2.getWeight()) {
			return -1;
		} else {
			return 1;
		}
		
	}

}
