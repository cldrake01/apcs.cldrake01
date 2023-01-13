package apcs.playList;

public class Song {
    String songName;
    String artist;
    int plays = 0;
    long time = 1;

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
        return (this.time / 100) % 60 >= 10
                ?
                "\nTitle: " + this.songName + ", Plays: " + this.plays + ", Duration: " + (this.time / 100) / 60 + ":"
                        + (this.time / 100) % 60
                :
                "\nTitle: " + this.songName + ", Plays: " + this.plays + ", Duration: " + (this.time / 100) / 60 + ":0"
                        + (this.time / 100) % 60
                ;
    }
}