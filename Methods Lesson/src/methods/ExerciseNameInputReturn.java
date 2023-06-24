package methods;

import java.util.Scanner;

public class ExerciseNameInputReturn {

	public static void main(String[] args) {
		
		System.out.println(returnName());

	}
	
	public static String returnName() {
		
		String name;
		String blankError = "You did not enter any characters";
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		name = sc.nextLine();
		
		if(name.isBlank()) {
			return blankError;
		} else {
		sc.close();
		return name;
		}
		
	}

}
