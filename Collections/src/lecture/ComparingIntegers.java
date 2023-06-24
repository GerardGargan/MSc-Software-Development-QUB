package lecture;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparingIntegers {

	public static void main(String[] args) {
		
		//must use compare to rather than relational operators for wrapper class (not > >= = <= <)
		Integer first = 50;
		Integer second = 45;
		
		int result = first.compareTo(second);
		
		if(first.compareTo(second)<0) {
			System.out.println("First is smallest");
		} else if(first.compareTo(second)>0) {
			System.out.println("Second is smallest");
		} else {
			System.out.println("they are equal");
		}
		
		System.out.println(result);
		
		List<Integer> moreNums = Arrays.asList(new Integer[] {3,5,77,4,-5,33});
		System.out.println(moreNums);
		Collections.sort(moreNums);
		System.out.println(moreNums);

	}

}
