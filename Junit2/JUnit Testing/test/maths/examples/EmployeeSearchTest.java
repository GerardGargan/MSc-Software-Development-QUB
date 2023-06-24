package maths.examples;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeSearchTest {

	Employee e1, e2, e3, e4, e5;
	int age1, age2, age3;
	ArrayList<Employee> inputList;

	@BeforeEach
	void setUp() throws Exception {
		inputList = new ArrayList<Employee>();

		e1 = new Employee("validname", 20, 100);
		e2 = new Employee("validname", 30, 100);
		e3 = new Employee("validname", 23, 100);
		e4 = new Employee("validname", 27, 100);
		e5 = new Employee("validname", 8, 100);

		inputList.add(e1);
		inputList.add(e2);
		inputList.add(e3);
		inputList.add(e4);
		inputList.add(e5);
	}

	@Test
	void EmployeeSearchValid() {
		ArrayList<Employee> results = EmployeeSearch.searchByAge(inputList, 23);

		assertTrue(results.size() == 3);
		assertTrue(results.contains(e1) && results.contains(e3) && results.contains(e5));

		ArrayList<Employee> results2 = EmployeeSearch.searchByAge(inputList, 7);

		assertTrue(results2.size() == 0);

	}

	@Test
	void EmployeeSearchInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			EmployeeSearch.searchByAge(inputList, -1);
		});
		
	
		assertThrows(IllegalArgumentException.class, ()->{
			EmployeeSearch.searchByAge(null, 10);
		});
	}

}
