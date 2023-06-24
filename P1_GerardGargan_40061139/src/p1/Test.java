package p1;

public class Test {
	
	public static int ROUNDS = 5;

	public static void main(String[] args) {
		int wins, draws, losses;
		wins = 1;
		draws = 1;
		losses = 3;
		
		displayStats(wins, draws, losses); //This one works
		System.out.println();
		displayStatsNotWorking(wins, draws, losses);//This one shows all as 0%

	}
	
	//This one works fine
	public static void displayStats(int winStats, int drawStats, int losingStats) {
		double winsDecimal, drawDecimal, lossesDecimal;
		// cast to a double to avoid losing the decimal value
		winsDecimal = (double) winStats / ROUNDS;
		lossesDecimal = (double) losingStats / ROUNDS;
		drawDecimal = (double) drawStats / ROUNDS;
		// print in the correct format, multiply by 100 to give a percentage
		System.out.println("Final statistics");
		System.out.printf("Win percentage: %.2f%%\n", winsDecimal * 100);
		System.out.printf("Loss percentage: %.2f%%\n", lossesDecimal * 100);
		System.out.printf("Draw percentage: %.2f%%\n", drawDecimal * 100);

	}
	
	//This one returns 0 for all stats.. not as expected
	public static void displayStatsNotWorking(int winStats, int drawStats, int losingStats) {
		double winsDecimal, drawDecimal, lossesDecimal;
		// cast to a double to avoid losing the decimal value
		winsDecimal = (double) (winStats / ROUNDS) *100;
		lossesDecimal = (double) (losingStats / ROUNDS) *100;
		drawDecimal = (double) (drawStats / ROUNDS) *100;
		// print in the correct format, multiply by 100 to give a percentage
		System.out.println("Final statistics");
		System.out.printf("Win percentage: %.2f%%\n", winsDecimal);
		System.out.printf("Loss percentage: %.2f%%\n", lossesDecimal);
		System.out.printf("Draw percentage: %.2f%%\n", drawDecimal);

	}

}
