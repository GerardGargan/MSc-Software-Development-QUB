package flights;

public class Flight {
	
	private String flightNumber, destination, origin;
	private double duration;
	
	public Flight() {
		
	}
	
	public Flight(String flightNumber, String destination, String origin, double duration) {
		setFlightNumber(flightNumber);
		setDestination(destination);
		setOrigin(origin);
		setDuration(duration);
	}
	
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public void setDuration(double duration) {
		if(duration>0 && duration<=18) {
			this.duration = duration;
		} else {
			this.duration = 0;
			System.out.println("Invalid duration (>=18 hrs)");
		}
	}
	
	public double getDuration() {
		return duration;
	}
	
	public String toString() {
		return String.format("Flight Number: %s\t Destination: %s\t\t Origin: %s\t Duration: %.1f",getFlightNumber(),getDestination(),getOrigin(),getDuration());
	}
}
