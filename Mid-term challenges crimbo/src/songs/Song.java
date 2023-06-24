package songs;

public class Song {
	private String title;
	private String artist;
	private int highestPosition;
	
	public Song() {
		
	}
	
	public Song(String title, String artist, int highestPosition) {
		setTitle(title);
		setArtist(artist);
		setHighestPosition(highestPosition);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setHighestPosition(int highestPosition) {
		this.highestPosition = highestPosition;
	}

	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", highestPosition=" + highestPosition + "]";
	}
}
