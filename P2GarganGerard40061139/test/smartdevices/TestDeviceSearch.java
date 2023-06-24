package smartdevices;

/**
 * 
 * @author ggargan
 * Gerard Gargan, Student number 40061139
 */
 
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeviceSearch {
	//create test data and array list
	ArrayList<SmartRadiator> list;
	SmartRadiator s1, s2, s3, s4, s5;

	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<SmartRadiator>();
		
		//create the objects and test data

		s1 = new SmartRadiator("name", "manu", Room.BATHROOM, 30, 20);
		s2 = new SmartRadiator("name", "manu", Room.BEDROOM, 20, 20);
		s3 = new SmartRadiator("name", "manu", Room.HOUSE, 10, 20);
		s4 = new SmartRadiator("name", "manu", Room.BATHROOM, 5, 20);
		s5 = new SmartRadiator("name", "manu", Room.LOUNGE, 0, 20);

		//add to array list to be passed in
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
	}

	@Test
	void testSearchByRoomValid() {
		ArrayList<SmartRadiator> results = DeviceSearch.searchByRoom(list, Room.BATHROOM);
		assertTrue(results.size() == 2);
		assertTrue(results.contains(s1));
		assertTrue(results.contains(s4));

		ArrayList<SmartRadiator> results2 = DeviceSearch.searchByRoom(list, Room.LOUNGE);
		assertTrue(results2.size() == 1);
		assertTrue(results2.contains(s5));

		ArrayList<SmartRadiator> results3 = DeviceSearch.searchByRoom(list, Room.KITCHEN);
		assertTrue(results3.size() == 0);

	}

	@Test
	void testSearchByRoomInvalid() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
			DeviceSearch.searchByRoom(null, Room.BATHROOM);
		});

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
			DeviceSearch.searchByRoom(list, null);
		});

		assertEquals("List cannot be null", e1.getMessage());
		assertEquals("room cannot be null", e2.getMessage());

	}

	@Test
	void testSearchByTempValid() {
		ArrayList<SmartRadiator> result = DeviceSearch.searchByTemp(list, 10, 20);
		assertTrue(result.size() == 2);
		assertTrue(result.contains(s3));
		assertTrue(result.contains(s2));

		ArrayList<SmartRadiator> result2 = DeviceSearch.searchByTemp(list, 0, 5);
		assertTrue(result2.size() == 2);
		assertTrue(result2.contains(s4));
		assertTrue(result2.contains(s5));
	}

	@Test
	void testSearchByTempInvalid() {
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> {
			DeviceSearch.searchByTemp(null, 0, 10);
		});

		Exception e2 = assertThrows(IllegalArgumentException.class, () -> {
			DeviceSearch.searchByTemp(list, -21, 10);
		});

		Exception e3 = assertThrows(IllegalArgumentException.class, () -> {
			DeviceSearch.searchByTemp(list, -20, 51);
		});

		Exception e4 = assertThrows(IllegalArgumentException.class, () -> {
			DeviceSearch.searchByTemp(list, -21, 51);
		});

		assertEquals("list cannot be null", e1.getMessage());
		assertEquals("Temp values are out of range, must be between -20 and 50", e2.getMessage());
		assertEquals("Temp values are out of range, must be between -20 and 50", e3.getMessage());
		assertEquals("Temp values are out of range, must be between -20 and 50", e4.getMessage());
	}

}
