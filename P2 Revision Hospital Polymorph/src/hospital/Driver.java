package hospital;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {

		Employee e1 = new Porter("Porter1", "P1LastName", 10, "Royal");
		Employee e2 = new Pharmacist("Pharm1", "PharmLast1", 20.50, 2, 200);
		Employee e3 = new Surgeon("Surg1", "SurgLast1", 30.00, "Neuro", 300);

		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);

		for (Employee e : employees) {
			e.calculateSalary(37.5);
			System.out.println();
		}

		System.out.println("Searching");
		ArrayList<Employee> search = SearchUtil.searchByLastName(employees, "e");
		displayEmployees(search);
		
		System.out.println("Payroll");
		payroll(employees, 30);
	}

	public static void displayEmployees(ArrayList<Employee> employeeList) {
		if (employeeList == null) {
			System.out.println("Empty list");
		} else {
			if (employeeList.size() == 0) {
				System.out.println("No records found");
			} else {
				for (Employee e : employeeList) {
					e.printAll();
				}
			}
		}
	}
	
	public static void payroll(ArrayList<Employee> employeeList, double hours) {
		if(employeeList==null) {
			System.out.println("List is null");
		} else if(employeeList.size()==0) {
			System.out.println("Empty list");
		} else {
			for(Employee e : employeeList) {
				e.printAll();
				System.out.println("Salary: "+e.calculateSalary(hours));
				System.out.println();
			}
		}
	}

}
