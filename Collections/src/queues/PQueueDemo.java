package queues;

import java.util.PriorityQueue;

import lecture.Employee;

public class PQueueDemo {

	public static void main(String[] args) throws InterruptedException {


		 PriorityQueue<Double> ranked = new PriorityQueue<Double>();
		 ranked.add(10.8);
		 ranked.add(7.2);
		 ranked.add(17.2);
		 ranked.add(-2.5);
		 
		 while(!ranked.isEmpty()) {
			 System.out.println(ranked.poll());
			 Thread.sleep(500);;
		 }

	}

}
