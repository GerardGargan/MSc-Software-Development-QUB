package solarsystem;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		SolarObject s1,s2,s3;
		s1 = new Planet("Earth", 100, PlanetType.TERRESTRIAL, 1);
		s2 = new Planet("Mars", 200, PlanetType.TERRESTRIAL, 3);
		s3 = new Planet("Pluto", 10000, PlanetType.ICE_GIANT, 20);
		
		ArrayList<SolarObject> objects = new ArrayList<SolarObject>();
		objects.add(s1);
		objects.add(s2);
		objects.add(s3);
		
		displaySolarObjects(SearchUtil.searchByMoons(objects, 3));
		
		

	}
	
	public static void displaySolarObjects(ArrayList<SolarObject> list) {
		for(SolarObject object : list) {
			object.printDetails();
		}
	}

}
