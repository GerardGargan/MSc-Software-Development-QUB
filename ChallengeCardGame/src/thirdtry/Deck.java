package thirdtry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		populateDeck();
		
	}

	/**
	 * @return the cards
	 */
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	private void populateDeck() {
		// populate the deck with 52 cards of appropriate suits
		for (int i = 1; i <= 4; i++) {
			// outer loop for each suit
			for (int j = 2; j <= 14; j++) {
				Suit suit = getSuit(i);
				String face = getFace(j);
				cards.add(new Card(face, j, suit));
			}
		}
	}

	/**
	 * Recieves an int, converts it to the equivilant Suit
	 * @param num
	 * @return the Suit
	 */
	public static Suit getSuit(int num) {
		Suit toReturn;
		switch (num) {
		case 1:
			toReturn = Suit.CLUBS;
			break;
		case 2:
			toReturn = Suit.DIAMONDS;
			break;
		case 3:
			toReturn = Suit.HEARTS;
			break;
		case 4:
			toReturn = Suit.SPADES;
			break;
		default:
			toReturn = null;
		}
		return toReturn;
	}

	/**
	 * Recieves an int, converts it to the equivilant face value (String)
	 * @param num
	 * @return the face value as a string
	 */
	public static String getFace(int num) {
		String toReturn = "empty";
		switch (num) {
		case 2:
			toReturn = "Two";
			break;
		case 3:
			toReturn = "Three";
			break;
		case 4:
			toReturn = "Four";
			break;
		case 5:
			toReturn = "Five";
			break;
		case 6:
			toReturn = "Six";
			break;
		case 7:
			toReturn = "Seven";
			break;
		case 8:
			toReturn = "Eight";
			break;
		case 9:
			toReturn = "Nine";
			break;
		case 10:
			toReturn = "Ten";
			break;
		case 11:
			toReturn = "Jack";
			break;
		case 12:
			toReturn = "Queen";
			break;
		case 13:
			toReturn = "King";
			break;
		case 14:
			toReturn = "Ace";
			break;

		}
		return toReturn;
	}
	
	/**
	 * Print the contents of the deck using the cards tostring method
	 */
	public void printDeck() {
		for(Card c : cards) {
			System.out.println(c.toString());
		}
	}
	
	/**
	 * Return the number of cards in the deck
	 * @return
	 */
	public int size() {
		return cards.size();
	}
	
	/**
	 * Shuffle deck in random order
	 */
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Reorder deck by value then suit
	 */
	public void reorderDeck() {
		Collections.sort(cards, new CompareByValue());
		Collections.sort(cards, new CompareBySuit());
		
	}

}
