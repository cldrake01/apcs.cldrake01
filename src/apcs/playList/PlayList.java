package apcs.playList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    String name;
    ArrayList<Song> songs = new ArrayList<Song>();

    public PlayList() {
        this.name = "New Playlist";
    }

    public PlayList(Song @NotNull ... songs) {
        this.songs.addAll(List.of(songs));
    }

    public PlayList(String name, Song @NotNull ... songs) {
        this.name = name;
        this.songs.addAll(List.of(songs));
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void add(Song... songs) {
        this.songs.addAll(List.of(songs));
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "songs=" + songs +
                '}';
    }
}
