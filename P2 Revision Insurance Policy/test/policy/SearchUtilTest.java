package policy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchUtilTest {

	MotorPolicy mp1, mp2, mp3, mp4, mp5;
	ArrayList<MotorPolicy> list;

	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<MotorPolicy>();
		mp1 = new MotorPolicy("validname", 18, MotorType.BUS);
		mp2 = new MotorPolicy("validname", 20, MotorType.CAR);
		mp3 = new MotorPolicy("validname", 50, MotorType.BUS);
		mp4 = new MotorPolicy("validname", 18, MotorType.TAXI);
		mp5 = new MotorPolicy("validname", 30, MotorType.CAR);
		list.add(mp1);
		list.add(mp2);
		list.add(mp3);
		list.add(mp4);
		list.add(mp5);
	}

	@Test
	void testSearchByAgeValid() {
		ArrayList<MotorPolicy> result = SearchUtil.searchByAge(list, 0, 20);
		assertTrue(result.size() == 3);
		assertTrue(result.contains(mp1));
		assertTrue(result.contains(mp4));
		assertTrue(result.contains(mp2));

		ArrayList<MotorPolicy> result2 = SearchUtil.searchByAge(list, 21, 22);
		assertTrue(result2.size() == 0);

	}

	@Test
	void testSearchByAgeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			SearchUtil.searchByAge(null, 10, 20);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			SearchUtil.searchByAge(list, -1, 20);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			SearchUtil.searchByAge(list, 0, 101);
		});

	}

	@Test
	void testSearchForAllByMotorPolicyTypeValid() {
		ArrayList<MotorPolicy> result = SearchUtil.searchForAllByMotorPolicyType(list, MotorType.BUS);
		assertTrue(result.size() == 2);
		assertTrue(result.contains(mp1));
		assertTrue(result.contains(mp3));
	}

	@Test
	void testSearchForAllByMotorPolicyTypeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			SearchUtil.searchForAllByMotorPolicyType(null, MotorType.BUS);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			SearchUtil.searchForAllByMotorPolicyType(list, null);
		});
	}

}
