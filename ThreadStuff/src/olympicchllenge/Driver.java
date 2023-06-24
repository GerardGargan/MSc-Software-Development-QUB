package olympicchllenge;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<RaceThread> swimmers = new ArrayList<RaceThread>();
		RaceThread s1 = new RaceThread("Usain Bolt", 9.81);
		RaceThread s2 = new RaceThread("Justin Gatlin", 9.890);
		RaceThread s3 = new RaceThread("Andre De Grasse", 11.910);
		RaceThread s4 = new RaceThread("Akani Simbine", 9.930);
		RaceThread s5 = new RaceThread("Ben Youssef", 9.940);
		RaceThread s6 = new RaceThread("Jimmy Vicaut", 14.960);
		RaceThread s7 = new RaceThread("Trayvon Bromell", 10.040);
		
		swimmers.add(s1);
		swimmers.add(s2);
		swimmers.add(s3);
		swimmers.add(s4);
		swimmers.add(s5);
		swimmers.add(s6);
		swimmers.add(s7);
		
		System.out.println("Race starting");
		for(RaceThread swimmer : swimmers) {
			Thread th = new Thread(swimmer);
			th.start();
		}
		
		
	}

}
