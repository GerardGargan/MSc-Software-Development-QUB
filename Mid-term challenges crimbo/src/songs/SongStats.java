package songs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SongStats {

	public static void main(String[] args) {
		String fileName = "songlist.csv";
		String line;

		try {
			// open file
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			line = br.readLine();
			ArrayList<Song> songs = new ArrayList<Song>();

			String[] songInfo = new String[3];
			int i = 0;

			while (line != null) {
				if (i != 0) {
					songInfo = line.split(",");
					System.out.println(Arrays.toString(songInfo));
					Song s1 = new Song(songInfo[0], songInfo[1], Integer.parseInt(songInfo[2]));
					songs.add(s1);
				}
				line = br.readLine();
				i++;
			}

			for (Song s : songs) {
				System.out.println(s.toString());
			}

			br.close();
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
