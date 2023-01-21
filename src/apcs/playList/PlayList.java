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

    public PlayList(Song... songs) {
        this.songs.addAll(List.of(songs));
    }

    public PlayList(String name, Song... songs) {
        this.name = name;
        this.songs.addAll(List.of(songs));
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     *
     * @return the name of the playlist, followed by the toString() methods for each of this.songs' Songs.
     */
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
        try {
            return this.songs.get(index).songName;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("There doesn't appear to be a song located at " + index + ".");
        }
        return "";
    }

    /**
     *
     * @param names: each name within names is used a Song.name attribute for a pathless new Song.
     */
    public void add(String... names) {
        for (String name : names) {
            this.songs.add(new Song(name, ""));
        }
    }

    /**
     *
     * @param songs: adds all Song objects passed through it to this.songs.
     */
    public void add(Song... songs) {
        this.songs.addAll(List.of(songs));
    }

    /**
     *
     * @param index: the index where the new Song is to be inserted.
     * @param name: the name attribute for the new pathless Song.
     */
    public void insert(int index, String name) {
        try {
            this.songs.add(index, new Song(name, ""));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Those indecies cannot be accessed within " + this.name + ".");
        }
    }

    /**
     *
     * @param index: the index within this.songs of the Song that is to be removed.
     */
    public void remove(int index) {
        try {
            this.songs.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("There doesn't appear to be a song located at " + index + ".");
        }
    }

    /**
     * @param song: the name of the song that is to be moved.
     * @param position: the index to which the desired song is moved.
     */
    public void move(String song, int position)  {
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

    /**
     * @param i: the index of the song that is to be moved.
     * @param position: the index to which the desired song is moved.
     */
    public void move(int i, int position) {
        try {
            Song song = songs.remove(i);
            songs.add(position, song);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid index provided for move method: " + e.getMessage());
        }
    }

    /**
     * Utilizes a for loop to call the play() method on each Song contained within the list.
     */
    public void play() {
        for (Song i : songs) {
            if (!Objects.equals(i.path, "")) i.play();
        }
    }

    /**
     * @param song: identifies which Song contains an identical String within its Song.name attribute.
     */
    public void play(String song) {
        for (Song i : songs) {
            if (i.getName().matches("(.*)" + song + "(.*)") && !Objects.equals(i.path, "")) i.play();
        }
    }

    /**
     * @param song: the index within this.songs which the Song.play() is called.
     */
    public void play(int song) {
        try {
            if (!Objects.equals(songs.get(song).path, "")) songs.get(song).play();
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid index provided for play method: " + e.getMessage());
        }
    }

    /**
     * Calls the this.play() until it is called again, thereby inverting its repeat boolean, and ending the loop.
     */
    public void repeat() {
        repeat = !this.repeat;
        while (this.repeat) {
            play();
        }
    }

    /**
     * Calls the Song.play() method on the Song with a matching Song.name attribute until it is called again,
     * thereby inverting its repeat boolean, and ending the loop.
     *
     * @param song: identifies which Song contains an identical String within its Song.name attribute.
     */
    public void repeat(String song) {
        repeat = !this.repeat;
        while (this.repeat) {
            play(song);
        }
    }

    /**
     *
     * @param index: the index for the Song within this.songs that is to be rated.
     * @param rating: the integer between 1 and 5 to which the Song.rating attribute is set.
     */
    public void rate(int index, int rating) {
        try {
            songs.get(index).rate(rating);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid index provided for rate method: " + e.getMessage());
        }
    }

    /**
     *
     * @param song: the name of the Song within this.songs that is to be rated.
     * @param rating: the integer between 1 and 5 to which the Song.rating attribute is set.
     */
    public void rate(String song, int rating) {
        boolean found = false;
        for (Song i : songs) {
            if (i.getName().matches("(.*)" + song + "(.*)")) {
                i.rate(rating);
                found = true;
                break;
            }
        }
        if (!found) {
            System.err.println("No song with the name " + song + " was found in the playlist.");
        }
    }

    /**
     *
     * @param name: a String that is referenced to the name attribute of the song whose .toString() method is returned.
     * @return song.toString()
     */
    public String find(String name) {
        for (Song song : songs) {
            if (song.getName().matches("(.)" + name + "(.)") && !Objects.equals(song.path, ""))
                return song.toString();
        }
        return "";
    }

    /**
     * Tallies the ratings of each Song, and returns Song.getName() for the Song with the highest rating.
     * @return Song.getName()
     */
    public String getFavorite() {
        Song favorite = new Song("", "");
        int fav = 0;
        for (Song song : this.songs) {
            if (song.getPlays() > fav) favorite = song;
        }
        return favorite.getName();
    }

    /**
     * Tallies the number of plays for each Song, and returns Song.getName() for the Song with the greatest
     * amount of plays.
     * @return Song.getName()
     */
    public String getMostPlayed() {
        Song max = new Song("", "");
        for (Song song : this.songs) {
            if (song.getPlays() > max.getPlays()) max = song;
        }
        return max.getName();
    }

    /**
     *
     * @return this.songs.size()
     */
    public int size() {
        return this.songs.size();
    }
}
