package flights;

public class AirTrafficControl {

	public static void main(String[] args) {
		Flight f1 = new Flight("ESY3214", "Belfast", "Amsterdam", 2.2);
		Flight f2 = new Flight("BA127", "London Heathrow", "Cape Town", 11.5);
		Flight f3 = new Flight("AE999", "Dublin", "New York JFK", 7.5);
		Flight f4 = new Flight("AA678", "Dublin", "Newwark", 8.5);
		
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		System.out.println(f3.toString());
		System.out.println(f4.toString());
		
		Flight[] flights = new Flight[4];
		flights[0] = f1;
		flights[1] = f2;
		flights[2] = f3;
		flights[3] = f4;
		
		System.out.println(flights[0].getFlightNumber());
		
		System.out.println("Outputitng all flights from array");
		for(Flight i : flights) {
			System.out.println(i.toString());
		}
		
		double LongestDuration = flights[0].getDuration();
		
		for(int i=0; i<flights.length; i++) {
			if(flights[i].getDuration()>LongestDuration) {
				LongestDuration = flights[i].getDuration();
			}
		}
		System.out.println("Flight with longest duration: "+LongestDuration);
		
		System.out.println("Flights with a destination of Dublin: ");
		for(int i=0; i<flights.length; i++) {
			if(flights[i].getDestination().equals("Dublin")) {
				System.out.println(flights[i].toString());
			}
		}
		
		Flight f5 = new Flight("AUS12", "Beijing", "Paris", 18.1);
		System.out.println(f5.toString());
	}

}
