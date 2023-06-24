package secondattempt;

public class Team {
	private String name;
	private int gamesPlayed;
	private int goalsFor;
	private int goalsAgainst;
	private int wins;
	private int losses;
	private int points;
	private int draws;
	
	
	
	/**
	 * @param name
	 * @param gamesPlayed
	 * @param goalsFor
	 * @param goalsAgainst
	 * @param wins
	 * @param losses
	 * @param points
	 */
	public Team(String name) {
		setName(name);
		gamesPlayed = 0;
		goalsFor = 0;
		goalsAgainst = 0;
		wins = 0;
		losses = 0;
		points = 0;
		draws = 0;
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
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	/**
	 * @param gamesPlayed the gamesPlayed to set
	 */
	public void incrementGamesPlayed() {
		gamesPlayed++;;
	}
	/**
	 * @return the goalsFor
	 */
	public int getGoalsFor() {
		return goalsFor;
	}
	/**
	 * @param goalsFor the goalsFor to set
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor += goalsFor;
	}
	/**
	 * @return the goalsAgainst
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}
	/**
	 * @param goalsAgainst the goalsAgainst to set
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst += goalsAgainst;
	}
	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}
	/**
	 * @param wins the wins to set
	 */
	public void incrementWins() {
		wins++;
	}
	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}
	/**
	 * @param draws the losses to set
	 */
	public void incrementLosses() {
		losses++;
	}
	
	public int getDraws() {
		return draws;
	}
	/**
	 * @param draws the draws to set
	 */
	public void incrementDraws() {
	
		draws++;
	}
	
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points += points;
	}
	
	public void printDetails() {
		System.out.printf("%s%n%-17s%-5d%n%-17s%-5d%n%-17s%-5d%n%-17s%-5d%n%-17s%-5d%n%-17s%-5d%n%-17s%-5d%n",name,"Games played:",gamesPlayed,"Goals for:",goalsFor,
				"Goals against:",goalsAgainst,"Wins:",wins,"Losses:",losses,"Draws:",draws,"Points:",points);
	}
	
	
}
