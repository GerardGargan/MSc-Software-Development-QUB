package trainchallenge;

import java.util.ArrayList;

public class Carriage {
	private int maxPassengers;
	private PassengerClass passengerClass;
	private ArrayList<Passenger> passengers;
	
	
	
	/**
	 * @param maxPassengers
	 * @param passengerClass
	 */
	public Carriage(int maxPassengers, PassengerClass passengerClass) {
		setMaxPassengers(maxPassengers);
		setPassengerClass(passengerClass);
		passengers = new ArrayList<Passenger>();
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
	 * @return the passengerClass
	 */
	public PassengerClass getPassengerClass() {
		return passengerClass;
	}
	/**
	 * @param passengerClass the passengerClass to set
	 */
	public void setPassengerClass(PassengerClass passengerClass) {
		this.passengerClass = passengerClass;
	}
	
	public int currentPassengers() {
		return passengers.size();
	}
	
	public boolean carriageFull() {
		if(passengers.size()==maxPassengers) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addPassenger(Passenger passenger) {
		if(!carriageFull()) {
			passengers.add(passenger);
		}
	}
	
	public void displayCarriageDetails() {
		System.out.println("Passengers on carriage: ");
		for(Passenger p : passengers) {
			System.out.println(p.toString());
		}
	}
	
	
}
