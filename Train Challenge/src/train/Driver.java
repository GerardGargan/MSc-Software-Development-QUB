package train;

public class Driver {

	public static void main(String[] args) {
		
		Passenger p1 = new Passenger("Gerard", 1, PASSENGER_CLASS.FIRST, "Gargan");
		Passenger p2 = new Passenger("Caoimhe", 1, PASSENGER_CLASS.FIRST, "Gargan");
		Passenger p3 = new Passenger("Gerry", 1, PASSENGER_CLASS.SECOND, "Gargano");
		Passenger p4 = new Passenger("dupe", 1, PASSENGER_CLASS.SECOND, "hello");
		
		Carriage c1 = new Carriage(1, PASSENGER_CLASS.FIRST);
		Carriage c2 = new Carriage(2, PASSENGER_CLASS.SECOND);
		
		
		Train t1 = new Train(2);
		t1.addCarriage(c1);
		t1.addCarriage(c2);
		
		t1.addPassenger(p1);
		t1.addPassenger(p2);
		t1.addPassenger(p3);
		t1.addPassenger(p4);
		t1.displayAllDetails();
		
	}

}
