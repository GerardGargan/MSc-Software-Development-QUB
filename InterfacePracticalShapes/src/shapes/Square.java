package shapes;

public class Square implements IMyShape {
	
	private double length;
	private String name;

	
	
	/**
	 * @param length
	 * @param name
	 */
	public Square(double length) {
		this.length = length;
		this.name = "Square";
	}

	@Override
	public double calculatePerimiter() {
		return length*2;
	}

	@Override
	public double calculateArea() {
		return Math.pow(length, 2);
	}

	@Override
	public String getShapeName() {
		return name;
	}

}
