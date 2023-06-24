package shapes;

public class Circle implements IMyShape {
	
	private double radius;
	private String shapeName;
	

	/**
	 * @param radius
	 * @param shapeName
	 */
	public Circle(double radius) {
		this.radius = radius;
		this.shapeName = "Circle";
	}

	@Override
	public double calculatePerimiter() {
		//2 pie r
		return 2*Math.PI*radius;
	}

	@Override
	public double calculateArea() {
		// pie r squared
		return Math.PI*radius*radius;
	}

	@Override
	public String getShapeName() {
		return shapeName;
	}
	
	
}
