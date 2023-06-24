package toptrump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTopTrumpCard {

	TopTrumpCard card;
	String nameValidLow, nameValidMid, nameValidHigh;
	String nameInvalidLow, nameInvalidHigh;
	String imageValidLow, imageValidMid, imageValidHigh;
	String imageInvalidLow, imageInvalidHigh, imageInvalidExt;
	Category hero, villain, catInvalid;
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
		imageInvalidExt = "x.gif";

		hero = Category.HERO;
		villain = Category.VILLAIN;
		catInvalid = null;

		speedValidLow = 0;
		speedValidMid = 50;
		speedValidHigh = 100;
		speedInvalidLow = -1;
		speedInvalidHigh = 101;

		bioValid = "not null";
		bioInvalid = null;

		card = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, speedValidMid, speedValidMid,
				speedValidMid, speedValidMid, bioValid);
	}

	@Test
	void testTopTrumpCardConstructorValid() {
		TopTrumpCard cardConst = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		assertEquals(nameValidMid, cardConst.getName());
		assertEquals(nameValidMid, cardConst.getRealName());
		assertEquals(imageValidMid, cardConst.getImageFileName());
		assertEquals(hero, cardConst.getCategory());
		assertEquals(speedValidMid, cardConst.getSpeed());
		assertEquals(speedValidMid, cardConst.getStrength());
		assertEquals(speedValidMid, cardConst.getAgility());
		assertEquals(speedValidMid, cardConst.getIntelligence());
		assertEquals(bioValid, cardConst.getBio());
	}

	@Test
	void testTopTrumpCardConstructorInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameInvalidHigh, nameValidMid, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameInvalidHigh, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageInvalidExt, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, catInvalid, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedInvalidHigh, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedValidHigh, speedInvalidHigh, speedValidHigh, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedValidHigh, speedValidHigh, speedInvalidHigh, speedValidMid, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedValidHigh, speedValidHigh, speedValidHigh, speedInvalidHigh, bioValid);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedValidHigh, speedValidHigh, speedValidHigh, speedValidHigh, bioInvalid);
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
	void testSetImageFileNameValid() {
		card.setImageFileName(imageValidLow);
		assertEquals(imageValidLow, card.getImageFileName());

		card.setImageFileName(imageValidMid);
		assertEquals(imageValidMid, card.getImageFileName());

		card.setImageFileName(imageValidHigh);
		assertEquals(imageValidHigh, card.getImageFileName());
	}

	@Test
	void testSetImageFileNameInvalid() {
		assertThrows(IllegalArgumentException.class, () -> {
			card.setImageFileName(imageInvalidLow);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			card.setImageFileName(imageInvalidHigh);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			card.setImageFileName(imageInvalidExt);
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
			card.setSpeed(speedInvalidLow);
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
		TopTrumpCard c1 = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, 10, 20, 30, 40, bioValid);
		assertEquals(3, c1.getMaxStatID());

		TopTrumpCard c2 = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, 10, 70, 30, 40, bioValid);
		assertEquals(1, c2.getMaxStatID());
	}

	@Test
	void testGetStatScoreValid() {
		TopTrumpCard c1 = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, 10, 20, 30, 40, bioValid);
		assertEquals(30, c1.getStatScore(2));
		assertEquals(10, c1.getStatScore(0));
		assertEquals(40, c1.getStatScore(3));
	}

	@Test
	void testGetStatScoreInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			card.getStatScore(-1);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			card.getStatScore(4);
		});
		
		}

}
