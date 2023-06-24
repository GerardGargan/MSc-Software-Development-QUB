package secondtry;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {

		List<Card> deck = populateDeck(52);
		//displayDeck(deck);
		
		//playHighCard(deck);
		playSnap(deck);

	}

	private static void playSnap(List<Card> deck) {
		List<Card> localDeck = new LinkedList<Card>(deck);
		Collections.shuffle(localDeck);
		
		Queue<Card> player1cards = new LinkedList<Card>();
		Queue<Card> player2cards = new LinkedList<Card>();
		
		int deckSize = localDeck.size();
		int halfdecksize = deckSize/2;
		
		for(int i=0; i<halfdecksize; i++) {
			player1cards.add(localDeck.get(i));
		}
		
		for(int i=halfdecksize; i<deckSize; i++) {
			player2cards.add(localDeck.get(i));
		}
		
		playSnapGame(player1cards,player2cards);
		
	}

	private static void playSnapGame(Queue<Card> player1cards, Queue<Card> player2cards) {
		Queue<Card> centralPile = new LinkedList<Card>();
		Random rand = new Random();
		
		int player1wins = 0;
		int player2wins = 0;
		
		while(player1cards.size()!=0 && player2cards.size()!=0) {
			//keep going until 1 players card size = 0
			Card p1card = player1cards.poll();
			Card p2card = player2cards.poll();
			
			centralPile.add(p1card);
			centralPile.add(p2card);
			
			if(p1card.getValue()==p2card.getValue()) {
				int winner = rand.nextInt(1)+1;
				System.out.println("SNAP! Player "+winner+" wins!");
				if(winner==1) {
					player1wins++;
					player2cards.addAll(centralPile);
					centralPile.clear();
				} else if(winner==2) {
					player2wins++;
					player1cards.addAll(centralPile);
					centralPile.clear();
				}
			}
		}
		
		System.out.println("Player 1 score"+player1wins);
		System.out.println("Player 2 score"+player2wins);
		
	}

	private static void playHighCard(List<Card> deck) {
		List<Card> localDeck = new LinkedList(deck);
		Collections.shuffle(localDeck);
		
		List<Card> player1cards = new LinkedList<>();
		List<Card> player2cards = new LinkedList<>();
		
		for(int i=0; i<localDeck.size()/2; i++) {
			player1cards.add(localDeck.get(i));
		}
		
		for(int i=localDeck.size()/2; i<localDeck.size(); i++) {
			player2cards.add(localDeck.get(i));
		}
		
		//play game
		
		playGameHighCard(player1cards, player2cards);
		
		
		
		
	}

	private static void playGameHighCard(List<Card> player1cards, List<Card> player2cards) {
		
		Random rand = new Random();
		
		
		for(int i=1; i<=5; i++) {
			//while each player still has cards keep playing, when one has 0 exit
			
			Card player1card = player1cards.get(rand.nextInt(player1cards.size()));
			Card player2card = player2cards.get(rand.nextInt(player2cards.size()));
			
			player1cards.remove(player1card);
			player2cards.remove(player2card);
			
			if(player1card.getValue()==player2card.getValue()) {
				//draw
				System.out.println("Player 1 played "+player1card.toString());
				System.out.println("Player 2 played "+player2card.toString());
				System.out.println("Draw");
			} else if(player1card.getValue()>player2card.getValue()) {
				//player 1 wins
				System.out.println("Player 1 played "+player1card.toString());
				System.out.println("Player 2 played "+player2card.toString());
				System.out.println("Player 1 wins");
			} else {
				//player 2 wins
				System.out.println("Player 1 played "+player1card.toString());
				System.out.println("Player 2 played "+player2card.toString());
				System.out.println("Player 2 wins");
			}
			
		}
		
		System.out.println("End of game");
		
	}

	private static List<Card> populateDeck(int num) {
		int numPerSuit = num/4;
		List<Card> cards = new LinkedList<Card>();
		
		for(int suit=1; suit<=4; suit++) { //outer loop once for each suit
			for(int cardNum=2; cardNum<=numPerSuit+1; cardNum++) { //inner loop to loop around and populate each suit
				cards.add(new Card(whichName(cardNum), whichSuit(suit), cardNum));
			}
		}
		
		return cards;
	}
	
	private static Suit whichSuit(int num) {
		Suit toReturn = null;
		switch(num) {
		case 1: toReturn = Suit.CLUBS;
		break;
		case 2: toReturn = Suit.DIAMONDS;
		break;
		case 3: toReturn = Suit.HEARTS;
		break;
		case 4: toReturn = Suit.SPADES;
		break;
		}
		
		return toReturn;
	}
	
	private static String whichName(int num) {
		String toReturn = "Default";
		switch(num) {
		case 2: toReturn = "Two";
		break;
		case 3: toReturn = "Three";
		break;
		case 4: toReturn = "Four";
		break;
		case 5: toReturn = "Five";
		break;
		case 6: toReturn = "Six";
		break;
		case 7: toReturn = "Seven";
		break;
		case 8: toReturn = "Eight";
		break;
		case 9: toReturn = "Nine";
		break;
		case 10: toReturn = "Ten";
		break;
		case 11: toReturn = "Jack";
		break;
		case 12: toReturn = "Queen";
		break;
		case 13: toReturn = "King";
		break;
		case 14: toReturn = "Ace";
		break;
		default: toReturn = "Undefined";
		}
		return toReturn;
		
	}
	
	public static void displayDeck(Collection<Card> deck) {
		for(Card c : deck) {
			
			System.out.println(c.toString());
		}
	}

}
