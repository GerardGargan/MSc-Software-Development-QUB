package conditions;

public class ConditionalOperatorPractice {

	public static void main(String[] args) {
		
		int age = 50;
		String job = "Janitor";
		String name = "Gerard";
		
		if((name.equalsIgnoreCase("Gerard") || job.equalsIgnoreCase("Lecturer")) &&age==50) {
			
			System.out.println("First branch is true");
		}

		System.out.println("End of program");


	}

}
