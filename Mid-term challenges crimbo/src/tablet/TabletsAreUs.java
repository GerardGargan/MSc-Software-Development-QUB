package tablet;

import java.util.ArrayList;

public class TabletsAreUs {

	public static void main(String[] args) {

		// simulating a few tablets
		Tablet t1 = new Tablet("Apple", "iPad", 338.94, false, 10.2,
				"10.2 inch Retina display A10 Fusion chip Up to 10 hours of	battery life");
		Tablet t2 = new Tablet("Apple", "iPad Air", 449.00, false, 10.5,
				"10.5 inch 10.5-inch Retina display with ProMotion, True Tone and wide colour, Up to 20 hours of battery life ");
		Tablet t3 = new Tablet("Google", "Fire", 79.99, true, 8, "8 inch display 10 hours of battery life");
		Tablet t4 = new Tablet("Samsung", "Galazy Tab", 180.00, true, 10.1,
				"10.1 inch  Entertainment for All: Designed with the whole family in mind, the Galaxy Tab A has what it takes to keep everyone happy. 5 hours battery.");
		Tablet t5 = new Tablet("Vankyo", "MatrixPad", 69.99, true, 7,
				"7-inch display Full-Featured Android Tablet with Eye Care for Kids Up to 4 hours of battery life");

		// adding to an arraylist
		ArrayList<Tablet> list = new ArrayList<Tablet>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);

		// show all in stock
		showAll(list);

		// exercising a few searches
		// 1. all screen sizes > 10 inches in size
		System.out.println("Display all tablets > 10 inches\n");
		showAll(searchSize(list, 10));
		// 2. all Apple products (over priced!)
		showAll(isApple(list));
		// 3. all Android tablets
		showAll(isAndroid(list));
		// 4. note search .. e.g. by key word search (note this is case sensitive)
		showAll(search(list,"Eye"));
		
		
	}
	public static ArrayList<Tablet> search(ArrayList<Tablet> t, String searchKey) {
		System.out.println("Displaying tablets that contain: "+searchKey+"\n");
		ArrayList<Tablet> result = new ArrayList<Tablet>();
		for(Tablet tablet : t) {
			if(tablet.toString().contains(searchKey)) {
				result.add(tablet);
			}
		}
		return result;
	}
	public static ArrayList<Tablet> isAndroid(ArrayList<Tablet> t) {
		System.out.println("Displaying all Android tablets\n");
		ArrayList<Tablet> result = new ArrayList<Tablet>();
		for(Tablet tablet : t) {
			if(tablet.isAndroid()) {
				result.add(tablet);
			}
		}
		return result;
	}
	// create all the searches as methods here (make them all static)

	public static void showAll(ArrayList<Tablet> t) {
		if (t.size() == 0 || t == null) {
			System.out.println("No tablets to show");
		} else {
			for (Tablet tablet : t) {
				tablet.allDetails();
			}
		}
	}

	public static ArrayList<Tablet> searchSize(ArrayList<Tablet> t, double size) {

		System.out.println("Displaying all tablets with a screen size greater than " + size);
		ArrayList<Tablet> result = new ArrayList<Tablet>();
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getSize() > size) {
				result.add(t.get(i));

			}
		}
		return result;
	}
	
	public static ArrayList<Tablet> isApple(ArrayList<Tablet> t){
		System.out.println("Displaying all apple tablets\n");
		ArrayList<Tablet> result = new ArrayList<Tablet>();
		for(Tablet tablet : t) {
			if(tablet.isAndroid()==false) {
			result.add(tablet);
			}
		}
		return result;
	}

}
