package playground;

import java.util.Comparator;

public class CompareComputerByRam implements Comparator<Computer> {

	@Override
	public int compare(Computer o1,  Computer o2) {
		return o1.getRam()-o2.getRam();
	}

}
