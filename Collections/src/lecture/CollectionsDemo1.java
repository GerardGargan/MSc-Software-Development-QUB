package lecture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CollectionsDemo1 {

	public static void main(String[] args) {
		
		List<String> myList = new ArrayList<String>();
		myList.add("Matthew");
		myList.add("Gerry");
		myList.add("Rory!");
		//System.out.println(myList);
		
		
		
		List<String> myList2 = new LinkedList<String>();
		myList2.add("William");
		myList2.add("Jarlath");
		//System.out.println(myList2);
		
		showAll(myList);
		showAll(myList2);
		
	}
	
	/**
	 * Display each element in input list on a separate line
	 * @param inputList
	 */
	public static void showAll(List<String> inputList) {
		for(String s : inputList) {
			System.out.println(s);
		}
	}

}
