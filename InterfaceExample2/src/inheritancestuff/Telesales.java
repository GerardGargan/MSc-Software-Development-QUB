package inheritancestuff;

public class Telesales extends Person implements IPest {
	
	private String company;

	public Telesales(String name,String company) {
		super(name);
		this.company = company;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void beAnnoying() {
		makePhoneRing();

	}
	
	private void makePhoneRing() {
		System.out.println("Ring Ring Ring Ring Ring Ring");
		System.out.println("Hello this is "+getName()+" from "+this.company);
	}

}
