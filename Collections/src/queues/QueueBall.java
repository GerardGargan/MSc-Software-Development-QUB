package queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBall {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		
		queue.add("Matthew");
		queue.add("Rory");
		queue.add("Sara");
		queue.add("Christopher");
		queue.add("Alyssa");
		queue.add("Nathaniel");
		
		String name;
		
		while(!queue.isEmpty()){
		System.out.println(queue.size());
		name = queue.remove();
		
		
		System.out.println(name);
		System.out.println(queue.size());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		

	}

}
