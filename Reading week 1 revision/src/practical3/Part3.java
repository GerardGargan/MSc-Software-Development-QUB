package practical3;

import java.util.Scanner;

public class Part3 {

	public static Scanner scan = new Scanner(System.in);

//	Prompt the user for his/her age.  Then check if the user is over 17.  If so then prompt the 
//	user for a name.  Then output the user’s inputted name and age.  Otherwise if not over 17 
//	then output “too young to continue” (i.e. do not prompt for name).  In addition ensure 
//	that the user does not enter a negative number or 0 for age. (if so exit the program 
//	gracefully with “sorry don’t recognise your input”.

	public static void main(String[] args) {

		int userAge = getUserAge();

		System.out.println("Age: " + userAge);

		String userName = checkUserAgeAndGetName(userAge);
		System.out.println("Name: " + userName);

		scan.close();
	}

	public static String getUserName() {
		String userName2;
		System.out.println("Please enter your name:");
		userName2 = scan.nextLine();
		return userName2;
	}

	public static int getUserAge() {
		int age;
		System.out.println("Please enter your age");
		age = scan.nextInt();
		scan.nextLine();
		return age;
	}
	
	public static String checkUserAgeAndGetName(int age) {
		String userName = "Empty";
		if(age>=17) {
			userName = getUserName();
		} else if(age<0 || age >=110) {
			userName = "Invalid age";
		} else {
			userName = "Too young to continue";
		}
		return userName;
	}

}
