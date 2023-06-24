package thirdtry;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static Scanner sc = new Scanner(System.in);
	public static Random rand = new Random();

	public static void main(String[] args) {

		Deck deckObject = new Deck();

		displayMenu(deckObject);
		sc.close();
	}

	private static void displayMenu(Deck deck) {
		int choice = -1;

		do {
			System.out.println("Please choose a menu option and press enter:");
			System.out.println("1. Display deck");
			System.out.println("2. Shuffle deck");
			System.out.println("3. Reorder deck");
			System.out.println("4. Play Highest Card Wins");
			System.out.println("5. Play Snap");
			System.out.println("6. Exit");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException ex) {
				choice = -1;
				sc.next();

			}

			switch (choice) {
			case 1:
				System.out.println("Displaying deck");
				deck.printDeck();
				break;
			case 2:
				System.out.println("Shuffling deck");
				deck.shuffleDeck();
				break;
			case 3:
				System.out.println("Deck reordered!");
				deck.reorderDeck();
				break;
			case 4:
				System.out.println("Playing highest card wins");
				playHighestCard(deck, 5);
				
				break;
			case 5:
				System.out.println("Playing snap");
				playSnap(deck);
				break;
			case 6:
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Invalid choice, try again");
			}

		} while (choice != 6);

	}

	private static void playSnap(Deck deck) {
		deck.shuffleDeck();
		List<Card> cards = deck.getCards();
		int deckSize = cards.size();
		int halfDeckSize = deckSize/2;
		
		Queue<Card> centralPile = new LinkedList<Card>();
		Queue<Card> p1cards = new LinkedList<Card>();
		Queue<Card> p2cards = new LinkedList<Card>();
		
		int player1wins = 0;
		int player2wins = 0;
		
		//populate players hands
		for(int i=0; i<halfDeckSize; i++) {
			p1cards.add(cards.get(i));
		}
		
		for(int i=halfDeckSize; i<deckSize; i++) {
			p2cards.add(cards.get(i));
		}
		
		while(p1cards.size()!=0 && p2cards.size()!=0) {
			//while both players have cards keep playing
			
			//remove and add to central pile (store for checking)
			Card p1 = p1cards.poll();
			Card p2 = p2cards.poll();
			centralPile.add(p1);
			centralPile.add(p2);
			
			try {
				Thread.sleep(100);
				System.out.println("Player 1: "+p1.toString());
				
				Thread.sleep(100);
				System.out.println("Player 2 "+p2.toString());
				
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			
			
			if(p1.getValue()==p2.getValue()) {
				int winner = rand.nextInt(1)+1;
				if(winner==1) {
					System.out.println("SNAP Player 1 wins!");
					player1wins++;
					//add pile to player 2's hand
					p2cards.addAll(centralPile);
					centralPile.clear();
				} else {
					System.out.println("SNAP! Player 2 wins");
					player2wins++;
					p1cards.addAll(centralPile);
					centralPile.clear();
				}
			}
			
		}
		
		String winner = p1cards.size()==0 ? "Player 1 wins: "+player1wins+" wins" : "Player 2 wins: "+player2wins+" wins";
		System.out.println("Player 2 had "+p2cards.size()+" cards left");
		System.out.println(winner);
		
	}

	/**
	 * Highest card game. Recieves a deck and a specified number of rounds to play.
	 * Each round a player takes the top card and compares, the highest card wins
	 * A prompt will ask if results want to be written to a file, 1 for yes 2 for no.
	 * @param deck
	 * @param rounds
	 */
	private static void playHighestCard(Deck deck, int rounds) {
		int p1wins = 0;
		int p2wins = 0;
		
		deck.shuffleDeck();
		
		
		List<Card> allCards = deck.getCards();
		int deckSize = allCards.size();
		int halfDeckSize = deckSize / 2;

		List<Card> p1 = new ArrayList<Card>();
		List<Card> p2 = new ArrayList<Card>();

		// populate player1 hand
		for (int i = 0; i < halfDeckSize; i++) {
			p1.add(allCards.get(i));
		}

		// populate player2 hand
		for (int i = halfDeckSize; i < deckSize; i++) {
			p2.add(allCards.get(i));
		}

		
		

		// play number of rounds passed in
		for (int i = 1; i <=rounds; i++) {
			Card p1card = p1.get(rand.nextInt(p1.size()));
			Card p2card = p2.get(rand.nextInt(p2.size()));
			
		if(p1card.getValue()==p2card.getValue()) {
				System.out.println("P1 card "+p1card.toString());
				System.out.println("P2 card "+p2card.toString());
				System.out.println("Draw!");
			} else if(p1card.getValue()>p2card.getValue()) {
				System.out.println("P1 card "+p1card.toString());
				System.out.println("P2 card "+p2card.toString());
				System.out.println("P1 wins!");
				p1wins++;
			} else {
				System.out.println("P1 card "+p1card.toString());
				System.out.println("P2 card "+p2card.toString());
				System.out.println("P2 wins!");
				p2wins++;
			}
		}
		
		String winner = p1wins > p2wins ? "Player 1 with "+p1wins+" wins" : "Player 2 with "+p2wins+" wins";

		System.out.println("Winner: "+winner);
		
		System.out.println("Write results to file? Yes = 1, No = 2");
		int choose = sc.nextInt();
		if(choose==1) {
			writeResults(winner);
		}
	}
	
	/**
	 * Writed results to file in a separate thread
	 * Creates a runnable object and passes in the winners details (String to write)
	 * Prints a success method when complete
	 * @param winner
	 */
	private static void writeResults(String winner ) {
		ToFile toWrite = new ToFile(winner);
		Thread th = new Thread(toWrite);
		th.start();
	}
	
	

}
