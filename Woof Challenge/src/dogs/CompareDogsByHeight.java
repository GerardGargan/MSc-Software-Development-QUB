package dogs;

import java.util.Comparator;

public class CompareDogsByHeight implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		if(o1.getHeight()==o2.getHeight()) {
			return 0;
		} else if(o1.getHeight()<o2.getHeight()) {
			return -1;
		} else {
			return 1;
		}
		
	}

}
