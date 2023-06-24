package mobilephone;

public class CarphoneWarehouse {

	public static void main(String[] args) {
		MobilePhone mb1 = new MobilePhone("Samsung", "S10", 1);
		System.out.println(mb1.toString());
		
		MobilePhone mb2 = new MobilePhone("Samsing", "S20", 5);
		System.out.println(mb2.toString());
		
		MobilePhone mb3 = new MobilePhone("Apple", "iPhone 11", 4);
		System.out.println(mb3.toString());
	}

}
