package practical3;

import java.util.Scanner;

public class Part2 {

	public static void main(String[] args) {

		int mark;
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter a mark (between 0 - 100)");
		mark = scan.nextInt();
		
		System.out.println(checkMark(mark));
		scan.close();
	}

	public static String checkMark(int mark) {
		String result = null;
		if (mark < 0 || mark > 100) {
			result = "Error, out of range";
		} else if(mark>=0 && mark <=49){
			result = "Fail";
		} else if(mark>=50 && mark<=59) {
			result = "Pass";
		} else if(mark>=60 && mark<=69) {
			result = "Merit";
		} else if(mark >=70 &&mark<=100) {
			result = "Distinction";
		} else {
			result = "Oops something went wrong";
		}
		return result;
	}
}
