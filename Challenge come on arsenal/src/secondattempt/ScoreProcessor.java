package secondattempt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class ScoreProcessor {

	public static final int WIN_POINTS = 3;
	public static final int DRAW_POINTS = 1;
	public static final int LOSS_POINTS = 0;

	public static void main(String[] args) {

		String fileName = "Results.txt";
		Map<String, Team> teams = processResults(fileName);

		printTeamListDetails(teams);
		printLeagueTable(teams);

	}

	public static void printLeagueTable(Map<String, Team> teams) {
		// convert to arraylist
		ArrayList<Team> list = new ArrayList<Team>(teams.values());
		// sort by points
		Collections.sort(list, new CompareByPoints());
		System.out.println("League table");
		System.out.println("------------");
		System.out.printf("%-20s%-10s%-4s%-10s%-2s%-2s%-10s%-10s%n", "Team", "Played", "For", "Against", "W", "D", "L",
				"Points");
		for (Team t : list) {
			System.out.printf("%-20s%-10d%-4d%-10d%-2d%-2d%-10d%-10d%n", t.getName(), t.getGamesPlayed(),
					t.getGoalsFor(), t.getGoalsAgainst(), t.getWins(), t.getDraws(), t.getLosses(), t.getPoints());

		}

	}

	public static void printTeamListDetails(Map<String, Team> map) {
		// convert to sortedset and display teams alphabetically
		SortedMap<String, Team> teamSet = new TreeMap<>(map);

		for (String team : teamSet.keySet()) {
			Team teamdet = teamSet.get(team);
			teamdet.printDetails();
			System.out.println();
		}

	}

	private static Map<String, Team> processResults(String filePath) {
		Map<String, Team> teamsList = new HashMap<String, Team>();

		// read the file and process results, add any teams to the list (add only once).
		File file = new File(filePath);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = "";

			line = br.readLine();
			String[] parts;

			String team1Name;
			int team1Score;
			String team2Name;
			int team2Score;

			while (line != null) {
				parts = line.split(" ");
				// store all the relevant info and parse
				team1Name = parts[0];
				team1Score = Integer.parseInt(parts[1]);
				team2Score = Integer.parseInt(parts[2]);
				team2Name = parts[3];

				int team1Pts = 0;
				int team2Pts = 0;

				// now teams are definitely in the list, check result

				if (team1Score > team2Score) {
					// team1Wins
					team1Pts = WIN_POINTS;
					team2Pts = LOSS_POINTS;

				} else if (team2Score > team1Score) {
					// team 2 wins
					team2Pts = WIN_POINTS;
					team1Pts = LOSS_POINTS;

				} else if (team1Score == team2Score) {
					// both draw
					team1Pts = DRAW_POINTS;
					team2Pts = DRAW_POINTS;
				}
				
				
				updateTeamsInfo(teamsList, team1Name, team1Score, team2Score, team1Pts);
				updateTeamsInfo(teamsList, team2Name, team2Score, team1Score, team2Pts);
				// read next line
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Invalid file path provided");

		} catch (IOException e1) {
			System.out.println("Oops something pretty major went wrong..");
			e1.printStackTrace();
		}

		return teamsList;
	}

	
	 private static void updateTeamsInfo(Map<String, Team> list, String name, int scoreFor, int scoreAgainst, int points) {
		 
		 if(list.containsKey(name)) {
			 //update details
			 Team team = list.get(name);
			 team.setGoalsFor(scoreFor);
			 team.setGoalsAgainst(scoreAgainst);
			 team.setPoints(points);
			 team.incrementGamesPlayed();
			 
			 if(scoreFor>scoreAgainst) {
				 //team won
				 team.incrementWins();
			 } else if(scoreFor<scoreAgainst) {
				 //team lost
				 team.incrementLosses();
			 } else if(scoreAgainst==scoreFor) {
				 //draw
				 team.incrementDraws();
			 }
		 } else {
			 Team newTeam = new Team(name);
			 list.put(name, newTeam);
			 updateTeamsInfo(list, name, scoreFor, scoreAgainst, points);
		 }
	 
	 }
}
