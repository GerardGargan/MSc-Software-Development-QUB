package carfactory;

public class FamilySaloon extends Car {
	private boolean metallicPaint;
	
	public FamilySaloon() {
		
	}
	
	public FamilySaloon(String make, String model, int horsePower, boolean metallicPaint) {
		super(make, model, horsePower);
		setMetallicPaint(metallicPaint);
	}

	/**
	 * @return the metallicPaint
	 */
	public boolean isMetallicPaint() {
		return metallicPaint;
	}

	/**
	 * @param metallicPaint the metallicPaint to set
	 */
	public void setMetallicPaint(boolean metallicPaint) {
		this.metallicPaint = metallicPaint;
	}
	
	public String displayAll() {
		return String.format("Family Saloon %nMake: %s%nModel:%s%nHorse Power: %d%nMetallic paint: %b%n%n",getMake(),getModel(),getHorsePower(),isMetallicPaint());
	}
	
	

}
