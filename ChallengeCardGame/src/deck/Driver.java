package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Deck deck1 = new Deck();
		deck1.setUpDeck();

		/*
		 * System.out.println("Display deck"); deck1.displayAllCards();
		 * System.out.println(); System.out.println("Shuffeling...");
		 * deck1.shuffleDeck(); deck1.displayAllCards();
		 */

		// playCardGame1(deck1);
		//playCardGame2(deck1);
		
		//print deck
		System.out.println("Unshuffled");
		deck1.displayAllCards();
		System.out.println();
		
		System.out.println("Shuffled:");
		deck1.shuffleDeck();
		deck1.displayAllCards();
		System.out.println();
		
		System.out.println("Reorder");
		deck1.sortCards();
		deck1.displayAllCards();
	}

	public static void playCardGame2(Deck deck) {
		int cardsInDeck = deck.getCards().size();
		int halfOfDeck = cardsInDeck / 2;

		deck.shuffleDeck();

		Queue<Card> player1Cards = new LinkedList<Card>();
		Queue<Card> player2Cards = new LinkedList<Card>();

		// populate player 1 cards
		System.out.println("Adding player 1 cards");
		for (int i = 0; i < halfOfDeck; i++) {
			Card card = deck.getCards().get(i);
			player1Cards.add(card);
			// System.out.println("Added card :"+(i+1));
			// card.displayCard();
		}

		// populate player 2 cards
		System.out.println("Adding player 2 cards");
		for (int i = halfOfDeck; i < cardsInDeck; i++) {
			Card card = deck.getCards().get(i);
			player2Cards.add(card);
			// System.out.println("Added card :"+(i+1));
			// card.displayCard();
		}

		// play game
		playSnap(player1Cards, player2Cards);
	}

	private static void playSnap(Queue<Card> player1Cards, Queue<Card> player2Cards) {
		ArrayList<Card> pile = new ArrayList<Card>();
		Random rand = new Random();
		

		int rounds = 1;
		while (player1Cards.size() > 0 && player2Cards.size() > 0) {
			// while players still have cards, keep playing

			Card player1turn = player1Cards.poll();
			Card player2turn = player2Cards.poll();
			pile.add(player1turn);
			pile.add(player2turn);
			System.out.println("Round " + rounds);
			System.out.println("Player 1: "+player1Cards.size());
			player1turn.displayCard();
			System.out.println("Player 2: "+player2Cards.size());
			player2turn.displayCard();
			System.out.println();

			if (player1turn.getValue() == player2turn.getValue()) {
				int playerWins = rand.nextInt(2) + 1;
				System.out.println("SNAP!! Player " + playerWins + " wins!");
				if (playerWins == 1) {
					player2Cards.addAll(pile);
					pile.clear();
				} else if (playerWins == 2) {
					player1Cards.addAll(pile);
					pile.clear();
				} else {
					System.out.println("ERROR");
				}
				System.out.println();
			}
			rounds++;
			
		}
		if(player1Cards.size()==0) {
			System.out.println("Player 1 winner");
		} else if (player2Cards.size()==0) {
			System.out.println("Player 2 winner");
		} else {
			System.out.println("Winner error");
		}

	}

	public static void playCardGame1(Deck deck) {
		Random rand = new Random();
		deck.shuffleDeck();

		List<Card> player1Cards = new LinkedList<Card>();
		List<Card> player2Cards = new LinkedList<Card>();

		int numOfCards = deck.getCards().size();
		int halfOfDeck = numOfCards / 2;

		System.out.println("numOfCards: " + numOfCards);
		System.out.println("halfOfDeck: " + halfOfDeck);

		// populate player 1 hand
		for (int i = 0; i < halfOfDeck; i++) {
			player1Cards.add(deck.getCards().get(i));
		}

		// populate player 2 hand
		for (int i = halfOfDeck; i < numOfCards; i++) {
			player2Cards.add(deck.getCards().get(i));
		}

		/*
		 * System.out.println("Player 1 hand: "); displayCards(player1Cards);
		 * 
		 * System.out.println(); System.out.println("Player 2 hand: ");
		 * displayCards(player2Cards);
		 */
		int player1Wins = 0;
		int player2Wins = 0;
		int draws = 0;
		// play the game
		for (int i = 1; i <= 5; i++) {
			System.out.println("Round " + i);

			int randNumPlay1 = rand.nextInt(player1Cards.size());
			int randNumPlay2 = rand.nextInt(player2Cards.size());
			Card player1 = player1Cards.get(randNumPlay1);
			Card player2 = player2Cards.get(randNumPlay2);

			System.out.println("Player 1:");
			player1.displayCard();
			System.out.println("Player 2: ");
			player2.displayCard();

			if (player1.getValue() > player2.getValue()) {
				System.out.println("Player 1 wins");
				player1Wins++;

			} else if (player2.getValue() > player1.getValue()) {
				System.out.println("Player 2 wins");
				player2Wins++;
			} else {
				System.out.println("Draw");
				draws++;
			}
			System.out.println();

			player1Cards.remove(player1);
			player2Cards.remove(player2);
		}

		System.out.println("Player 1 score: " + player1Wins);
		System.out.println("Player 2 score: " + player2Wins);
		System.out.println("Draws: " + draws);

	}

	public static void displayCards(List<Card> cards) {

		for (Card c : cards) {
			c.displayCard();
		}
	}
	


}
