package hospital;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testPorter {

	Porter porter;
	String siteValid, siteInvalid;

	String firstNameValid, firstNameInvalid;
	String lastNameValid, lastNameInvalid;
	double baseRateValid, baseRateInvalid;
	double salaryValid, salaryInvalid;

	@BeforeEach
	void setUp() throws Exception {
		porter = new Porter();
		firstNameValid = "Name";
		firstNameInvalid = "";

		lastNameValid = "Name";
		lastNameInvalid = "";

		baseRateValid = Employee.MIN_RATE;
		baseRateInvalid = Employee.MIN_RATE - 0.1;

		salaryValid = 1;
		salaryInvalid = -1;

		siteValid = "Royal";

	}

	@Test
	void testCalculateSalaryValid() {
		porter.calculateSalary(salaryValid);
		assertEquals(salaryValid * porter.getBaseRate(), porter.calculateSalary(salaryValid));
	}

	@Test
	void testCalculateSalaryinValid() {
		assertThrows(IllegalArgumentException.class, () -> {
			porter.calculateSalary(salaryInvalid);
		});
	}

	@Test
	void testPorter() {
		assertNotNull(porter);
		assertEquals("DefaultName", porter.getFirstName());
		assertEquals("DefaultLastName", porter.getLastName());
		assertEquals(0.0, porter.getBaseRate());
	}

	@Test
	void testPorterConstructorWithArgsValid() {
		Porter p1 = new Porter(firstNameValid, lastNameValid, baseRateValid, siteValid);
		assertEquals(firstNameValid, p1.getFirstName());
		assertEquals(lastNameValid, p1.getLastName());
		assertEquals(baseRateValid, p1.getBaseRate());
		assertEquals(siteValid, p1.getSite());
	}

	@Test
	void testPorterConstructorWithArgsInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Porter(firstNameInvalid, lastNameValid, baseRateValid, siteValid);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Porter(firstNameValid, lastNameInvalid, baseRateValid, siteValid);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new Porter(firstNameValid, lastNameValid, baseRateInvalid, siteValid);
		});

	}

	@Test
	void testSetGetSite() {
		porter.setSite(siteValid);
		assertEquals(siteValid, porter.getSite());
	}

	@Test
	void testSetGetFirstName() {
		porter.setFirstName(firstNameValid);
		assertEquals(firstNameValid, porter.getFirstName());
	}

	@Test
	void testSetGetFirstNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			porter.setFirstName(firstNameInvalid);
		});
	}

	@Test
	void testSetLastNameValid() {
		fail("Not yet implemented");
	}

	@Test
	void testSetBaseRateValid() {
		porter.setBaseRate(baseRateValid);
		assertEquals(baseRateValid, porter.getBaseRate());
	}

	@Test
	void testSetBaseRateInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			porter.setBaseRate(baseRateInvalid);
		});
	}

}
