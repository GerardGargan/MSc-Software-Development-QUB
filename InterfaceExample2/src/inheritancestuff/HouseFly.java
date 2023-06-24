package inheritancestuff;

public class HouseFly extends Insect implements IPest {
	
	public HouseFly() {
		super("HouseFly");
	}
	
	private void flyAroundYourHead() {
		System.out.println("Buzz..Buzz..Buzz");
	}

	@Override
	public void beAnnoying() {
		flyAroundYourHead();
		
	}

}
