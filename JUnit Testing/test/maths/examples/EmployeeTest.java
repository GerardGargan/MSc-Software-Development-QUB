package maths.examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
	//test data
	Employee emp;
	String nameValidLow, nameValidMid, nameValidHigh;
	String nameInvalidValidLow,nameInvalidValidHigh,nameInvalidNull;
	
	int ageValidLow,ageValidMid,ageValidHigh;
	int ageInvalidLow,ageInvalidHigh;
	
	double validSalary1, validSalary2, invalidSalary3;

	@BeforeEach
	void setUp() throws Exception {
		nameValidLow = "aa";
		nameValidMid= "aaaaaaaaaaaaaaa";
		nameValidHigh= "x".repeat(20);
		nameInvalidValidLow = "x";
		nameInvalidValidHigh = "x".repeat(21);
		nameInvalidNull = null;
		
		ageValidLow = 0;
		ageValidMid = 34;
		ageValidHigh = 65;
		ageInvalidLow = -1;
		ageInvalidHigh = 66;
		
		validSalary1 = 0; 
		validSalary2 = 2000; 
		invalidSalary3 = -0.01;
		
		emp = new Employee();
		
	}

	@Test
	void testEmployee() {
		fail("Not yet implemented");
	}

	@Test
	void testEmployeeConstructorWithArgsValidData() {
		Employee empArgs = new Employee(nameValidMid, ageValidMid, validSalary1);
		assertNotNull(empArgs);
		assertEquals(nameValidMid, empArgs.getName());
		assertEquals(ageValidMid, empArgs.getAge());
		assertEquals(validSalary1, empArgs.getSalary());
	}
	
	@Test
	void testEmployeeConstructorWithArgsInvalidData() {
		//need to test each one individually with one which is invalid.. change and test each one. 
		//Dont test all invalid at once in the same constructor
		assertThrows(IllegalArgumentException.class, ()->{
			new Employee(nameInvalidValidLow, ageValidMid, validSalary1);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Employee(nameValidMid, ageInvalidLow, validSalary1);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			new Employee(nameValidMid, ageValidMid, invalidSalary3);
		});
	}
	
	@Test
	void testGetSetName() {
		//testing the happy path
		emp.setName(nameValidLow);
		assertEquals(nameValidLow, emp.getName());
		
		emp.setName(nameValidMid);
		assertEquals(nameValidMid, emp.getName());
		
		emp.setName(nameValidHigh);
		assertEquals(nameValidHigh, emp.getName());
	}
	
	@Test
	void testSetNameInvalid() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			emp.setName(nameInvalidValidLow);
		});
		
		Exception exp2 = assertThrows(IllegalArgumentException.class, ()->{
			emp.setName(nameInvalidValidHigh);
		});
		
		assertEquals("Invalid name length", exp.getMessage()); //checking the message
		
		Exception exp3 = assertThrows(IllegalArgumentException.class, ()->{
			emp.setName(null);
		});
		
		assertEquals("Name cant be null", exp3.getMessage()); //checking the message
	}

	@Test
	void testGetSetAge() {
		//testing the happy data
		emp.setAge(ageValidLow);
		assertEquals(ageValidLow, emp.getAge());
		
		emp.setAge(ageValidMid);
		assertEquals(ageValidMid, emp.getAge());
		
		emp.setAge(ageValidHigh);
		assertEquals(ageValidHigh, emp.getAge());
	}
	
	@Test
	void testSetInvalidAge() {
		//testing the unhappy data
		assertThrows(IllegalArgumentException.class, ()->{
			emp.setAge(ageInvalidLow);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			emp.setAge(ageInvalidHigh);
		});
	
	}

	@Test
	void testGetSetSalary() {
		//testing with happy data
		emp.setSalary(validSalary1);
		assertEquals(validSalary1, emp.getSalary());
		
		emp.setSalary(validSalary2);
		assertEquals(validSalary2, emp.getSalary());
	}
	
	@Test
	void testInvalidSalary() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			emp.setSalary(invalidSalary3);
		});
		
		assertEquals("Cant set negative salary",exp.getMessage());
	}

}
