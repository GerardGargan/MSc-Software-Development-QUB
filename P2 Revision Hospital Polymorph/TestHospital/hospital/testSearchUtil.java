package hospital;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testSearchUtil {
	
	Employee e1,e2,e3;
	ArrayList<Employee> employeeList;
	ArrayList<Employee> emptyList;

	@BeforeEach
	void setUp() throws Exception {
		employeeList = new ArrayList<Employee>();
		emptyList = new ArrayList<Employee>();
		e1 = new Porter("John", "Wright", 13, "Royal");
		e2 = new Surgeon("Jim", "Left", 13, "Test", 200);
		e3 = new Pharmacist("Maureen", "gargan", 13, 2, 200);
		
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
	}

	@Test
	void testSearchByLastNameValid() {
		ArrayList<Employee> search = hospital.SearchUtil.searchByLastName(employeeList, "gargan");
		assertTrue(search.size()==1);
		assertTrue(search.contains(e3));
	}
	@Test
	void testSearchInvalid() {
		Exception e = assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByLastName(null, "test");
		});
		
		Exception d = assertThrows(IllegalArgumentException.class, ()->{
			SearchUtil.searchByLastName(emptyList, "gargan");
		});
		
		assertEquals("array list cant be null", e.getMessage());
		assertEquals("Empty array list", d.getMessage());
	}

}
