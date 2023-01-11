package apcs.frq;

import java.util.Arrays;

public class SoundRunner {
    public static void main(String[] args) {
        Sound sound = new Sound();
        
        System.out.println("Before trimSilenceFromBeginning(): " + Arrays.toString(sound.samples)); 
        // Before trimSilenceFromBeginning(): [0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0]
        sound.trimSilenceFromBeginning();
        System.out.println("After trimSilenceFromBeginning(): " + Arrays.toString(sound.samples));
        // After trimSilenceFromBeginning(): [-14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0]
        System.out.println("Changes made with amplitudeLimit(): " + sound.limitAmplitude(32));
        // Changes made with amplitudeLimit(): 3
        System.out.println("Final Array: " + Arrays.toString(sound.samples));
        // Final Array: [-14, 0, -32, -32, 0, -7, 16, 32, 32, 0, 0]

        
        /*
         Full output:
         
         Before trimSilenceFromBeginning(): [0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0]
         After trimSilenceFromBeginning(): [-14, 0, -35, -39, 0, -7, 16, 32, 37, 0, 0]
         Changes made with amplitudeLimit(): 3
         Final Array: [-14, 0, -32, -32, 0, -7, 16, 32, 32, 0, 0]
         
        */
    }
}
