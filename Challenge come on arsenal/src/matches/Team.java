package matches;

public class Team {
	private String name;
	private int gamesPlayed;
	private int goalsFor;
	private int goalsAgainst;
	private int wins;
	private int draws;
	private int losses;
	/**
	 * @param name
	 */
	public Team(String name) {
		setName(name);
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
	
	public void incrementGamesPlayed() {
		gamesPlayed++;
	}
	
	public int getGamesPlayed() {
		return this.gamesPlayed;
	}
	
	public void increaseGoalsFor(int goals) {
		this.goalsFor += goals;
	}
	
	public int getGoalsFor() {
		return this.goalsFor;
	}
	
	public void increaseGoalsAgainst(int goals) {
		this.goalsAgainst += goals;
	}
	
	public int getGoalsAgainst() {
		return this.goalsAgainst;
	}
	
	public void incrementWins() {
		wins++;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void incrementDraws() {
		draws++;
	}
	
	public int getDraws() {
		return draws;
	}
	
	public void incrementLosses() {
		losses++;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int pointsTotal() {
		return this.wins*3 + this.getDraws();
	}
	
	public String stats() {
		return String.format("%s%nGames Played: %d%nGoals For: %d%nGoals Against: %d%nGames won: %d%nGames drew: %d%nGames Lost: %d%nPoints: %d",name,getGamesPlayed(),getGoalsFor(),getGoalsAgainst(),getWins(),getDraws(),getLosses(),pointsTotal() );
	}
	
	
	
	}
