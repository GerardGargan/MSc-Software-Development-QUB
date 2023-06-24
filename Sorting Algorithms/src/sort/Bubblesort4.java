package sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bubblesort4 {
	
	public static int LENGTH = 10;
	public static int BOUNDARY = 200;
	public static Random rand = new Random();
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Please enter a number for the length of the array");
		LENGTH = scan.nextInt();
		System.out.println("Please enter a number for the boundary of rand numbers generated");
		BOUNDARY = scan.nextInt();
		
		int[] myNums = new int[LENGTH];
		
		fillArray(myNums, LENGTH, BOUNDARY);
		
		System.out.println(Arrays.toString(myNums));
		
		sortArray(myNums);
		
		System.out.println(Arrays.toString(myNums));
		

	}

	private static void sortArray(int[] myNums) {
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i=0; i< myNums.length-1; i++) {
				if(myNums[i]>myNums[i+1]) {
					swapArray(myNums, i, i+1);
					flag = true;
				}
			}
		}
		
	}

	private static void swapArray(int[] myNums, int i, int j) {
		int temp;
		temp = myNums[i];
		myNums[i] = myNums[j];
		myNums[j] = temp;
		
	}

	private static void fillArray(int[] myNums, int length2, int boundary2) {
		int randNum;
		for(int i=0; i<myNums.length; i++) {
			randNum = rand.nextInt(boundary2)+1;
			myNums[i] = randNum;
		}
		
	}


}
