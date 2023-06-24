package lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RemoveDupes {
	public static void main(String[] args) {

		ArrayList<Integer> arList = new ArrayList<Integer>();
		arList.add(5);
		arList.add(52);
		arList.add(65);
		arList.add(21);
		arList.add(99);
		
		LinkedList<Integer> linkList = new LinkedList<Integer>();
		linkList.add(21);
		linkList.add(99);
		linkList.add(5);
		linkList.add(80);
		System.out.println("Pre mod "+arList);
		System.out.println("To Remove "+linkList);
		
		//removeMatches(arList, linkList);
		removeDuplicated(arList);
		System.out.println("Post Mod"+arList);
		System.out.println("end");
		
		Collections.sort(arList);
	}
	
	/**
	 * Remove elements in first list which occur in second list
	 * First list will be changed as a result of calling this method
	 * @param toModify
	 * @param toRemove
	 */
	public static void removeMatches(List<Integer> toModify, List<Integer> toRemove) {
		
		for(Integer val : toRemove) {
			toModify.remove(val);
		}
	}
	
	/**
	 * modifies input list to remove any elements which occur more than once
	 * @param inputList
	 */
	public static void removeDuplicated(List<Integer> inputList) {
		List<Integer> unique = new ArrayList<Integer>();
		
		for(Integer val : inputList) {
			if(!unique.contains(val)) {
				unique.add(val);
			}
		}
		
		inputList.clear();
		inputList.addAll(unique);
		
		//dont do this - will not point to the correct memory location (pass by ref/pass by value)
		//inputList = unique;
	}

}
