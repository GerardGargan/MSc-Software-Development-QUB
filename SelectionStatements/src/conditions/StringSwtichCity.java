package conditions;

import java.util.Scanner;

public class StringSwtichCity {

	public static void main(String[] args) {
		
		String city = "";
		String postcode = "";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter a city");
		city = sc.nextLine();
		

		switch(city.toLowerCase()) {
		case "lisburn" : postcode = "Lisburns code";
		break;
		case "belfast" : postcode = "Belfasts code";
		break;
		case "newry" : postcode = "Newrys code";
		break;
		default: postcode = "Not recognised";
		
				
		}
		System.out.println(postcode);
		sc.close();
	}

}
