package hospital;

import java.util.ArrayList;

public class SearchUtil {
	
	public static ArrayList<Employee> searchByLastName(ArrayList<Employee> employees, String lastName){
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		if(employees==null) {
			throw new IllegalArgumentException("array list cant be null");
		} else if(employees.size()<1) {
			throw new IllegalArgumentException("Empty array list");
		}
		
		for(Employee e : employees) {
			if(e.getLastName().equals(lastName)) {
				result.add(e);
			}
		}
		
		return result;
		
	}

}
