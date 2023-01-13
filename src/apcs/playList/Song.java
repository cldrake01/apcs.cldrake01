package apcs.playList;

public class Song {
    String songName;
    String artist;
    int plays = 0;
    double time;

    public Song(String name) {
        this.songName = name;
    }

    public void setName(String name) {
        this.songName = name;
    }

    public Song(String name, double time) {
        this.songName = name;
        this.time = time;
    }

    public Song(String name, double time, String artist) {
        this.songName = name;
        this.artist = artist;
        this.time = time;
    }

    public String getName() {
        return songName;
    }

    public int getPlays() {
        return plays;
    }

    public void play() {
        this.plays++;
    }

    @Override
    public String toString() {
        return "Title: '" + songName + '\'' + "; Plays: '" + plays + '\'';
    }
}