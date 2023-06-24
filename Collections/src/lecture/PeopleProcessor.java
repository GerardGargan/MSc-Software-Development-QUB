package lecture;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PeopleProcessor {

	public static void main(String[] args) {
		
		List<Person> census = new ArrayList<Person>();
		census.add(new Person("Matthew", "Collins"));
		census.add(new Person("Gerard", "Gargan"));
		census.add(new Person("Rory", "Bro"));
		census.add(new Person("Ryan", "gargan"));
		census.add(new Person("Caoimhe", "Drain"));
		Person pete = new Person("Pete", "Jones");
		census.add(pete);
		
		Person toRemove = new Person("Gerard", "Gargan");
		
		//this wont remove Gerard as its a new object, not the same as the object already created
		//now that a .equals method exists we could use .equals to remove it as it has the same values
		census.remove(toRemove);
		//this will work
		census.remove(pete);
		
		//removing more than one at a time
		List<Person> fired = new ArrayList<Person>();
		fired.add(toRemove);
		fired.add(pete);
		census.removeAll(fired);
		
		showAll(census);
		System.out.println(census.size());
		
		//will not sort - ages are defaulted to 0 - wrong constructor used
		Collections.sort(census);
		showAll(census);

	}
	
	public static void showAll(Collection<Person> inputList) {
		for(Person p : inputList) {
			System.out.println(p.toString());
		}
	}

}
