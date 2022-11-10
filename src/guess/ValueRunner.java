package guess;

import java.util.InputMismatchException;

public class ValueRunner {
    public static void main(String[] args) {
        Value v1 = new Value();
/*
        try {

            while (v1.guess() == false) {

                v1.guess();

            }

        } catch (InputMismatchException e) {

            System.err.println("That's not an integer, please try again.");

            v1.guess();

        }
*/
        v1.roboGuess();
    }
}
