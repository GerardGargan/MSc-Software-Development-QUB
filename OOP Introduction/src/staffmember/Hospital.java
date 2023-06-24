package staffmember;

public class Hospital {

	public static void main(String[] args) {
		StaffMember s1 = new StaffMember("Matthew","Collins");
		StaffMember s2 = new StaffMember("gerard","gargan");
		Doctor d1 = new Doctor("Doctor","Spock",4);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
		System.out.println(d1.toString()); //overwrited to string method from the superclass
		
		System.out.println(d1.getLastName());
		
		Programmer p1 = new Programmer("Gerard","Gargan","Java");
		System.out.println(p1.toString());
	}

}
