package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MapDemo {
	

	public static void main(String[] args) {

		String words = "to be or not to be";

		Map<String, Integer> myMap = new TreeMap<String, Integer>();
		String[] tokens = words.split(" ");

		for (String token : tokens) {
			if (myMap.containsKey(token)) {
				int count = myMap.get(token);
				myMap.put(token, count + 1);
			} else {
				myMap.put(token, 1);
			}
		}

		System.out.println(myMap.toString());

		displayMap(myMap);
	}

	private static void displayMap(Map<String, Integer> myMap) {
		Set<String> keys = myMap.keySet();
		System.out.printf("%-10s%10s%n", "Keys", "Values");
		for (String k : keys) {
			System.out.printf("%-10s%10d%n", k, myMap.get(k));
		}
	}

}
