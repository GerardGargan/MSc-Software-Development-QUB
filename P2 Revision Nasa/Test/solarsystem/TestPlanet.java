package solarsystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPlanet {
	
	Planet planet;
	
	String validName, invalidName;
	double validDistance, invalidDistance;
	PlanetType planetTypeValid, planetTypeInvalid;
	int moonsValid, moonsInvalid;

	@BeforeEach
	void setUp() throws Exception {
		planet = new Planet();
		validName = "Earth";
		invalidName = "";
		
		validDistance = 1;
		invalidDistance = -1;
		
		planetTypeValid = PlanetType.GAS_GIANT;
		planetTypeInvalid = null;
		
		moonsValid = 1;
		moonsInvalid = -1;
		
	}

	@Test
	void testPlanet() {
		assertNotNull(planet);
	}

	@Test
	void testPlanetConstructorValid() {
		Planet p = new Planet(validName, validDistance, planetTypeValid, moonsValid);
		assertEquals(validName, p.getName());
		assertEquals(validDistance, p.getDistanceFromSun());
		assertEquals(validDistance, p.getDistanceFromSun());
		assertEquals(moonsValid, p.getMoons());
	}
	
	@Test
	void testPlanetConstructorInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Planet(invalidName, validDistance, planetTypeValid, moonsValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Planet(validName, invalidDistance, planetTypeValid, moonsValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Planet(validName, validDistance, planetTypeInvalid, moonsValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Planet(validName, validDistance, planetTypeValid, moonsInvalid);
		});
	}

	@Test
	void testGetSetMoonsValid() {
		planet.setMoons(moonsValid);
		assertEquals(moonsValid, planet.getMoons());
	}
	
	@Test
	void testGetSetMoonsInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			planet.setMoons(moonsInvalid);
		});
	}

	@Test
	void testGetSetPlanetTypeValid() {
		planet.setPlanetType(planetTypeValid);
		assertEquals(planetTypeValid, planet.getPlanetType());
	}
	
	@Test
	void testGetSetPlanetTypeInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			planet.setPlanetType(planetTypeInvalid);
		});
	}

	@Test
	void testGetSetNameValid() {
		planet.setName(validName);
		assertEquals(validName, planet.getName());
	}
	
	@Test
	void testGetSetNameInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			planet.setName(invalidName);
		});
	}

	@Test
	void testSetDistanceFromSunValid() {
		planet.setDistanceFromSun(validDistance);
		assertEquals(validDistance, planet.getDistanceFromSun());
	}
	@Test
	void testSetDistanceFromSunInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			planet.setDistanceFromSun(invalidDistance);
		});
	}

}
