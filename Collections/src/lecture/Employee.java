package lecture;

public class Employee {
    private String name;
    private int age;
    private String status;
    /**
     * @param name
     * @param age
     * @param status
     */
    public Employee(String name, int age, String status) {
        this.setName(name);
        this.setAge(age);
        this.setStatus(status);
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
     * @return the age
     */
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     * @throws IllegalArgumentException if status provide is not FT or PT
     */
    public void setStatus(String status) throws IllegalArgumentException{
        switch(status) {
        case "FT":
        case "PT":this.status = status;
        break;
        default: throw new IllegalArgumentException("FT or PT only");
        }
    }
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", status=" + status + "]";
	}
    
}