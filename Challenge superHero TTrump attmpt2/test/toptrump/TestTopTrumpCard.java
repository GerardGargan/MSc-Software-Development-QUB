package toptrump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTopTrumpCard {

	TopTrumpCard card, c1, c2, c3;

	String nameValidLow, nameValidMid, nameValidHigh;
	String nameInvalidLow, nameInvalidHigh;

	String imageValidLow, imageValidMid, imageValidHigh;
	String imageInvalidLow, imageInvalidHigh, imageInvalidExt, imageInvalidSpace;

	Category hero, villain;
	Category catInvalid;

	int speedValidLow, speedValidMid, speedValidHigh;
	int speedInvalidLow, speedInvalidHigh;

	String bioValid, bioInvalid;

	@BeforeEach
	void setUp() throws Exception {
		nameValidLow = "x";
		nameValidMid = "x".repeat(15);
		nameValidHigh = "x".repeat(30);

		nameInvalidLow = "";
		nameInvalidHigh = "x".repeat(31);

		imageValidLow = "x.jpg";
		imageValidMid = "x".repeat(15) + ".jpg";
		imageValidHigh = "x".repeat(26) + ".jpg";

		imageInvalidLow = ".jpg";
		imageInvalidHigh = "x".repeat(27) + ".jpg";
		imageInvalidSpace = "xx x.jpg";
		imageInvalidExt = "xxxx.gif";

		speedValidLow = 0;
		speedValidMid = 50;
		speedValidHigh = 100;

		speedInvalidLow = -1;
		speedInvalidHigh = 101;

		bioValid = "This is my bio";
		bioInvalid = null;

		hero = Category.HERO;
		villain = Category.VILLAIN;
		catInvalid = null;

		card = new TopTrumpCard(nameValidMid, imageValidMid, hero, imageValidMid, speedValidMid, speedValidMid,
				speedValidMid, speedValidMid, bioValid);
		c1 = new TopTrumpCard(nameValidMid, nameValidMid, hero, imageValidMid, 10, 20, 30, 40, bioValid);
		c2 = new TopTrumpCard(nameValidMid, nameValidMid, hero, imageValidMid, 90, 20, 40, 30, bioValid);
		c3 = new TopTrumpCard(nameValidMid, nameValidMid, hero, imageValidMid, 91, 99, 40, 30, bioValid);
	}

	@Test
	void testConstructorValid() {
		TopTrumpCard cardconst = new TopTrumpCard(nameValidLow, nameValidLow, hero, imageValidLow, speedValidLow,
				speedValidLow, speedValidLow, speedValidLow, bioValid);
		assertEquals(nameValidLow, cardconst.getName());
		assertEquals(nameValidLow, cardconst.getRealName());
		assertEquals(Category.HERO, cardconst.getCategory());
		assertEquals(imageValidLow, cardconst.getImage());
		assertEquals(speedValidLow, cardconst.getSpeed());
		assertEquals(bioValid, cardconst.getBio());
	}

	@Test
	void testConstructorInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			new TopTrumpCard(nameInvalidLow, nameValidMid, hero, imageValidMid, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new TopTrumpCard(nameValidMid, nameInvalidLow, hero, imageValidMid, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new TopTrumpCard(nameValidMid, nameValidMid, catInvalid, imageValidMid, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new TopTrumpCard(nameValidMid, nameValidMid, hero, imageInvalidHigh, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new TopTrumpCard(nameValidMid, nameValidMid, hero, imageValidMid, speedInvalidLow, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			new TopTrumpCard(nameValidMid, nameValidMid, hero, imageValidMid, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioInvalid);
		});
	}

	@Test
	void testSetNameValid() {
		card.setName(nameValidLow);
		assertEquals(nameValidLow, card.getName());

		card.setName(nameValidMid);
		assertEquals(nameValidMid, card.getName());

		card.setName(nameValidHigh);
		assertEquals(nameValidHigh, card.getName());
	}

	@Test
	void testSetNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			card.setName(nameInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			card.setName(nameInvalidHigh);
		});
	}

	@Test
	void testSetRealNameValid() {
		card.setRealName(nameValidLow);
		assertEquals(nameValidLow, card.getRealName());

		card.setRealName(nameValidMid);
		assertEquals(nameValidMid, card.getRealName());

		card.setRealName(nameValidHigh);
		assertEquals(nameValidHigh, card.getRealName());
	}

	@Test
	void testSetRealNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			card.setRealName(nameInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			card.setRealName(nameInvalidHigh);
		});
	}

	@Test
	void testSetCategoryValid() {
		card.setCategory(hero);
		assertEquals(hero, card.getCategory());

		card.setCategory(villain);
		assertEquals(villain, card.getCategory());
	}

	@Test
	void testSetCategoryInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			card.setCategory(catInvalid);
		});
	}

	@Test
	void testSetSpeedValid() {
		card.setSpeed(speedValidLow);
		assertEquals(speedValidLow, card.getSpeed());

		card.setSpeed(speedValidMid);
		assertEquals(speedValidMid, card.getSpeed());

		card.setSpeed(speedValidHigh);
		assertEquals(speedValidHigh, card.getSpeed());
	}

	@Test
	void testSetSpeedInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			card.setSpeed(speedInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			card.setSpeed(speedInvalidHigh);
		});
	}

	@Test
	void testSetBioValid() {
		card.setBio(bioValid);
		assertEquals(bioValid, card.getBio());
	}

	@Test
	void testSetBioInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			card.setBio(bioInvalid);
		});
	}

	@Test
	void testGetMaxStatIDValid() {

		assertEquals(3, c1.getMaxStatID());
		assertEquals(0, c2.getMaxStatID());
		assertEquals(1, c3.getMaxStatID());
	}

	@Test
	void testGetStatScoreValid() {
		assertEquals(10, c1.getStatScore(0));

		assertEquals(30, c2.getStatScore(3));

		assertEquals(99, c3.getStatScore(1));
	}

	@Test
	void testGetStatScoreInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			c1.getStatScore(4);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			c1.getStatScore(-1);
		});
	}

}
