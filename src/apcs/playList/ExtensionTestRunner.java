package apcs.playList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ExtensionTestRunner {
    public static void main(String[] args)
            throws ClassNotFoundException, UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        PlayList playList = new PlayList("My Playlist",
                new Song("FYMAM", "/Users/collindrake/Downloads/Free_Your_Mind_About_Music.wav"),
                new Song("Airborne Grooves", "/Users/collindrake/Downloads/Airborne_Grooves.wav"),
                new Song("Something", "")
        );

        playList.rate("Air", 5);
        playList.rate(0, 4);

        System.out.println(playList);

        playList.add(
                new Song("Undulation", "/Users/collindrake/Downloads/Undulation.wav")
        );

        System.out.println(playList);

        playList.move("Air", 0);
        playList.repeat("Air");

        System.out.println(playList);
    }
}
