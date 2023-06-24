package thirdtry;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsProcessor {

	public static final int WIN_POINTS = 3;
	public static final int DRAW_POINTS = 1;
	public static final int LOSS_POINTS = 0;

	public static void main(String[] args) {

		Map<String, Team> teams = readTeams("Results.txt");
		// displayTeams(teams);
		printLeagueTable(teams);
	}

	private static Map<String, Team> readTeams(String fileName) {
		Map<String, Team> teamsList = new HashMap<String, Team>();

		File file = new File(fileName);
		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String[] parts;
			String line = br.readLine();

			while (line != null) {
				parts = line.split(" ");
				String team1 = parts[0];
				int team1Goals = Integer.parseInt(parts[1]);
				int team2Goals = Integer.parseInt(parts[2]);
				String team2 = parts[3];

				int team1Points;
				int team2Points;

				if (team1Goals > team2Goals) {
					team1Points = WIN_POINTS;
					team2Points = LOSS_POINTS;
				} else if (team1Goals < team2Goals) {
					team1Points = LOSS_POINTS;
					team2Points = WIN_POINTS;
				} else {
					team1Points = DRAW_POINTS;
					team2Points = DRAW_POINTS;
				}

				updateTeamStats(teamsList, team1, team1Goals, team2Goals, team1Points);
				updateTeamStats(teamsList, team2, team2Goals, team1Goals, team2Points);

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teamsList;
	}

	private static void updateTeamStats(Map<String, Team> teamsList, String teamName, int goalsFor, int goalsAgainst,
			int points) {

		if (teamsList.containsKey(teamName)) {
			// update the stats, team exists
			Team team = teamsList.get(teamName);
			team.incrementGamesPlayed();
			team.setGoalsFor(team.getGoalsFor() + goalsFor);
			team.setGoalsAgainst(team.getGoalsAgainst() + goalsAgainst);
			team.setPoints(team.getPoints() + points);
			if (points == WIN_POINTS) {
				team.incrementWins();
			} else if (points == DRAW_POINTS) {
				team.incrementDraws();
			} else {
				team.incrementLosses();
			}

		} else {
			// create the team and add to the list
			teamsList.put(teamName, new Team(teamName));
			// recursive call, should now fall into first if block
			updateTeamStats(teamsList, teamName, goalsFor, goalsAgainst, points);
		}

	}

	private static void displayTeams(Map<String, Team> list) {
		for (String team : list.keySet()) {
			Team value = list.get(team);
			System.out.println(value.toString());
		}
	}

	public static void printLeagueTable(Map<String, Team> list) {
		//convert to a list to be able to sort
		System.out.println("League table");
		System.out.println("------------");
		List<Team> listOfTeams = new ArrayList<Team>(list.values());
		Collections.sort(listOfTeams, new CompareTeamsByPoints());
		System.out.printf("%-25s%-10s%-5s%-10s%-2s%-2s%-10s%-10s%n", "Team", "Played", "For", "Against", "W", "D", "L",
				"Points");
		for (Team team : listOfTeams) {
			team.toLeagueTable();
		}
	}

}
