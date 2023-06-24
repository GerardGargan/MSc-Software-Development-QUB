package shapes;

public class Rectangle implements IMyShape {
	
	private double sideLength1;
	private double sideLength2;
	private String name;

	/**
	 * @param sideLength1
	 * @param sideLength2
	 * @param name
	 */
	public Rectangle(double sideLength1, double sideLength2) {
		this.sideLength1 = sideLength1;
		this.sideLength2 = sideLength2;
		this.name = "Rectangle";
	}

	@Override
	public double calculatePerimiter() {
		// TODO Auto-generated method stub
		return sideLength1+sideLength2;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return sideLength1*sideLength2;
	}

	@Override
	public String getShapeName() {
		// TODO Auto-generated method stub
		return name;
	}

}
