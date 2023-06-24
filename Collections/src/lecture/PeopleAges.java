package lecture;

import java.util.Collections;
import java.util.LinkedList;

public class PeopleAges {

	public static void main(String[] args) {
		LinkedList<Person> people = new LinkedList<Person>();
		people.add(new Person("Gerard", "Gargan",30));
		people.add(new Person("Caoimhe", "Gargan",29));
		people.add(new Person("Eileen", "Gargan",9));
		
		//Collections.sort(people);
		Collections.sort(people, new ComparePersonByAge());
		
		System.out.println(people.toString());
	}

}
