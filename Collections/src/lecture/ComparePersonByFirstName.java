package lecture;

import java.util.Comparator;

public class ComparePersonByFirstName implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		
		//compare first name of o2 object to first name of o2 object
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
