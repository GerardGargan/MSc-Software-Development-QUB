package train;

import java.util.ArrayList;
import java.util.List;

public class Carriage {
	
	private int maxPassengers;
	private List<Passenger> passengers = new ArrayList<Passenger>();
	private PASSENGER_CLASS passengerType;
	
	
	
	/**
	 * @param maxPassengers
	 * @param passengerType
	 */
	public Carriage(int maxPassengers, PASSENGER_CLASS passengerType) {
		setMaxPassengers(maxPassengers);
		setPassengerType(passengerType);
	}
	/**
	 * @return the maxPassengers
	 */
	public int getMaxPassengers() {
		return maxPassengers;
	}
	/**
	 * @param maxPassengers the maxPassengers to set
	 */
	public void setMaxPassengers(int maxPassengers) {
		this.maxPassengers = maxPassengers;
	}
	/**
	 * @return the passengerType
	 */
	public PASSENGER_CLASS getPassengerType() {
		return passengerType;
	}
	/**
	 * @param passengerType the passengerType to set
	 */
	public void setPassengerType(PASSENGER_CLASS passengerType) {
		this.passengerType = passengerType;
	}
	
	public void addPassenger(Passenger p) {
		passengers.add(p);
	}
	
	public int currentPassengers() {
		return passengers.size();
	}
	
	public void displayAll(){
		System.out.println("Carriage details:");
		System.out.println("Max Passengers: "+maxPassengers);
		System.out.println("Passenger type: "+passengerType);
		
		//display all passengers on carriage:
		System.out.println("Displaying all passengers on carriage");
		for(Passenger p : passengers) {
			System.out.println(p.toString());
		}
	}
	
	public boolean carriageNotFull() {
		if(currentPassengers()<getMaxPassengers()) {
			return true;
		} else {
			return false;
		}
	}
}
