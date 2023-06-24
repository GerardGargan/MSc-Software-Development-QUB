package thirdtry;

public class Card {
	private String faceValue;
	private int value;
	private Suit suit;
	
	
	
	/**
	 * @param faceValue
	 * @param value
	 * @param suit
	 */
	public Card(String faceValue, int value, Suit suit) {
		setFaceValue(faceValue);
		setValue(value);
		setSuit(suit);
	}
	/**
	 * @return the faceValue
	 */
	public String getFaceValue() {
		return faceValue;
	}
	/**
	 * @param faceValue the faceValue to set
	 */
	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
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
	@Override
	public String toString() {
		return String.format("%s of %s", faceValue, suit);
	}
	
	

}
