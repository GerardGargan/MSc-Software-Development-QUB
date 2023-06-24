package inheritancestuff;

public class SimsGame {

	public static void main(String[] args) {
		
		Person p1 = new Person("Gerard");
		Person p2 = new Person("Chris");
		
		Telesales t1 = new Telesales("Joshua", "Argos");
		Telesales t2 = new Telesales("Liam", "Iceland");
		
		IPest pest = new HouseFly();
		HouseFly fly = new HouseFly();
		IPest pest2 = new Telesales("Someone else", "Somewhere else");
		
		Person[] people = new Person[] {p1,p2,t1};
		IPest[] pests = new IPest[] {t1,t2,pest,pest2,fly};
		
		DiningRoom room = new DiningRoom(people, pests);
		
		room.serveFood();
	}

}
