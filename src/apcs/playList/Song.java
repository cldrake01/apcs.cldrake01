package apcs.playList;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Song {
    Scanner in = new Scanner(System.in);

    String path = "";
    String songName;
    int plays = 0;
    int rating = 0;
    long time = 0;

    public Song(String name) {
        this.songName = name;
    }

    public Song(String name, String path) {
        this.songName = name;
        this.path = path;
    }

    public void setName(String name) {
        this.songName = name;
    }

    public String getName() {
        return this.songName;
    }

    public int getPlays() {
        return this.plays;
    }

    public void rate(int rating) {
        this.rating = rating;
    }

    /**
     * This extension
     *
     */
    public void play() {
        this.plays++;
        synchronized (this) {
            try {
                File file = new File(this.path);

                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

                AudioFormat format = audioInputStream.getFormat();

                long audioFileLength = file.length();
                this.time = audioFileLength;
                int frameSize = format.getFrameSize();
                float frameRate = format.getFrameRate();
                float durationInSeconds = (audioFileLength / (frameSize * frameRate));
                this.time = (long) durationInSeconds;

                DataLine.Info info = new DataLine.Info(Clip.class, format);
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(audioInputStream);
                clip.start();
                wait((long) (durationInSeconds * 1000));
                clip.close();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String toString() {
        return this.time % 60 >= 10
                ?
                "\nTitle: " + this.songName + ", Plays: " + this.plays + ", Duration: " + this.time / 60 + ":"
                        + this.time % 60 + ", Rating: " + this.rating
                :
                "\nTitle: " + this.songName + ", Plays: " + this.plays + ", Duration: " + this.time / 60 + ":0"
                        + this.time % 60 + ", Rating: " + this.rating
                ;
    }
}