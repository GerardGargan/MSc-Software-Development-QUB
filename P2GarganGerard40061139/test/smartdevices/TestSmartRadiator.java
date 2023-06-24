package smartdevices;

/**
 * 
 * @author ggargan
 * Gerard Gargan, Student number 40061139
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSmartRadiator {

	//create test data
	SmartRadiator radiator;

	String validName, invalidName, invalidName2;
	String validManufacturer, invalidManufacturer, invalidManufacturer2;

	Room roomHouse, roomKitchen, roomBedroom, roomBathroom, roomLounge, roomInvalid;
	PowerState powerOn, powerOff, powerInvalid;

	double tempNowValidLow, tempNowValidMid, tempNowValidHigh;
	double tempNowInvalidLow, tempNowInvalidHigh;

	double tempTargetValidLow, tempTargetValidMid, tempTargetValidHigh;
	double tempTargetInvalidLow, tempTargetInvalidHigh;

	@BeforeEach
	void setUp() throws Exception {

		//set up test data, instansiate the variables with data
		radiator = new SmartRadiator();

		validName = "name";
		invalidName = "xx";
		invalidName2 = "x".repeat(21);

		validManufacturer = "name";
		invalidManufacturer = "xx";
		invalidManufacturer2 = "x".repeat(21);

		roomHouse = Room.HOUSE;
		roomKitchen = Room.KITCHEN;
		roomBedroom = Room.BEDROOM;
		roomBathroom = Room.BATHROOM;
		roomLounge = Room.LOUNGE;
		roomInvalid = null;

		powerOn = PowerState.ON;
		powerOff = PowerState.OFF;
		powerInvalid = null;

		tempNowValidLow = -10;
		tempNowValidMid = 15;
		tempNowValidHigh = 30;

		tempNowInvalidLow = -11;
		tempNowInvalidHigh = 31;

		tempTargetValidLow = 5;
		tempTargetValidMid = 15;
		tempTargetValidHigh = 26;

		tempTargetInvalidLow = 4;
		tempTargetInvalidHigh = 27;
	}

	@Test
	void testStatus() {
		// SR-NAME-ROOM-NOW:X.X-TARGET:X.X-POWERSTATE
		// SR-%s-%s-NOW:%.1f-TARGET:%.1f-%s
		// must remove spaces and name be in upper case and follow the above format (1
		// decimal place for temps).
		SmartRadiator srad = new SmartRadiator("test name", "manutest", Room.BATHROOM, 10, 20);
		assertEquals("SR-TESTNAME-BATHROOM-NOW:10.0-TARGET:20.0-ON", srad.status());
	}

	@Test
	void testSmartRadiatorDefaultConstructor() {
		assertNotNull(radiator);
		assertEquals("default", radiator.getManufacturer());
		assertEquals("default", radiator.getName());
		assertEquals(Room.HOUSE, radiator.getRoom());
		assertEquals(PowerState.OFF, radiator.getPowerState());
		assertEquals(20, radiator.getTempNow());
		assertEquals(20, radiator.getTempTarget());
	}

	@Test
	void testSmartRadiatorConstructorArgsValid() {
		SmartRadiator s = new SmartRadiator(validName, validManufacturer, roomHouse, tempNowValidLow,
				tempTargetValidLow);
		assertEquals(validName, s.getName());
		assertEquals(validManufacturer, s.getManufacturer());
		assertEquals(roomHouse, s.getRoom());
		assertEquals(tempNowValidLow, s.getTempNow());
		assertEquals(tempTargetValidLow, s.getTempTarget());
	}

	@Test
	void testSmartRadiatorConstructorArgsInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new SmartRadiator(invalidName, validManufacturer, roomHouse, tempNowValidLow, tempTargetValidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new SmartRadiator(validName, invalidManufacturer, roomHouse, tempNowValidLow, tempTargetValidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new SmartRadiator(validName, validManufacturer, null, tempNowValidLow, tempTargetValidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new SmartRadiator(validName, validManufacturer, roomHouse, tempNowInvalidHigh, tempTargetValidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new SmartRadiator(validName, validManufacturer, roomHouse, tempNowValidLow, tempTargetInvalidLow);
		});
	}

	@Test
	void testSetGetTempNowValid() {
		radiator.setTempNow(tempNowValidLow);
		assertEquals(tempNowValidLow, radiator.getTempNow());

		radiator.setTempNow(tempNowValidMid);
		assertEquals(tempNowValidMid, radiator.getTempNow());

		radiator.setTempNow(tempNowValidHigh);
		assertEquals(tempNowValidHigh, radiator.getTempNow());

	}

	@Test
	void testSetGetTempNowInvalid() {

		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setTempNow(tempNowInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setTempNow(tempNowInvalidHigh);
		});
	}

	@Test
	void testSetGetTempTargetValid() {
		radiator.setTempTarget(tempTargetValidLow);
		assertEquals(tempTargetValidLow, radiator.getTempTarget());

		radiator.setTempTarget(tempTargetValidMid);
		assertEquals(tempTargetValidMid, radiator.getTempTarget());

		radiator.setTempTarget(tempTargetValidHigh);
		assertEquals(tempTargetValidHigh, radiator.getTempTarget());
	}

	@Test
	void testSetGetTempTargetInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setTempTarget(tempTargetInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setTempTarget(tempTargetInvalidHigh);
		});
	}

	@Test
	void testSetGetNameValid() {
		radiator.setName(validName);
		assertEquals(validName, radiator.getName());
	}

	@Test
	void testSetGetNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setName(invalidName);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setName(invalidName2);
		});
	}

	@Test
	void testSetGetManufacturerValid() {
		radiator.setManufacturer(validManufacturer);
		assertEquals(validManufacturer, radiator.getManufacturer());
	}

	@Test
	void testSetGetManufacturerInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setManufacturer(invalidManufacturer);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setManufacturer(invalidManufacturer2);
		});
	}

	@Test
	void testSetGetRoomValid() {
		radiator.setRoom(roomHouse);
		assertEquals(roomHouse, radiator.getRoom());

		radiator.setRoom(roomBathroom);
		assertEquals(roomBathroom, radiator.getRoom());

		radiator.setRoom(roomBedroom);
		assertEquals(roomBedroom, radiator.getRoom());

		radiator.setRoom(roomKitchen);
		assertEquals(roomKitchen, radiator.getRoom());

		radiator.setRoom(roomLounge);
		assertEquals(roomLounge, radiator.getRoom());
	}

	@Test
	void testSetRoomInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setRoom(roomInvalid);
		});
	}
 
	@Test
	void testSetPowerStateValid() {
		radiator.setPowerState(powerOn);
		assertEquals(powerOn, radiator.getPowerState());

		radiator.setPowerState(powerOff);
		assertEquals(powerOff, radiator.getPowerState());
	}

	@Test
	void testSetPowerStateInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			radiator.setPowerState(null);
		});
	}

	@Test
	void TestTempNowSetterPowerTrigger() {
		SmartRadiator s1 = new SmartRadiator("name", "name", Room.BATHROOM, 10, 20);
		assertEquals(PowerState.ON, s1.getPowerState());

		SmartRadiator s2 = new SmartRadiator("name", "name", Room.BATHROOM, 20, 10);
		assertEquals(PowerState.OFF, s2.getPowerState());

	}

}
