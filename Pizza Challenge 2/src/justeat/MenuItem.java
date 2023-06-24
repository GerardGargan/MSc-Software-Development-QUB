package justeat;

public class MenuItem implements IDetail {
	private String name;
	private double price;
	
	
	
	
	/**
	 * @param name
	 * @param price
	 */
	public MenuItem(String name, double price) {
		setName(name);
		setPrice(price);
	}


	public MenuItem(String name) {
		setName(name);
		setPrice(0);
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param setter for name, must be non empty and contain letters and spaces only, not being with a space either
	 * 
	 */
	public void setName(String name) {
		if(name==null) {
			throw new IllegalArgumentException();
		} else if(name.isEmpty()) {
			System.out.println("Name cannot be empty, setting to INVALID");
			this.name = "INVALID";
		} else if(name.charAt(0)==' ') {
			System.out.println("Name cannot start with a space, setting to INVALID");
			this.name = "INVALID";
		} else if(!validateLettersSpaces(name)) {
			System.out.println("Name must only contain letters or spaces, setting to INVALID");
			this.name = "INVALID";
		} else {
			this.name = name;
		}
		
	}

	/**
	 * Check that a string only contans letters and spaces (case insensitive)
	 * @param name
	 * @return true if business rule met, false if invalid characters are in the string
	 */
	private boolean validateLettersSpaces(String name) {
		String lower = name.toLowerCase();
		String acceptable = "abcdefghijklmnopqrstuvwxyz ";
		
		for(int i=0; i<lower.length(); i++) {
			if(acceptable.indexOf(lower.charAt(i))==-1) {
				//invalid character return false
				return false;
			}
		}
		//we got here so return true
		
		return true;
	}


	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		if(price<0) {
			System.out.println("Price cannot be lower than 0, setting to 0");
			this.price = 0;
		} else {
			this.price = price;
		}
		
	}


	@Override
	public void printDetails() {
		System.out.printf("%-20s£%-10.2f",name,price);

		
	}
	
	
	
	
}
