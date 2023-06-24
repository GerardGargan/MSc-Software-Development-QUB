package queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exercise {

	public static void main(String[] args) throws InterruptedException {

		String[] nameArray = new String[] {"James", "Gerard", "Arthur", "Eileen", "Caoimhe", "Betty", "Maureen", "Alice"};
		List<String> names = Arrays.asList(nameArray);
		
		Queue<String> queue = new LinkedList<String>(names);
		
		for(int i=queue.size(); i>0; i--) {
			System.out.println(queue.poll());
			Thread.sleep(500);;
		}
		
	}

}
