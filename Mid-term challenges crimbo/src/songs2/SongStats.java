package songs2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SongStats {

	public static void main(String[] args) {
		ArrayList<Song> songs = readInSongs("songlist.csv");
		
		for(Song s : songs) {
			System.out.println(s.toString());
		}
		

	}
	
	public static ArrayList<Song> readInSongs(String fileName){
		
		ArrayList<Song> songsReadIn = new ArrayList<Song>();
		
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = br.readLine();//throw away
			line = br.readLine();
			String[] songDetails;
			
			while(line!=null) {
				songDetails = line.split(",");
				Song s1 = new Song(songDetails[0], songDetails[1], Integer.parseInt(songDetails[2]));
				songsReadIn.add(s1);
				line = br.readLine();
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
		
		return songsReadIn;
	}

}
