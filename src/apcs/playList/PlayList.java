package apcs.playList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    ArrayList<Song> songs = new ArrayList<Song>();

    public PlayList(String name, Song @NotNull ... songs) {
        songs.addAll(songs);
    }
}
