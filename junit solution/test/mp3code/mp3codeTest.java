package mp3code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class mp3codeTest {
	
//	private int ref;
//	private String artist;
//	private String songName;
//	private int rating;
	
	int refValid, refInvalid;
	String artistValid;
	String songNameValid;
	int ratingValidLow, ratingValidMid, ratingValidHigh;
	int ratingInvalidLow, ratingInvalidHigh;
	
	int lengthValidLow, lengthValidMid, lengthValidHigh;
	int lengthInvalidLow, lengthInvalidHigh;
	
	Mp3 song;
	

	@BeforeEach
	void setUp() throws Exception {
		refValid = 1;
		refInvalid = -1;
		
		artistValid = "Jimmy";
		songNameValid = "Welcome to the jungle";
		
		ratingValidLow = 0;
		ratingValidMid = 2;
		ratingValidHigh = 5;
		
		ratingInvalidLow = -1;
		ratingInvalidHigh = 6;
		
		lengthInvalidLow = -1;
		lengthInvalidHigh = 2501;
		
		lengthValidLow = 1;
		lengthValidMid = 1000;
		lengthValidHigh = 2499;
		
		song = new Mp3();
	}
	
	@Test
	void testLengthValid() {
		song.setLength(lengthValidLow);
		assertEquals(lengthValidLow, song.getLength());
		
		song.setLength(lengthValidMid);
		assertEquals(lengthValidMid, song.getLength());
		
		song.setLength(lengthValidHigh);
		assertEquals(lengthValidHigh, song.getLength());
	}
	
	@Test
	void testLEngthInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			song.setLength(lengthInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			song.setLength(lengthInvalidHigh);
		});
	}

	@Test
	void testMp3ConstructorValid() {
		Mp3 songs = new Mp3(refValid, artistValid, songNameValid, ratingValidMid, lengthValidHigh);
		assertNotNull(songs);
		assertEquals(refValid, songs.getRef());
		assertEquals(artistValid, songs.getArtist());
		assertEquals(songNameValid, songs.getSongName());
		assertEquals(ratingValidMid, songs.getRating());
		assertEquals(lengthValidHigh, songs.getLength());
	}
	
	@Test
	void TestMp3ConstructorInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			new Mp3(refInvalid, artistValid, songNameValid, ratingValidMid,lengthValidHigh);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Mp3(refValid, artistValid, artistValid, ratingInvalidLow,lengthValidHigh);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Mp3(refValid, artistValid, songNameValid, ratingValidLow, lengthInvalidLow);
		});
	}

	@Test
	void testSetGetRefValid() {
		song.setRef(refValid);
		assertEquals(refValid, song.getRef());
	}

	@Test
	void testSetRefInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			song.setRef(refInvalid);
		});
		assertEquals("Ref less than 0", exp.getMessage());
	}

	@Test
	void testGetSetArtist() {
		song.setArtist(artistValid);
		assertEquals(artistValid, song.getArtist());
	}


	@Test
	void testGetSetSongName() {
		song.setSongName(songNameValid);
		assertEquals(songNameValid, song.getSongName());
	}


	@Test
	void testGetSetRatingValid() {
		song.setRating(ratingValidLow);
		assertEquals(ratingValidLow, song.getRating());
		
		song.setRating(ratingValidMid);
		assertEquals(ratingValidMid, song.getRating());
		
		song.setRating(ratingValidHigh);
		assertEquals(ratingValidHigh, song.getRating());
	}

	@Test
	void testSetRatingInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			song.setRating(ratingInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			song.setRating(ratingInvalidHigh);
		});
	}

}
