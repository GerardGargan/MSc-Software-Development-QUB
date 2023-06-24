package tablet2;

import java.util.ArrayList;

public class TestClass {

	public static void main(String[] args) {

				Tablet t1 = new Tablet("Apple", "iPad", 338.94, false, 10.2,
				"10.2 inch Retina display A10 Fusion chip Up to 10 hours of	battery life");
				Tablet t2 = new Tablet("Apple", "iPad Air", 449.00, false, 10.5,
				"10.5 inch 10.5-inch Retina display with ProMotion, True Tone and wide colour, Up to 20 hours of battery life ");
				Tablet t3 = new Tablet("Google", "Fire", 79.99, true, 8, "8 inch display 10 hours of battery life");
				Tablet t4 = new Tablet("Samsung", "Galazy Tab", 180.00, true, 10.1, "10.1 inch Entertainment for All: Designed with the whole family in mind, the Galaxy Tab A has what it takes to keep everyone happy. 5 hours battery.");
				Tablet t5 = new Tablet("Vankyo", "MatrixPad", 69.99, true, 7,
				"7-inch display Full-Featured Android Tablet with Eye Care for Kids Up to 4 hours of battery life");
				
				ArrayList<Tablet> tablets = new ArrayList<Tablet>();
				tablets.add(t1);
				tablets.add(t2);
				tablets.add(t3);
				tablets.add(t4);
				tablets.add(t5);
				
				displayTablets(tablets);
				displayTablets(searchSize(tablets, 8.3));
				displayTablets(isAndroid(tablets, true));
				displayTablets(noteSearch(tablets, "Full"));
				
				
	}
	
	public static void displayTablets(ArrayList<Tablet> tabletList) {
		for(Tablet t : tabletList) {
			System.out.println(t.allDetails());
		}
	}
	
	public static ArrayList<Tablet> searchSize(ArrayList<Tablet> tabletList, double minSize){
		
		ArrayList<Tablet> results = new ArrayList<Tablet>();
		System.out.println("Showing all tablets with a minimum size of: "+minSize);
		for(Tablet t : tabletList) {
			if(t.getSize()>=minSize) {
				results.add(t);
			}
		}
		
		return results;
		
	}
	
	public static ArrayList<Tablet> isAndroid(ArrayList<Tablet> tabletList, boolean isAndroid){
		ArrayList<Tablet> result = new ArrayList<Tablet>();
		System.out.println("Displaying all andriod tablets: ");
		for(Tablet t : tabletList) {
			if(t.isAndroid()==true) {
				result.add(t);
			}
		}
		return result;
	}
	
	public static ArrayList<Tablet> noteSearch(ArrayList<Tablet> tabletList, String key){
		ArrayList<Tablet> results = new ArrayList<Tablet>();
		System.out.println("Displaying all tablets containing the word: "+key);
		for(Tablet t : tabletList) {
			if(t.getNotes().contains(key)) {
				results.add(t);
			}
		}
		return results;
	}

}
