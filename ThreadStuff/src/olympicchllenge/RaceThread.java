package olympicchllenge;

public class RaceThread implements Runnable {
	private String name;
	private double time;
	
	
	
	/**
	 * @param name
	 * @param time
	 */
	public RaceThread(String name, double time) {
		setName(name);
		setTime(time);
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
		this.time = time*1000;
	}
	@Override
	public void run() {

		try {
			Thread.sleep((long) time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+" finished: "+(time/1000));
		
	}
	
	
}
