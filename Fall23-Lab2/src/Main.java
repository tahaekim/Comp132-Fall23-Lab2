/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
SIGNATURE: <Ahmet Taha Ekim, 79234>
********************************************************************************/
import java.security.SecureRandom;
import java.util.Random;
public class Main {
	public static void main(String[] args) {
		// Creating the different singers. Adele will not have any associated songs, 
		// and is just to verify that the printSongNamesOfSinger shouldn't find any songs
		// with her name.
		Singer a1 = new Singer("Luis Fonsi");
		Singer a2 = new Singer("Ed Sheeran");
		Singer a3 = new Singer("Serdar Ortac");
		Singer a4 = new Singer("Lady Gaga");
		Singer a5 = new Singer("Adele");
		
		// Creating some songs associated to the singers above.
		Song s1 = new Song("Despacito", a1, 229, 8.99);
		Song s2 = new Song("Shape of You", a2, 234, 6.99);
		Song s3 = new Song("Karabiberim", a3, 228);
		Song s4 = new Song("Perfect", a2, 264);
		Song s5 = new Song("Alejandro", a4, 275, 9.99);
		Song s6 = new Song("Judas", a4, 249, 11.99);
		
		// Creating two playlists and adding some songs to them.
		Playlist p1 = new Playlist("A", "Cem");
		p1.addSong(s1);
		p1.addSong(s2);
		p1.addSong(s4);
		
		Playlist p2 = new Playlist("B", "Dilara");
		p2.addSong(s2);
		p2.addSong(s3);
		p2.addSong(s5);
		p2.addSong(s6);

		// Printing out the songs in each playlist associated to all of the singers except adele above.
		printSongNamesOfSinger("Luis Fonsi", p1);
		printSongNamesOfSinger("Ed Sheeran", p1);
		printSongNamesOfSinger("Adele", p1);
		printSongNamesOfSinger("Lady Gaga", p2);
		printSongNamesOfSinger("Serdar Ortac", p2);
		printSongNamesOfSinger("Adele", p2);
		
		// Printing out the playlist information associated to each playlist
		printPlaylistInfo(p1);
		printPlaylistInfo(p2);
		
		
		// This is used to verify that the removeSong method in the Playlist class is written correctly.
		// If there is a problem in that method, then after this loop runs, there will be more than 3
		// songs in the playlist.
		for(int i = 0; i < 10; i++) {
			p1.removeSong(0);
			p1.addSong(s1);
		}
		
		printPlaylistInfo(p1);
		
		// ***** Extra Test for InLab *****
		System.out.println("");
		System.out.println("------------In Lab Tests------------");
		System.out.println("");
		System.out.println("Popularity Test:");
		// Creating the test objects
		Singer genericSinger = new Singer("Generic Singer");
		Song genericSong = new Song("Generic Song", genericSinger, 200, 6.99);
		// Creating a new Playlist and adding the song multiple times
		Playlist testPlaylist = new Playlist("Test Popularity", "User");
		System.out.println("Initial Popularity of " + genericSong.getTitle() + ": " + genericSong.getPopularity());
		for (int i = 0; i < 10; i++) {
		testPlaylist.addSong(genericSong);
		}
		System.out.println("After Adding to Playlist, Popularity of " + genericSong.getTitle() + ": " +
		genericSong.getPopularity());
		System.out.println("");
		System.out.println("Shuffle Test");
		Song[] genericSongs = new Song[10];
		for (int i = 0; i < 10; i++) {
		genericSongs[i] = new Song("Generic Song " + (i + 1), genericSinger, 200 + i, 5.99 + i);
		}
		Playlist genericPlaylist = new Playlist("Test Shuffle", "User");
		for (int i = 0; i < 10; i++) {
		genericPlaylist.addSong(genericSongs[i]);
		}
		System.out.println("Original Playlist:");
		for (int i = 0; i < genericPlaylist.getNumSongs(); i++) {
		System.out.println(genericPlaylist.getSong(i).getTitle());
		}
		Playlist shuffledPlaylist = shuffle(genericPlaylist);
		System.out.println("\nShuffled Playlist:");
		for (int i = 0; i < shuffledPlaylist.getNumSongs(); i++) {
		System.out.println(shuffledPlaylist.getSong(i).getTitle());
		}
		Playlist partiallyShuffledPlaylist = shuffle(genericPlaylist, 5);
		System.out.println("\nPartially Shuffled Playlist (from index 5):");
		for (int i = 0; i < partiallyShuffledPlaylist.getNumSongs(); i++) {
		System.out.println(partiallyShuffledPlaylist.getSong(i).getTitle());
		}
	}
	
	public static void printSongNamesOfSinger(String singerName, Playlist playlist) {
		Song[] songs = playlist.songlist;
		System.out.println("----------------------------------------------------");
		System.out.println("The songs by " + singerName + "in the playlist " + playlist.getName() +" are:");
		for (int i = 0; i < songs.length; i++) {
			if(songs[i] != null && songs[i].getSinger().getName() == singerName) {
				System.out.println(songs[i].getTitle());
			}
		}
		System.out.println("----------------------------------------------------");
		System.out.println("\n");
	}
	
	public static void printPlaylistInfo(Playlist playlist) {
		System.out.println("****************************************************");
		System.out.println(playlist.toString());
		System.out.println("Total Duration: " + playlist.totalDuration());
		System.out.println("Total Cost: " + playlist.price());
		double avg = (playlist.price() / playlist.getNumSongs());
		String sayi = String.format("%.2f", avg);
		System.out.println("Average Cost: " + sayi);
		
		if (avg <= 4) {
			System.out.println("Grade: D");
		}
		else if (4 < avg && avg <= 8) {
			System.out.println("Grade: C");
		}
		else if (8 < avg && avg <= 12) {
			System.out.println("Grade: B");
		}
		else if (12 < avg) {
			System.out.println("Grade: A");
		}
		System.out.println("****************************************************");
		System.out.println("\n");
	}
	
	public static Playlist shuffle(Playlist playlist){
		Song[] mixedList = new Song[playlist.getNumSongs()];
		
		for(int i = 0; i < (playlist.getNumSongs()); i++) {
			mixedList[i] = playlist.getSong(i);
		}
		SecureRandom rand = new SecureRandom();
		
		for(int i = 1; i < mixedList.length; i++) {
			Song tprr = mixedList[i];
			int rind = rand.nextInt(i + 1);
			mixedList[i] = mixedList[rind];
			mixedList[rind] = tprr;
		}
		
		Playlist mixedPlaylist = new Playlist(playlist.getName() + "-Shuffled", playlist.getUser());
		for(int i = 0; i < mixedList.length; i++) {
			mixedPlaylist.addSong(mixedList[i]);
		}
		return mixedPlaylist;
	}
	
	public static Playlist shuffle(Playlist playlist, int index){
		Song[] mixedList = new Song[playlist.getNumSongs()];
		
		for(int i = 0; i < (playlist.getNumSongs()); i++) {
			mixedList[i] = playlist.getSong(i);
		}
		SecureRandom rand = new SecureRandom();
		
		for(int i = index + 1; i < mixedList.length; i++) {
			Song tprr = mixedList[i];
			int rind = rand.nextInt(i - index) + index + 1;
			mixedList[i] = mixedList[rind];
			mixedList[rind] = tprr;
		}
		
		Playlist pmixedPlaylist = new Playlist(playlist.getName() + "-Partially Shuffled", playlist.getUser());
		for(int i = 0; i < mixedList.length; i++) {
			pmixedPlaylist.addSong(mixedList[i]);
		}
		return pmixedPlaylist;
	}

}
