package solarsystem;

import java.util.ArrayList;

public class SearchUtil {
	
	public static ArrayList<SolarObject> searchByMoons(ArrayList<SolarObject> list, int moons){
		
		if(list==null) {
			throw new IllegalArgumentException("List cant be null");
		} else {
		
		ArrayList<SolarObject> results = new ArrayList<SolarObject>();
		
		
		for(SolarObject object : list) {
			if(object instanceof Planet) {
				Planet p = (Planet)object;
				if(p.getMoons()==moons) {
					results.add(object);
				}
			}
		}
		
		return results;
		}
	}

}
