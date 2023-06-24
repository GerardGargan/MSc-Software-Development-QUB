package conditions;


public class SwitchExample2 {

	public static void main(String[] args) {
		
		int month = 22;
		String season;
		
		switch(month) {
		
		case 12:
		case 1:
		case 2: season = "winter";
		break;
		case 3:
		case 4:
		case 5: season = "Spring";
		break;
		case 6:
		case 7:
		case 8: season = "Summer";
		break;
		case 9:
		case 10:
		case 11: season = "autumn";
		break;
		default: season = "Error";
				
		
		}
		// Note if switch is not initialised it will throw an error if there is no default i.e. 
		//it is possible in the program that season is never initialised
		
		System.out.println(season);
		
	}
	

}
