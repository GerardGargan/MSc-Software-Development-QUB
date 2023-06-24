package mp3code;

public class Mp3 {

	public final static int LOWER_RATING = 0;
	public final static int SONG_LENGTH = 2500;

	private int ref;
	private String artist;
	private String songName;
	private int rating;
	private int length;
	
	public Mp3() {
		
	}

	public Mp3(int ref, String artist, String songName, int rating, int length) {
		setRef(ref);
		this.artist = artist;
		this.songName = songName;
		setRating(rating);
		setLength(length);
	}

	public void setLength(int length) {
		if(length>SONG_LENGTH || length<1) {
			throw new IllegalArgumentException("Song length exceeds the min/max (1-"+SONG_LENGTH+")");
		} else {
			this.length = length;
		}
		
	}
	
	public int getLength() {
		return length;
	}

	public int getRef() {
		return ref;
	}

	/**
	 * Set the reference number, integer If less than zero then throw
	 * IllegalArgumentException
	 * 
	 * @param ref
	 */
	public void setRef(int ref) throws IllegalArgumentException {

		if (ref >= 0) {
			this.ref = ref;
		} else {
			throw new IllegalArgumentException("Ref less than 0");
		}
	}

	/**
	 * 
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * Set the artist
	 * 
	 * @param artist
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * return the songname
	 * 
	 * @return
	 */
	public String getSongName() {
		return songName;
	}

	/**
	 * Set the songName
	 * 
	 * @param songName
	 */
	public void setSongName(String songName) {
		this.songName = songName;
	}

	/**
	 * 
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * set the rating rating must be between lower boundary (constant) & 5
	 * 
	 * @param rating
	 */
	public void setRating(int rating) throws IllegalArgumentException {
		if ((rating >= LOWER_RATING) && (rating <= 5)) {
			this.rating = rating;
		} else {
			throw new IllegalArgumentException("Invalid rating - should be between 0 & 5");
		}

	}

}
