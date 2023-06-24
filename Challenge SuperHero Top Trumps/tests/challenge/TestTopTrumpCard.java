package challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTopTrumpCard {
	
	TopTrumpCard card;
	
	String nameValidLow, nameValidMid, nameValidHigh;
	String nameInvalidLow, nameInvalidHigh;
	
	String imageValidLow, imageValidMid, imageValidHigh;
	String imageInvalidLow, imageInvalidHigh, imageInvalidSpaces, imageInvalidExt;
	
	Category catHero,catVillain,catInvalid;
	
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
		imageValidMid = "x".repeat(11)+".jpg";
		imageValidHigh = "x".repeat(26)+".jpg";
		
		imageInvalidLow = ".jpg";
		imageInvalidHigh = "x".repeat(27)+".jpg";
		imageInvalidExt = "xx.gif";
		imageInvalidSpaces = "file name.jpg";	
		
		catHero = Category.HERO;
		catVillain = Category.VILLAIN;
		catInvalid = null;
		
		speedValidLow = 0;
		speedValidMid = 50;
		speedInvalidHigh = 100;
		
		speedInvalidLow = -1;
		speedInvalidHigh = 101;
		
		bioValid = "x".repeat(10);
		bioInvalid = null;
		card = new TopTrumpCard(nameValidMid, nameValidMid, imageValidMid, catHero, speedValidMid, speedValidMid, speedValidMid, speedValidMid, bioValid);
	}

	@Test
	void testTopTrumpCardConstructorValid() {
		fail("Not yet implemented");
	}
	
	@Test
	void testTopTrumpCardConstructorInvalid() {
		fail("Not yet implemented");
	}


	@Test
	void testSetNameVaid() {
		card.setName(nameValidLow);
		assertEquals(nameValidLow, card.getName());
		
		card.setName(nameValidMid);
		assertEquals(nameValidMid, card.getName());
		
		card.setName(nameValidHigh);
		assertEquals(nameValidHigh, card.getName());
	}
	
	@Test
	void testSetNameInvalid() {
		assertThrows(IllegalArgumentException.class, ()-> {
			card.setName(nameInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()-> {
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
		Exception e1 = assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(imageInvalidExt);
		});
		
		assertEquals("invalid file extension, must be .jpg", e1.getMessage());
		
		Exception e2 = assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(imageInvalidSpaces);
		});
		
		assertEquals("image file name cannot contain spaces", e2.getMessage());
		
		Exception e3 = assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(imageInvalidLow);
		});
		
		assertEquals("image file name invalid length", e3.getMessage());
		
		Exception e4 = assertThrows(IllegalArgumentException.class, ()->{
			card.setImageFileName(imageInvalidHigh);
		});
		
		assertEquals("image file name invalid length", e4.getMessage());
		
		
	}

	@Test
	void testSetCategoryValid() {
		card.setCategory(catHero);
		assertEquals(catHero, card.getCategory());
		
		card.setCategory(catVillain);
		assertEquals(catVillain, card.getCategory());
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
		
		card.setSpeed(speedValidMid);
		assertEquals(speedValidMid, card.getSpeed());
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
	void testGetMaxStatIDValid() {
		TopTrumpCard card1 = new TopTrumpCard(nameValidLow, nameValidHigh, imageValidLow, catHero, 1, 10, 20, 30, bioValid);
		assertEquals(3, card1.getMaxStatID());
		
		card1.setSpeed(40);
		assertEquals(0, card1.getMaxStatID());
		
		card1.setStrength(60);
		assertEquals(1, card1.getMaxStatID());
		
		//need to think more carefully if two are equal, how to process? currently returning a -1
		card1.setSpeed(60);
		assertEquals(-1, card1.getMaxStatID());
	}
	

	@Test
	void testGetStatScoreValid() {
		TopTrumpCard card2 = new TopTrumpCard(nameValidLow, nameValidHigh, imageValidLow, catHero, 20, 30, 40, 50, bioValid);
		assertEquals(20, card2.getStatScore(0));
		assertEquals(30, card2.getStatScore(1));
		assertEquals(40, card2.getStatScore(2));
		assertEquals(50, card2.getStatScore(3));
	}
	
	@Test
	void testGetStatScoreInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			card.getStatScore(4);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			card.getStatScore(-1);
		});
	}
	
	

}
