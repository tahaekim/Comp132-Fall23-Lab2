[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/cj5ZLA0c)
# COMP 132, Fall 2023

# MUST READ

For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your _main method source code file_. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```

# IMPORTANT NOTES

## 1- After you complete the tasks, do not forget to commit your changes and push them to your repository on Github.

## 2- This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

## 3- All classes to be implemented should be put under a package named trackPlay.

# Lab-2 Prelab - TrackPlay, a Music Application
![](/img/music.jpeg?raw=true "")

A popular music application, TrackPlay, provides song tracks for users, where they can have their own playlists. Each song track has a corresponding cost. Thus, users should pay a total price for their playlists. However, for each song track they only need to pay one time and can play it forever. In this assignment, you are asked to implement a Java program for this application. The Java program (classes and their fields/methods) that you should design is described below. You should implement these classes according to the description given below.

**Note:** We provide a template project for you, in which you can find the packages and classes. Also, in the main method, there is some hard-coded information that you should use for testing your solution. The sample output is given at the end of this description.

## Singer Class

This public class will represent the singer of a song. 

### Instance Variables
- #### String name:
The name of the singer. 

### Methods
```
- public Singer(String name)
```
  Constructor that initializes a singer with a given name.
```
- public String getName()
```
  Returns the name of the singer.

## Song Class
This public class represents one of the songs available in the TrackPlay. 

### Instance Variables
- #### String title: 
  The title of the song.
- #### Singer singer: 
  The singer of the song.
- #### int duration:
  The duration of the song in seconds.
- #### double cost:
  The cost of the song.

### Methods
```
-  public Song(String title, Singer singer, int duration, double cost):
```
  A constructor that initializes a Song object with given instance variables. The title should not be changed after the initialization
```
-  public Song(String title, Singer singer, int duration):
```
  A constructor that initializes a Song object with given instance variables, and a default cost value of 4.99. 
  
  **Hint:** Take a look at method overloading.


```
- public String getTitle():
```
  Getter method for the title instance variable.
```
- public Singer getSinger():
```
  Getter method for the singer instance variable.
```
- public int getDuration():
```
  Getter method for the duration of the song.
```
- public double getCost():
```
  Getter method for the cost of the song.
```
- public void setCost(double c):
```
  Setter method for the cost of the song.

## Playlist Class

This public class represents a playlist.

### Instance Variables
  - #### String name
    Represents the name of the playlist.
  - #### Song[] songlist
    An array of songs that can contain a maximum of 10 songs.
  - #### String user
    The name of the user who is the owner of the playlist.
  - #### int numSongs
    Counts the number of songs currently in the playlist.

### Methods
```
- public Playlist(String name, String user)
```
  A constructor that initializes the Playlist with the provided name and user, and initializes the array to have size 10.
```
- public void addSong(Song s)
```
  A method that adds a song to the playlist.
```
 -  public void removeSong(int index)
```
  A method that removes the song stored at position "index" from the playlist. Once this song has been removed, you should shift
  every song after it one position to the left, so that there are no gaps. For example, if our playlist looks like [A, B, C, D, E],
  and we remove the song in index 1, then the playlist after should be [A, C, D, E] instead of [A, _, C, D, E].
```
 -  public int getNumSongs()
```
  A method that returns the number of songs stored in the playlist.
```
 -  public int totalDuration()
```
  A method that returns the total duration of the songs in the playlist.
```
 -  public double price()
```
  A method that returns the total cost of the songs in the playlist.
```
 -  public String getName()
```
  A method which returns the name of the playlist.
```
 -  public String getUser()
```
  A method which returns the name of the user who owns the playlist.
```
 -  public String toString()
```
  A method which provides a string representation of the Playlist object. It returns the playlist's name, its user's name, the number of songs in the playlist, and the titles of the songs in the playlist.


**Example:** Assume we have a Playlist object examplePlaylist with the name "A", owned by a user named "Cem". The playlist contains 3 songs: "Song1", "Song2", and "Song3". Calling examplePlaylist.toString() should return the following string:

```
Playlist name: A
User name: Cem
Number of songs: 3
Songs in playlist:
* Song1
* Song2
* Song3
```



## Main Class

For the prelab, you must write two **static** methods in your Main Class java file as follows:
```
public static void printSongNamesOfSinger(String singerName, Playlist playlist) 
```
Given the provided singerName and playlist, this method finds every song in the playlist by singerName, and prints them out.
```
public static void printPlaylistInfo(Playlist songsList) 
```
This method should calculate the total cost and average cost of the songs in the playlist. Then, based on the average cost, the playlist should be assigned
a letter grade based on the following:

 ```
-        Average cost less than or equal to 4 : D
-        Average cost between 4 and less than or equal to 8: C
-        Average cost between 8 and less than or equal to 12: B
-        Average cost more than 12: A
```

**Notes:** 


1- Don't worry about the same song being added to the playlist multiple times; this is allowed. For simplicity, you also don't need to ensure that the price of the song is counted only once. 


2- If the playlist is full and the user tries to add another song, print a statement notifying the user and do nothing.


3- If the index provided with the removeSong(int index) method is out of bounds of the array, notify the user and do nothing.


## Sample Output
```

----------------------------------------------------
The songs by Luis Fonsi in the playlist A are:
Despacito
----------------------------------------------------


----------------------------------------------------
The songs by Ed Sheeran in the playlist A are:
Shape of You
Perfect
----------------------------------------------------


----------------------------------------------------
The songs by Adele in the playlist A are:
----------------------------------------------------


----------------------------------------------------
The songs by Lady Gaga in the playlist B are:
Alejandro
Judas
----------------------------------------------------


----------------------------------------------------
The songs by Serdar Ortac in the playlist B are:
Karabiberim
----------------------------------------------------


----------------------------------------------------
The songs by Adele in the playlist B are:
----------------------------------------------------


****************************************************
Playlist name: A
User name: Cem
Number of songs: 3
Songs in playlist:
* Despacito
* Shape of You
* Perfect

Total duration: 727
Total Cost: 20.97
Average Cost: 6.99
Grade: C
****************************************************


****************************************************
Playlist name: B
User name: Dilara
Number of songs: 4
Songs in playlist:
* Shape of You
* Karabiberim
* Alejandro
* Judas

Total duration: 986
Total Cost: 33.96
Average Cost: 8.49
Grade: B
****************************************************


****************************************************
Playlist name: A
User name: Cem
Number of songs: 3
Songs in playlist:
* Despacito
* Despacito
* Despacito

Total duration: 687
Total Cost: 26.97
Average Cost: 8.99
Grade: B
****************************************************
```


## Submission Instructions
After finishing each class, you should push your changes to GitHub Classroom. We will be checking the commit logs to verify this.


This pre-lab must be finished before 10 am Friday, when the lab starts. Any questions can be answered by attending the office hours of one of the TAs/SLs, or emailing one of us.
You should not modify the main method in the Main class, however you will be required to add other methods to the Main class.

