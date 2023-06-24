package postcode;

public class Postcode {

	private String outcode;
	private String incode;
	
	
	/**
	 * @param outcode
	 * @param incode
	 */
	public Postcode(String outcode, String incode) throws IllegalArgumentException {
		if(validate(incode, outcode)) {
		setOutcode(outcode);
		setIncode(incode);
		} else {
			throw new IllegalArgumentException("Invalid postcode provided");
		}
	}
	
	/**
	 * @return the outcode
	 */
	private String getOutcode() {
		return outcode;
	}
	/**
	 * @param outcode the outcode to set
	 */
	private void setOutcode(String outcode) {
		this.outcode = outcode;
	}
	/**
	 * @return the incode
	 */
	private String getIncode() {
		return incode;
	}
	/**
	 * @param incode the incode to set
	 */
	private void setIncode(String incode) {
		this.incode = incode;
	}
	
	public String getCode() {
		return String.format("%s %s", getOutcode(), getIncode());
	}
	
	/**
	 * Validation method, checks if incode and outcode are the correct length individually
	 * @param incode
	 * @param outcode
	 * @return
	 * @throws IllegalArgumentException
	 */
	private boolean validate(String incode, String outcode) throws IllegalArgumentException {
		
		if(incode==null || outcode==null) {
			throw new IllegalArgumentException("Cant be set to null");
		} else if(outcode.length()==4 && incode.length()==3) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
}
