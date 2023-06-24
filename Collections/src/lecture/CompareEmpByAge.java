package lecture;


import java.util.Comparator;

public class CompareEmpByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getAge() - o2.getAge();
	}

}
