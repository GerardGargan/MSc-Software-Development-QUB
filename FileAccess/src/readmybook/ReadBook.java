package readmybook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadBook {

	public static void main(String[] args) {
		String line;
		String filename;
		int lines, numWords, characters, yossarian, a;
		lines=0;
		numWords=0;
		characters=0;
		yossarian=0;
		a=0;
		filename = "Catch 22.txt";
		String redactedfile = "redacted.txt";
		
		try {
			File file = new File(filename);
			File filerd = new File(redactedfile);
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			FileWriter fw = new FileWriter(filerd);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			line = br.readLine();
			while(line!= null) {
				
				lines++; //increment by 1 line
				characters += line.length(); //number of characters in each line added to itself
				
				//find number of words
				String words[] = line.split(" ");
				numWords +=words.length;
				
				//finding instances of Yossarian
				if(line.contains("Yossarian")) {
					yossarian++;
					String redacted =line.replace("Yossarian", "*********") ;
					System.out.println(redacted);
					bw.write(redacted+"\n");
				} else {
					System.out.println(line);
					bw.write(line+"\n");
				}
				
				//count A's
				
				for(int i=0; i<line.length(); i++) {
					switch(line.charAt(i)) {
					case 'a':
					case 'A':
						a++;
						break;
					}
				}
				
				line = br.readLine();
				
			}
			
			br.close();
			fr.close();
			bw.close();
			fw.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		} catch (IOException e) {
			System.out.println("Oops something went wrong");
			e.printStackTrace();
		}
		
		System.out.printf("%n%nLines: %d%nWords: %d%nYossarian: %d%nCharacters: %d%nA's: %d%n",lines,numWords,yossarian,characters,a);

	}

}
