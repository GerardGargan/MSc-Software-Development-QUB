package simpsons;

public class CartoonApp {

	public static void main(String[] args) {
		
		SimpsonsCharacter sc1 = new SimpsonsCharacter();
		sc1.setName("Bart");
		sc1.setCatchPhrase("Eat my shorts");
		
		SimpsonsCharacter sc2 = new SimpsonsCharacter();
		sc2.setName("Homer");
		sc2.setCatchPhrase("D'oh !");

		SimpsonsCharacter sc3 = new SimpsonsCharacter();
		sc3.setName("Lisa");
		sc3.setCatchPhrase("I'll be in my room");
		
		SimpsonsCharacter sc4 = new SimpsonsCharacter();
		sc4.setName("Nelson");
		sc4.setCatchPhrase("HaHa");
		
		//outputs
		
		sc1.sayCatchPhrase();
		sc2.sayCatchPhrase();
		sc3.sayCatchPhrase();
		sc4.sayCatchPhrase();
		System.out.println("End of program");
		
	}

}
