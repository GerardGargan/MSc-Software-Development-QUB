package train;

import java.util.ArrayList;
import java.util.List;

public class Train {

	private List<Carriage> carraiges = new ArrayList<Carriage>();
	private int maxNumCarraiges;

	public void addPassenger(Passenger p) {
		/*
		 * 1st class passengers are allocated to the first available first class
		 * carriage. If none available then they go to the first available 2nd class. If
		 * none available then they are told to wait until the next train.
		 * 
		 * 2nd class passengers are allocated to the first available 2nd class carriage.
		 * If none available then they are told to wait until the next train.
		 */

		if(getTotalCurrentPassengers()<getTrainMaxCapacity()) {
			//we can add, below max capacity
			for(Carriage c : carraiges) {
				if(c.carriageNotFull()) {
					//carriage is not full, continue
					if(p.getPassengerClass()==c.getPassengerType()) {
						//passenger type matches the carraige type, add them
						c.addPassenger(p);						
						System.out.println("Adding to the matching class");
						break;
					} else if(p.getPassengerClass()==PASSENGER_CLASS.FIRST && c.getPassengerType()==PASSENGER_CLASS.SECOND) {
						c.addPassenger(p);
						System.out.println("Adding you to second class, no seats in first");
						break;
					} else {
						System.out.println("You need to upgrade your ticket, only seats left in first!");
						break;
					}
				}
			}
		} else {
			System.out.println("At max capacity, wait for the next train");
		}
		

	}

	private int getTotalCurrentPassengers() {
		int totalPass = 0;

		for (Carriage c : carraiges) {
			totalPass += c.currentPassengers();
		}

		return totalPass;
	}

	private int getTrainMaxCapacity() {
		int max = 0;

		for (Carriage c : carraiges) {
			max += c.getMaxPassengers();
		}

		return max;
	}

	/**
	 * @param maxNumCarraiges
	 */
	public Train(int maxNumCarraiges) {
		this.maxNumCarraiges = maxNumCarraiges;
	}

	public void addCarriage(Carriage c) {
		if (getNumCarriages() < maxNumCarraiges) {
			carraiges.add(c);
		} else {
			System.out.println("Max carriages reached");
		}
	}

	public int getNumCarriages() {
		return carraiges.size();
	}

	/**
	 * @return the maxNumCarraiges
	 */
	public int getMaxNumCarraiges() {
		return maxNumCarraiges;
	}

	/**
	 * @param maxNumCarraiges the maxNumCarraiges to set
	 */
	public void setMaxNumCarraiges(int maxNumCarraiges) {
		this.maxNumCarraiges = maxNumCarraiges;
	}

	public void displayAllDetails() {
		System.out.println("Train...");
		System.out.println("Max number of carriages: " + maxNumCarraiges);
		System.out.println();

		System.out.println("Displaying all carriages: ");
		for (Carriage c : carraiges) {
			c.displayAll();
			System.out.println();
		}
	}

}
