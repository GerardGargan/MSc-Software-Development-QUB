package lecture;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CompareEmployeeDemo {
    public static void main(String[] args) {
        Employee e1 = new Employee("Matthew", 37, "PT");
        Employee e2 = new Employee("Alice", 45, "FT");
        Employee e3 = new Employee("Bob", 88, "PT");
        Employee e4 = new Employee("Zach", 19, "FT");
        List<Employee> staffList = new LinkedList<Employee>();
        staffList.add(e1);
        staffList.add(e2);
        staffList.add(e3);
        staffList.add(e4);
        
       // Collections.sort(staffList, new CompareEmpByStatus());
        
        showAll(staffList);
        
        //find oldest person in the list
        Employee oldest = Collections.max(staffList, new CompareEmpByAge());
        System.out.println("Oldest");
        System.out.println(oldest);
        //pass by reference will change original
        oldest.setName("Adam");
        System.out.println(e3);
        
    }
    public static void showAll(Collection<Employee> inputList) {
        for (Employee value : inputList) {
            System.out.println(value.toString());
        }
        System.out.println("*****");
    }
}