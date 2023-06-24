package hospitalpayroll;

public class PayrollManager {
	public static final int HOURS_PER_WEEK = 35;
	public static Employee[] employees = new Employee[6];
	
	public static void main(String[] args) {
		
		Employee p1 = new Porter("Ivana", "Patient", 10.5, "Royal");
		Employee p2 = new Porter("Amanda", "Pushabed", 10.5, "BCH");
		Employee s1 = new Surgeon("Jack", "Ripper", 55.25, "Renal", 650);
		Employee s2 = new Surgeon("Edward", "Lister", 55.25, "Vascular", 800);
		Employee ph1 = new Pharmacist("Poppy", "Pill", 30.5, 7, 750);
	
		addEmployeeToList(p1);
		addEmployeeToList(p2);
		addEmployeeToList(s2);
		addEmployeeToList(s1);
		addEmployeeToList(ph1);
		
		displayAllEmployees(employees);
		processWeeklyPayroll(employees);
	}
	
	public static void addEmployeeToList(Employee e) {
		for(int i=0; i<employees.length; i++) {
			if(employees[i]==null) {
				employees[i]=e;
				break;
			}
		}
	}
	
	public static void displayAllEmployees(Employee[] employees) {
		for(Employee e : employees) {
			if(e!=null) {
			System.out.println(e.printAll());
			} else {
				break;
			}
		}
	}
	
	public static void processWeeklyPayroll(Employee[] employees) {
		for(Employee e : employees) {
			if(e!=null) {
				System.out.println(e.calculateWeeklySalary(HOURS_PER_WEEK));
			}
		}
	}
	
}
