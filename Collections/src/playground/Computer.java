package playground;

public class Computer implements Comparable<Computer>{
	private String name;
	private double diskSpace;
	private double price;
	private int ram;
	
	
	
	/**
	 * @param name
	 * @param diskSpace
	 * @param price
	 * @param ram
	 */
	public Computer(String name, double diskSpace, double price, int ram) {
		setName(name);
		setDiskSpace(diskSpace);
		setPrice(price);
		setRam(ram);
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
	 * @return the diskSpace
	 */
	public double getDiskSpace() {
		return diskSpace;
	}
	/**
	 * @param diskSpace the diskSpace to set
	 */
	public void setDiskSpace(double diskSpace) {
		this.diskSpace = diskSpace;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the ram
	 */
	public int getRam() {
		return ram;
	}
	/**
	 * @param ram the ram to set
	 */
	public void setRam(int ram) {
		this.ram = ram;
	}
	@Override
	public String toString() {
		return String.format("Computer Name: %s%nDiskSpace: %.2f GB%nRam: %dGB%nPrice: £%.2f%n", name,diskSpace,ram,price);
	}
	@Override
	public int compareTo(Computer o) {
		// TODO Auto-generated method stub
		if(this.price<o.getPrice()) {
			return -1;
		} else if(this.price>o.getPrice()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	
	
	
	
	
}
