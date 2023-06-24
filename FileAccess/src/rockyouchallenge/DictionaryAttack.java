package rockyouchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryAttack {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String line;
		String filename = "rockyou.txt";
		String password;
		boolean ok = false;
		while(!ok) {
			ok = true;
		password = getPassword();
		
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			line = br.readLine();
			while(line!=null) {
				if(password.equalsIgnoreCase(line)){
					ok = false;
				}
				line = br.readLine();
			}
			if(!ok) {
				System.out.println("Invalid password");
			}
			
			
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Oops something went wrong");
		}
		}
		System.out.println("PAssword is OK");
	
		sc.close();
	}
	
	public static String getPassword() {
		String password;
		System.out.println("Please enter a password: ");
		password = sc.next();
		return password;
	}

}
