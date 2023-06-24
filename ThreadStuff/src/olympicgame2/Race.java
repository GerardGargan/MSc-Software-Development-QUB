package olympicgame2;

import java.util.ArrayList;
import java.util.List;

public class Race {

	public static void main(String[] args) {

		Runner r1 = new Runner("Usain Bolt", 5.981);
		Runner r2 = new Runner("Justin Gatlin", 10.890);
		Runner r3 = new Runner("Andrew De Grasse", 15.910);
		Runner r4 = new Runner("Yohan Blake", 7.930);
		Runner r5 = new Runner("Akani Simbine", 14.940);
		Runner r6 = new Runner("Ben Youssef Meite", 8.960);

		List<Runner> runners = new ArrayList<Runner>();
		runners.add(r1);
		runners.add(r2);
		runners.add(r3);
		runners.add(r4);
		runners.add(r5);
		runners.add(r6);

		
		try {
			System.out.println("ON YOUR MARKS");
			Thread.sleep(2000);
			System.out.println("READY");
			Thread.sleep(3000);
			System.out.println("BANG! Race Started");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Runner runner : runners) {
			Thread th = new Thread(runner);
			th.start();
		}
		
	}

}
