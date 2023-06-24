package lecture;

import java.util.Comparator;

public class ComparePersonBySurname implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		
		return o1.getSurName().compareTo(o2.getSurName());
	}

}
