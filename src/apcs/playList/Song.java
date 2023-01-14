package apcs.playList;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Song {
    String path = "";
    String songName;
    int plays = 0;
    long time = 1;

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

    public void play() {
        this.plays++;
        synchronized (this) {
            try {
                this.playSound();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void playSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        try {
            //Path absolutePath = FileSystems.getDefault().getPath("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/playList").toAbsolutePath();
            //File file = new File(absolutePath + "/Airborne_Grooves.wav");
            File file = new File(this.path);

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

            AudioFormat format = audioInputStream.getFormat();

            long audioFileLength = file.length();
            this.time = audioFileLength;
            int frameSize = format.getFrameSize();
            float frameRate = format.getFrameRate();
            float durationInSeconds = (audioFileLength / (frameSize * frameRate));

            System.out.println((long) (durationInSeconds * 1000));

            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip clip = (Clip) AudioSystem.getLine(info);
            clip.open(audioInputStream);
            clip.start();
            wait((long) (durationInSeconds * 1000));
            clip.close();
        } catch (UnsupportedAudioFileException | IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return (this.time / 100) % 60 >= 10
                ?
                "\nTitle: " + this.songName + ", Plays: " + this.plays + ", Duration: " + (this.time / 100) / 60 + ":"
                        + (this.time / 100) % 60
                :
                "\nTitle: " + this.songName + ", Plays: " + this.plays + ", Duration: " + (this.time / 100) / 60 + ":0"
                        + (this.time / 100) % 60
                ;
    }
}