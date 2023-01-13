package apcs.playList;

public class Song {
    String songName;
    String artist;
    int plays = 0;

    public Song (String name) {
        this.songName = name;
    }

    public Song (String name, String artist) {
        this.songName = name;
         this.artist = artist;
    }

    public void setName(String name) {
        this.songName = name;
    }

    public String getName() {
        return songName;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    @Override
    public String toString() {
        return  "Title: '" + songName + '\'' + "; Plays: '" + plays + '\'';
    }
}