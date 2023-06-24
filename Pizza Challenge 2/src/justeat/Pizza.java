package justeat;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {

	private int size;
	private List<Topping> extraToppings;

	/**
	 * @param name
	 * @param price
	 */
	public Pizza(int size) {
		super("Pizza");
		// set the size and update the price in the setter (dont update price here as
		// size could be invalid - need to check first)
		setSize(size);
		// instansiate the extraToppings list
		extraToppings = new ArrayList<Topping>();
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set, also updates the price as the size = price
	 *             (initial)
	 */
	public void setSize(int size) {
		if (size < 8) {
			System.out.println("Too small, setting to min of 8");
			super.setPrice(8);
			this.setSize(8);
		} else if (size > 16) {
			System.out.println("Too large, setting to max of 16");
			this.setSize(16);
			super.setPrice(16);
		} else {
			super.setPrice(size);
			this.size = size;
		}

	}

	/**
	 * @return the extraToppings
	 */
	public List<Topping> getExtraToppings() {
		return extraToppings;
	}

	/**
	 * Add an extra topping to the pizza
	 * 
	 * @param topping
	 */
	public void addTopping(Topping topping) {
		if (topping == null) {
			throw new IllegalArgumentException();
		} else if (extraToppings.contains(topping)) {
			System.out.println("Topping already on pizza.. cannot add again");
		} else {
			extraToppings.add(topping);
			updatePrice();
		}

	}

	/**
	 * Updates the price by 0.50 when called
	 */
	private void updatePrice() {
		double curPrice = super.getPrice();
		super.setPrice(curPrice + 0.5);

	}

	@Override
	public void printDetails() {
		
		String custName = extraToppings.size()==0 ? "Plain Pizza" : "Custom Pizza";
		
		System.out.printf("%-20s(%d) £%.2f",custName,size,super.getPrice());
		if(extraToppings.size()>0) {
		System.out.printf("%nWith toppings:%n");
		printToppings();
		}
		
	}

	/**
	 * prints all toppings in the list
	 */
	private void printToppings() {
		if (extraToppings.size() == 0) {
			System.out.println("No toppings, plain pizza");
		} else {
			int loop = 1;
			for (Topping topping : extraToppings) {
				System.out.print(" * "+topping);
				
				if(loop!=extraToppings.size()) {
					System.out.println();
				}
				loop++;
			}
		}

	}
	
	public boolean isVegeterian() {
		
		if(extraToppings==null || extraToppings.size()==0) {
			//no toppings must be veggie
			return true;
		} else if(extraToppings.contains(Topping.BEEF) || extraToppings.contains(Topping.CHICKEN) || 
				extraToppings.contains(Topping.HAM) || extraToppings.contains(Topping.PEPPERONI)) {
			//list contians one of the meet items below, not veggie
			return false;
		} else {
			return true;
		}
			
	}

}
