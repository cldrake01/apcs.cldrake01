package apcs.playList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    String name;
    ArrayList<Song> songs = new ArrayList<>();

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
        return getClass().getName().replace(".PlayList", "") +
                ": " +
                this.songs.toString() +
                "\n";
    }

    public void moveTo(String song, int position) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getName().matches("(.*)" + song + "(.*)")) {
                songs.add(position, songs.get(i));
                if (position < i) {
                    songs.remove(i + 1);
                } else if (position > i) {
                    songs.remove(i - 1);
                }
            }
        }
    }

    public void play() {
        for (Song i : songs) {
            i.play();
        }
    }

    public void play(String song) {
        for (Song i : songs) {
            if (i.getName().matches("(.*)" + song + "(.*)")) i.play();
        }
    }
}
