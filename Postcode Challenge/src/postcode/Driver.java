package postcode;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<Person>();
		Postcode p1;
		Address a1;
		Person person1;
		//creating individually
	
		p1 = new Postcode("BT28", "3BA");
		a1 = new Address(18, "Sir richard wallace drive", "Co Antrim", "Lisburn", p1);
		person1 = new Person("Gerard", "Gargan", a1);
		people.add(person1);
		 
				
		//creating on the fly inside the person
		Person person2 = new Person("Gerard", "Gargan", 
				new Address(10, "Jubilee Park", "Dromore", "Co Down", 
						new Postcode("BT11", "8JR")));
		
		
		
		people.add(person2);

		displayList(people);
		
	}
	
	public static void displayList(List<Person> allPeople) {
		for(Person p : allPeople) {
			System.out.println(p.toString());
		}
	}

}
