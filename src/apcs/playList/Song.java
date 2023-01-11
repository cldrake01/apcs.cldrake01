package apcs.playList;

public class Song {
    String name;
    String artist;
    int plays = 0;

    public Song (String name) {
        this.name = name;
    }

    public Song (String name, String artist) {
        this.name = name;
         this.artist = artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }
}