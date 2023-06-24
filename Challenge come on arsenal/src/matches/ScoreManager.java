package matches;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ScoreManager {
	
	public static HashMap<String, Team> teams = new HashMap<String, Team>();

	public static void main(String[] args) {
		
		ArrayList<String> readResults = readResults("Results.txt");
		
		processResults(readResults);	
		
		for(String team : teams.keySet()) {
			Team t = teams.get(team);
			System.out.println(t.stats());
			System.out.println();
		}

	}



	public static void processResults(ArrayList<String> readResults) {

		HashMap<String, Team> teams = new HashMap<String,Team>();
		String[] token;
		String team1, team2;
		int team1Goals, team2Goals, team1Pts, team2Pts;
		
		for(String line : readResults) {
			token = line.split(" ");
			team1 = token[0];
			team2 = token[3];
			team1Goals = Integer.parseInt(token[1]);
			team2Goals = Integer.parseInt(token[2]);
			
			if(team1Goals==team2Goals) {
				team1Pts = 1;
				team2Pts = 1;
			} else if(team1Goals>team2Goals) {
				team1Pts = 3;
				team2Pts = 0;
			} else {
				team2Pts = 3;
				team1Pts = 0;
			}
			
			
			updateTeamStats(team1, team1Goals, team2Goals, team1Pts);
			updateTeamStats(team2, team2Goals, team1Goals, team2Pts);
		}
		
	
	}



	private static void updateTeamStats(String team, int goalsScored, int goalsConceeded, int teamPts) {

		if(teams.containsKey(team)) {
			//team exists, do an update
			teams.get(team).incrementGamesPlayed();
			teams.get(team).increaseGoalsFor(goalsScored);
			teams.get(team).increaseGoalsAgainst(goalsConceeded);
			
			if(teamPts==0) {
				teams.get(team).incrementLosses();
			} else if(teamPts==1) {
				teams.get(team).incrementDraws();
			} else if(teamPts==3) {
				teams.get(team).incrementWins();
			} else {
				System.out.println("Error");
			}
		} else {
			teams.put(team, new Team(team));
			updateTeamStats(team, goalsScored, goalsConceeded, teamPts);
		}
		
	}



	private static ArrayList<String> readResults(String filename) {
		ArrayList<String> results = new ArrayList<String>();
		
		
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			line = br.readLine();
			while(line!=null) {
				results.add(line);
				line = br.readLine();
			}
			
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}

}
