package car;

public class CarFactory {

	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setMake("Ford");
		car1.setModel("Fiesta");
		car1.setColour("Blue");
		car1.setNumberOfDoors(4);
		car1.setEngineSize(1.2);
		car1.setMaxSpeed(110);
		
		Car car2 = new Car();
		car2.setMake("Peugeot");
		car2.setModel("308");
		car2.setColour("Silver");
		car2.setNumberOfDoors(4);
		car2.setEngineSize(1.8);
		car2.setMaxSpeed(130);
		
		Car car3 = new Car();
		car3.setMake("Ferrari");
		car3.setModel("F4");
		car3.setColour("Red");
		car3.setNumberOfDoors(2);
		car3.setEngineSize(2.8);
		car3.setMaxSpeed(230);
		
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println(car3.toString());
		
		car1.startCar();
		System.out.println(car1.toString());
		car1.startCar();
		
		car1.stopCar();
		System.out.println(car1.toString());

	}

}
