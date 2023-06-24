package readingWeekChallenges;

public class FizzBuzz {

	public static void main(String[] args) {
//		Write a program that prints the numbers from 1 to 100 and for multiples of '3' print "Fizz" 
//		instead of the number and for the multiples of '5' print "Buzz", 
//		for multiples of 3 and 5 write Fizz Buzz.
//
//		1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, Fizz Buzz, 16, 17, 
//		Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, Fizz Buzz, 31, 32, Fizz, 34, Buzz, Fizz, ...

		int start = 1;
		int end = 100;
		fizzBuzz(start, end);
	}

	public static void fizzBuzz(int start, int end) {
		for(int i=start; i<=end; i++) {
			if(i%3==0 && i%5==0) {
				System.out.print("Fizz Buzz");
			} else if(i%3==0) {
				System.out.print("Fizz");
			} else if(i%5==0) {
				System.out.print("Buzz");
			} else {
				System.out.print(i);
			}
			if(i!=end) {
				System.out.print(", ");
			}
		}
		
	}

}
