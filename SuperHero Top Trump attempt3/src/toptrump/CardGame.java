package toptrump;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Stand alone file for use as part of p3 Assessment
 * NO NEED TO MODIFY THIS FILE
 * Class assumes the existence of a TopTrumpCard class with appropriate methods is available in the package
 * (if this class does not compile it is because the TopTrumpCard class does not match expectations - missing methods etc.)
 * StartApp should be able to create a list of these objects after reading the required data from toptrumpscards.csv
 * Option 2 from StartApp Menu will call the playDemo method from this class with the List and simulate a game
 * Option 2 is initially commented out as students should prioritise other tasks if they can't get this one working.
 * @author Matthew Collins
 *
 */
public class CardGame {

	public static void playDemo(List<TopTrumpCard> deck) {

		shuffleDeck(deck);
		Queue<TopTrumpCard> dealer = new LinkedList<TopTrumpCard>(deck);

		if (dealer.size() % 2 != 0) {
			System.err.println("Cards in deck: " + dealer.size());
			System.err.println("Even number of cards required to play");
			System.err.println("Discarding 1 card (for duration of game) to balance it out");
			dealer.remove();
		} else if (dealer.size() < 2) {
			System.err.println("Not enough cards to play");
			System.err.println("Cards in deck: " + dealer.size());
			System.err.println("Exiting method");
			return;
		}

		Queue<TopTrumpCard> p1Pile = new LinkedList<TopTrumpCard>();
		Queue<TopTrumpCard> p2Pile = new LinkedList<TopTrumpCard>();
		List<TopTrumpCard> centerPile = new LinkedList<TopTrumpCard>();

		int turn = 1; // 1 or 2 for players 1 and 2 respectively, player 1 goes first initially

		while (!dealer.isEmpty()) {
			p1Pile.add(dealer.remove());
			p2Pile.add(dealer.remove());
		}

		// Random rand = new Random();
		int round=1;
		System.out.println("****************************************");
		System.out.printf("Demo Top Trumps Game %n");
		System.out.println("****************************************");
		while (p1Pile.size() > 0 && p2Pile.size() > 0) {
			System.out.println("Round "+round);
			System.out.println("****************************************");
			
			int opponent = turn == 1 ? 2 : 1;

			TopTrumpCard p1Card = p1Pile.peek();
			TopTrumpCard p2Card = p2Pile.peek();
			centerPile.add(p1Pile.remove());
			centerPile.add(p2Pile.remove());

			TopTrumpCard callerCard = turn == 1 ? p1Card : p2Card;
			TopTrumpCard opponentCard = turn == 1 ? p2Card : p1Card;

			System.out.printf("Player %d goes first this round%n", turn);
			int statChoice = callerCard.getMaxStatID();
			String statName = "unknown";
			
			switch (statChoice) {
			case 0:
				statName = "Speed";
				break;
			case 1:
				statName = "Strength";
				break;
			case 2:
				statName = "Agility";
				break;
			case 3:
				statName = "Intelligence";
				break;
			}

			System.out.printf("Player %d plays: " + callerCard.getName() + " with stat " + statName + ": "+callerCard.getStatScore(statChoice)+ "%n", turn);
			System.out.printf("Player %d plays: " + opponentCard.getName() +" "+statName+"="+opponentCard.getStatScore(statChoice)+ "%n", opponent);

			// assumes appropriate stat value can be accessed with a method call like this
			int p1StatScore = p1Card.getStatScore(statChoice);
			int p2StatScore = p2Card.getStatScore(statChoice);

			if (p1StatScore == p2StatScore) {
				System.out.println("Draw Round, played cards carry to next round");
			} else {
				if (p1StatScore > p2StatScore) {
					System.out.println("Player 1 wins the round and claims the cards in play");
					p1Pile.addAll(centerPile);
					centerPile.clear();
					turn=1;
				} else {
					System.out.println("Player 2 wins the round and claims the cards in play");
					p2Pile.addAll(centerPile);
					centerPile.clear();
					turn=2;
				}
			}
			System.out.printf("Card counts: P1-%d cards | P2-%d cards | center-%d cards | Total (%d)%n",
						p1Pile.size(), p2Pile.size(), centerPile.size(),
						(p1Pile.size() + p2Pile.size() + centerPile.size()));
			System.out.println("****************************************");
			round++;
		}
		System.out.println("****************************************");
		System.out.println("Game Over");
		System.out.printf("Final Card counts: P1-%d cards | P2-%d cards | center-%d cards | Total (%d)%n",
				p1Pile.size(), p2Pile.size(), centerPile.size(), (p1Pile.size() + p2Pile.size() + centerPile.size()));
		if (p1Pile.size() == p2Pile.size()) {
			System.out.println("Draw Game");
		} else if (p1Pile.size() > p2Pile.size()) {
			System.out.println("Player 1 wins");
		} else {
			System.out.println("Player 2 wins");
		}
		System.out.println("****************************************");
		System.out.println();

	}

	/**
	 * Randomise the order of the deck
	 * 
	 * @param deck
	 */
	private static void shuffleDeck(List<TopTrumpCard> deck) {
		Collections.shuffle(deck);
	}

}
