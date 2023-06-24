package smartdevices;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// testing the show all method and implementation/overriding
 
		ArrayList<SmartRadiator> list = new ArrayList<SmartRadiator>();

		//create the objects
		SmartRadiator s1 = new SmartRadiator("BigBerta", "Phillips", Room.HOUSE, 10, 20);
		SmartRadiator s2 = new SmartRadiator("RoastyToasty", "Samsung", Room.BEDROOM, 20, 10);
		SmartRadiator s3 = new SmartRadiator("Heater", "Argos", Room.HOUSE, 10, 20);

		//add to array list to be passed in
		list.add(s1);
		list.add(s2);
		list.add(s3);

		//loop through and call the method to print
		if (list != null) {
			for (SmartRadiator rad : list) {
				rad.showAll();
				System.out.println();
			}

		}
	}

}
