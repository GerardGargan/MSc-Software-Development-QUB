package whale;

public class Animal {
	private String name;
	
	public Animal() {
		
	}
	
	public Animal(String name) {
		setName(name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
