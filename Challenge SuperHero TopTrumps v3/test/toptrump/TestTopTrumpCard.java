package toptrump;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTopTrumpCard {
	
	TopTrumpCard card, c1, c2, c3;
	
	String nameValidLow, nameValidMid, nameValidHigh;
	String nameInvalidLow, nameInvalidHigh, nameNull;
	
	String imageValidLow, imageValidMid, imageValidHigh;
	String imageInvalidLow, imageInvalidHigh, imageInvalidExt, imageInvalidSpaces;
	
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
		nameNull = null;
		
		imageValidLow = "x.jpg";
		imageValidMid = "x".repeat(15)+".jpg";
		imageValidHigh = "x".repeat(25)+".jpg";
		imageInvalidLow = ".jpg";
		imageInvalidHigh = "x".repeat(27)+".jpg";
		imageInvalidExt = "x.gif";
		imageInvalidSpaces = "x .jpg";
		
		hero = Category.VILLAIN;
		villain = Category.VILLAIN;
		catInvalid = null;
		
		speedValidLow = 0;
		speedValidMid = 50;
		speedValidHigh = 100;
		speedInvalidLow = -1;
		speedInvalidHigh = 101;
		
		bioValid = "";
		bioInvalid = null;
		
		card = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		c1 = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, 10, 20, 30, 40, bioValid);
		c2 = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, 70, 20, 30, 40, bioValid);
		c3 = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, hero, 20, 3, 90, 91, bioValid);
	}

	@Test
	void testTopTrumpCardConstructorValid() {
		TopTrumpCard constValid = new TopTrumpCard(nameValidMid, nameValidLow, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		assertEquals(nameValidMid, constValid.getName());
		assertEquals(nameValidLow, constValid.getRealName());
		assertEquals(imageValidMid, constValid.getImage());
		assertEquals(hero, constValid.getCategory());
		assertEquals(speedValidMid, constValid.getSpeed());
		assertEquals(bioValid, constValid.getBio());
		
	}
	
	@Test
	void testTopTrumpCardConstructorInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameInvalidLow, nameValidMid, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameInvalidLow, imageValidMid, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageInvalidLow, hero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, catInvalid, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedInvalidHigh, speedValidMid, speedValidMid, speedValidMid, bioValid);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new TopTrumpCard(nameValidMid, nameValidHigh, imageValidHigh, hero, speedValidHigh, speedValidMid, speedValidMid, speedValidMid, bioInvalid);
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
		assertThrows(IllegalArgumentException.class, ()->{
			card.setName(nameNull);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.setName(nameInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
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
		assertThrows(IllegalArgumentException.class, ()->{
			card.setRealName(nameInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.setRealName(nameInvalidHigh);
		});
	}

	@Test
	void testSetImageValid() {
		card.setImage(imageValidLow);
		assertEquals(imageValidLow, card.getImage());
		
		card.setImage(imageValidMid);
		assertEquals(imageValidMid, card.getImage());
		
		card.setImage(imageValidHigh);
		assertEquals(imageValidHigh, card.getImage());
		
	}
	
	@Test
	void testSetImageInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImage(imageInvalidExt);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImage(imageInvalidSpaces);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImage(imageInvalidLow);
		});
		
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.setImage(imageInvalidHigh);
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
		assertThrows(IllegalArgumentException.class, ()->{
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
		assertThrows(IllegalArgumentException.class, ()->{
			card.setSpeed(speedInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
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
		assertThrows(IllegalArgumentException.class, ()->{
			card.setBio(bioInvalid);
		});
	}

	@Test
	void testGetAvgValid() {
		assertEquals(50, card.getAvg());
		assertEquals(25, c1.getAvg());
		assertEquals(51, c3.getAvg());
	}
	

	@Test
	void testGetMaxStatIdValid() {
		assertEquals(3, c1.getMaxStatID());
		assertEquals(0, c2.getMaxStatID());
		assertEquals(3, c3.getMaxStatID());
	}
	
	
	@Test
	void testGetStatScoreValid() {
		assertEquals(10, c1.getStatScore(0));
		assertEquals(30, c2.getStatScore(2));
		assertEquals(91, c3.getStatScore(3));
	}
	
	@Test
	void testGetStatScoreInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			c1.getStatScore(-1);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			c1.getStatScore(4);
		});
	}

}
