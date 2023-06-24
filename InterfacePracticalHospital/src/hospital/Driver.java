package hospital;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {


		//create some objects
		Pharmacist pharm1 = new Pharmacist("Maureen", "Gargan", 18.5, 3, 100);
		Surgeon s1 = new Surgeon("Kieran", "Reid", 40.2, "Guinocologist", 300);
		Porter port1 = new Porter("Peter", "Pan", 10.50, "Royal");
		
		ArrayList<AdministerDrugs> issuer = new ArrayList<AdministerDrugs>();
		issuer.add(s1);
		issuer.add(pharm1);
		
		for(AdministerDrugs a : issuer) {
			System.out.println(a.adminControlledDrugs());
			System.out.println(a.adminNonControlledDrugs());
		}
		

	}

}
