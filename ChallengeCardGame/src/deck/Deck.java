package deck;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {
	private LinkedList<Card> cards;
	private final int maxCards = 52;
	/**
	 * @return the cards
	 */
	public LinkedList<Card> getCards() {
		return cards;
	}
	/**
	 * @param cards the cards to set
	 */
	public void setUpDeck() {
		this.cards = populateCards();
	}
	
	private Suit whichSuite(int num) {
		Suit suit = null;
		switch(num) {
		case 1: suit=Suit.CLUBS;
		break;
		case 2: suit = Suit.DIAMONDS;
		break;
		case 3: suit = Suit.HEARTS;
		break;
		case 4: suit = Suit.SPADES;
		break;
		default: suit=null;
		}		
		return suit;
	}
	
	private String whichName(int num) {
		String name = "empty";
		
		switch(num) {
		case 2: name="Two";
		break;
		case 3: name="Three";
		break;
		case 4: name="Four";
		break;
		case 5: name="Five";
		break;
		case 6: name="Six";
		break;
		case 7: name="Seven";
		break;
		case 8: name="Eight";
		break;
		case 9: name="Nine";
		break;
		case 10: name="Ten";
		break;
		case 11: name="Jack";
		break;
		case 12: name="Queen";
		break;
		case 13: name="King";
		break;
		case 14: name = "Ace";
		break;
		default: name = "Oops";
		
		}
		
		return name;
	}
	
	private LinkedList<Card> populateCards() {
		LinkedList<Card> cardsQueue = new LinkedList<Card>();
		
		for(int suit=1; suit<=4; suit++) {
			for(int j=2; j<=14; j++) {
				cardsQueue.add(new Card(whichName(j), j, whichSuite(suit)));
			}
		}
		
		return cardsQueue;
	}
	
	public void displayAllCards() {
		if(cards==null || cards.size()==0) {
			System.out.println("Empty or null deck");
		} else {
		System.out.println("Printing contents of deck");
		System.out.println();
		for(Card c : cards) {
			c.displayCard();
		}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public void sortCards() {
		Collections.sort(cards, new SortCardsByValue());
		Collections.sort(cards, new SortCardsBySuit());
	}
	
}
