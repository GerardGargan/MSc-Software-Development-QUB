package practicals;

public class Liftoff {

	public static void main(String[] args) {

		for (int count = 10; count >= 1; count--) {

			System.out.print(count + ", ");

		}

		System.out.println("Liftoff!");
		
		//Now repeat this using a while loop
		
		int whileCount = 10;
		
		while(whileCount >= 1) {
			System.out.print(whileCount+", ");
			whileCount--;
		}
		System.out.println("Liftoff!");

	}
	
	

}
