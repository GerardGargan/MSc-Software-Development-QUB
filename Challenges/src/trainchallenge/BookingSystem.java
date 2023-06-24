package trainchallenge;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

	public static void main(String[] args) {
		Passenger p1 = new Passenger("Gerard", "Gargan", 1, PassengerClass.FIRST);
		Passenger p2 = new Passenger("Caomimhe", "Gargan", 1, PassengerClass.FIRST);
		Passenger p3 = new Passenger("Eileen", "Christie", 1, PassengerClass.SECOND);
		Passenger p4 = new Passenger("Arthur", "Christie", 1, PassengerClass.FIRST);
		Passenger p5 = new Passenger("James", "Gargan", 1, PassengerClass.SECOND);
		Passenger p6 = new Passenger("Michael", "Drain", 1, PassengerClass.FIRST);
		Passenger p7 = new Passenger("Ann", "Drain", 1, PassengerClass.SECOND);
		Passenger p8 = new Passenger("Alfie", "Gargan", 1, PassengerClass.FIRST);
		Passenger p9 = new Passenger("Lola", "Gargan", 1, PassengerClass.FIRST);
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		passengers.add(p1);
		passengers.add(p2);
		passengers.add(p3);
		passengers.add(p4);
		passengers.add(p5);
		passengers.add(p6);
		passengers.add(p7);
		passengers.add(p8);
		passengers.add(p9);
				
		Carriage c1 = new Carriage(4, PassengerClass.FIRST);
		Carriage c2 = new Carriage(4, PassengerClass.SECOND);
		
		Train t1 = new Train(2);
		t1.addCarriage(c1);
		t1.addCarriage(c2);
		
		for(Passenger p : passengers) {
			t1.addPassenger(p);
			
		}
		
		t1.displayAllTrainDetails();
	}

}
