package frq;

import java.util.Arrays;

public class SoundRunner {
    public static void main(String[] args) {
        Sound sound = new Sound();
        sound.trimSilenceFromBeginning();
        System.out.println(Arrays.toString(sound.samples));
        System.out.println(sound.limitAmplitude(32));
        System.out.println(Arrays.toString(sound.samples));

    }
}
