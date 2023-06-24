package postcode;

public class Address {
	
	private int houseNum;
	private String line1;
	private String line2;
	private String line3;
	private Postcode postcode;
	
	
	/**
	 * @param houseNum
	 * @param line1
	 * @param line2
	 * @param line3
	 * @param postcode
	 */
	public Address(int houseNum, String line1, String line2, String line3, Postcode postcode) {
		setHouseNum(houseNum);
		setLine1(line1);
		setLine2(line2);
		setLine3(line3);
		setPostcode(postcode);
	}
	
	/**
	 * @return the houseNum
	 */
	public int getHouseNum() {
		return houseNum;
	}
	/**
	 * @param houseNum the houseNum to set
	 */
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}
	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}
	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	/**
	 * @return the line3
	 */
	public String getLine3() {
		return line3;
	}
	/**
	 * @param line3 the line3 to set
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}
	/**
	 * @return the postcode
	 */
	public Postcode getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(Postcode postcode) {
		
		this.postcode = postcode;
		
	}

	@Override
	public String toString() {
		return String.format("%d %s,%n%s,%n%s,%n%s%n", getHouseNum(),getLine1(),getLine2(),getLine3(),getPostcode().getCode());
	}
	
	
}
