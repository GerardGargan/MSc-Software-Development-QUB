package secondtry;

public class Card implements Comparable<Card> {
	private String name;
	private Suit suit;
	private int value;
	
	
	
	/**
	 * @param name
	 * @param suit
	 * @param value
	 */
	public Card(String name, Suit suit, int value) {
		setName(name);
		setSuit(suit);
		setValue(value);
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

	@Override
	public String toString() {
		return String.format("%s of %s", name, suit);
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return this.getValue()-o.getValue();
	}
	
	
	
}
