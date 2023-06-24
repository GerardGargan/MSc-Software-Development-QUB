package month;

public class Month {

	public static String numToMonth(int monthNumber) {
		String result = "Error";

		if (monthNumber < 1 || monthNumber > 12) {
			throw new NumberFormatException("Invalid month number");
		} else {

			switch (monthNumber) {
			case 1: result = "January";
			break;
			case 2: result = "Feburary";
			break;
			case 3: result = "March";
			break;
			case 4: result = "April";
			break;
			case 5: result = "May";
			break;
			case 6: result = "June";
			break;
			case 7: result = "July";
			break;
			case 8: result = "August";
			break;
			case 9: result = "September";
			break;
			case 10: result = "October";
			break;
			case 11: result = "November";
			break;
			case 12: result = "December";
			break;
			default: result = "Oh no something went VERY wrong";
			}
		}
		return result;
	}

}
