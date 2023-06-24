package olympicgame2;

public class Runner implements Runnable {
	private String name;
	private double time;
	
	
	/**
	 * @param name
	 * @param time
	 */
	public Runner(String name, double time) {
		this.name = name;
		this.time = time;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(double time) {
		this.time = time;
	}
	
	public String toString() {
		return String.format("%-25s%-6.2f", name,time);
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep((long) (time*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(this.toString());
		
	}
	
	
	
	
}
