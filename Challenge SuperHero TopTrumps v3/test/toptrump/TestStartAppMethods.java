package toptrump;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStartAppMethods {
	TopTrumpCard c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
	List<TopTrumpCard> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list = new ArrayList<TopTrumpCard>();
		
		c1 = new TopTrumpCard("Gerard", "Gerry", "test.jpg", Category.HERO, 10, 40, 20, 99, "Hi im gerry");
		c2 = new TopTrumpCard("SpiderMan", "Peter Parker", "test.jpg", Category.HERO, 10, 40, 20, 99, "Hi im gerry");
		c3 = new TopTrumpCard("Bat Man", "Dunno", "test.jpg", Category.VILLAIN, 10, 40, 20, 99, "Hi im gerry");
		c4 = new TopTrumpCard("Fat Man", "Gerard again", "test.jpg", Category.HERO, 10, 40, 20, 99, "Hi im gerry");
		c5 = new TopTrumpCard("Capt Amer", "No idea", "test.jpg", Category.HERO, 10, 40, 20, 99, "Hi im gerry");
		c6 = new TopTrumpCard("Who else", "Gerry", "test.jpg", Category.VILLAIN, 10, 40, 20, 99, "Hi im gerry");
		c7 = new TopTrumpCard("Rayment", "Drain", "test.jpg", Category.HERO, 10, 40, 20, 99, "Hi im gerry");
		c8 = new TopTrumpCard("Not sure", "Gerry", "test.jpg", Category.HERO, 10, 40, 20, 99, "Hi im gerry");
		c9 = new TopTrumpCard("Jerry", "Maguire", "test.jpg", Category.VILLAIN, 10, 40, 20, 99, "Hi im gerry");
		c10 = new TopTrumpCard("Jerry", "Maguire", "test.jpg", Category.VILLAIN, 10, 40, 20, 99, "Hi im gerry");
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		list.add(c7);
		list.add(c8);
		list.add(c9);
		list.add(c10);
	}

	@Test
	void testRemoveDupes() {
		fail("Not yet implemented");
	}

	@Test
	void testFindDupes() {
		List<TopTrumpCard> dupes = StartApp.findDupes(list);
		assertTrue(dupes.size()==1);
		assertTrue(dupes.contains(c9));
		
	}

	@Test
	void testSearchByAgility() {
		//
	}

	@Test
	void testTopXbyComparison() {
		fail("Not yet implemented");
	}

	@Test
	void testSearchByCat() {
		fail("Not yet implemented");
	}

}
