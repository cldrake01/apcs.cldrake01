package frq;

import java.util.Arrays;

public class SoundRunner {
    public static void main(String[] args) {

        Sound sound = new Sound();
        System.out.println("Before trimSilenceFromBeginning(): " + Arrays.toString(sound.samples));
        sound.trimSilenceFromBeginning();
        System.out.println("After trimSilenceFromBeginning(): " + Arrays.toString(sound.samples));
        System.out.println("Changes made with amplitudeLimit(): " + sound.limitAmplitude(32));
        System.out.println("Final Array: " + Arrays.toString(sound.samples));

    }
}
