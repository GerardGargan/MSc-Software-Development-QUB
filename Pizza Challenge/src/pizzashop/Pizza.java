package pizzashop;

import java.util.ArrayList;

public class Pizza extends MenuItem {
	public final int MAX_SIZE = 16;
	public final int MIN_SIZE = 8;

	private int size;
	private ArrayList<Topping> extraTopping;

	public Pizza(int size) {
		super("Pizza");
		setSize(size);
		extraTopping = new ArrayList<Topping>();
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		if (size < MIN_SIZE || size > MAX_SIZE) {
			throw new IllegalArgumentException("Cannot set invalid size");
		} else {
			this.size = size;
			this.setPrice(size);
		}
	}

	private void updatePrice() {
		double currentPrice = super.getPrice();
		double newPrice = currentPrice + 0.5;
		setPrice(newPrice);
	}

	public void addTopping(Topping t) {
		// check if topping already in the list

		// first check it is not an empty array list or null
		if (extraTopping == null || extraTopping.size() == 0) {
			//no toppings on the pizza, safe to add & avoid a loop which is expensive..
			extraTopping.add(t);
			updatePrice();
		} else {
			//not an empty list
			//check if the array list contains this topping already?
			if(extraTopping.contains(t)) {
				System.out.println("Topping already added, cannot add again");
			} else {
				//add the topping
				extraTopping.add(t);
				updatePrice();
			}
			
		}

	}

	@Override
	public void printDetails() {
		
		System.out.printf("%s\t(%d) £%.2f%n",getName(),getSize(),getPrice());
		printToppingDetails();
		
	}
	
	public void printToppingDetails() {
		if(extraTopping==null || extraTopping.size()==0) {
			System.out.println("No toppings on the pizza");
		} else {
			System.out.println("With toppings: ");
			for(Topping t : extraTopping) {
				System.out.println(" *"+t);
			}
		}
	}
	
	public boolean isVegeterian() {
		//PEPPERONI, HAM, PEPPERS, ONIONS, CHEESE, PINEAPPLE,
		//CHICKEN, EXTRACHEESE, BEEF;
		if(extraTopping.contains(Topping.HAM) || extraTopping.contains(Topping.PEPPERONI) || 
				extraTopping.contains(Topping.CHICKEN) || extraTopping.contains(Topping.BEEF)) {
			return false;
		} else {
			return true;
		}
	}
	
	

}
