package fileaccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ExerciseLectureNotes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rounds = 5;
		int[] userInput = new int[rounds];
		
		for(int i=0; i<userInput.length; i++) {
			System.out.println("Enter Number "+(i+1));
			userInput[i] = scan.nextInt();
		}
		
		System.out.println("Unsorted");
		System.out.println(Arrays.toString(userInput));
		sortArray(userInput);
		System.out.println("Sorted");
		System.out.println(Arrays.toString(userInput));
		
		//write to file
		try {
			File file = new File("File.txt");
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		for(int i=0; i<userInput.length; i++) {
			bw.write(userInput[i]+"\n");
		}
		
		bw.close();
		fw.close();
		} catch(IOException ex) {
			System.out.println("File not found");
		}
		
		scan.close();
	}

	private static void sortArray(int[] userInput) {
		boolean flag = true;
		
		do {
			flag = false;
		for(int i=0; i<userInput.length-1; i++) {
			if(userInput[i]>userInput[i+1]) {
				int temp;
				temp = userInput[i];
				userInput[i] = userInput[i+1];
				userInput[i+1] = temp;
				flag = true;
			}
		}
		} while(flag);
		
	}

}
