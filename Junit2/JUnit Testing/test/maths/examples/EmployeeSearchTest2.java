package maths.examples;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeSearchTest2 {
	
	//need employee objects
	//need array list of employees
	
	Employee e1,e2,e3,e4,e5;
	
	ArrayList<Employee> allEmployees;

	@BeforeEach
	void setUp() throws Exception {
		allEmployees = new ArrayList<Employee>();
		e1 = new Employee("validName", 10, 1000);
		e2 = new Employee("Valid Name", 20, 1000);
		e3 = new Employee("validName", 30, 1000);
		e4 = new Employee("ValidNAme", 40, 1000);
		e5 = new Employee("validNAme", 0, 1000);
		
		allEmployees.add(e1);
		allEmployees.add(e2);
		allEmployees.add(e3);
		allEmployees.add(e4);
		allEmployees.add(e5);
	}

	@Test
	void testSearchByAgeValid() {
		ArrayList<Employee> results = EmployeeSearch.searchByAge(allEmployees, 10);
		assertTrue(results.size()==2);
		assertTrue(results.contains(e1));
		assertTrue(results.contains(e5));
		
		ArrayList<Employee> results2 = EmployeeSearch.searchByAge(allEmployees, 0);
		assertTrue(results2.size()==1);
		assertTrue(results2.contains(e5));
	}
	
	@Test
	void testSearchByAgeinValid() {
		assertThrows(IllegalArgumentException.class, ()->{
			EmployeeSearch.searchByAge(allEmployees, -1);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			EmployeeSearch.searchByAge(null, 10);
		});
	}

}
