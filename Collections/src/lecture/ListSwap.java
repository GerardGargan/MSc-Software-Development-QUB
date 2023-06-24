package lecture;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListSwap {

	public static void main(String[] args) {

		List<String> words = new LinkedList<>();
		words.add("I");
		words.add("dream");
		words.add("have");
		words.add("a");

		System.out.println(words);
		
		String[] addition = new String[] {"more","words"};
		Collections.addAll(words, addition);
		Collections.addAll(words, "and","some","more");
		
		words.addAll(Arrays.asList(addition));

		// after swap
		// swap(words, 1,2);
		// swap(words, 2, 3);

		Collections.sort(words);
		System.out.println(words);
		int index = Collections.binarySearch(words, "have");
		System.out.println("Location " + index);
		
		//relies on the .equals method, ok here for strings but for complex objects would need a .equals method in the object
		int count = Collections.frequency(words, "more");
		System.out.println("count "+count);
		
		String min = Collections.min(words);
		System.out.println(min);
	}

	public static void swap(List<String> list, int pos1, int pos2) {
		String temp = list.get(pos1);

		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}

}
