package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lecture.CompareEmpByAge;
import lecture.Employee;

public class SetDemo {
	public static void main(String[] args) {
		String[] colours = new String[] {"red","blue","red","green", "red", "green","yellow","Indigo"};
		List<String> theList = new LinkedList<String>(Arrays.asList(colours));
		
		
		System.out.println(theList);
		
		printNonDupe(theList);
		
		Set<Employee> empTree = new TreeSet<>(new CompareEmpByAge()); //using comparator
		empTree.add(new Employee("Matthew", 38, "FT"));
		empTree.add(new Employee("Matthew Jr", 7, "FT"));
		empTree.add(new Employee("Matthew Sr", 77, "FT"));
		
		System.out.println(empTree);
	}

	public static void printNonDupe(List<String> input) {
		Set<String> mySet = new TreeSet<String>();
		
		for(String value : input) {
			//System.out.println("Adding "+value);
			boolean added = mySet.add(value);
			//System.out.println("added? "+added);
		}
		
		System.out.println(mySet);
		
	}
}
