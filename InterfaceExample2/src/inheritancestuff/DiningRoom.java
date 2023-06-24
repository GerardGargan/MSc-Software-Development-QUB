package inheritancestuff;

public class DiningRoom {

	private Person[] persons;
	private IPest[] pests;

	/**
	 * @param persons
	 * @param pests
	 */
	public DiningRoom(Person[] persons, IPest[] pests) {
		this.persons = persons;
		this.pests = pests;
	}

	/**
	 * Trigger the annoying behavious of the pests in the dining room
	 */
	public void serveFood() {
		System.out.println("Serving food...");
		for(IPest pest : pests) {
			pest.beAnnoying();
			System.out.println();
		}
	}

}
