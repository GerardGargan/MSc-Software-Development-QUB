package p3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author GarganGerard - 40061139
 */
class TestAccomodation {

	Accommodation accom;
	String nameValidLow, nameValidHigh;
	String nameInvalidNull, nameInvalidLow;

	Type hotel, hostel, bnb;
	Type typeInvalid;

	int starsValidLow, starsValidMid, starsValidHigh;
	int starsInvalidLow, starsInvalidHigh;

	String cityValidLow, cityValidHigh;
	String cityInvalidNull, cityInvalidLow;

	double priceValidLow, priceValidHigh;
	double priceInvalidNegative;

	int roomsValidLow, roomsValidHigh;
	int roomsInvalidNegative;

	@BeforeEach
	void setUp() throws Exception {
		nameValidLow = "x";
		// doing a high as well to set the value to initially, so we can make sure there
		// is a change when we set the low value & to ensure it also doesnt fail
		nameValidHigh = "x".repeat(10);
		nameInvalidNull = null;
		nameInvalidLow = "";

		hotel = Type.HOTEL;
		hostel = Type.HOSTEL;
		bnb = Type.BNB;
		typeInvalid = null;

		starsValidLow = 1;
		starsValidMid = 3;
		starsValidHigh = 5;
		starsInvalidLow = 0;
		starsInvalidHigh = 6;

		cityValidLow = "x";
		// doing a high as well to set the value to initially, so we can make sure there
		// is a change when we set the low value & to ensure it also doesnt fail
		cityValidHigh = "x".repeat(10);
		cityInvalidNull = null;
		cityInvalidLow = "";

		priceValidLow = 0.0;
		// doing a high as well to set the value to initially, so we can make sure there
		// is a change when we set the low value & to ensure it also doesnt fail
		priceValidHigh = 1000.00;
		priceInvalidNegative = -0.01;

		roomsValidLow = 0;
		// doing a high as well to set the value to initially, so we can make sure there
		// is a change when we set the low value & to ensure it also doesnt fail
		roomsValidHigh = 100;
		roomsInvalidNegative = -1;

		// setting to value which will change based on the first tests implemented (e.g.
		// if it was set to low, thenw e test low we dont know if it actually changed)
		accom = new Accommodation(nameValidHigh, bnb, starsValidMid, cityValidHigh, priceValidHigh, roomsValidHigh);

	}

	@Test
	void testAccommodationConstructorValid() {
		Accommodation a1 = new Accommodation(nameValidLow, bnb, starsValidMid, cityValidLow, priceValidLow,
				roomsValidLow);
		assertEquals(nameValidLow, a1.getName());
		assertEquals(bnb, a1.getType());
		assertEquals(starsValidMid, a1.getStars());
		assertEquals(cityValidLow, a1.getCity());
		assertEquals(priceValidLow, a1.getPrice());
		assertEquals(roomsValidLow, a1.getRooms());
	}

	@Test
	void testAccommodationConstructorInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Accommodation(nameInvalidLow, bnb, starsValidLow, cityValidLow, priceValidLow, roomsValidLow);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Accommodation(nameValidHigh, typeInvalid, starsValidLow, cityValidLow, priceValidLow, roomsValidLow);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Accommodation(nameValidHigh, bnb, starsInvalidLow, cityValidLow, priceValidLow, roomsValidLow);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Accommodation(nameValidHigh, bnb, starsValidLow, cityInvalidLow, priceValidLow, roomsValidLow);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Accommodation(nameValidHigh, bnb, starsValidLow, cityValidLow, priceInvalidNegative, roomsValidLow);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Accommodation(nameValidHigh, bnb, starsValidLow, cityValidLow, priceValidLow, roomsInvalidNegative);
		});
	}

	@Test
	void testGetSetStarsValid() {
		accom.setStars(starsValidLow);
		assertEquals(starsValidLow, accom.getStars());

		accom.setStars(starsValidMid);
		assertEquals(starsValidMid, accom.getStars());

		accom.setStars(starsValidHigh);
		assertEquals(starsValidHigh, accom.getStars());
	}

	@Test
	void testGetSetStarsInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			accom.setStars(starsInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			accom.setStars(starsInvalidHigh);
		});
	}

}
