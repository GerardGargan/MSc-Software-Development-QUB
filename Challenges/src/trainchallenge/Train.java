package trainchallenge;

import java.util.ArrayList;

public class Train {
	private int maxCarriages;
	private ArrayList<Carriage> carriages;

	/**
	 * @param maxCarriages
	 * @param carriages
	 */
	public Train(int maxCarriages) {
		setMaxCarriages(maxCarriages);
		carriages = new ArrayList<Carriage>();
	}

	/**
	 * @return the maxCarriages
	 */
	public int getMaxCarriages() {
		return maxCarriages;
	}

	/**
	 * @param maxCarriages the maxCarriages to set
	 */
	public void setMaxCarriages(int maxCarriages) {
		this.maxCarriages = maxCarriages;
	}

	/**
	 * @return the carriages
	 */
	public ArrayList<Carriage> getCarriages() {
		return carriages;
	}

	private int getTotalCurrentPassengers() {
		int total = 0;
		for (Carriage c : carriages) {
			total += c.currentPassengers();
		}

		return total;
	}

	private int getMaxTrainCapacity() {
		int total = 0;
		for (Carriage c : carriages) {
			total += c.getMaxPassengers();
		}

		return total;
	}

	public void addCarriage(Carriage c) {
		if (carriages.size() < getMaxCarriages()) {
			carriages.add(c);
		}
	}

	public void addPassenger(Passenger passenger) {
		PassengerClass pClass = passenger.getPassengerClass();

		boolean passAdded = false;
		// keep looping until passenger added

		for (Carriage carriage : carriages) {
			// check if carriage is not full
			if (!carriage.carriageFull()) {
				// we are here so there is space in the carriage, now check if the passenger
				// class matches the carriage class
				if (carriage.getPassengerClass() == passenger.getPassengerClass()) {
					// classes match, add the passenger
					carriage.addPassenger(passenger);
					passAdded = true;
					break;

				} else if (passenger.getPassengerClass() == PassengerClass.FIRST) {
					// there was no match, check if the passenger is first class, if so add them to
					// the second class carriage
					carriage.addPassenger(passenger);
					passAdded = true;
					break;

				} else {
					System.out.println("First class carriage, second class passenger.. checking next carriage");
				}

			} else {
				System.out.println("Carriage full, checking next carriage");
			}
			// no space, let it go around the loop again to check against the next carriage

		}
		if (passAdded == false) {
			System.out.println("No space, buy a first class ticket or wait on next train");
		}

	}

	public void displayAllTrainDetails() {
		for (Carriage c : carriages) {
			c.displayCarriageDetails();
		}
	}

}
