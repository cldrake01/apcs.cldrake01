package apcs.playList;

public class Song {
    String songName;
    String artist;
    int plays = 0;
    long time = 0;

    public Song(String name) {
        this.songName = name;
    }

    public void setName(String name) {
        this.songName = name;
    }

    public Song(String name, long time) {
        this.songName = name;
        this.time = time;
    }

    public Song(String name, long time, String artist) {
        this.songName = name;
        this.artist = artist;
        this.time = time;
    }

    public String getName() {
        return this.songName;
    }

    public int getPlays() {
        return this.plays;
    }

    public void play() {
        this.plays++;
        synchronized (this) {
            try {
                wait(this.time);
            } catch (InterruptedException ignored) {}
        }
    }

    @Override
    public String toString() {
        return "Title: '" + this.songName + '\'' + "; Plays: '" + this.plays + '\'';
    }
}