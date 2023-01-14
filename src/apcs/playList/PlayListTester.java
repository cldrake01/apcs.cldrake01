package apcs.playList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class PlayListTester {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        PlayList playList = new PlayList("My Playlist");
        playList.add(
                new Song("FYMAM", "/Users/collindrake/Downloads/Free_Your_Mind_About_Music.wav"),
                new Song("Airborne Grooves", "/Users/collindrake/Downloads/Airborne_Grooves.wav"),
                new Song("Undulation", "/Users/collindrake/Downloads/Undulation.wav")
        );
        System.out.println(playList);
        playList.moveTo("Air", 0);
        System.out.println(playList);
        playList.play();
        System.out.println(playList);
    }
}
