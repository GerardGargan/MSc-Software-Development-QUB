package thirdtry;

public class Team {
	private String name;
	private int gamesPlayed;
	private int goalsFor;
	private int goalsAgainst;
	private int wins;
	private int draws;
	private int losses;
	private int points;
	
	public Team(String name) {
		setName(name);
		gamesPlayed = 0;
		goalsFor = 0;
		goalsAgainst = 0;
		wins = 0;
		draws = 0;
		losses = 0;
		points = 0;
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
	 * @return the goalsFor
	 */
	public int getGoalsFor() {
		return goalsFor;
	}
	/**
	 * @param goalsFor the goalsFor to set
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor = goalsFor;
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
		this.goalsAgainst = goalsAgainst;
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
		this.points = points;
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
		this.gamesPlayed++;
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
	 * @return the draws
	 */
	public int getDraws() {
		return draws;
	}

	/**
	 * @param draws the draws to set
	 */
	public void incrementDraws() {
		this.draws++;
	}

	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * @param losses the losses to set
	 */
	public void incrementLosses() {
		this.losses++;
	}

	@Override
	public String toString() {
		return String.format("%s%nGames Played: %d%nGoals For: %d%nGoals Against: %d%nWins: %d%nDraws: %d%nLosses: %d%nPoints: %d%n", name,gamesPlayed,goalsFor,goalsAgainst,wins,draws,losses,points);
	}

	public void toLeagueTable() {
		System.out.printf("%-25s%-10d%-5d%-10d%-2d%-2d%-10d%-10d%n",name, gamesPlayed,  goalsFor, goalsAgainst, wins,draws,losses,points);
		
	}
	
	
	
	
}
