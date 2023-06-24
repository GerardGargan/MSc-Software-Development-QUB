package pizzashop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {

		Pizza p1 = new Pizza(16);
		p1.addTopping(Topping.CHEESE);
		p1.addTopping(Topping.HAM);
		p1.addTopping(Topping.PINEAPPLE);

		// p1.printDetails();

		Pizza p2 = new Pizza(9);
		p2.addTopping(Topping.CHEESE);
		p2.addTopping(Topping.ONIONS);

		MenuItem burger = new MenuItem("Burger", 10.99);

		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		list.add(p1);
		list.add(p2);
		list.add(burger);

		// printReceipt(list);
		// findVeggies(list);

		ArrayList<MenuItem> readIn;
		// readIn = readFromFile("OrderList-1-BasicOnly.csv");
		// readIn = readFromFile("OrderList-2-PizzasOnly.csv");
		readIn = readFromFile("OrderList-3-Full.csv");
		printReceipt(readIn);
		// findVeggies(readIn);
	}

	public static void printReceipt(ArrayList<MenuItem> list) {
		double totalPrice = 0;
		for (MenuItem item : list) {
			totalPrice += item.getPrice();
			item.printDetails();
			System.out.println();
		}
		System.out.printf("%nTotal: %.2f", totalPrice);
	}

	public static void findVeggies(ArrayList<MenuItem> pizzas) {
		System.out.println("Searching for vegeterian pizzas...");
		int numOfVeggies = 0;
		if (pizzas == null || pizzas.size() == 0) {
			System.out.println("No pizzas to show, list null or empty");
		} else {
			for (MenuItem p : pizzas) {
				if (p instanceof Pizza) {
					Pizza pizza = (Pizza) p;
					if (pizza.isVegeterian()) {
						numOfVeggies++;
						pizza.printDetails();
					}
				}
			}
			System.out.println("Number of veggie pizzas: " + numOfVeggies);
		}
	}

	public static ArrayList<MenuItem> readFromFile(String fileName) {
		ArrayList<MenuItem> list = new ArrayList<MenuItem>();
		String line = "";
		String[] parts = new String[3];

		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine(); // throw away header values
			line = br.readLine();
			while (line != null) {
				parts = line.split(",");
				if (parts[0].equals("Pizza")) {
					int size = Integer.parseInt(parts[1]);
					// add pizza
					Pizza pizza = new Pizza(size);
					// check and add toppings
					if (parts.length > 2) {
						for (int i = 2; i < parts.length; i++) {
							// loop through all topping and add
							pizza.addTopping(Topping.valueOf(parts[i]));
						}
					}

					list.add(pizza);
				} else {
					// add menuItem
					double price = Double.parseDouble(parts[1]);
					list.add(new MenuItem(parts[0], price));
				}

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem!! IO Exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

}
