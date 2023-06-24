package playground;

import java.util.Comparator;

public class CompareComputerByName implements Comparator<Computer> {

	@Override
	public int compare(Computer o1, Computer o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}

	

}
