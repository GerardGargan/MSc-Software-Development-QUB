package whale;

public class WhaleWatcher {

	public static void main(String[] args) {
		Animal w1 = new Whale("Right", "Atlantic", 2001, 21, 16);
		Animal w2 = new Whale("Blue", "Pacific", 2001, 23, 16);
		Animal w3 = new Whale("Sperm", "Atlantic", 1900, 20, 40);
		Animal w4 = new Whale("Humpback", "Antartic", 919, 13, 13);

		Animal[] whales = { w1, w2, w3, w4 };

		// Use the array to output all the details for each Whale (use the toString()
		// method).
		for (Animal a : whales) {
			System.out.println(a.toString());
		}

		// Use the array to output the names of the whales that swim mostly in the
		// Atlantic
		for (Animal a : whales) {
			Whale w = (Whale) a;
			if (w.getMainOcean().equalsIgnoreCase("Atlantic")) {
				System.out.println(w.getName() + " " + w.getMainOcean());
			}
		}
		
		//Use an array  to output the name of the whale(s) that swim fastest
		swimFastest(whales);
		
		//Output average length of the all whales
		avgLength(whales);
		
		//Use an array to output the name of the heaviest whale(s)
		heaviestWhales(whales);
	}
	
	public static void heaviestWhales(Animal[] whales) {
		Whale w = (Whale) whales[0];
		int heaviest = w.getWeight();
		String heaviestName = w.getName();
		for(int i=0; i<whales.length; i++) {
			w = (Whale) whales[i];
			if(w.getWeight()>heaviest) {
				heaviest = w.getWeight();
				heaviestName = w.getName();
			}
		}
		System.out.println("Heaviest whale is "+heaviestName+" with a weight of "+heaviest);
		
	}

	public static void avgLength(Animal[] whales) {
		int sum = 0;
		for(Animal w : whales) {
			Whale whale = (Whale) w;
			sum += whale.getLength();
		}
		System.out.println("Average length of whales: "+(double)sum/whales.length);
		
	}

	public static void swimFastest(Animal[] whales) {
		Whale w = (Whale) whales[0];
		int fastest = w.getMaxSpeed();
		String fastestName = "";
		for(int i=0; i<whales.length; i++) {
		w = (Whale) whales[i];
		if(w.getMaxSpeed()>fastest) {
			fastest = w.getMaxSpeed();
			fastestName = w.getName();
		}
			
		}
		System.out.println("Fastest Whale is: "+fastestName+" with a speed of "+fastest);
	}

}


