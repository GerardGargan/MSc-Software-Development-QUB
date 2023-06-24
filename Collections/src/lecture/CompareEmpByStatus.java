package lecture;

import java.util.Comparator;

public class CompareEmpByStatus implements Comparator<Employee>{
    @Override
    //Put PT infront of FT
    public int compare(Employee o1, Employee o2) {
        if(o1.getStatus().equals("PT") && o2.getStatus().equals("FT")) {
            return -1;
        }else if (o1.getStatus().equals("FT") && o2.getStatus().equals("PT")) {
            return 1;
        }else {
            return 0;
        }
    }
}
