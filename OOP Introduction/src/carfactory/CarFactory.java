package carfactory;

public class CarFactory {

	public static void main(String[] args) {
		Car c1 = new FamilySaloon("Audi", "A3", 130, true);
		Car c2 = new F1("Ferarri", "Maranello", 2330, 1.24);
		Car c3 = new F1("McLaren", "MCL2016", 2320, 1.12);
		Car c4 = new RallyCar("Subaru", "Impreza", 143, 1.98);
		Car c5 = new FamilySaloon("Subaru", "Legacy", 123, false);
		
		Car[] cars = {c1,c2,c3,c4,c5};
		
		//display all cars in the array
		for(Car c : cars) {
			System.out.println(c.displayAll());
		}
		
		leastHorsepower(cars);
		displayMake(cars);
		avgHP(cars);

	}

	public static void avgHP(Car[] cars) {
		int sum = 0;
		double avg = 0;
		for(int i=0; i<cars.length; i++) {
			sum += cars[i].getHorsePower();
		}
		avg = (double)sum/cars.length;
		System.out.println("Average HP: "+avg);
	}

	public static void displayMake(Car[] cars) {
		System.out.println("Displaying all makes:");
		for(Car c : cars) {
			System.out.println(c.getMake());
		}
		
	}

	public static void leastHorsepower(Car[] cars) {
		int leastHP = cars[0].getHorsePower();
		//loop through to find the lowest horsepower
		for(int i=0; i<cars.length; i++) {
			if(cars[i].getHorsePower()<leastHP) {
				leastHP = cars[i].getHorsePower();
			}
		}
		System.out.println("Least HP: "+leastHP);
		//loop through and outoput the models that match this HP
		System.out.println("Cars with least Horsepower:");
		for(int i=0; i<cars.length; i++) {
			if(cars[i].getHorsePower()==leastHP) {
				System.out.println(cars[i].getModel());
			}
		}
		
	}

}
