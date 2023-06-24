package solarsystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSearch {
	
	SolarObject s1,s2,s3;
	ArrayList<SolarObject> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<SolarObject>();
		s1 = new Planet("Earth", 100, PlanetType.ICE_GIANT, 1);
		s2 = new Planet("Mars", 200, PlanetType.GAS_GIANT, 2);
		s3 = new Planet("Earth", 100, PlanetType.ICE_GIANT, 1);
		s3 = new Planet("Earth", 100, PlanetType.ICE_GIANT, 0);
		list.add(s1);
		list.add(s2);
		list.add(s3);
	}

	@Test
	void testSearchByMoonsValid() {
		ArrayList<SolarObject> results = SearchUtil.searchByMoons(list, 1);
		assertTrue(results.size()==2);
		assertTrue(results.contains(s1));
		assertTrue(results.contains(s2));
	}

}
