package maths.examples;

import java.util.ArrayList;

public class EmployeeSearch {

	/**
	 * 	 * Search input list for all employees at or below specified age
	 * @param allEmployees
	 * @param age
	 * @return ArrayList of matching values
	 * @throws IllegalArgumentException - Null input list or negative search age
	 */
	public static ArrayList<Employee> searchByAge(ArrayList<Employee> allEmployees, int age) throws IllegalArgumentException{
		
		if(age<0) {
			throw new IllegalArgumentException("search age cant be negative");
		}
		if(allEmployees==null) {
			throw new IllegalArgumentException("Cant be null");
		}
		
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		for(Employee employee : allEmployees) {
			if(employee.getAge()<=age) {
				result.add(employee);
			}
		}
		
		return result;
	}
}
