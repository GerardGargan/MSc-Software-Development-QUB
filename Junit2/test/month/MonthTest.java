package month;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthTest {
	
	int monthValidLow, monthValidMid, monthValidHigh;
	int monthInvalidLow, monthInvalidHigh;

	@BeforeEach
	void setUp() throws Exception {
		monthValidLow = 1;
		monthValidMid = 6;
		monthValidHigh = 12;
		
		monthInvalidHigh = 12;
		monthInvalidLow = 0;
	}

	@Test
	void testNumToMonthValid() {
		assertEquals("January", Month.numToMonth(monthValidLow));
		assertEquals("June", Month.numToMonth(monthValidMid));
		assertEquals("December", Month.numToMonth(monthValidHigh));
	}
	
	@Test
	void testNumToMonthInvalid() {
		Exception exp = assertThrows(NumberFormatException.class, ()->{
			Month.numToMonth(monthInvalidLow);
		});
		
		Exception exp2 = assertThrows(NumberFormatException.class, ()->{
			Month.numToMonth(monthInvalidLow);
		});
		
		assertEquals("Invalid month number", exp.getMessage());
		assertEquals("Invalid month number", exp2.getMessage());
	}

}
