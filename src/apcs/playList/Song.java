package apcs.playList;

import jdk.jfr.Timespan;

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
        return songName;
    }

    public int getPlays() {
        return plays;
    }

    public void play() {
        this.plays++;
        try {
            wait(time);
        } catch (InterruptedException e) {

        }
    }

    @Override
    public String toString() {
        return "Title: '" + songName + '\'' + "; Plays: '" + plays + '\'';
    }
}