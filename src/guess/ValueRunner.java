package guess;

import org.w3c.dom.ranges.RangeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValueRunner {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Value v1 = new Value();
        int input = 0;

        while (!v1.equals(input)) {
            try {

                System.out.println("Please enter a number between 1 and 100: ");

                input = reader.nextInt();

                if (v1.equals(input)) {

                    System.out.println("Correct!");

                } else {
                    if (input > v1.getValue()) {

                        System.out.println("Go lower");

                    } else {

                        System.out.println("Go higher");

                    }
                }

            } catch (InputMismatchException e) {

                System.out.println("That's not an integer. Try again.");

            } catch (RangeException j) {

                System.out.println("That's not between 1 and 100. Try again.");

            }
        }
    }
}
