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

public class Playlist {
	private String name;
	private String user;
	private int numSongs;
	public Song[] songlist;
	
	public Playlist(String name, String user) {
		this.name = name;
		this.user = user;
		this.songlist = new Song[10];
	}
	
	public Song getSong(int index) {
		return songlist[index];
	}
	
	public void addSong(Song s) {
		if(numSongs <= 10) {
			songlist[numSongs] = s;
			numSongs++;
			s.popularity++;
		}
		else {
			System.out.println("The playlist is full!");
		}
	}
	
	public void removeSong(int index) {
		if (index < numSongs && index >= 0) {
			int a = index;
			while(a < (numSongs - 1)) {
				songlist[a].popularity--;
				songlist[a] = songlist[a + 1];
				a++;
			}
			songlist[a + 1] = null;
			numSongs--;
			
		}
		else {
			System.out.println("Please put in a valid number!");
		}
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public int totalDuration() {
		int totald = 0;
		for (int b = 0; b < songlist.length; b++) {
			if (songlist[b] != null) {
	            totald += songlist[b].getDuration();
	        }
		}
		return totald;
	}
	
	public double price() {
		double totalp = 0;
		for (int d = 0; d < songlist.length; d++) {
			if (songlist[d] != null) {
	            totalp += songlist[d].getCost();
	        }
		}
		return totalp;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUser() {
		return user;
	}
	
	public String toString() {
		String info = "Playlist name: " + name + "\n";
		info += "User name: " + user + "\n";
	    info += "Number of songs: " + numSongs + "\n";
	    info += "Songs in playlist:\n";
	    
	    for (int a = 0; a < songlist.length; a++ ) {
	    	if(songlist[a] != null) {
	    		info += "* " + songlist[a].getTitle() + "\n";
	    	}
	    }
	    return info;
	}
}
