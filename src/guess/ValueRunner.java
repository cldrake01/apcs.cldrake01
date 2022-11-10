package guess;

import org.w3c.dom.ranges.RangeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValueRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Value v1 = new Value();
        int input = 0;
        boolean tryAgain = true;

        try {

            while (v1.test().equals("")) {

                v1.test();

            }

        } catch (InputMismatchException e) {

            System.err.println("That's not an integer, please try again.");

            v1.test();

        } catch (RangeException e) {

            System.err.println("That number isn't between 1 and 100, please try again.");

            v1.test();

        }
    }
}
