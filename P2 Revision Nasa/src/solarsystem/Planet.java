package solarsystem;

public class Planet extends SolarObject {
	private PlanetType planetType;
	private int moons;

	public Planet() {

	}

	public Planet(String name, double distanceFromSun, PlanetType planetType, int moons) {
		super(name, distanceFromSun);
		setPlanetType(planetType);
		setMoons(moons);

	}

	public void setMoons(int moons) throws IllegalArgumentException {
		if(moons<0) {
			throw new IllegalArgumentException("Moons cannot be less than zero");
		} else {
		this.moons = moons;
		}

	}

	public void setPlanetType(PlanetType planetType) throws IllegalArgumentException {
		if(planetType==null) {
			throw new IllegalArgumentException("Cant be null");
		} else {
		this.planetType = planetType;
		}

	}

	/**
	 * @return the planetType
	 */
	public PlanetType getPlanetType() {
		return planetType;
	}

	/**
	 * @return the moons
	 */
	public int getMoons() {
		return moons;
	}
	
	@Override
	public void printDetails() {
		super.printDetails();
		System.out.println("Planet type: "+planetType);
		System.out.println("Moons: "+moons);
	}
	
	public void printPlanet() {
		System.out.println("Planet");
	}

}
