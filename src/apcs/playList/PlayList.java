package apcs.playList;

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

    public PlayList(Song ... songs) {
        this.songs.addAll(List.of(songs));
    }

    public PlayList(String name, Song ... songs) {
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

    public Song getName(int index) {
        return this.songs.get(index);
    }

    public String getSong(int index) {
        return this.songs.get(index).songName;
    }

    public void add(String... names) {
        for (String name : names) {
            this.songs.add(new Song(name, ""));
        }
    }

    public void add(Song... songs) {
        this.songs.addAll(List.of(songs));
    }

    public void insert(int index, String name) {
        this.songs.add(index, new Song(name, ""));
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

    public void move(int i, int position) throws IndexOutOfBoundsException{
        songs.add(position, songs.get(i));
        if (position < i) {
            songs.remove(i + 1);
        } else if (position > i) {
            songs.remove(i - 1);
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

    public String find(String name) {
        for (Song song : songs) {
            if (song.getName().matches("(.*)" + name + "(.*)") && !Objects.equals(song.path, ""))
                return song.toString();
        }
        return "";
    }

    public void play(int song) {
        try {
            if (!Objects.equals(songs.get(song).path, "")) songs.get(song).play();
        } catch (Exception ignored) {
            System.err.println("That song number can't be found within this playlist.");
        }
    }

    public void repeat() {
        repeat = !this.repeat;
        while (this.repeat) {
            play();
        }
    }

    public void repeat(String song) {
        repeat = !this.repeat;
        while (this.repeat) {
            play(song);
        }
    }

    public void rate(int index, int rating) {
        songs.get(index).rate(rating);
    }

    public void rate(String song, int rating) {
        for (Song i : songs) {
            if (i.getName().matches("(.*)" + song + "(.*)")) i.rate(rating);
        }
    }

    public int size() {
        return this.songs.size();
    }

    public void remove(int index) {
        this.songs.remove(index);
    }

    public String getMostPlayed() {
        Song max = new Song("", "");
        for (Song song : this.songs) {
            if (song.getPlays() > max.getPlays()) max = song;
        }
        return max.getName();
    }

    public String getFavorite() {
        Song favorite = new Song("", "");
        int fav = 0;
        for (Song song : this.songs) {
            if (song.getPlays() > fav) favorite = song;
        }
        return favorite.getName();
    }
}
