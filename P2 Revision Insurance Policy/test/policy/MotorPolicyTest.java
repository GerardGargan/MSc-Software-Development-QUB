package policy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MotorPolicyTest {

	MotorPolicy mp;
	String surnameValidLow, surnameValidMid, surnameValidHigh;
	String surnameInvalidLow, surnameInvalidHigh;

	int ageValidLow, ageValidMid, ageValidHigh;
	int ageInvalidLow, ageInvalidHigh;

	MotorType motorTypeValid1, motorTypeValid2, motorTypeValid3, motorTypeInvalid;

	@BeforeEach
	void setUp() throws Exception {
		mp = new MotorPolicy();

		surnameValidLow = "x".repeat(3);
		surnameValidMid = "x".repeat(10);
		surnameValidHigh = "x".repeat(20);

		surnameInvalidLow = "x".repeat(2);
		surnameInvalidHigh = "x".repeat(21);

		ageValidLow = 18;
		ageValidMid = 30;
		ageValidHigh = 50;

		ageInvalidHigh = 51;
		ageInvalidLow = 17;

		motorTypeValid1 = MotorType.BUS;
		motorTypeValid2 = MotorType.CAR;
		motorTypeValid3 = MotorType.TAXI;

	}

	@Test
	void testMotorPolicy() {
		assertNotNull(mp);
		assertEquals("default", mp.getSurname());
		assertEquals(-1, mp.getAge());
		assertEquals("default", mp.getMotorPolicyId());
		assertEquals(null, mp.getMotorType());
	}

	@Test
	void testMotorPolicyConstructorArgsValid() {
		MotorPolicy m = new MotorPolicy(surnameValidHigh, ageValidHigh, motorTypeValid1);
		assertEquals(surnameValidHigh, m.getSurname());
		assertEquals(ageValidHigh, m.getAge());
		assertEquals(motorTypeValid1, m.getMotorType());
		assertNotNull(m.getMotorPolicyId());
	}

	@Test
	void testMotorPolicyConstructorArgsInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			 new MotorPolicy(surnameInvalidHigh, ageValidHigh, motorTypeValid1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			 new MotorPolicy(surnameValidHigh, ageInvalidHigh, motorTypeValid1);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			 new MotorPolicy(surnameValidHigh, ageValidHigh, motorTypeInvalid);
		});

	}

	@Test
	void testSetMotorTypeValid() {
		mp.setMotorType(motorTypeValid1);
		assertEquals(motorTypeValid1, mp.getMotorType());

		mp.setMotorType(motorTypeValid2);
		assertEquals(motorTypeValid2, mp.getMotorType());

		mp.setMotorType(motorTypeValid3);
		assertEquals(motorTypeValid3, mp.getMotorType());
	}

	@Test
	void testSetMotorTypeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setMotorType(motorTypeInvalid);
		});
	}

	@Test
	void testMotorPolicyId() {
		MotorPolicy motor = new MotorPolicy(surnameValidHigh, ageValidHigh, motorTypeValid1);
		String sur = "xxx";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		int timestamp = year + month;
		int parity = (timestamp % 2 == 0) ? 0 : 1;
		String expected = sur + timestamp + parity;
		assertEquals(expected, motor.getMotorPolicyId());
	}

	@Test
	void testSetSurnameValid() {
		mp.setSurname(surnameValidLow);
		assertEquals(surnameValidLow, mp.getSurname());

		mp.setSurname(surnameValidMid);
		assertEquals(surnameValidMid, mp.getSurname());

		mp.setSurname(surnameValidHigh);
		assertEquals(surnameValidHigh, mp.getSurname());
	}

	@Test
	void testSetSurnameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setSurname(surnameInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			mp.setSurname(surnameInvalidHigh);
		});
	}

	@Test
	void testSetAgeValid() {
		mp.setAge(ageValidLow);
		assertEquals(ageValidLow, mp.getAge());

		mp.setAge(ageValidMid);
		assertEquals(ageValidMid, mp.getAge());

		mp.setAge(ageValidHigh);
		assertEquals(ageValidHigh, mp.getAge());
	}

	@Test
	void testSetAgeInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			mp.setAge(ageInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			mp.setAge(ageInvalidHigh);
		});

	}

}
