package apcs.playList;

import java.io.Reader;

public class PlayListTester {
    public static void main(String[] args) {
        PlayList playList = new PlayList("My Playlist");
        playList.add(new Song("Metadata"), new Song("AES", 800), new Song("The Orwellian Oracle"));
        System.out.println(playList);
        playList.play("Meta");
        playList.moveTo("Oracle", 0);
        System.out.println(playList);
    }
}
