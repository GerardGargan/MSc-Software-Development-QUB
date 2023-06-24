package bookanlysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Start {
	
	public static ReadBookToScreen book = new ReadBookToScreen();
	public static BookReadSpeech bookSpeech = new BookReadSpeech();

	public static void main(String[] args) {
		System.out.println("Welcome to QUB book read\n");

		displayMenu();

	}

	private static void displayMenu() {
		String filePath = "Dracula.txt";
		Queue<String> wholeText = null;
		
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println();
			System.out.println("Please select an option: ");
			System.out.println("1. Load book");
			System.out.println("2. Read / Resume book");
			System.out.println("3. Pause read");
			System.out.println("4. Speak book");
			System.out.println("5. Pause speak");
			System.out.println("6. Quit");
			System.out.println("Enter option ...\n");
			
			option = sc.nextInt();
			
			switch(option) {
			case 1: System.out.println("Loading book...");
			wholeText = readin(filePath);
			break;
			case 2: System.out.println("Read/resume book");
			readBookToScreen(wholeText);
			break;
			case 3: System.out.println("Pausing book");
			stopReadToScreen(book);
			break;
			case 4: System.out.println("Speaking book");
			readOutLoud(wholeText);
			break;
			case 5: System.out.println("Pausing speak");
			break;
			case 6: System.out.println("Quitting");
			}

		} while (option!=6);
		
		System.out.println("Program ended..");
		
		sc.close();

	}

	private static void readOutLoud(Queue<String> wholeText) {
		bookSpeech.bookText = wholeText;
		Thread th = new Thread(bookSpeech);
		th.start();
		
	}

	private static void readBookToScreen(Queue<String> wholeText) {
		book.bookText = wholeText;
		Thread th = new Thread(book);
		th.start();
		
	}
	
	private static void stopReadToScreen(ReadBookToScreen book) {
		if(book==null) {
			System.out.println("Book is null...");
		}
		book.setStopRead(true);
	}

	private static Queue<String> readin(String filePath) {
		Queue<String> text = new LinkedList<String>();

		File file = new File(filePath);

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {

			String line = br.readLine();

			while (line != null) {
				text.add(line);

				line = br.readLine();
			}

			System.out.println("Read in " + text.size() + " lines");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return text;
	}

}
