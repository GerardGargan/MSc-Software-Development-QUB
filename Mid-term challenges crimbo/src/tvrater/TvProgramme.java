package tvrater;

public class TvProgramme {
	private String name;
	private String broadcaster;
	private int rating;
	private double averageAudience;
	
	public TvProgramme() {
		
	}
	
	public TvProgramme(String name, String broadcaster, int rating, double averageAudience) {
		setName(name);
		setAverageAudience(averageAudience);
		setBroadcaster(broadcaster);
		setRating(rating);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the broadcaster
	 */
	public String getBroadcaster() {
		return broadcaster;
	}

	/**
	 * @param broadcaster the broadcaster to set
	 */
	public void setBroadcaster(String broadcaster) {
		this.broadcaster = broadcaster;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the averageAudience
	 */
	public double getAverageAudience() {
		return averageAudience;
	}

	/**
	 * @param averageAudience the averageAudience to set
	 */
	public void setAverageAudience(double averageAudience) {
		this.averageAudience = averageAudience;
	}

	@Override
	public String toString() {
		return "TvProgramme [name=" + name + ", broadcaster=" + broadcaster + ", rating=" + rating
				+ ", averageAudience=" + averageAudience + "]";
	}
}
