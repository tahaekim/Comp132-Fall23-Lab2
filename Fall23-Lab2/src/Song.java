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

public class Song {
	private final String title;
	private Singer singer;
	private int duration;
	private double cost;
	public int popularity;
	
	public Song(String title, Singer singer, int duration, double cost) {
		this.title = title;
		this.singer = singer;
		this.duration = duration;
		this.cost = cost;
		this.popularity = 0;
	}
	
	public Song(String title, Singer singer, int duration) {
		this(title, singer, duration, 4.99);
	}
	
	public int getPopularity() {
		
		return popularity;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Singer getSinger() {
		return singer;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double c) {
		this.cost = c;
	}
}
