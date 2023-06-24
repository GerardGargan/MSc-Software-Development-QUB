package secondattempt;

import java.util.ArrayList;

public class Carriage {
	private int maxPassengers;
	private PassengerType passengerType;
	private ArrayList<Passenger> passengers;
	
	
	
	/**
	 * @param maxPassengers
	 * @param passengerType
	 */
	public Carriage(int maxPassengers, PassengerType passengerType) {
		this.maxPassengers = maxPassengers;
		this.passengerType = passengerType;
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
	 * @return the passengerType
	 */
	public PassengerType getPassengerType() {
		return passengerType;
	}
	/**
	 * @param passengerType the passengerType to set
	 */
	public void setPassengerType(PassengerType passengerType) {
		this.passengerType = passengerType;
	}
	/**
	 * @return the passengers
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	/**
	 * @param passengers the passengers to set
	 */
	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}
	
	public boolean isCarriageFull() {
		if(numOfCurrentPassengers()==maxPassengers) {
			return true;
		} else {
			return false;
		}
	}
	
	public int numOfCurrentPassengers() {
		return passengers.size();
	}
	
	public void displayCarriageDetails() {
		System.out.println("Carriage details: ");
		System.out.println("Max capacity: "+maxPassengers);
		System.out.println("Class: "+passengerType);
		
		displayAllPassengers();
		System.out.println();
	}
	
	private void displayAllPassengers() {
		if(passengers==null || passengers.size()==0) {
			System.out.println("No passengers on this carriage yet");
		} else {
			for(Passenger p : passengers) {
				p.displayPassengerDetails();
				System.out.println();
			}
			System.out.println("End of passengers in this carriage");
			
		}
	}
	
	
	
}
