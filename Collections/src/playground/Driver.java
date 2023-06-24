package playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		Computer c1 = new Computer("HP Envy", 250, 799.00, 16);
		Computer c2 = new Computer("Samsung galaxy book", 500, 499.00, 8);
		Computer c3 = new Computer("HP Pavilion", 128, 399.00, 4);
		Computer c4 = new Computer("Lenovo IdeaPad", 1000, 949, 16);
		Computer c5 = new Computer("Samsung Galaxy Book3 Ultra", 1000, 3049, 16);

		Computer[] computers = new Computer[] { c1, c2, c3, c4, c5 };

		List<Computer> comps = Arrays.asList(computers);
		System.out.println("Unsorted");
		displayAll(comps);

		Collections.sort(comps);
		System.out.println();
		System.out.println("Sorted by Natural order");
		System.out.println();
		displayAll(comps);
		
		System.out.println("Sorted by RAM");
		System.out.println();
		Collections.sort(comps, new CompareComputerByRam());
		displayAll(comps);
		
		System.out.println();
		System.out.println("Sorted by Name");
		Collections.sort(comps, new CompareComputerByName());
		displayAll(comps);
		
		System.out.println();
		System.out.println("Reverse sort");
		Collections.reverse(comps);
		displayAll(comps);
		System.out.println();
		
		Computer largest = Collections.max(comps);
		Computer smallest = Collections.min(comps);
		
		System.out.printf("The most expensive is :%s%nThe least expensive is: %s%n",largest.toString(),smallest.toString());
		
		Computer maxRam = Collections.max(comps, new CompareComputerByRam());
		Computer minRam = Collections.min(comps, new CompareComputerByRam());
		System.out.printf("The most RAM: %s%nThe least RAM: %s%n",maxRam.toString(),minRam.toString());
		
		
	}

	public static void displayAll(List<Computer> c) {
		if(c==null || c.size()==0) {
			System.out.println("Empty or null array");
		} else {
			for(Computer comp : c  ) {
				System.out.println(comp.toString());
			}
		}
	}
}
