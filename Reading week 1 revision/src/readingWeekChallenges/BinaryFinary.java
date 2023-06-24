package readingWeekChallenges;

public class BinaryFinary {
	
//	Given the following array that represents an 8 bit (non signed) binary number 
//	boolean[] eightBitArray = { true, false, false, true, false, true, false, true };
//	write a method that will output the array as a 0 or 1 based number representation; where true =1 and false = 0 i.e. 
//	1 0 0 1 0 1 0 1

	public static void main(String[] args) {
		boolean[] eightBitArray = { true, false, false, true, false, true, false, true };

		convertArray(eightBitArray);
	}

	public static void convertArray(boolean[] eightBitArray) {
		for(int i=0; i<eightBitArray.length; i++) {
			if(eightBitArray[i]==true) {
				System.out.print(1);
			} else if(eightBitArray[i]==false) {
				System.out.print(0);
			}
			else {
				System.out.println("ERROR");
			}
		}
		
	}

}
