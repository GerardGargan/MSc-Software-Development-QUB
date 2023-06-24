package practicals;

public class LeapYears {

	public static void main(String[] args) {
		
		for(int year = 1910; year<= 1990; year++) {
			
			System.out.println(year);
			if(year % 4==0) {
				System.out.println(year+" is a leap year");
			}
			
		}

	}

}
