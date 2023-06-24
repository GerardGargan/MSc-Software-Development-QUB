package secondattempt;

import java.util.ArrayList;

public class Train {
	private ArrayList<Carriage> carriages;
	private int maxNumberOfCarriages;

	/**
	 * @param carriages
	 * @param maxNumberOfCarriages
	 */
	public Train(int maxNumberOfCarriages) {
		this.maxNumberOfCarriages = maxNumberOfCarriages;
		carriages = new ArrayList<Carriage>();
	}
	
	public void addPassenger(Passenger p) {
		//check if train has free capacity
		if(getTotalPassengers()==getMaxTrainCapacity()) {
			System.out.println("No free space on train, wait for the next one");
		} else {
			//free space on train, check if the passenger type equals the carriage type, if so add
			//loop through each carriage to check
			boolean isPassAdded = false;
			for(Carriage c : carriages) {
				if(p.getPassengerType()==c.getPassengerType() && !c.isCarriageFull()) {
					//carriage not full, passenger type matches the carriage, add them
					c.addPassenger(p);
					isPassAdded = true;
					System.out.println("Added passenger success");
					break;
					
				} else if(p.getPassengerType()==PassengerType.FIRST && !c.isCarriageFull()) {
					//forget about matching the class, check if they are first class & add them even if it is a second class carriage
					c.addPassenger(p);
					isPassAdded = true;
					System.out.println("Adding to second class, no space in first");
					break;
					
				} 
				
			}
			
			//moved this outside the loop, as we need the loop to go through every carriage and not exit until it is finished checking all carriages
			if(!isPassAdded) {
				//if we are here and the person is not added, there are empty seats - which must mean the person is second class, 
				// & there is only space left in first class. Dont add them offer them a chance to upgrade
				System.out.println("You need to upgrade your ticket to get into first class");
			}
		}
	}

	private int numOfCurrentCarriages() {
		return carriages.size();
	}

	/**
	 * @return the carriages
	 */
	public ArrayList<Carriage> getCarriages() {
		return carriages;
	}
	
	public int getTotalPassengers() {
		int totalPass = 0;
		if(carriages==null || carriages.size()==0) {
			System.out.println("No carriages, cannot check number of passengers");
		} else {
			for(Carriage c : carriages) {
				totalPass += c.numOfCurrentPassengers();
			}
		}
		return totalPass;
	}
	
	public int getMaxTrainCapacity() {
		int maxCap = 0;
		
		for(Carriage c : carriages) {
			maxCap += c.getMaxPassengers();
		}
		
		return maxCap;
	}

	/**
	 * @param carriages the carriages to set
	 */
	public void addCarriage(Carriage carriage) {
		if (numOfCurrentCarriages() == maxNumberOfCarriages) {
			System.out.println("Max carriages reached, cant add any more");
		} else {
			carriages.add(carriage);
		}
	}

	/**
	 * @return the maxNumberOfCarriages
	 */
	public int getMaxNumberOfCarriages() {
		return maxNumberOfCarriages;
	}

	/**
	 * @param maxNumberOfCarriages the maxNumberOfCarriages to set
	 */
	public void setMaxNumberOfCarriages(int maxNumberOfCarriages) {
		this.maxNumberOfCarriages = maxNumberOfCarriages;
	}
	
	public void printTrainDetails() {
		System.out.println("Train details...");
		System.out.println("Max num of carriages: "+maxNumberOfCarriages);
		System.out.println("Total capacity: "+getMaxTrainCapacity());
		System.out.println("Total carriages: "+carriages.size());
		
		//print details of each carriage, which includes a call to passenger details
		for(Carriage c : carriages) {
			c.displayCarriageDetails();
		}
	}

}
