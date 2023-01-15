package apcs.playList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlayList {
    String name;
    boolean repeat = false;
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

    @Override
    public String toString() {
        return (this.name != "")
                ?
                this.name + ": " + this.songs.toString() + "\n"
                :
                getClass().getName()
                        .replace(".PlayList", "")
                        + ": " + this.songs.toString() + "\n"
                ;
    }

    public void add(Song... songs) {
        this.songs.addAll(List.of(songs));
    }

    public void move(String song, int position) {
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
            if (!Objects.equals(i.path, "")) i.play();
        }
    }

    public void play(String song) {
        for (Song i : songs) {
            if (i.getName().matches("(.*)" + song + "(.*)") && !Objects.equals(i.path, "")) i.play();
        }
    }

    public void play(int song) {
        try {
            if (songs.get(song).path != "") songs.get(song - 1).play();
        } catch (Exception ignored) {
            System.err.println("That song number can't be found within this playlist.");
        }
    }

    public void repeat() {
        repeat = !this.repeat;
        while(this.repeat) {
            play();
        }
    }

    public void repeat(String song) {
        repeat = !this.repeat;
        while(this.repeat) {
            play(song);
        }
    }
}
