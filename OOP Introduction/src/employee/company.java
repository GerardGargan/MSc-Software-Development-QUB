package employee;

public class company {

	public static void main(String[] args) {
		Employee e1 = new Employee("Gerard","Gargan");
		Employee e2 = new Employee("Matthew","Collins");
		Employee e3 = new Employee("Someone","Else");
		
		e1.displayDetails();
		e2.displayDetails();
		e3.displayDetails();
		
		System.out.println(Employee.getCount()); //static call to method

	}

}
