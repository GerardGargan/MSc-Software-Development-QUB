package justeat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PizzaShop {

	public static void main(String[] args) {
		// List<MenuItem> list1 = readMenu("OrderList-1-BasicOnly.csv");
		// printReceipt(list1);

//		List<MenuItem> list2 = readMenu("OrderList-2-PizzasOnly.csv");
//		printReceipt(list2);
		
		List<MenuItem> list3 = readMenu("OrderList-3-Full.csv");
		printReceipt(list3);

	}

	private static List<MenuItem> readMenu(String fileName) {
		List<MenuItem> results = new ArrayList<MenuItem>();

		File file = new File(fileName);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine(); // throw away headers
			line = br.readLine();
			String parts[];

			while (line != null) {
				parts = line.split(",");

				String name = parts[0];
				double price = Double.parseDouble(parts[1]);

				if (name.equalsIgnoreCase("Pizza")) {
					Pizza pizza = new Pizza((int) price);
					// read toppings

					for (int i = 2; i < parts.length; i++) {
						pizza.addTopping(Topping.valueOf(parts[i]));
					}
					results.add(pizza);
				} else {
					results.add(new MenuItem(name, price));
				}

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		System.out.println("Items read in: " + results.size());
		return results;
	}

	/**
	 * Recieves a list of menuitem objects and invokes their printDetails method,
	 * printing their details to screen
	 * 
	 * @param food
	 */
	public static void printReceipt(List<MenuItem> food) {
		double totalPrice = 0;
		if (food == null || food.size() == 0) {
			System.out.println("No food in the list to display");
		} else {
			System.out.println("-------------");
			System.out.println("ORDER DETAILS");
			System.out.println("-------------");
			for (MenuItem item : food) {
				item.printDetails();
				System.out.println();
				totalPrice += item.getPrice();
			}
			System.out.println("Total: " + totalPrice);
		}
	}

	public static List<MenuItem> findVeggies(List<MenuItem> list) {
		List<MenuItem> results = new ArrayList<MenuItem>();
		// recieving a list of menu items so need to check list is not empty, then loop
		// through and check if it is an instance of pizza
		// then count based on the isVegeterian method returning true from the pizza
		// class
		int result = 0;
		if (list == null || list.size() == 0) {
			System.out.println("List is null or empty - in find veggies method");
		} else {
			for (MenuItem item : list) {
				// check if it is a pizza object
				if (item instanceof Pizza) {
					// now we can cast it and use the isveggie method
					Pizza pizza = (Pizza) item;
					if (pizza.isVegeterian()) {
						results.add(pizza);
					}
				}
			}
		}

		return results;
	}

}
