package deck;

public class Card implements Comparable<Card>{
	private String name;
	private int value;
	private Suit suit;
	
	
	
	/**
	 * @param name
	 * @param value
	 * @param suit
	 */
	public Card(String name, int value, Suit suit) {
		setName(name);
		setValue(value);
		setSuit(suit);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * @return the suit
	 */
	public Suit getSuit() {
		return suit;
	}
	/**
	 * @param suit the suit to set
	 */
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	public void displayCard() {
		System.out.printf("%s of %s%n",name,suit);
	}
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.value-o.value;
	}
	
	
}
