package secondattempt;

public class Driver {

	public static void main(String[] args) {

		Passenger p1 = new Passenger("Gerard", 1, PassengerType.FIRST, "Gargan");
		Passenger p2 = new Passenger("Caoimhe", 1, PassengerType.SECOND, "Gargan");
		Passenger p3 = new Passenger("Ryan", 1, PassengerType.FIRST, "Gargan");
		Passenger p4 = new Passenger("eileen", 1, PassengerType.FIRST, "Gargan");
		Passenger p5 = new Passenger("Artur", 1, PassengerType.SECOND, "Gargan");
		Passenger p6 = new Passenger("Dad", 1, PassengerType.SECOND, "Gargan");
		
		Carriage c1 = new Carriage(2, PassengerType.FIRST);
		Carriage c2 = new Carriage(3, PassengerType.SECOND);
		
		Train t1 = new Train(2);
		t1.addCarriage(c1);
		t1.addCarriage(c2);
		
		t1.addPassenger(p1);
		t1.addPassenger(p2);
		t1.addPassenger(p3);
		t1.addPassenger(p4);
		t1.addPassenger(p5);
		t1.addPassenger(p6);
		
		System.out.println();
		System.out.println();
		t1.printTrainDetails();

	}

}
